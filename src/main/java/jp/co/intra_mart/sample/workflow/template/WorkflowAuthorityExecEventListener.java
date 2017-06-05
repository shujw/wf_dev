package jp.co.intra_mart.sample.workflow.template;

import java.util.List;
import java.util.Map;

import jp.co.intra_mart.foundation.workflow.exception.WorkflowException;
import jp.co.intra_mart.foundation.workflow.listener.IWorkflowAuthorityExecEventListener;
import jp.co.intra_mart.foundation.workflow.listener.model.TargetUserModel;
import jp.co.intra_mart.foundation.workflow.listener.model.WorkflowSortCondition;
import jp.co.intra_mart.foundation.workflow.listener.param.WorkflowAuthorityParameter;
import jp.co.intra_mart.foundation.workflow.listener.param.WorkflowMatterParameter;
import jp.co.intra_mart.foundation.workflow.listener.param.WorkflowParameter;
import jp.co.intra_mart.foundation.workflow.plugin.authority.im_master.model.UserDataModel;

/**
 * 処理対象者プラグイン テンプレート<p>
 *
 * @author  INTRAMART
 * 
 */
public class WorkflowAuthorityExecEventListener implements IWorkflowAuthorityExecEventListener {

    /**
     *  処理対象者取得メソッド<p>
     * 
     * @param workflowParam 
     * @param matterParam 
     * 
     * @return List ユーザ展開情報 
     * 
     * @throws WorkflowException 
     */
    public List<UserDataModel> execute(
            final WorkflowAuthorityParameter workflowParam,
            final WorkflowMatterParameter matterParam) throws WorkflowException {
        System.out.println("----- WorkflowAuthorityExecEventListener - execute -----");
        System.out.println("LoginGroupId      : " + workflowParam.getLoginGroupId());
        System.out.println("LocaleId          : " + workflowParam.getLocaleId());
        if (workflowParam.getTargetLocales() != null) {
            System.out.print("TargetLocales     : ");
            for (String str : workflowParam.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales     : ");
        }
        System.out.println("ApplyBaseDate     : " + workflowParam.getApplyBaseDate());
        System.out.println("Parameter         : " + workflowParam.getParameter());
        System.out.println("ContentsId        : " + matterParam.getContentsId());
        System.out.println("ContentsVersionId : " + matterParam.getContentsVersionId());
        System.out.println("RouteId           : " + matterParam.getRouteId());
        System.out.println("RouteVersionId    : " + matterParam.getRouteVersionId());
        System.out.println("FlowId            : " + matterParam.getFlowId());
        System.out.println("FlowVersionId     : " + matterParam.getFlowVersionId());
        System.out.println("NodeId            : " + matterParam.getNodeId());
        System.out.println("SystemMatterId    : " + matterParam.getSystemMatterId());
        System.out.println("UserDataId        : " + matterParam.getUserDataId());
        System.out.println("----- WorkflowAuthorityExecEventListener - execute -----");
        return null;
    }

    /**
     *  処理対象ユーザリスト取得メソッド<p>
     * 
     * @param workflowParam 
     * @param matterParam 
     * @param sort 
     * 
     * @return Map ロケールIDをキーにした処理対象ユーザリスト
     * 
     * @throws WorkflowException 
     */
    public Map<String, TargetUserModel[]> getTargetUserList(
            final WorkflowAuthorityParameter workflowParam,
            final WorkflowMatterParameter matterParam,
            final WorkflowSortCondition[] sort) throws WorkflowException {
        System.out.println("----- WorkflowAuthorityExecEventListener - getTargetUserList -----");
        System.out.println("LoginGroupId      : " + workflowParam.getLoginGroupId());
        System.out.println("LocaleId          : " + workflowParam.getLocaleId());
        if (workflowParam.getTargetLocales() != null) {
            System.out.print("TargetLocales     : ");
            for (String str : workflowParam.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales     : ");
        }
        System.out.println("ApplyBaseDate     : " + workflowParam.getApplyBaseDate());
        System.out.println("Parameter         : " + workflowParam.getParameter());
        System.out.println("ContentsId        : " + matterParam.getContentsId());
        System.out.println("ContentsVersionId : " + matterParam.getContentsVersionId());
        System.out.println("RouteId           : " + matterParam.getRouteId());
        System.out.println("RouteVersionId    : " + matterParam.getRouteVersionId());
        System.out.println("FlowId            : " + matterParam.getFlowId());
        System.out.println("FlowVersionId     : " + matterParam.getFlowVersionId());
        System.out.println("NodeId            : " + matterParam.getNodeId());
        System.out.println("SystemMatterId    : " + matterParam.getSystemMatterId());
        System.out.println("UserDataId        : " + matterParam.getUserDataId());
        System.out.println("----- WorkflowAuthorityExecEventListener - getTargetUserList -----");
        return null;
    }

    /**
     * 処理対象者プラグイン設定情報表示名取得メソッド<p>
     * 
     * @param workflowParam WorkflowParameter
     * 
     * @return Map キー：ロケールID、値：パラメータ値の表示名
     * 
     * @throws WorkflowException 
     */
    public Map<String, String> getDisplayName(final WorkflowParameter workflowParam)
            throws WorkflowException {
        System.out.println("----- WorkflowAuthorityExecEventListener - getDisplayName -----");
        System.out.println("LoginGroupId      : " + workflowParam.getLoginGroupId());
        System.out.println("LocaleId          : " + workflowParam.getLocaleId());
        if (workflowParam.getTargetLocales() != null) {
            System.out.print("TargetLocales     : ");
            for (String str : workflowParam.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales     : ");
        }
        System.out.println("ApplyBaseDate     : " + workflowParam.getApplyBaseDate());
        System.out.println("Parameter         : " + workflowParam.getParameter());
        System.out.println("----- WorkflowAuthorityExecEventListener - getDisplayName -----");
        return null;
    }

}
