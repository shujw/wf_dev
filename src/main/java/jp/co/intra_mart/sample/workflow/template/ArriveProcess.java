package jp.co.intra_mart.sample.workflow.template;

import jp.co.intra_mart.foundation.workflow.plugin.process.arrive.ArriveProcessEventListener;
import jp.co.intra_mart.foundation.workflow.plugin.process.arrive.ArriveProcessParameter;

/**
 * 到達処理プログラム テンプレート<p>
 *
 * @author  INTRAMART
 * 
 * このプログラム中で、データベースの登録／更新／削除処理を行
 * う場合は、独自にDBトランザクション制御を行ってください。<br>
 */
public class ArriveProcess extends ArriveProcessEventListener {

    public ArriveProcess() {
        super();
    }

    /**
     * 到達処理プログラムの実行メソッド<p>
     * 
     * @param parameter ArriveProcessParameter
     * 
     * @return true/false
     * 
     * @throws Exception 
     */
    public boolean execute(final ArriveProcessParameter parameter) throws Exception {
        System.out.println("----- ArriveProcess - execute -----");
        System.out.println("LoginGroupId           : " + parameter.getLoginGroupId());
        System.out.println("LocaleId               : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales          : ");
            for (String str : parameter.getTargetLocales()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("TargetLocales          : ");
        }
        System.out.println("ContentsId             : " + parameter.getContentsId());
        System.out.println("ContentsVersionId      : " + parameter.getContentsVersionId());
        System.out.println("RouteId                : " + parameter.getRouteId());
        System.out.println("RouteVersionId         : " + parameter.getRouteVersionId());
        System.out.println("FlowId                 : " + parameter.getFlowId());
        System.out.println("FlowVersionId          : " + parameter.getFlowVersionId());
        System.out.println("ApplyBaseDate          : " + parameter.getApplyBaseDate());
        System.out.println("ProcessDate            : " + parameter.getProcessDate());
        System.out.println("SystemMatterId         : " + parameter.getSystemMatterId());
        System.out.println("UserDataId             : " + parameter.getUserDataId());
        System.out.println("MatterName             : " + parameter.getMatterName());
        System.out.println("MatterNumber           : " + parameter.getMatterNumber());
        System.out.println("PriorityLevel          : " + parameter.getPriorityLevel());
        System.out.println("Parameter              : " + parameter.getParameter());
        System.out.println("NodeId                 : " + parameter.getNodeId());
        System.out.println("ActFlag                : " + parameter.getActFlag());
        System.out.println("PreNodeId              : " + parameter.getPreNodeId());
        System.out.println("PreNodeAuthUserCd      : " + parameter.getPreNodeAuthUserCd());
        System.out.println("PreNodeExecUserCd      : " + parameter.getPreNodeExecUserCd());
        System.out.println("PreNodeResultStatus    : " + parameter.getPreNodeResultStatus());
        System.out.println("PreNodeAuthCompanyCode : " + parameter.getPreNodeAuthCompanyCode());
        System.out.println("PreNodeAuthOrgzSetCode : " + parameter.getPreNodeAuthOrgzSetCode());
        System.out.println("PreNodeAuthOrgzCode    : " + parameter.getPreNodeAuthOrgzCode());
        System.out.println("PreNodeProcessComment  : " + parameter.getPreNodeProcessComment());
        if (parameter.getMailIds() != null) {
            System.out.print("MailIds                : ");
            for (String str : parameter.getMailIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("MailIds                : ");
        }
        if (parameter.getImBoxIds() != null) {
            System.out.print("ImBoxIds               : ");
            for (String str : parameter.getImBoxIds()) {
                System.out.print(str + " ");
            }
            System.out.println();
        } else {
            System.out.println("ImBoxIds               : ");
        }
        System.out.println("MailReplaceMap         : " + parameter.getMailReplaceMap());
        System.out.println("ImBoxReplaceMap        : " + parameter.getImBoxReplaceMap());
        System.out.println("----- ArriveProcess - execute -----");
        
        return true;
    }
}
