package jp.co.intra_mart.sample.workflow.purchase.plugin.authority.item_total.controller.service;

import javax.servlet.http.HttpServletRequest;

import jp.co.intra_mart.foundation.security.exception.AccessSecurityException;
import jp.co.intra_mart.foundation.security.message.MessageManager;
import jp.co.intra_mart.framework.base.service.ServiceControllerAdapter;
import jp.co.intra_mart.framework.base.service.ServiceResult;
import jp.co.intra_mart.framework.system.exception.ApplicationException;
import jp.co.intra_mart.framework.system.exception.SystemException;

/**
 * サンプル用処理対象者プラグインを選択した際に呼ばれるサービスコントローラー
 * @author INTRAMART
 * @version 8.0.6
 * @since 7.2
 */
public class ItemTotalConfigServiceController extends ServiceControllerAdapter {

    public ItemTotalConfigServiceController() {
        super();
    }

    @Override
    public ServiceResult service() throws SystemException, ApplicationException {
        final HttpServletRequest request = getRequest();
        final ItemTotalConfigServiceResult serviceResult = new ItemTotalConfigServiceResult();
        try {
            serviceResult.setParentCallBackFunction(request.getParameter("callBackFunction"));
            serviceResult.setExtensionPointId(request.getParameter("extensionPointId"));
            serviceResult.setPluginId(request.getParameter("pluginId"));
            serviceResult.setParameter(request.getParameter("pluginName"));
            serviceResult.setPluginName(MessageManager.getInstance().getMessage(request.getParameter("pluginName")));
            serviceResult.setDisplayName(MessageManager.getInstance().getMessage(request.getParameter("pluginName")));
            serviceResult.setTargetDate(request.getParameter("targetDate"));
            serviceResult.setTargetType("");
            serviceResult.setTargetCode("");
        } catch (final AccessSecurityException e) {
            throw new SystemException(e);
        }

        return serviceResult;
    }
}
