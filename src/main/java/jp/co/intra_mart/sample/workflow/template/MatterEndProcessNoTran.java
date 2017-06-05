package jp.co.intra_mart.sample.workflow.template;

import jp.co.intra_mart.foundation.workflow.plugin.process.matter_end_no_transaction.MatterEndNoTransactionProcessEventListener;
import jp.co.intra_mart.foundation.workflow.plugin.process.matter_end_no_transaction.MatterEndNoTransactionProcessParameter;

/**
 * 案件終了処理（トランザクションなし）プログラム テンプレート<br/>
 * <br/>
 * このプログラム中で、データベースの登録／更新／削除処理を行 う場合は、独自にDBトランザクション制御を行ってください。
 * @author INTRAMART
 * @version 8.0.11
 * @since 8.0.11
 */
public class MatterEndProcessNoTran extends MatterEndNoTransactionProcessEventListener {

    /**
     * コンストラクター。
     */
    public MatterEndProcessNoTran() {
        super();
    }

    /**
     * 案件終了処理（トランザクションなし）プログラムの実行メソッド
     * <p>
     * @param parameter ユーザ指定案件終了処理（トランザクションなし）パラメータ
     * @throws Exception
     * @version 8.0.11
     * @since 8.0.11
     */
    @Override
    public void execute(final MatterEndNoTransactionProcessParameter parameter) throws Exception {
        System.out.println("----- MatterEndProcessNoTran - execute -----");
        System.out.println("LoginGroupId        : " + parameter.getLoginGroupId());
        System.out.println("LocaleId            : " + parameter.getLocaleId());
        if (parameter.getTargetLocales() != null) {
            System.out.print("TargetLocales       : ");
            for (final String str : parameter.getTargetLocales()) {
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
        System.out.println("----- MatterEndProcessNoTran - execute -----");
    }

}
