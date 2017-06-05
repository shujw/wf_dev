package jp.co.intra_mart.sample.workflow.purchase.controller.service;

import javax.servlet.http.HttpServletRequest;

import jp.co.intra_mart.framework.base.service.DefaultTransition;
import jp.co.intra_mart.framework.base.service.ServicePropertyException;
import jp.co.intra_mart.framework.base.service.TransitionException;

public class ApplyServiceTransition extends DefaultTransition {

    @Override
    public String getNextPage() throws ServicePropertyException, TransitionException {
        final ApplyServiceResult serviceResult = (ApplyServiceResult) getResult();
        return getNextPagePath(serviceResult.getNextPageServiceId());
    }

    @Override
    public void setInformation() throws TransitionException {
        final HttpServletRequest request = getRequest();
        final ApplyServiceResult serviceResult = (ApplyServiceResult) getResult();
        request.setAttribute("imwGroupId", serviceResult.getImwGroupId());
        request.setAttribute("imwUserCode", serviceResult.getImwUserCode());
        request.setAttribute("imwPageType", serviceResult.getImwPageType());
        request.setAttribute("imwUserDataId", serviceResult.getImwUserDataId());
        request.setAttribute("imwSystemMatterId", serviceResult.getImwSystemMatterId());
        request.setAttribute("imwNodeId", serviceResult.getImwNodeId());
        request.setAttribute("imwArriveType", serviceResult.getImwArriveType());
        request.setAttribute("imwAuthUserCode", serviceResult.getImwAuthUserCode());
        request.setAttribute("imwApplyBaseDate", serviceResult.getImwApplyBaseDate());
        request.setAttribute("imwContentsId", serviceResult.getImwContentsId());
        request.setAttribute("imwContentsVersionId", serviceResult.getImwContentsVersionId());
        request.setAttribute("imwRouteId", serviceResult.getImwRouteId());
        request.setAttribute("imwRouteVersionId", serviceResult.getImwRouteVersionId());
        request.setAttribute("imwFlowId", serviceResult.getImwFlowId());
        request.setAttribute("imwFlowVersionId", serviceResult.getImwFlowVersionId());
        request.setAttribute("imwCallOriginalParams", serviceResult.getImwCallOriginalParams());
        request.setAttribute("imwCallOriginalPagePath", serviceResult.getImwCallOriginalPagePath());
        request.setAttribute("item_name", serviceResult.getItemName());
        request.setAttribute("item_amount", serviceResult.getItemAmount());
        request.setAttribute("item_price", serviceResult.getItemPrice());
        request.setAttribute("item_total", serviceResult.getItemTotal());
        request.setAttribute("item_comment", serviceResult.getItemComment());
    }
}
