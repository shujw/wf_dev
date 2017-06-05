package jp.co.intra_mart.sample.workflow.purchase.action;

import java.util.Map;

import jp.co.intra_mart.foundation.workflow.application.general.UserActvMatterPropertyValue;
import jp.co.intra_mart.foundation.workflow.application.model.UserMatterPropertyModel;
import jp.co.intra_mart.foundation.workflow.plugin.process.action.ActionProcessEventListener;
import jp.co.intra_mart.foundation.workflow.plugin.process.action.ActionProcessParameter;

/**
 * アクション処理プログラム テンプレート<p>
 *
 * @author  INTRAMART
 *
 * このプログラム中ではDBトランザクションを張らないで下さい。<br>
 */
public class ActionProcess2 extends ActionProcessEventListener {

    public ActionProcess2() {
        super();
    }

    // 申請
    @Override
    public String apply(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - apply -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - apply -----");

        final UserMatterPropertyModel matterPropertyModel = new UserMatterPropertyModel();
        matterPropertyModel.setUserDataId(parameter.getUserDataId());
        matterPropertyModel.setMatterPropertyKey("item_total");
        matterPropertyModel.setMatterPropertyValue(
                Integer.valueOf(userParameter.get("item_amount").toString()).intValue()
                * Integer.valueOf(userParameter.get("item_price").toString()).intValue() + "");

        final UserActvMatterPropertyValue property = new UserActvMatterPropertyValue();
        final UserMatterPropertyModel[] matterProperty = new UserMatterPropertyModel[1];
        matterProperty[0] = matterPropertyModel;
        property.createMatterProperty(matterProperty);

        return null;
    }

    // 再申請
    @Override
    public String reapply(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - reapply -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - reapply -----");

        final UserMatterPropertyModel matterPropertyModel = new UserMatterPropertyModel();
        matterPropertyModel.setUserDataId(parameter.getUserDataId());
        matterPropertyModel.setMatterPropertyKey("item_total");
        matterPropertyModel.setMatterPropertyValue(
                Integer.valueOf(userParameter.get("item_amount").toString()).intValue()
                * Integer.valueOf(userParameter.get("item_price").toString()).intValue() + "");

        final UserActvMatterPropertyValue property = new UserActvMatterPropertyValue();
        final UserMatterPropertyModel[] matterProperty = new UserMatterPropertyModel[1];
        matterProperty[0] = matterPropertyModel;

        property.updateMatterProperty(matterProperty);

        return null;
    }

    // 申請(一時保存案件)
    @Override
    public String applyFromTempSave(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - applyFromTempSave -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - applyFromTempSave -----");

        final UserMatterPropertyModel matterPropertyModel = new UserMatterPropertyModel();
        matterPropertyModel.setUserDataId(parameter.getUserDataId());
        matterPropertyModel.setMatterPropertyKey("item_total");
        matterPropertyModel.setMatterPropertyValue(
                Integer.valueOf(userParameter.get("item_amount").toString()).intValue()
                * Integer.valueOf(userParameter.get("item_price").toString()).intValue() + "");

        final UserActvMatterPropertyValue property = new UserActvMatterPropertyValue();
        final UserMatterPropertyModel[] matterProperty = new UserMatterPropertyModel[1];
        matterProperty[0] = matterPropertyModel;
        property.updateMatterProperty(matterProperty);

        return null;
    }

    // 申請(未申請状態案件)
    @Override
    public String applyFromUnapply(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - applyFromUnapply -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - applyFromUnapply -----");

        final UserMatterPropertyModel matterPropertyModel = new UserMatterPropertyModel();
        matterPropertyModel.setUserDataId(parameter.getUserDataId());
        matterPropertyModel.setMatterPropertyKey("item_total");
        matterPropertyModel.setMatterPropertyValue(
                Integer.valueOf(userParameter.get("item_amount").toString()).intValue()
                * Integer.valueOf(userParameter.get("item_price").toString()).intValue() + "");

        final UserActvMatterPropertyValue property = new UserActvMatterPropertyValue();
        final UserMatterPropertyModel[] matterProperty = new UserMatterPropertyModel[1];
        matterProperty[0] = matterPropertyModel;
        property.createMatterProperty(matterProperty);

        return null;
    }

    // 取止め
    @Override
    public void discontinue(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - discontinue -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - discontinue -----");
    }

    // 引戻し
    @Override
    public void pullBack(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - pullBack -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - pullBack -----");
    }

    // 差戻し後引戻し
    @Override
    public void sendBackToPullBack(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - sendBackToPullBack -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - sendBackToPullBack -----");
    }

    // 承認
    @Override
    public void approve(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - approve -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - approve -----");
    }

    // 承認終了
    @Override
    public void approveEnd(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - approveEnd -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - approveEnd -----");
    }

    // 否認
    @Override
    public void deny(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - deny -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - deny -----");
    }

    // 差戻し
    @Override
    public void sendBack(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - sendBack -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - sendBack -----");
    }

    // 保留
    @Override
    public void reserve(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - reserve -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - reserve -----");
    }

    // 保留解除
    @Override
    public void reserveCancel(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - reserveCancel -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - reserveCancel -----");
    }

    // 案件操作
    @Override
    public void matterHandle(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - matterHandle -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - matterHandle -----");
    }

    // 一時保存(新規登録)
    @Override
    public void tempSaveCreate(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - tempSaveCreate -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - tempSaveCreate -----");

        String itemAmount = (String) userParameter.get("item_amount");
        String itemPrice  = (String) userParameter.get("item_price");
        if (itemAmount.equals("")) {
            itemAmount = "0";
        }
        if (itemPrice.equals("")) {
            itemPrice = "0";
        }

        final UserMatterPropertyModel matterPropertyModel = new UserMatterPropertyModel();
        matterPropertyModel.setUserDataId(parameter.getUserDataId());
        matterPropertyModel.setMatterPropertyKey("item_total");
        matterPropertyModel.setMatterPropertyValue(
                Integer.valueOf(itemAmount).intValue()
                * Integer.valueOf(itemPrice).intValue() + "");

        final UserActvMatterPropertyValue property = new UserActvMatterPropertyValue();
        final UserMatterPropertyModel[] matterProperty = new UserMatterPropertyModel[1];
        matterProperty[0] = matterPropertyModel;

        property.createMatterProperty(matterProperty);
    }

    // 一時保存(更新)
    @Override
    public void tempSaveUpdate(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - tempSaveUpdate -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - tempSaveUpdate -----");

        String itemAmount = (String) userParameter.get("item_amount");
        String itemPrice  = (String) userParameter.get("item_price");
        if (itemAmount.equals("")) {
            itemAmount = "0";
        }
        if (itemPrice.equals("")) {
            itemPrice = "0";
        }

        final UserMatterPropertyModel matterPropertyModel = new UserMatterPropertyModel();
        matterPropertyModel.setUserDataId(parameter.getUserDataId());
        matterPropertyModel.setMatterPropertyKey("item_total");
        matterPropertyModel.setMatterPropertyValue(
                Integer.valueOf(itemAmount).intValue()
                * Integer.valueOf(itemPrice).intValue() + "");

        final UserActvMatterPropertyValue property = new UserActvMatterPropertyValue();
        final UserMatterPropertyModel[] matterProperty = new UserMatterPropertyModel[1];
        matterProperty[0] = matterPropertyModel;

        property.updateMatterProperty(matterProperty);
    }

    // 一時保存(削除)
    @Override
    public void tempSaveDelete(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter2 - tempSaveDelete -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales       : ");
        }
        System.out.println("ContentsId          : " + parameter.getContentsId());
        System.out.println("ContentsVersionId   : " + parameter.getContentsVersionId());
        System.out.println("RouteId             : " + parameter.getRouteId());
        System.out.println("RouteVersionId      : " + parameter.getRouteVersionId());
        System.out.println("FlowId              : " + parameter.getFlowId());
        System.out.println("FlowVersionId       : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate       : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate         : " + parameter.getProcessDate());
        System.out.println("SystemMatterId      : " + parameter.getSystemMatterId());
        System.out.println("UserDataId          : " + parameter.getUserDataId());
        System.out.println("MatterName          : " + parameter.getMatterName());
        System.out.println("MatterNumber        : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel       : " + parameter.getPriorityLevel());
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("NodeId              : " + parameter.getNodeId());
        if (parameter.getNextNodeIds() != null) {
            System.out.print("NextNodeIds         : ");
            for (String str : parameter.getNextNodeIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("NextNodeIds         : ");
        }
        System.out.println("AuthUserCd          : " + parameter.getAuthUserCd());
        System.out.println("ExecUserCd          : " + parameter.getExecUserCd());
        System.out.println("ResultStatus        : " + parameter.getResultStatus());
        System.out.println("AuthCompanyCode     : " + parameter.getAuthCompanyCode());
        System.out.println("AuthOrgzSetCode     : " + parameter.getAuthOrgzSetCode());
        System.out.println("AuthOrgzCode        : " + parameter.getAuthOrgzCode());
        System.out.println("ProcessComment      : " + parameter.getProcessComment());
        System.out.println("LumpProcessFlag     : " + parameter.getLumpProcessFlag());
        System.out.println("AutoProcessFlag     : " + parameter.getAutoProcessFlag());
        System.out.println("----- ActionProcessParameter2 - tempSaveDelete -----");

        final UserMatterPropertyModel matterPropertyModel = new UserMatterPropertyModel();
        matterPropertyModel.setUserDataId(parameter.getUserDataId());
        matterPropertyModel.setMatterPropertyKey("item_total");

        final UserActvMatterPropertyValue property = new UserActvMatterPropertyValue();
        final UserMatterPropertyModel[] matterProperty = new UserMatterPropertyModel[1];
        matterProperty[0] = matterPropertyModel;

        property.deleteMatterProperty(matterProperty);
    }

}
