package com.alipay.api.response;

import com.alipay.api.internal.mapping.ApiField;

import com.alipay.api.AlipayResponse;

/**
 * ALIPAY API: alipay.open.public.partner.menu.query response.
 *
 * @author auto create
 * @since 1.0, 2016-03-31 21:03:11
 */
public class AlipayOpenPublicPartnerMenuQueryResponse extends AlipayResponse {

    private static final long serialVersionUID = 6357944793576487228L;

    /**
     * 服务窗菜单
     */
    @ApiField("public_menu")
    private String publicMenu;

    public void setPublicMenu(String publicMenu) {
        this.publicMenu = publicMenu;
    }

    public String getPublicMenu() {
        return this.publicMenu;
    }

}
