package com.alipay.api.request;

import java.util.Map;

import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipayEcoWelfareCodeSyncResponse;
import com.alipay.api.AlipayObject;

/**
 * ALIPAY API: alipay.eco.welfare.code.sync request
 *
 * @author auto create
 * @since 1.0, 2016-11-02 19:53:47
 */
public class AlipayEcoWelfareCodeSyncRequest implements AlipayRequest<AlipayEcoWelfareCodeSyncResponse> {

    private AlipayHashMap udfParams; // add user-defined text parameters
    private String apiVersion = "1.0";

    /**
     * 福利平台用户订单外部核销接口
     */
    private String bizContent;

    public void setBizContent(String bizContent) {
        this.bizContent = bizContent;
    }

    public String getBizContent() {
        return this.bizContent;
    }

    private String terminalType;
    private String terminalInfo;
    private String prodCode;
    private String notifyUrl;
    private String returnUrl;
    private boolean needEncrypt = false;
    private AlipayObject bizModel = null;

    public String getNotifyUrl() {
        return this.notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return this.returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getApiVersion() {
        return this.apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public void setTerminalInfo(String terminalInfo) {
        this.terminalInfo = terminalInfo;
    }

    public String getTerminalInfo() {
        return this.terminalInfo;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdCode() {
        return this.prodCode;
    }

    public String getApiMethodName() {
        return "alipay.eco.welfare.code.sync";
    }

    public Map<String, String> getTextParams() {
        AlipayHashMap txtParams = new AlipayHashMap();
        txtParams.put("biz_content", this.bizContent);
        if (udfParams != null) {
            txtParams.putAll(this.udfParams);
        }
        return txtParams;
    }

    public void putOtherTextParam(String key, String value) {
        if (this.udfParams == null) {
            this.udfParams = new AlipayHashMap();
        }
        this.udfParams.put(key, value);
    }

    public Class<AlipayEcoWelfareCodeSyncResponse> getResponseClass() {
        return AlipayEcoWelfareCodeSyncResponse.class;
    }


    public boolean isNeedEncrypt() {

        return this.needEncrypt;
    }


    public void setNeedEncrypt(boolean needEncrypt) {

        this.needEncrypt = needEncrypt;
    }

    public AlipayObject getBizModel() {

        return this.bizModel;
    }


    public void setBizModel(AlipayObject bizModel) {

        this.bizModel = bizModel;
    }


}
