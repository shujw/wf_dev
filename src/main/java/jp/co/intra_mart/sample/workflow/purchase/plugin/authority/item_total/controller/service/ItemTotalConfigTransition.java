package jp.co.intra_mart.sample.workflow.purchase.plugin.authority.item_total.controller.service;

import javax.servlet.http.HttpServletRequest;

import jp.co.intra_mart.framework.base.service.DefaultTransition;
import jp.co.intra_mart.framework.base.service.ServicePropertyException;
import jp.co.intra_mart.framework.base.service.TransitionException;

public class ItemTotalConfigTransition extends DefaultTransition {

    public String getNextPage() throws ServicePropertyException, TransitionException {
        final ItemTotalConfigServiceResult serviceResult = (ItemTotalConfigServiceResult) getResult();
        return getNextPagePath((String) serviceResult.getNextPageServiceId());
    }

    public void setInformation() throws TransitionException {
        final HttpServletRequest request = getRequest();
        final ItemTotalConfigServiceResult serviceResult = (ItemTotalConfigServiceResult) getResult();
        request.setAttribute("parentCallBackFunction", (String) serviceResult.getParentCallBackFunction());
        request.setAttribute("extensionPointId", (String) serviceResult.getExtensionPointId());
        request.setAttribute("pluginId", (String) serviceResult.getPluginId());
        request.setAttribute("parameter", (String) serviceResult.getParameter());
        request.setAttribute("pluginName", (String) serviceResult.getPluginName());
        request.setAttribute("displayName", (String) serviceResult.getDisplayName());
        request.setAttribute("targetDate", (String) serviceResult.getTargetDate());
        request.setAttribute("targetType", (String) serviceResult.getTargetType());
        request.setAttribute("targetCode", (String) serviceResult.getTargetCode());
    }
}
