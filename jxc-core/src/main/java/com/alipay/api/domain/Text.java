package com.alipay.api.domain;

import com.alipay.api.AlipayObject;
import com.alipay.api.internal.mapping.ApiField;

/**
 * 文本消息内容
 *
 * @author auto create
 * @since 1.0, 2016-10-26 17:43:42
 */
public class Text extends AlipayObject {

    private static final long serialVersionUID = 5174371536276398528L;

    /**
     * 你好!
     */
    @ApiField("content")
    private String content;

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
