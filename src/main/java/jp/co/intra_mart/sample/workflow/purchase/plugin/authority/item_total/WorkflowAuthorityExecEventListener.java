package jp.co.intra_mart.sample.workflow.purchase.plugin.authority.item_total;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.intra_mart.foundation.exception.BizApiException;
import jp.co.intra_mart.foundation.master.common.search.AppCmnSearchCondition;
import jp.co.intra_mart.foundation.master.company.CompanyManager;
import jp.co.intra_mart.foundation.master.company.model.CompanyPostBizKey;
import jp.co.intra_mart.foundation.master.company.model.DepartmentListNode;
import jp.co.intra_mart.foundation.master.user.model.UserBizKey;
import jp.co.intra_mart.foundation.master.user.model.UserListNode;
import jp.co.intra_mart.foundation.security.exception.AccessSecurityException;
import jp.co.intra_mart.foundation.security.message.MessageManager;
import jp.co.intra_mart.foundation.workflow.application.general.ActvMatter;
import jp.co.intra_mart.foundation.workflow.application.general.UserActvMatterPropertyValue;
import jp.co.intra_mart.foundation.workflow.application.model.MatterProcessHistoryModel;
import jp.co.intra_mart.foundation.workflow.application.model.UserMatterPropertyModel;
import jp.co.intra_mart.foundation.workflow.exception.WorkflowException;
import jp.co.intra_mart.foundation.workflow.listener.IWorkflowAuthorityExecEventListener;
import jp.co.intra_mart.foundation.workflow.listener.model.TargetUserModel;
import jp.co.intra_mart.foundation.workflow.listener.model.WorkflowSortCondition;
import jp.co.intra_mart.foundation.workflow.listener.param.WorkflowAuthorityParameter;
import jp.co.intra_mart.foundation.workflow.listener.param.WorkflowMatterParameter;
import jp.co.intra_mart.foundation.workflow.listener.param.WorkflowParameter;
import jp.co.intra_mart.foundation.workflow.plugin.authority.im_master.model.OrgzDataModel;
import jp.co.intra_mart.foundation.workflow.plugin.authority.im_master.model.UserDataModel;
import jp.co.intra_mart.foundation.workflow.util.WorkflowPluginUtilManager;

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
        
        // ユーザ一覧を取得
        final UserListNode[] listUser = getListUser(
                workflowParam.getLoginGroupId(),
                workflowParam.getLocaleId(),
                workflowParam.getApplyBaseDate(),
                matterParam.getSystemMatterId(),
                matterParam.getUserDataId());
        if (listUser == null) {
            return null;
        }
        
        final List<UserDataModel> useList = new ArrayList<UserDataModel>();
        try {
            // 各ユーザが所属する組織一覧を取得
            final CompanyManager companyManager = new CompanyManager();
            final UserBizKey bizKey = new UserBizKey();
            final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            final Date date = format.parse(workflowParam.getApplyBaseDate());
            for (int i = 0; i < listUser.length; i++) {
                bizKey.setUserCd(listUser[i].getUserCd());
                final DepartmentListNode[] departmentList = companyManager.listDepartmentWithUser(
                        bizKey,
                        new AppCmnSearchCondition(),
                        false,
                        date,
                        WorkflowPluginUtilManager.getLocale());
                
                final OrgzDataModel[] orgzData = new OrgzDataModel[departmentList.length];
                for (int j = 0; j < departmentList.length; j++) {
                    orgzData[j] = new OrgzDataModel();
                    orgzData[j].setCompanyName("");
                    orgzData[j].setOrgzName(departmentList[j].getDisplayName());
                    orgzData[j].setCompanyCode(departmentList[j].getCompanyCd());
                    orgzData[j].setOrgzSetCode(departmentList[j].getDepartmentSetCd());
                    orgzData[j].setOrgzCode(departmentList[j].getDepartmentCd());
                }
                
                final UserDataModel userDate = new UserDataModel();
                userDate.setUserCode(listUser[i].getUserCd());
                userDate.setUserName(listUser[i].getDisplayName());
                userDate.setLocaleId(workflowParam.getLocaleId());
                userDate.setUserOrgzModels(orgzData);
                
                useList.add(userDate);
            }
        } catch (final BizApiException e) {
            return null;
        } catch (final ParseException e) {
            return null;
        }
        
        return useList;
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
            final WorkflowSortCondition[] sort)
                throws WorkflowException {
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
        
        // ユーザ一覧を取得
        final UserListNode[] listUser = getListUser(
                workflowParam.getLoginGroupId(),
                workflowParam.getLocaleId(),
                workflowParam.getApplyBaseDate(),
                matterParam.getSystemMatterId(),
                matterParam.getUserDataId());
        if (listUser == null) {
            return null;
        }
        
        final TargetUserModel[] userlist = new TargetUserModel[listUser.length];
        for (int i = 0; i < listUser.length; i++) {
            userlist[i] = new TargetUserModel();
            userlist[i].setUserCode(listUser[i].getUserCd());
            userlist[i].setUserName(listUser[i].getDisplayName());
            userlist[i].setLocaleId(workflowParam.getLocaleId());
        }
        
        final Map<String, TargetUserModel[]> map = new HashMap<String, TargetUserModel[]>();
        map.put(workflowParam.getLocaleId(), userlist);
        
        return map;
    }

    /**
     * 処理対象者プラグイン設定情報表示名取得メソッド<p>
     * 
     * @param workflowParam 
     * 
     * @return Map ロケールIDをキーにした処理対象ユーザリスト
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
        
        final Map<String, String> map = new HashMap<String, String>();
        try {
            map.put(workflowParam.getLocaleId(), MessageManager.getInstance().getMessage(workflowParam.getParameter()));
        } catch (final AccessSecurityException e) {
            return null;
        }
        
        return map;
    }

    /**
     * 処処理対象者の一覧を取得するメソッド<p>
     * 
     * [合計金額]により、処理対象の役職を変更する
     *    5万円以上            ⇒ 社長
     *    1万円以上、5万円未満 ⇒ 部長
     *    1万円未満            ⇒ 課長
     * 
     * @param loginGroupId
     * @param localeId
     * @param applyBaseDate
     * @param systemMatterId
     * @param userDataId
     * 
     * @return UserListNode[] ユーザリスト情報
     * 
     * @throws WorkflowException
     * 
     */
    private UserListNode[] getListUser(
            final String loginGroupId,
            final String localeId,
            final String applyBaseDate,
            final String systemMatterId,
            final String userDataId) throws WorkflowException {
        final int minimum = 10000;
        final int maximum = 50000;
        
        final String post1 = "ps001";  // 役職CD：社長
        final String post2 = "ps002";  // 役職CD：部長
        final String post3 = "ps003";  // 役職CD：課長
        
        // 案件プロパティから[合計金額]を取得
        final UserActvMatterPropertyValue matterProperty  = new UserActvMatterPropertyValue();
        final UserMatterPropertyModel matterPropertyModel = matterProperty.getMatterProperty(userDataId, "item_total");
        final int itemTotal = Integer.valueOf(matterPropertyModel.getMatterPropertyValue()).intValue();
        
        // 役職に所属するユーザ一覧を取得するための条件を取得
        final CompanyPostBizKey bizKey = new CompanyPostBizKey();
        final ActvMatter actvMatter = new ActvMatter(localeId.toString(), systemMatterId);
        final MatterProcessHistoryModel[] historyModel = actvMatter.getProcessHistoryLatestList();
        for (int i = 0; i < historyModel.length; i++) {
            // 申請者が選択した組織から、「会社CD」「組織セットCD」を取得
            if (historyModel[i].getNodeType().equals("2")) {
                bizKey.setCompanyCd(historyModel[i].getAuthCompanyCode());
                bizKey.setDepartmentSetCd(historyModel[i].getAuthOrgzSetCode());
                break;
            }
        }
        if (itemTotal >= maximum) {
            // 5万円以上            ⇒ 社長
            bizKey.setPostCd(post1);
        } else if (itemTotal < maximum && itemTotal >= minimum) {
            // 1万円以上、5万円未満 ⇒ 部長
            bizKey.setPostCd(post2);
        } else {
            // 1万円未満            ⇒ 課長
            bizKey.setPostCd(post3);
        }
        
        // 役職に所属するユーザ一覧を取得
        UserListNode[] listUser = null;
        try {
            final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            final Date date = format.parse(applyBaseDate);
            
            final CompanyManager companyManager = new CompanyManager();
            listUser = companyManager.listUserWithCompanyPost(
                    bizKey,
                    new AppCmnSearchCondition(),
                    date,
                    WorkflowPluginUtilManager.getLocale());
        } catch (final BizApiException e) {
            return null;
        } catch (final ParseException e) {
            return null;
        }
        
        return listUser;
    }
}
