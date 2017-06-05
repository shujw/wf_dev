package jp.co.intra_mart.sample.workflow.purchase.listener;

import jp.co.intra_mart.foundation.security.exception.AccessSecurityException;
import jp.co.intra_mart.foundation.security.message.MessageManager;
import jp.co.intra_mart.foundation.workflow.exception.WorkflowException;
import jp.co.intra_mart.foundation.workflow.listener.IWorkflowMatterArchiveListener;
import jp.co.intra_mart.framework.base.event.EventException;
import jp.co.intra_mart.framework.base.event.EventManager;
import jp.co.intra_mart.framework.base.event.EventManagerException;
import jp.co.intra_mart.framework.base.event.EventPropertyException;
import jp.co.intra_mart.framework.system.exception.ApplicationException;
import jp.co.intra_mart.framework.system.exception.SystemException;
import jp.co.intra_mart.sample.workflow.purchase.model.event.SelectEvent;
import jp.co.intra_mart.sample.workflow.purchase.model.event.SelectEventResult;
import jp.co.intra_mart.sample.workflow.purchase.model.event.UpdateEvent;
import jp.co.intra_mart.sample.workflow.purchase.model.object.ImwPurchaseModelObject;

/**
 * 案件退避処理リスナー テンプレート<p>
 *
 * @author  INTRAMART
 * 
 * このプログラム中ではDBトランザクションを張らないで下さい。<br>
 */
public class WorkflowMatterArchiveListener implements IWorkflowMatterArchiveListener {

    /**
     * 案件退避処理リスナーの実行メソッド<p>
     * 
     * @param loginGroupId 
     * @param localeId 
     * @param systemMatterId 
     * @param userDataId 
     * 
     * @throws WorkflowException 
     */
    public void execute(
            final String loginGroupId,
            final String localeId,
            final String systemMatterId,
            final String userDataId) throws WorkflowException {
        System.out.println("----- WorkflowMatterArchiveListener - execute -----");
        System.out.println("LoginGroupId        : " + loginGroupId);
        System.out.println("LocaleId            : " + localeId);
        System.out.println("systemMatterId      : " + systemMatterId);
        System.out.println("userDataId          : " + userDataId);
        System.out.println("----- WorkflowMatterArchiveListener - execute -----");
        
        try {
            final EventManager eventManager = EventManager.getEventManager();
            final SelectEvent selectEvent = (SelectEvent) eventManager.createEvent("imw_sample_purchase", "select");
            selectEvent.setUserDataId(userDataId);

            final SelectEventResult eventResult = (SelectEventResult) eventManager.dispatch(selectEvent, true);
            if (eventResult.getModelObject() != null){
                final ImwPurchaseModelObject modelObject = eventResult.getModelObject();
                modelObject.setArchiveFlag("1");
                
                final UpdateEvent updateEvent = (UpdateEvent) eventManager.createEvent("imw_sample_purchase", "update");
                updateEvent.setModelObject(modelObject);
                eventManager.dispatch(updateEvent, true);
            }
        } catch (final EventManagerException e) {
            try {
                throw new WorkflowException(
                        MessageManager.getInstance().getMessage(localeId, "SAMPLE.IMW.ERR.001"));
            } catch (final AccessSecurityException ex) {
                ex.printStackTrace();
            }
        } catch (final EventPropertyException e) {
            try {
                throw new WorkflowException(
                        MessageManager.getInstance().getMessage(localeId, "SAMPLE.IMW.ERR.001"));
            } catch (final AccessSecurityException ex) {
                ex.printStackTrace();
            }
        } catch (final EventException e) {
            try {
                throw new WorkflowException(
                        MessageManager.getInstance().getMessage(localeId, "SAMPLE.IMW.ERR.001"));
            } catch (final AccessSecurityException ex) {
                ex.printStackTrace();
            }
        } catch (final SystemException e) {
            try {
                throw new WorkflowException(
                        MessageManager.getInstance().getMessage(localeId, "SAMPLE.IMW.ERR.001"));
            } catch (final AccessSecurityException ex) {
                ex.printStackTrace();
            }
        } catch (final ApplicationException e) {
            try {
                throw new WorkflowException(
                        MessageManager.getInstance().getMessage(localeId, "SAMPLE.IMW.ERR.001"));
            } catch (final AccessSecurityException ex) {
                ex.printStackTrace();
            }
        }
    }

}
