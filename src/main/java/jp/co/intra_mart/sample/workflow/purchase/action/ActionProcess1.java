package jp.co.intra_mart.sample.workflow.purchase.action;

import java.util.Map;

import jp.co.intra_mart.common.aid.jdk.java.util.LocaleUtil;
import jp.co.intra_mart.foundation.security.message.MessageManager;
import jp.co.intra_mart.foundation.workflow.exception.WorkflowException;
import jp.co.intra_mart.foundation.workflow.exception.WorkflowExternalException;
import jp.co.intra_mart.foundation.workflow.plugin.process.action.ActionProcessEventListener;
import jp.co.intra_mart.foundation.workflow.plugin.process.action.ActionProcessParameter;
import jp.co.intra_mart.foundation.workflow.util.WorkflowNumberingManager;
import jp.co.intra_mart.framework.base.event.EventManager;
import jp.co.intra_mart.framework.system.exception.SystemException;
import jp.co.intra_mart.sample.workflow.purchase.model.event.DeleteEvent;
import jp.co.intra_mart.sample.workflow.purchase.model.event.InsertEvent;
import jp.co.intra_mart.sample.workflow.purchase.model.event.UpdateEvent;
import jp.co.intra_mart.sample.workflow.purchase.model.object.ImwPurchaseModelObject;

/**
 * アクション処理プログラム テンプレート<p>
 *
 * @author  INTRAMART
 *
 * このプログラム中ではDBトランザクションを張らないで下さい。<br>
 */
public class ActionProcess1 extends ActionProcessEventListener {

    public ActionProcess1() {
        super();
    }

    // 申請
    @Override
    public String apply(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - apply -----");
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
        System.out.println("----- ActionProcessParameter1 - apply -----");

        String number = null;
        try {
            number = WorkflowNumberingManager.getNumber();
        } catch (final WorkflowException e) {
            throw new WorkflowExternalException(MessageManager.getInstance().getMessage(LocaleUtil.toLocale(parameter.getLocaleId()), "SAMPLE.IMW.ERR.003"));
        }
        final ImwPurchaseModelObject modelObject = new ImwPurchaseModelObject();
        modelObject.setUserDataId(parameter.getUserDataId());
        modelObject.setSystemMtterId(parameter.getSystemMatterId());
        modelObject.setItemName((String) userParameter.get("item_name"));
        modelObject.setItemAmount((String) userParameter.get("item_amount"));
        modelObject.setItemPrice((String) userParameter.get("item_price"));
        modelObject.setItemTotal(Integer.valueOf(modelObject.getItemAmount()).intValue() * Integer.valueOf(modelObject.getItemPrice()).intValue() + "");
        modelObject.setItemComment((String) userParameter.get("item_comment"));
        modelObject.setEndFlag("0");
        modelObject.setArchiveFlag("0");

        // 申請
        final EventManager eventManager = EventManager.getEventManager();
        final InsertEvent insertEvent = (InsertEvent) eventManager.createEvent("imw_sample_purchase", "insert");
        insertEvent.setModelObject(modelObject);
        try {
            eventManager.dispatch(insertEvent, true);
        } catch (final SystemException e) {
            throw new WorkflowExternalException(
                    MessageManager.getInstance().getMessage(
                            LocaleUtil.toLocale(
                                    parameter.getLocaleId()), "SAMPLE.IMW.ERR.000"));
        }
        return number;
    }

    // 再申請
    @Override
    public String reapply(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - reapply -----");
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
        System.out.println("----- ActionProcessParameter1 - reapply -----");

        final ImwPurchaseModelObject modelObject = new ImwPurchaseModelObject();
        modelObject.setUserDataId(parameter.getUserDataId());
        modelObject.setSystemMtterId(parameter.getSystemMatterId());
        modelObject.setItemName((String) userParameter.get("item_name"));
        modelObject.setItemAmount((String) userParameter.get("item_amount"));
        modelObject.setItemPrice((String) userParameter.get("item_price"));
        modelObject.setItemTotal(Integer.valueOf(modelObject.getItemAmount()).intValue() * Integer.valueOf(modelObject.getItemPrice()).intValue() + "");
        modelObject.setItemComment((String) userParameter.get("item_comment"));
        modelObject.setEndFlag("0");
        modelObject.setArchiveFlag("0");

        final EventManager eventManager = EventManager.getEventManager();
        final UpdateEvent updateEvent = (UpdateEvent) eventManager.createEvent("imw_sample_purchase", "update");
        updateEvent.setModelObject(modelObject);

        try {
            eventManager.dispatch(updateEvent, true);
        } catch (final SystemException e) {
            throw new WorkflowExternalException(
                    MessageManager.getInstance().getMessage(
                            LocaleUtil.toLocale(
                                    parameter.getLocaleId()), "SAMPLE.IMW.ERR.001"));
        }

        return null;
    }

    // 申請(一時保存案件)
    @Override
    public String applyFromTempSave(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - applyFromTempSave -----");
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
        System.out.println("----- ActionProcessParameter1 - applyFromTempSave -----");

        String number = null;
        try {
            number = WorkflowNumberingManager.getNumber();
        } catch (final WorkflowException e) {
            throw new WorkflowExternalException(MessageManager.getInstance().getMessage(LocaleUtil.toLocale(parameter.getLocaleId()), "SAMPLE.IMW.ERR.003"));
        }
        final ImwPurchaseModelObject modelObject = new ImwPurchaseModelObject();
        modelObject.setUserDataId(parameter.getUserDataId());
        modelObject.setSystemMtterId(parameter.getSystemMatterId());
        modelObject.setItemName((String) userParameter.get("item_name"));
        modelObject.setItemAmount((String) userParameter.get("item_amount"));
        modelObject.setItemPrice((String) userParameter.get("item_price"));
        modelObject.setItemTotal(Integer.valueOf(modelObject.getItemAmount()).intValue() * Integer.valueOf(modelObject.getItemPrice()).intValue() + "");
        modelObject.setItemComment((String) userParameter.get("item_comment"));
        modelObject.setEndFlag("0");
        modelObject.setArchiveFlag("0");

        // 一時保存 → 申請
        final EventManager eventManager = EventManager.getEventManager();
        final UpdateEvent updateEvent = (UpdateEvent) eventManager.createEvent("imw_sample_purchase", "update");
        updateEvent.setModelObject(modelObject);
        try {
            eventManager.dispatch(updateEvent, true);
        } catch (final SystemException e) {
            throw new WorkflowExternalException(
                    MessageManager.getInstance().getMessage(
                            LocaleUtil.toLocale(
                                    parameter.getLocaleId()), "SAMPLE.IMW.ERR.001"));
        }
        return number;
    }

    // 申請(未申請状態案件)
    @Override
    public String applyFromUnapply(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - applyFromUnapply -----");
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
        System.out.println("----- ActionProcessParameter1 - applyFromUnapply -----");

        String number = null;
        try {
            number = WorkflowNumberingManager.getNumber();
        } catch (final WorkflowException e) {
            throw new WorkflowExternalException(MessageManager.getInstance().getMessage(LocaleUtil.toLocale(parameter.getLocaleId()), "SAMPLE.IMW.ERR.003"));
        }
        final ImwPurchaseModelObject modelObject = new ImwPurchaseModelObject();
        modelObject.setUserDataId(parameter.getUserDataId());
        modelObject.setSystemMtterId(parameter.getSystemMatterId());
        modelObject.setItemName((String) userParameter.get("item_name"));
        modelObject.setItemAmount((String) userParameter.get("item_amount"));
        modelObject.setItemPrice((String) userParameter.get("item_price"));
        modelObject.setItemTotal(Integer.valueOf(modelObject.getItemAmount()).intValue() * Integer.valueOf(modelObject.getItemPrice()).intValue() + "");
        modelObject.setItemComment((String) userParameter.get("item_comment"));
        modelObject.setEndFlag("0");
        modelObject.setArchiveFlag("0");

        // 未申請 → 申請
        final EventManager eventManager = EventManager.getEventManager();
        final InsertEvent insertEvent = (InsertEvent) eventManager.createEvent("imw_sample_purchase", "insert");
        insertEvent.setModelObject(modelObject);
        try {
            eventManager.dispatch(insertEvent, true);
        } catch (final SystemException e) {
            throw new WorkflowExternalException(
                    MessageManager.getInstance().getMessage(
                            LocaleUtil.toLocale(
                                    parameter.getLocaleId()), "SAMPLE.IMW.ERR.000"));
        }
        return number;
    }

    // 取止め
    @Override
    public void discontinue(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - discontinue -----");
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
        System.out.println("----- ActionProcessParameter1 - discontinue -----");
    }

    // 引戻し
    @Override
    public void pullBack(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - pullBack -----");
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
        System.out.println("----- ActionProcessParameter1 - pullBack -----");
    }

    // 差戻し後引戻し
    @Override
    public void sendBackToPullBack(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - sendBackToPullBack -----");
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
        System.out.println("----- ActionProcessParameter1 - sendBackToPullBack -----");
    }

    // 承認
    @Override
    public void approve(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - approve -----");
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
        System.out.println("----- ActionProcessParameter1 - approve -----");
    }

    // 承認終了
    @Override
    public void approveEnd(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - approveEnd -----");
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
        System.out.println("----- ActionProcessParameter1 - approveEnd -----");
    }

    // 否認
    @Override
    public void deny(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - deny -----");
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
        System.out.println("----- ActionProcessParameter1 - deny -----");
    }

    // 差戻し
    @Override
    public void sendBack(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - sendBack -----");
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
        System.out.println("----- ActionProcessParameter1 - sendBack -----");
    }

    // 保留
    @Override
    public void reserve(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - reserve -----");
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
        System.out.println("----- ActionProcessParameter1 - reserve -----");
    }

    // 保留解除
    @Override
    public void reserveCancel(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - reserveCancel -----");
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
        System.out.println("----- ActionProcessParameter1 - reserveCancel -----");
    }

    // 案件操作
    @Override
    public void matterHandle(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - matterHandle -----");
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
        System.out.println("----- ActionProcessParameter1 - matterHandle -----");
    }

    // 一時保存(新規登録)
    @Override
    public void tempSaveCreate(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - tempSaveCreate -----");
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
        System.out.println("----- ActionProcessParameter1 - tempSaveCreate -----");

        String itemAmount = (String) userParameter.get("item_amount");
        String itemPrice  = (String) userParameter.get("item_price");
        if (itemAmount.equals("")) {
            itemAmount = "0";
        }
        if (itemPrice.equals("")) {
            itemPrice = "0";
        }

        final ImwPurchaseModelObject modelObject = new ImwPurchaseModelObject();
        modelObject.setUserDataId(parameter.getUserDataId());
        modelObject.setSystemMtterId(parameter.getSystemMatterId());
        modelObject.setItemName((String) userParameter.get("item_name"));
        modelObject.setItemAmount((String) userParameter.get("item_amount"));
        modelObject.setItemPrice((String) userParameter.get("item_price"));
        modelObject.setItemTotal(Integer.valueOf(itemAmount).intValue() * Integer.valueOf(itemPrice).intValue() + "");
        modelObject.setItemComment((String) userParameter.get("item_comment"));
        modelObject.setEndFlag("0");
        modelObject.setArchiveFlag("0");

        final EventManager eventManager = EventManager.getEventManager();
        final InsertEvent insertEvent = (InsertEvent) eventManager.createEvent("imw_sample_purchase", "insert");
        insertEvent.setModelObject(modelObject);

        try {
            eventManager.dispatch(insertEvent, true);
        } catch (final SystemException e) {
            throw new WorkflowExternalException(
                    MessageManager.getInstance().getMessage(
                            LocaleUtil.toLocale(
                                    parameter.getLocaleId()), "SAMPLE.IMW.ERR.000"));
        }
    }

    // 一時保存(更新)
    @Override
    public void tempSaveUpdate(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - tempSaveUpdate -----");
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
        System.out.println("----- ActionProcessParameter1 - tempSaveUpdate -----");

        String itemAmount = (String) userParameter.get("item_amount");
        String itemPrice  = (String) userParameter.get("item_price");
        if (itemAmount.equals("")) {
            itemAmount = "0";
        }
        if (itemPrice.equals("")) {
            itemPrice = "0";
        }

        final ImwPurchaseModelObject modelObject = new ImwPurchaseModelObject();
        modelObject.setUserDataId(parameter.getUserDataId());
        modelObject.setSystemMtterId(parameter.getSystemMatterId());
        modelObject.setItemName((String) userParameter.get("item_name"));
        modelObject.setItemAmount((String) userParameter.get("item_amount"));
        modelObject.setItemPrice((String) userParameter.get("item_price"));
        modelObject.setItemTotal(Integer.valueOf(itemAmount).intValue() * Integer.valueOf(itemPrice).intValue() + "");
        modelObject.setItemComment((String) userParameter.get("item_comment"));
        modelObject.setEndFlag("0");
        modelObject.setArchiveFlag("0");

        final EventManager eventManager = EventManager.getEventManager();
        final UpdateEvent updateEvent = (UpdateEvent) eventManager.createEvent("imw_sample_purchase", "update");
        updateEvent.setModelObject(modelObject);

        try {
            eventManager.dispatch(updateEvent, true);
        } catch (final SystemException e) {
            throw new WorkflowExternalException(
                    MessageManager.getInstance().getMessage(
                            LocaleUtil.toLocale(
                                    parameter.getLocaleId()), "SAMPLE.IMW.ERR.001"));
        }
    }

    // 一時保存(削除)
    @Override
    public void tempSaveDelete(final ActionProcessParameter parameter, final Map<String, Object> userParameter) throws Exception {
        System.out.println("----- ActionProcessParameter1 - tempSaveDelete -----");
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
        System.out.println("----- ActionProcessParameter1 - tempSaveDelete -----");

        final EventManager eventManager = EventManager.getEventManager();
        final DeleteEvent deleteEvent = (DeleteEvent) eventManager.createEvent("imw_sample_purchase", "delete");
        deleteEvent.setUserDataId(parameter.getUserDataId());

        try {
            eventManager.dispatch(deleteEvent, true);
        } catch (final SystemException e) {
            throw new WorkflowExternalException(
                    MessageManager.getInstance().getMessage(
                            LocaleUtil.toLocale(
                                    parameter.getLocaleId()), "SAMPLE.IMW.ERR.002"));
        }
    }

}
