package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.security.info.analysis response.
 *
 * @author auto create
 * @since 1.0, 2016-03-04 14:55:20
 */
public class AlipaySecurityInfoAnalysisResponse extends AlipayResponse {

    private static final long serialVersionUID = 1447161767295275278L;

    /**
     * 风险标签
     */
    @ApiField("risk_code")
    private String riskCode;

    /**
     * 风险等级
     */
    @ApiField("risk_level")
    private Long riskLevel;

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getRiskCode() {
        return this.riskCode;
    }

    public void setRiskLevel(Long riskLevel) {
        this.riskLevel = riskLevel;
    }

    public Long getRiskLevel() {
        return this.riskLevel;
    }

}
