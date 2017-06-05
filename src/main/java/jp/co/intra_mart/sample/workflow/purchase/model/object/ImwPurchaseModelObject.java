package jp.co.intra_mart.sample.workflow.purchase.model.object;

import java.io.Serializable;

public class ImwPurchaseModelObject implements Serializable {

    private static final long serialVersionUID = 1L;

    /* ユーザデータID */
    private String userDataId;
    /* システム案件ID */
    private String systemMtterId;
    /* 品名 */
    private String itemName;
    /* 数量 */
    private String itemAmount;
    /* 金額 */
    private String itemPrice;
    /* 合計 */
    private String itemTotal;
    /* 備考 */
    private String itemComment;
    /* 終了フラグ */
    private String endFlag;
    /* アーカイブフラグ */
    private String archiveFlag;

    /**
     * ImwTPurchaseModelObjectを新規に生成します。
     * 
     */
    public ImwPurchaseModelObject() {
        this.setUserDataId("");
        this.setSystemMtterId("");
        this.setItemName("");
        this.setItemAmount("");
        this.setItemPrice("");
        this.setItemTotal("");
        this.setItemComment("");
        this.setEndFlag("");
        this.setArchiveFlag("");
    }

    /**
     * ユーザデータIDを取得します。
     * 
     * @return userDataId ユーザデータID
     */
    public String getUserDataId() {
        return this.userDataId;
    }

    /**
     * ユーザデータIDを設定します。
     * 
     * @param userDataId ユーザデータID
     */
    public void  setUserDataId(final String userDataId) {
        this.userDataId = userDataId;
    }

    /**
     * システム案件IDを取得します。
     * 
     * @return systemMtterId システム案件ID
     */
    public String getSystemMtterId() {
        return this.systemMtterId;
    }

    /**
     * システム案件IDを設定します。
     * 
     * @param systemMtterId システム案件ID
     */
    public void  setSystemMtterId(final String systemMtterId) {
        this.systemMtterId = systemMtterId;
    }

    /**
     * 品名を取得します。
     * 
     * @return itemName 品名
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * 品名を設定します。
     * 
     * @param itemName 品名
     */
    public void  setItemName(final String itemName) {
        this.itemName = itemName;
    }

    /**
     * 数量を取得します。
     * 
     * @return itemAmount 数量
     */
    public String getItemAmount() {
        return this.itemAmount;
    }

    /**
     * 数量を設定します。
     * 
     * @param itemAmount 数量
     */
    public void  setItemAmount(final String itemAmount) {
        this.itemAmount = itemAmount;
    }

    /**
     * 金額を取得します。
     * 
     * @return itemPrice 金額
     */
    public String getItemPrice() {
        return this.itemPrice;
    }

    /**
     * 金額を設定します。
     * 
     * @param itemPrice 金額
     */
    public void  setItemPrice(final String itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * 合計を取得します。
     * 
     * @return itemTotal 合計
     */
    public String getItemTotal() {
        return this.itemTotal;
    }

    /**
     * 合計を設定します。
     * 
     * @param itemTotal 合計
     */
    public void  setItemTotal(final String itemTotal) {
        this.itemTotal = itemTotal;
    }

    /**
     * 備考を取得します。
     * 
     * @return itemComment 備考
     */
    public String getItemComment() {
        return itemComment;
    }

    /**
     * 備考を設定します。
     * 
     * @param itemComment 備考
     */
    public void setItemComment(final String itemComment) {
        this.itemComment = itemComment;
    }

    /**
     * 終了フラグを取得します。
     * 
     * @return endFlag 終了フラグ
     */
    public String getEndFlag() {
        return this.endFlag;
    }

    /**
     * 終了フラグを設定します。
     * 
     * @param endFlag 終了フラグ
     */
    public void  setEndFlag(final String endFlag) {
        this.endFlag = endFlag;
    }
    
    /**
     * アーカイブフラグを取得します。
     * 
     * @return archiveFlag アーカイブフラグ
     */
    public String getArchiveFlag() {
        return this.archiveFlag;
    }

    /**
     * アーカイブフラグを設定します。
     * 
     * @param archiveFlag アーカイブフラグ
     */
    public void  setArchiveFlag(final String archiveFlag) {
        this.archiveFlag = archiveFlag;
    }
    
}
