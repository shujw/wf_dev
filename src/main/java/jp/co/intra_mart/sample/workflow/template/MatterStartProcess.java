package jp.co.intra_mart.sample.workflow.template;

import jp.co.intra_mart.foundation.workflow.plugin.process.matter_start.MatterStartProcessEventListener;
import jp.co.intra_mart.foundation.workflow.plugin.process.matter_start.MatterStartProcessParameter;

/**
 * 案件開始処理プログラム テンプレート<p>
 *
 * @author  INTRAMART
 * 
 * このプログラム中ではDBトランザクションを張らないで下さい。<br>
 */
public class MatterStartProcess extends MatterStartProcessEventListener {

    public MatterStartProcess() {
        super();
    }

    /**
     * 案件開始処理プログラムの実行メソッド<p>
     * 
     * @param parameter MatterStartProcessParameter
     * 
     * @throws Exception 
     */
    public void execute(final MatterStartProcessParameter parameter) throws Exception {
        System.out.println("----- MatterStartProcess - execute -----");
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
        System.out.println("----- MatterStartProcess - execute -----");
    }
    
}
