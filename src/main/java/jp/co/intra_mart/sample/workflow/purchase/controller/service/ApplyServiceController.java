package jp.co.intra_mart.sample.workflow.purchase.controller.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import jp.co.intra_mart.foundation.security.exception.AccessSecurityException;
import jp.co.intra_mart.foundation.security.message.MessageManager;
import jp.co.intra_mart.foundation.service.client.information.Identifier;
import jp.co.intra_mart.foundation.ui.page.Transfer;
import jp.co.intra_mart.foundation.ui.page.Transfer.Message;
import jp.co.intra_mart.framework.base.service.ServiceControllerAdapter;
import jp.co.intra_mart.framework.base.service.ServiceResult;
import jp.co.intra_mart.framework.system.exception.ApplicationException;
import jp.co.intra_mart.framework.system.exception.SystemException;
import jp.co.intra_mart.sample.workflow.purchase.model.event.SelectEvent;
import jp.co.intra_mart.sample.workflow.purchase.model.event.SelectEventResult;
import jp.co.intra_mart.sample.workflow.purchase.model.object.ImwPurchaseModelObject;

/**
 * サンプル用申請画面を表示するためのサービスコントローラー
 * @author INTRAMART
 * @version 8.0.6
 * @since 7.2
 */
public class ApplyServiceController extends ServiceControllerAdapter {

    public ApplyServiceController() {
        super();
    }

    @Override
    public ServiceResult service() throws SystemException, ApplicationException {
        final HttpServletRequest request = getRequest();

        final ApplyServiceResult serviceResult = new ApplyServiceResult();
        serviceResult.setImwGroupId(request.getParameter("imwGroupId"));
        serviceResult.setImwUserCode(request.getParameter("imwUserCode"));
        serviceResult.setImwPageType(request.getParameter("imwPageType"));
        serviceResult.setImwUserDataId(request.getParameter("imwUserDataId"));
        serviceResult.setImwSystemMatterId(request.getParameter("imwSystemMatterId"));
        serviceResult.setImwNodeId(request.getParameter("imwNodeId"));
        serviceResult.setImwArriveType(request.getParameter("imwArriveType"));
        serviceResult.setImwAuthUserCode("");
        serviceResult.setImwApplyBaseDate(request.getParameter("imwApplyBaseDate"));
        serviceResult.setImwContentsId(request.getParameter("imwContentsId"));
        serviceResult.setImwContentsVersionId(request.getParameter("imwContentsVersionId"));
        serviceResult.setImwRouteId(request.getParameter("imwRouteId"));
        serviceResult.setImwRouteVersionId(request.getParameter("imwRouteVersionId"));
        serviceResult.setImwFlowId(request.getParameter("imwFlowId"));
        serviceResult.setImwFlowVersionId(request.getParameter("imwFlowVersionId"));
        serviceResult.setImwCallOriginalParams(request.getParameter("imwCallOriginalParams"));
        serviceResult.setImwCallOriginalPagePath(request.getParameter("imwCallOriginalPagePath"));

        final String[] imwAuthUserCodeList = request.getParameterValues("imwAuthUserCode");
        if (imwAuthUserCodeList != null && imwAuthUserCodeList.length == 1) {
            serviceResult.setImwAuthUserCode(imwAuthUserCodeList[0]);
        }

        String item_name = "";
        String item_amount = "";
        String item_price = "";
        String item_comment = "";

        if (request.getParameter("imwPageType").equals("0") || request.getParameter("imwPageType").equals("10")) {
            // 申請
            String userDataId = "";
            final Identifier identifier = new Identifier();
            try {
                userDataId = identifier.get();
            } catch (final IOException e) {
                final Message message = new Message();
                try {
                    message.setTitle(MessageManager.getInstance().getMessage("SAMPLE.IMW.ERR.004"));
                    message.setMessage(MessageManager.getInstance().getMessage("SAMPLE.IMW.ERR.004"));
                    final String[] details = { e.getMessage() };
                    message.setDetails(details);
                    Transfer.toErrorPage(message);
                } catch (final AccessSecurityException e1) {
                    throw new SystemException(e1);
                } catch (final IOException e1) {
                    throw new SystemException(e1);
                }
                return serviceResult;
            }
            serviceResult.setImwUserDataId(userDataId);
        } else if (request.getParameter("imwPageType").equals("2") || request.getParameter("imwPageType").equals("12")) {
            // 起票
        } else {
            // 一時保存 or 再申請
            final SelectEvent event = (SelectEvent) createEvent("imw_sample_purchase", "select");
            event.setUserDataId(request.getParameter("imwUserDataId"));

            SelectEventResult eventResult = null;
            try {
                eventResult = (SelectEventResult) dispatchEvent(event);
            } catch (final SystemException e) {
                final Message message = new Message();
                try {
                    message.setTitle(MessageManager.getInstance().getMessage("SAMPLE.IMW.ERR.004"));
                    message.setMessage(MessageManager.getInstance().getMessage("SAMPLE.IMW.ERR.004"));
                    final String[] details = { e.getMessage() };
                    message.setDetails(details);
                    Transfer.toErrorPage(message);
                } catch (final AccessSecurityException e1) {
                    throw new SystemException(e1);
                } catch (final IOException e1) {
                    throw new SystemException(e1);
                }
                return serviceResult;
            }

            if (eventResult.getModelObject() == null) {
                final Message message = new Message();
                try {
                    message.setTitle(MessageManager.getInstance().getMessage("SAMPLE.IMW.ERR.004"));
                    message.setMessage(MessageManager.getInstance().getMessage("SAMPLE.IMW.ERR.004"));
                    final String[] details = { MessageManager.getInstance().getMessage("SAMPLE.IMW.ERR.005") };
                    message.setDetails(details);
                    Transfer.toErrorPage(message);
                } catch (final AccessSecurityException e) {
                    throw new SystemException(e);
                } catch (final IOException e) {
                    throw new SystemException(e);
                }
                return serviceResult;
            }

            final ImwPurchaseModelObject modelObject = eventResult.getModelObject();
            item_name = modelObject.getItemName();
            item_amount = modelObject.getItemAmount();
            item_price = modelObject.getItemPrice();
            if (modelObject.getItemComment() != null) {
                item_comment = modelObject.getItemComment();
            }
        }
        serviceResult.setItemName(item_name);
        serviceResult.setItemAmount(item_amount);
        serviceResult.setItemPrice(item_price);
        serviceResult.setItemComment(item_comment);

        return serviceResult;
    }
}
