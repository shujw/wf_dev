package jp.co.intra_mart.sample.workflow.template;

import jp.co.intra_mart.foundation.workflow.exception.WorkflowException;
import jp.co.intra_mart.foundation.workflow.listener.IWorkflowCplMatterDeleteListener;

/**
 * 完了案件削除処理リスナー テンプレート<p>
 *
 * @author  INTRAMART
 * 
 * このプログラム中ではDBトランザクションを張らないで下さい。<br>
 */
public class WorkflowCplMatterDeleteListener implements IWorkflowCplMatterDeleteListener {

    /**
     * 完了案件削除処理リスナーの実行メソッド<p>
     * 
     * @param loginGroupId 
     * @param localeId 
     * @param systemMatterId 
     * @param userDataId 
     * 
     * @throws WorkflowException 
     */
    public void execute(final String loginGroupId, final String localeId, final String systemMatterId, final String userDataId) throws WorkflowException {
        System.out.println("----- WorkflowCplMatterDeleteListener - execute -----");
        System.out.println("LoginGroupId        : " + loginGroupId);
        System.out.println("LocaleId            : " + localeId);
        System.out.println("systemMatterId      : " + systemMatterId);
        System.out.println("userDataId          : " + userDataId);
        System.out.println("----- WorkflowCplMatterDeleteListener - execute -----");
    }

}
