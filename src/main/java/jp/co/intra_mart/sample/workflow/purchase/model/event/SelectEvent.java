package jp.co.intra_mart.sample.workflow.purchase.model.event;

import jp.co.intra_mart.framework.base.event.Event;

public class SelectEvent extends Event {

    private static final long serialVersionUID = 1L;

    private String userDataId;

    /**
     * SelectEventを新規に生成します。
     * 
     */
    public SelectEvent() {
        super();
        userDataId = "";
    }

    /**
     * ユーザデータIDを設定します。
     * 
     * @param value ユーザデータID
     */
    public void setUserDataId(final String value) {
        userDataId = value;
    }

    /**
     * ユーザデータIDを返却します。
     * 
     * @return ユーザデータID
     */
    public String getUserDataId() {
        return userDataId;
    }

}
