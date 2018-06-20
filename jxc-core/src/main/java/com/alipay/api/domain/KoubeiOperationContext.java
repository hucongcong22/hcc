package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * context 保存操作者信息
 *
 * @author auto create
 * @since 1.0, 2016-11-23 00:09:37
 */
public class KoubeiOperationContext extends AlipayObject {

    private static final long serialVersionUID = 7165498557431435487L;

    /**
     * 如果是商户自己操作，请传入MERCHANT；如果是isv代操作，请传入ISV；如果是其他角色（服务商、服务商员工、商户员工）操作，不需填写
     */
    @ApiField("op_role")
    private String opRole;

    public String getOpRole() {
        return this.opRole;
    }

    public void setOpRole(String opRole) {
        this.opRole = opRole;
    }

}
