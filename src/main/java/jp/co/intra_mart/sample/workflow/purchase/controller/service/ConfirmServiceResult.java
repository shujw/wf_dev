package jp.co.intra_mart.sample.workflow.purchase.controller.service;

import jp.co.intra_mart.framework.base.service.ServiceResult;

public class ConfirmServiceResult implements ServiceResult {
    /* 次ページのServiceId */
    private String nextPageServiceId;

    /* ログイングループID */
    private String imwGroupId;

    /* ログインユーザCD */
    private String imwUserCode;

    /* 画面種別 */
    private String imwPageType;

    /* ユーザデータID */
    private String imwUserDataId;

    /* システム案件ID */
    private String imwSystemMatterId;

    /* ノードID */
    private String imwNodeId;

    /* 申請基準日 */
    private String imwApplyBaseDate;

    /* コンテンツID */
    private String imwContentsId;

    /* コンテンツバージョンID */
    private String imwContentsVersionId;

    /* ルートID */
    private String imwRouteId;

    /* ルートバージョンID */
    private String imwRouteVersionId;

    /* フローID */
    private String imwFlowId;

    /* フローバージョンID */
    private String imwFlowVersionId;

    /* 呼出元パラメータ */
    private String imwCallOriginalParams;

    /* 呼出元ページパス */
    private String imwCallOriginalPagePath;

    /* 品名 */
    private String item_name;

    /* 数量 */
    private String item_amount;

    /* 金額 */
    private String item_price;

    /* 合計 */
    private String item_total;

    /* 備考 */
    private String item_comment;

    /**
     * ConfirmServiceResultを初期化します。
     */
    public ConfirmServiceResult() {
        setNextPageServiceId("");
        setImwGroupId("");
        setImwUserCode("");
        setImwPageType("");
        setImwUserDataId("");
        setImwSystemMatterId("");
        setImwNodeId("");
        setImwApplyBaseDate("");
        setImwContentsId("");
        setImwContentsVersionId("");
        setImwRouteId("");
        setImwRouteVersionId("");
        setImwFlowId("");
        setImwFlowVersionId("");
        setImwCallOriginalParams("");
        setImwCallOriginalPagePath("");
        setItemName("");
        setItemAmount("");
        setItemPrice("");
        setItemTotal("");
        setItemComment("");
    }

    /**
     * 申請基準日を取得します。
     * @return 申請基準日
     */
    public String getImwApplyBaseDate() {
        return this.imwApplyBaseDate;
    }

    /**
     * 呼出元ページパスを取得します。
     * @return 呼出元ページパス
     */
    public String getImwCallOriginalPagePath() {
        return this.imwCallOriginalPagePath;
    }

    /**
     * 呼出元パラメータを取得します。
     * @return 呼出元パラメータ
     */
    public String getImwCallOriginalParams() {
        return this.imwCallOriginalParams;
    }

    /**
     * コンテンツIDを取得します。
     * @return コンテンツID
     */
    public String getImwContentsId() {
        return this.imwContentsId;
    }

    /**
     * コンテンツバージョンIDを取得します。
     * @return コンテンツバージョンID
     */
    public String getImwContentsVersionId() {
        return this.imwContentsVersionId;
    }

    /**
     * フローIDを取得します。
     * @return フローID
     */
    public String getImwFlowId() {
        return this.imwFlowId;
    }

    /**
     * フローバージョンIDを取得します。
     * @return フローバージョンID
     */
    public String getImwFlowVersionId() {
        return this.imwFlowVersionId;
    }

    /**
     * ログイングループIDを取得します。
     * @return ログイングループID
     */
    public String getImwGroupId() {
        return this.imwGroupId;
    }

    /**
     * ノードIDを取得します。
     * @return ノードID
     */
    public String getImwNodeId() {
        return this.imwNodeId;
    }

    /**
     * 画面種別を取得します。
     * @return 画面種別
     */
    public String getImwPageType() {
        return this.imwPageType;
    }

    /**
     * ルートIDを取得します。
     * @return ルートID
     */
    public String getImwRouteId() {
        return this.imwRouteId;
    }

    /**
     * ルートバージョンIDを取得します。
     * @return ルートバージョンID
     */
    public String getImwRouteVersionId() {
        return this.imwRouteVersionId;
    }

    /**
     * システム案件IDを取得します。
     * @return システム案件ID
     */
    public String getImwSystemMatterId() {
        return this.imwSystemMatterId;
    }

    /**
     * ログインユーザCDを取得します。
     * @return ログインユーザCD
     */
    public String getImwUserCode() {
        return this.imwUserCode;
    }

    /**
     * ユーザデータIDを取得します。
     * @return ユーザデータID
     */
    public String getImwUserDataId() {
        return this.imwUserDataId;
    }

    /**
     * 数量を取得します。
     * @return 数量
     */
    public String getItemAmount() {
        return item_amount;
    }

    /**
     * 備考を取得します。
     * @return 備考
     */
    public String getItemComment() {
        return item_comment;
    }

    /**
     * 品名を取得します。
     * @return 品名
     */
    public String getItemName() {
        return item_name;
    }

    /**
     * 金額を取得します。
     * @return 金額
     */
    public String getItemPrice() {
        return item_price;
    }

    /**
     * 合計を取得します。
     * @return 合計
     */
    public String getItemTotal() {
        return item_total;
    }

    /**
     * 次ページのServiceIdを取得します。
     * @return 次ページのServiceId
     */
    public String getNextPageServiceId() {
        return this.nextPageServiceId;
    }

    /**
     * 申請基準日を設定します。
     * @param imwApplyBaseDate 申請基準日
     */
    public void setImwApplyBaseDate(final String imwApplyBaseDate) {
        this.imwApplyBaseDate = imwApplyBaseDate;
    }

    /**
     * 呼出元ページパスを設定します。
     * @param imwCallOriginalPagePath 呼出元ページパス
     */
    public void setImwCallOriginalPagePath(final String imwCallOriginalPagePath) {
        this.imwCallOriginalPagePath = imwCallOriginalPagePath;
    }

    /**
     * 呼出元パラメータを設定します。
     * @param imwCallOriginalParams 呼出元パラメータ
     */
    public void setImwCallOriginalParams(final String imwCallOriginalParams) {
        this.imwCallOriginalParams = imwCallOriginalParams;
    }

    /**
     * コンテンツバージョンIDを設定します。
     * @param imwContentsId コンテンツバージョンID
     */
    public void setImwContentsId(final String imwContentsId) {
        this.imwContentsId = imwContentsId;
    }

    /**
     * コンテンツIDを設定します。
     * @param imwContentsVersionId コンテンツID
     */
    public void setImwContentsVersionId(final String imwContentsVersionId) {
        this.imwContentsVersionId = imwContentsVersionId;
    }

    /**
     * フローIDを設定します。
     * @param imwFlowId フローID
     */
    public void setImwFlowId(final String imwFlowId) {
        this.imwFlowId = imwFlowId;
    }

    /**
     * フローバージョンIDを設定します。
     * @param imwFlowVersionId フローバージョンID
     */
    public void setImwFlowVersionId(final String imwFlowVersionId) {
        this.imwFlowVersionId = imwFlowVersionId;
    }

    /**
     * ログイングループIDを設定します。
     * @param imwGroupId ログイングループID
     */
    public void setImwGroupId(final String imwGroupId) {
        this.imwGroupId = imwGroupId;
    }

    /**
     * ノードIDを設定します。
     * @param imwNodeId ノードID
     */
    public void setImwNodeId(final String imwNodeId) {
        this.imwNodeId = imwNodeId;
    }

    /**
     * 画面種別を設定します。
     * @param imwPageType 画面種別
     */
    public void setImwPageType(final String imwPageType) {
        this.imwPageType = imwPageType;
    }

    /**
     * ルートIDを設定します。
     * @param imwRouteId ルートID
     */
    public void setImwRouteId(final String imwRouteId) {
        this.imwRouteId = imwRouteId;
    }

    /**
     * ルートバージョンIDを設定します。
     * @param imwRouteVersionId ルートバージョンID
     */
    public void setImwRouteVersionId(final String imwRouteVersionId) {
        this.imwRouteVersionId = imwRouteVersionId;
    }

    /**
     * システム案件IDを設定します。
     * @param imwSystemMatterId システム案件ID
     */
    public void setImwSystemMatterId(final String imwSystemMatterId) {
        this.imwSystemMatterId = imwSystemMatterId;
    }

    /**
     * ログインユーザCDを設定します。
     * @param imwUserCode ログインユーザCD
     */
    public void setImwUserCode(final String imwUserCode) {
        this.imwUserCode = imwUserCode;
    }

    /**
     * ユーザデータIDを設定します。
     * @param imwUserDataId ユーザデータID
     */
    public void setImwUserDataId(final String imwUserDataId) {
        this.imwUserDataId = imwUserDataId;
    }

    /**
     * 数量を設定します。
     * @param item_amount 数量
     */
    public void setItemAmount(final String item_amount) {
        this.item_amount = item_amount;
    }

    /**
     * 備考を設定します。
     * @param item_comment 備考
     */
    public void setItemComment(final String item_comment) {
        this.item_comment = item_comment;
    }

    /**
     * 品名を設定します。
     * @param item_name 品名
     */
    public void setItemName(final String item_name) {
        this.item_name = item_name;
    }

    /**
     * 金額を設定します。
     * @param item_price 金額
     */
    public void setItemPrice(final String item_price) {
        this.item_price = item_price;
    }

    /**
     * 合計を設定します。
     * @param item_total 合計
     */
    public void setItemTotal(final String item_total) {
        this.item_total = item_total;
    }

    /**
     * 次ページのServiceIdを設定します。
     * @param nextPageServiceId 次ページのServiceId
     */
    public void setNextPageServiceId(final String nextPageServiceId) {
        this.nextPageServiceId = nextPageServiceId;
    }
}
