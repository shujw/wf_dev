package jp.co.intra_mart.sample.workflow.purchase.plugin.authority.item_total.controller.service;

import jp.co.intra_mart.framework.base.service.ServiceResult;

public class ItemTotalConfigServiceResult implements ServiceResult {
    /* 次ページのServiceId */
    private String nextPageServiceId;
    /* parentCallBackFunction */
    private String parentCallBackFunction;
    /* extensionPointId */
    private String extensionPointId;
    /* pluginId */
    private String pluginId;
    /* parameter */
    private String parameter;
    /* pluginName */
    private String pluginName;
    /* displayName */
    private String displayName;
    /* targetDate */
    private String targetDate;
    /* targetType */
    private String targetType;
    /* targetCode */
    private String targetCode;

    /**
     * ItemTotalConfigServiceResultを初期化します。
     *
     */
    public ItemTotalConfigServiceResult() {
        setParentCallBackFunction("");
        setExtensionPointId("");
        setPluginId("");
        setParameter("");
        setPluginName("");
        setDisplayName("");
        setTargetDate("");
        setTargetType("");
        setTargetCode("");
    }
    
    /**
     * 次ページのServiceIdを設定します。
     *
     * @param nextPageServiceId 次ページのServiceId
     */
    public void setNextPageServiceId(final String nextPageServiceId) {
        this.nextPageServiceId = nextPageServiceId;
    }

    /**
     * 次ページのServiceIdを取得します。
     *
     * @return 次ページのServiceId
     */
    public String getNextPageServiceId() {
        return this.nextPageServiceId;
    }

    /**
     * ParentCallBackFunctionを設定します。
     *
     * @param parentCallBackFunction 
     */
    public void setParentCallBackFunction(final String parentCallBackFunction) {
        this.parentCallBackFunction = parentCallBackFunction;
    }

    /**
     * ParentCallBackFunctionを取得します。
     *
     * @return ParentCallBackFunction
     */
    public String getParentCallBackFunction() {
        return this.parentCallBackFunction;
    }

    /**
     * ExtensionPointIdを設定します。
     *
     * @param extensionPointId 
     */
    public void setExtensionPointId(final String extensionPointId) {
        this.extensionPointId = extensionPointId;
    }

    /**
     * ExtensionPointIdを取得します。
     *
     * @return ExtensionPointId
     */
    public String getExtensionPointId() {
        return this.extensionPointId;
    }

    /**
     * PluginIdを設定します。
     *
     * @param pluginId 
     */
    public void setPluginId(final String pluginId) {
        this.pluginId = pluginId;
    }

    /**
     * PluginIdを取得します。
     *
     * @return PluginId
     */
    public String getPluginId() {
        return this.pluginId;
    }

    /**
     * Parameterを設定します。
     *
     * @param parameter 
     */
    public void setParameter(final String parameter) {
        this.parameter = parameter;
    }

    /**
     * Parameterを取得します。
     *
     * @return Parameter
     */
    public String getParameter() {
        return this.parameter;
    }

    /**
     * PluginNameを設定します。
     *
     * @param pluginName 
     */
    public void setPluginName(final String pluginName) {
        this.pluginName = pluginName;
    }

    /**
     * PluginNameを取得します。
     *
     * @return PluginName
     */
    public String getPluginName() {
        return this.pluginName;
    }

    /**
     * DisplayNameを設定します。
     *
     * @param displayName 
     */
    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    /**
     * DisplayNameを取得します。
     *
     * @return DisplayName
     */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
     * TargetDateを設定します。
     *
     * @param targetDate 
     */
    public void setTargetDate(final String targetDate) {
        this.targetDate = targetDate;
    }

    /**
     * TargetDateを取得します。
     *
     * @return TargetDate
     */
    public String getTargetDate() {
        return this.targetDate;
    }

    /**
     * TargetTypeを設定します。
     *
     * @param targetType 
     */
    public void setTargetType(final String targetType) {
        this.targetType = targetType;
    }

    /**
     * TargetTypeを取得します。
     *
     * @return TargetType
     */
    public String getTargetType() {
        return this.targetType;
    }

    /**
     * TargetCodeを設定します。
     *
     * @param targetCode 
     */
    public void setTargetCode(final String targetCode) {
        this.targetCode = targetCode;
    }

    /**
     * TargetCodeを取得します。
     *
     * @return TargetCode
     */
    public String getTargetCode() {
        return this.targetCode;
    }
}
