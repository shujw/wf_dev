package jp.co.intra_mart.sample.workflow.purchase.model.event;

import jp.co.intra_mart.framework.base.event.Event;
import jp.co.intra_mart.sample.workflow.purchase.model.object.ImwPurchaseModelObject;

public class InsertEvent extends Event {

    private static final long serialVersionUID = 1L;

    private ImwPurchaseModelObject modelObject;

    /**
     * InsertEventを新規に生成します。
     * 
     */
    public InsertEvent() {
        super();
        modelObject = null;
    }

    /**
     * ImwPurchaseModelObject情報を設定します。
     * 
     * @param modelObject ImwPurchaseModelObject
     */
    public void setModelObject(final ImwPurchaseModelObject modelObject) {
        this.modelObject = modelObject;
    }

    /**
     * ImwPurchaseModelObject情報を返却します。
     * 
     * @return ImwPurchaseModelObject
     */
    public ImwPurchaseModelObject getModelObject() {
        return modelObject;
    }
}
