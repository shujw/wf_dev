package jp.co.intra_mart.sample.workflow.purchase.listener;

import jp.co.intra_mart.foundation.security.exception.AccessSecurityException;
import jp.co.intra_mart.foundation.security.message.MessageManager;
import jp.co.intra_mart.foundation.workflow.exception.WorkflowException;
import jp.co.intra_mart.foundation.workflow.listener.IWorkflowArcMatterDeleteListener;
import jp.co.intra_mart.framework.base.event.EventException;
import jp.co.intra_mart.framework.base.event.EventManager;
import jp.co.intra_mart.framework.base.event.EventManagerException;
import jp.co.intra_mart.framework.base.event.EventPropertyException;
import jp.co.intra_mart.framework.system.exception.ApplicationException;
import jp.co.intra_mart.framework.system.exception.SystemException;
import jp.co.intra_mart.sample.workflow.purchase.model.event.DeleteEvent;

/**
 * 過去案件削除処理リスナー テンプレート<p>
 *
 * @author  INTRAMART
 * 
 * このプログラム中ではDBトランザクションを張らないで下さい。<br>
 */
public class WorkflowArcMatterDeleteListener implements IWorkflowArcMatterDeleteListener {

    /**
     * 過去案件削除処理リスナーの実行メソッド<p>
     * 
     * @param loginGroupId 
     * @param localeId 
     * @param systemMatterId 
     * @param userDataId 
     * @param archiveMonth 
     * 
     * @throws WorkflowException 
     */
    public void execute(
            final String loginGroupId,
            final String localeId,
            final String systemMatterId,
            final String userDataId,
            final String archiveMonth) throws WorkflowException {
        System.out.println("----- WorkflowArcMatterDeleteListener - execute -----");
        System.out.println("LoginGroupId        : " + loginGroupId);
        System.out.println("LocaleId            : " + localeId);
        System.out.println("systemMatterId      : " + systemMatterId);
        System.out.println("userDataId          : " + userDataId);
        System.out.println("archiveMonth        : " + archiveMonth);        
        System.out.println("----- WorkflowArcMatterDeleteListener - execute -----");

        try {
            final EventManager eventManager = EventManager.getEventManager();
            final DeleteEvent deleteEvent = (DeleteEvent) eventManager.createEvent("imw_sample_purchase", "delete");
            deleteEvent.setUserDataId(userDataId);
            eventManager.dispatch(deleteEvent, true);
        } catch (final EventManagerException e) {
            try {
                throw new WorkflowException(
                        MessageManager.getInstance().getMessage(localeId, "SAMPLE.IMW.ERR.002"));
            } catch (final AccessSecurityException ex) {
                ex.printStackTrace();
            }
        } catch (final EventPropertyException e) {
            try {
                throw new WorkflowException(
                        MessageManager.getInstance().getMessage(localeId, "SAMPLE.IMW.ERR.002"));
            } catch (final AccessSecurityException ex) {
                ex.printStackTrace();
            }
        } catch (final EventException e) {
            try {
                throw new WorkflowException(
                        MessageManager.getInstance().getMessage(localeId, "SAMPLE.IMW.ERR.002"));
            } catch (final AccessSecurityException ex) {
                ex.printStackTrace();
            }
        } catch (final SystemException e) {
            try {
                throw new WorkflowException(
                        MessageManager.getInstance().getMessage(localeId, "SAMPLE.IMW.ERR.002"));
            } catch (final AccessSecurityException ex) {
                ex.printStackTrace();
            }
        } catch (final ApplicationException e) {
            try {
                throw new WorkflowException(
                        MessageManager.getInstance().getMessage(localeId, "SAMPLE.IMW.ERR.002"));
            } catch (final AccessSecurityException ex) {
                ex.printStackTrace();
            }
        }
    }

}
