package jp.co.intra_mart.sample.workflow.purchase.model.event;

import jp.co.intra_mart.foundation.context.Contexts;
import jp.co.intra_mart.foundation.context.model.AccountContext;
import jp.co.intra_mart.framework.base.event.Event;
import jp.co.intra_mart.framework.base.event.EventResult;
import jp.co.intra_mart.framework.base.event.StandardEventListener;
import jp.co.intra_mart.framework.system.exception.ApplicationException;
import jp.co.intra_mart.framework.system.exception.SystemException;
import jp.co.intra_mart.sample.workflow.purchase.model.data.ImwPurchaseDAOIF;
import jp.co.intra_mart.sample.workflow.purchase.model.object.ImwPurchaseModelObject;

public class SelectEventListener extends StandardEventListener {

    protected EventResult fire(final Event event) throws SystemException, ApplicationException {
        final SelectEvent selectEvent = (SelectEvent) event;
        final String userDataId = selectEvent.getUserDataId();
        final AccountContext context = Contexts.get(AccountContext.class);
        final ImwPurchaseDAOIF dao = (ImwPurchaseDAOIF) getDAO("imw_sample_purchase", "imwpurchase", context.getLoginGroupId());
        final ImwPurchaseModelObject modelObject = dao.select(userDataId);
        final SelectEventResult selectEventResult = new SelectEventResult();
        selectEventResult.setModelObject(modelObject);
        return selectEventResult;
    }

}
