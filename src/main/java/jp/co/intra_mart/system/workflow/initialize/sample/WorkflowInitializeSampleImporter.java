package jp.co.intra_mart.system.workflow.initialize.sample;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import jp.co.intra_mart.foundation.security.ExtendsImport;
import jp.co.intra_mart.foundation.security.exception.AccessSecurityException;
import jp.co.intra_mart.foundation.service.client.file.PublicStorage;
import jp.co.intra_mart.foundation.service.client.file.SystemStorage;
import jp.co.intra_mart.foundation.workflow.exception.WorkflowException;
import jp.co.intra_mart.foundation.workflow.util.WorkflowParameterManager;
import jp.co.intra_mart.system.workflow.initialize.WorkflowInitializeImporter;

public class WorkflowInitializeSampleImporter implements ExtendsImport{

    private static final String EXTENSION      = ".xml";
    private static final String SEPARATOR      = "/";
    private static final String TEMP_ROOT      = "products/import/sample/im_workflow/template";
    private static final String SAVE_ROOT      = "im_workflow/data";
    
    public void doImport(String groupId) throws AccessSecurityException {
        try {
            final WorkflowParameterManager workflowParameterManager = new WorkflowParameterManager();
            final String masterFileDir = workflowParameterManager.getParameter("master-file-dir");
            
            this.doCopyRouteFiles(groupId, masterFileDir);
            this.doCopyRouteTemplateFiles(groupId, masterFileDir);
        } catch (final WorkflowException e) {
            throw new AccessSecurityException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new AccessSecurityException(e.getMessage(), e);
        }
        
    }

    private void doCopyRouteFiles(final String groupId, final String masterFileDir) throws AccessSecurityException {
        try {
            final String dirTempRootPath = TEMP_ROOT + SEPARATOR + "route";
            
            final SystemStorage dirTempRootStorage = new SystemStorage(dirTempRootPath);
            final Collection<?> dirTempRootList = dirTempRootStorage.directories(false);
            final Iterator<?> iteratorDirRoot = dirTempRootList.iterator();
            while (iteratorDirRoot.hasNext()) {
                final Object dirRoot = iteratorDirRoot.next();
                final SystemStorage dirTempStorage = new SystemStorage(dirTempRootPath + SEPARATOR + dirRoot.toString());
                final Collection<?> dirTempList = dirTempStorage.directories(false);
                final Iterator<?> iteratorDir = dirTempList.iterator();
                while (iteratorDir.hasNext()) {
                    final Object dir = iteratorDir.next();
                    final SystemStorage dirStorage = new SystemStorage(dirTempRootPath + SEPARATOR + dirRoot.toString() + SEPARATOR + dir.toString());
                    final Collection<String> fileList = dirStorage.list(false);
                    final Iterator<?> iterator = fileList.iterator();
                    while (iterator.hasNext()) {
                        final Object file = iterator.next();
                        final String fileName = file.toString();
                        if (fileName.endsWith(EXTENSION)) {
                            final String tempPath = dirTempRootPath + SEPARATOR + dirRoot.toString() + SEPARATOR + dir.toString();
                            final String savePath = SAVE_ROOT + SEPARATOR + groupId + SEPARATOR + masterFileDir + SEPARATOR + "route" + SEPARATOR + dirRoot.toString() + SEPARATOR + dir.toString();
                            final PublicStorage dirSaveRoot = new PublicStorage(savePath);
                            if (!dirSaveRoot.isDirectory()) {
                                dirSaveRoot.makeDirectories();
                            }
                            final PublicStorage fileSave = new PublicStorage(savePath + SEPARATOR + fileName);
                            if (!fileSave.isFile()) {
                                WorkflowInitializeImporter.doCopyFile(tempPath + SEPARATOR + fileName, savePath + SEPARATOR + fileName);
                            }
                        }
                    }
                }
            }
        } catch (final IOException e) {
            throw new AccessSecurityException(e.getMessage(), e);
        }
    }

    private void doCopyRouteTemplateFiles(final String groupId, final String masterFileDir) throws AccessSecurityException, IOException {
        final String dirTempRootPath = TEMP_ROOT + SEPARATOR + "route_template";
        
        final SystemStorage dirTempRootStorage = new SystemStorage(dirTempRootPath);
        final Collection<?> dirTempRootList = dirTempRootStorage.directories(false);
        final Iterator<?> iteratorDirRoot = dirTempRootList.iterator();
        while (iteratorDirRoot.hasNext()) {
            final Object dirRoot = iteratorDirRoot.next();
            final SystemStorage dirTempStorage = new SystemStorage(dirTempRootPath + SEPARATOR + dirRoot.toString());
            final Collection<?> dirTempList = dirTempStorage.list(false);
            final Iterator<?> iteratorDir = dirTempList.iterator();
            while (iteratorDir.hasNext()) {
                final Object file = iteratorDir.next();
                final String fileName = file.toString();
                if (fileName.endsWith(EXTENSION)) {
                    final String tempPath = dirTempRootPath + SEPARATOR + dirRoot.toString();
                    final String savePath = SAVE_ROOT + SEPARATOR + groupId + SEPARATOR + masterFileDir + SEPARATOR + "route_template" + SEPARATOR + dirRoot.toString();
                    final PublicStorage dirSaveRoot = new PublicStorage(savePath);
                    if (!dirSaveRoot.isDirectory()) {
                        dirSaveRoot.makeDirectories();
                    }
                    final PublicStorage fileSave = new PublicStorage(savePath + SEPARATOR + fileName);
                    if (!fileSave.isFile()) {
                        WorkflowInitializeImporter.doCopyFile(tempPath + SEPARATOR + fileName, savePath + SEPARATOR + fileName);
                    }
                }
            }
        }
    }
}
