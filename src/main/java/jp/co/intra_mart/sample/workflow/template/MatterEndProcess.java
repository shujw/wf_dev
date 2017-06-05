package jp.co.intra_mart.sample.workflow.template;

import jp.co.intra_mart.foundation.workflow.plugin.process.matter_end.MatterEndProcessEventListener;
import jp.co.intra_mart.foundation.workflow.plugin.process.matter_end.MatterEndProcessParameter;

/**
 * 案件終了処理プログラム テンプレート<p>
 *
 * @author  INTRAMART
 * 
 * このプログラム中ではDBトランザクションを張らないで下さい。<br>
 */
public class MatterEndProcess extends MatterEndProcessEventListener {

    public MatterEndProcess() {
        super();
    }

    /**
     * 案件終了処理プログラムの実行メソッド<p>
     * 
     * @param parameter MatterEndProcessParameter
     * 
     * @return true/false
     * 
     * @throws Exception 
     */
    public boolean execute(final MatterEndProcessParameter parameter) throws Exception {
        System.out.println("----- MatterEndProcess - execute -----");
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
        System.out.println("ActFlag             : " + parameter.getActFlag());
        System.out.println("LastProcessNodeId   : " + parameter.getLastProcessNodeId());
        System.out.println("LastAuthUserCd      : " + parameter.getLastAuthUserCd());
        System.out.println("LastExecUserCd      : " + parameter.getLastExecUserCd());
        System.out.println("LastResultStatus    : " + parameter.getLastResultStatus());
        if (parameter.getMailIds() != null) {
            System.out.print("MailIds             : ");
            for (String str : parameter.getMailIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("MailIds             : ");
        }
        if (parameter.getImBoxIds() != null) {
            System.out.print("ImBoxIds            : ");
            for (String str : parameter.getImBoxIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("ImBoxIds            : ");
        }
        System.out.println("MailReplaceMap      : " + parameter.getMailReplaceMap());
        System.out.println("ImBoxReplaceMap     : " + parameter.getImBoxReplaceMap());
        System.out.println("----- MatterEndProcess - execute -----");
        
        return true;
    }
}
