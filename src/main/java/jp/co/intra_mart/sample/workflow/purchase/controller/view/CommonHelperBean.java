package jp.co.intra_mart.sample.workflow.purchase.controller.view;

import java.io.Serializable;

import jp.co.intra_mart.foundation.BaseUrl;
import jp.co.intra_mart.foundation.context.Contexts;
import jp.co.intra_mart.foundation.context.model.AccountContext;
import jp.co.intra_mart.foundation.security.exception.AccessSecurityException;
import jp.co.intra_mart.foundation.security.message.MessageManager;
import jp.co.intra_mart.framework.base.web.bean.HelperBean;
import jp.co.intra_mart.framework.base.web.bean.HelperBeanException;

public class CommonHelperBean extends HelperBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public CommonHelperBean() throws HelperBeanException {
        super();
    }

    public String getMessage(final String key) throws HelperBeanException, AccessSecurityException {
        final AccountContext context = Contexts.get(AccountContext.class);
        return MessageManager.getInstance().getMessage(context.getLocale(), key);
    }

    public String getHomeUrl() {
        final AccountContext context = Contexts.get(AccountContext.class);
        return BaseUrl.get(getRequest()) + context.getHomeUrl();
    }
}
