package com.alipay.api.response;

import java.util.List;

import com.alipay.api.internal.mapping.ApiField;
import com.alipay.api.internal.mapping.ApiListField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: zhima.credit.antifraud.verify response.
 *
 * @author auto create
 * @since 1.0, 2016-11-24 11:21:55
 */
public class ZhimaCreditAntifraudVerifyResponse extends AlipayResponse {

    private static final long serialVersionUID = 1882841597483331156L;

    /**
     * 芝麻信用对于每一次请求返回的业务号。后续可以通过此业务号进行对账
     */
    @ApiField("biz_no")
    private String bizNo;

    /**
     * 风险因素code列表
     */
    @ApiListField("verify_code")
    @ApiField("string")
    private List<String> verifyCode;

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getBizNo() {
        return this.bizNo;
    }

    public void setVerifyCode(List<String> verifyCode) {
        this.verifyCode = verifyCode;
    }

    public List<String> getVerifyCode() {
        return this.verifyCode;
    }

}