package jp.co.intra_mart.sample.workflow.purchase.action;

import jp.co.intra_mart.foundation.workflow.plugin.rule.condition.RuleConditionEventListener;
import jp.co.intra_mart.foundation.workflow.plugin.rule.condition.RuleConditionParameter;
import jp.co.intra_mart.framework.base.event.EventManager;
import jp.co.intra_mart.sample.workflow.purchase.model.event.SelectEvent;
import jp.co.intra_mart.sample.workflow.purchase.model.event.SelectEventResult;
import jp.co.intra_mart.sample.workflow.purchase.model.object.ImwPurchaseModelObject;

/**
 * 分岐条件／分岐結合処理プログラム テンプレート<p>
 *
 * @author  INTRAMART
 *
 * このプログラム中ではDBトランザクションを張らないで下さい。<br>
 */
public class RuleCondition3 extends RuleConditionEventListener {

    public RuleCondition3() {
        super();
    }

    /**
     * 分岐条件／分岐結合処理プログラムの実行メソッド<p>
     *
     * @param parameter RuleConditionParameter
     *
     * @return true/false
     *
     * @throws Exception 
     */
    public boolean execute(final RuleConditionParameter parameter) throws Exception {
        System.out.println("----- RuleCondition3 - execute -----");
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
        System.out.println("Parameter           : " + parameter.getParameter());
        System.out.println("NodeId              : " + parameter.getNodeId());
        System.out.println("----- RuleCondition3 - execute -----");

        final int maximum = 50000;

        boolean result = false;

        final EventManager eventManager = EventManager.getEventManager();
        final SelectEvent selectEvent = (SelectEvent) eventManager.createEvent("imw_sample_purchase", "select");
        selectEvent.setUserDataId(parameter.getUserDataId());
        final SelectEventResult eventResult = (SelectEventResult) eventManager.dispatch(selectEvent, true);
        if (eventResult.getModelObject() != null){
            final ImwPurchaseModelObject modelObject = eventResult.getModelObject();
            if (Integer.valueOf(modelObject.getItemTotal()).intValue() >= maximum) {
                result = true;
            }
        }

        return result;
    }
}
