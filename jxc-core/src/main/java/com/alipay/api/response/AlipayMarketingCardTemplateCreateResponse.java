package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.marketing.card.template.create response.
 *
 * @author auto create
 * @since 1.0, 2016-11-18 17:15:24
 */
public class AlipayMarketingCardTemplateCreateResponse extends AlipayResponse {

    private static final long serialVersionUID = 6443726597917567889L;

    /**
     * 支付宝卡模板ID
     */
    @ApiField("template_id")
    private String templateId;

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateId() {
        return this.templateId;
    }

}
