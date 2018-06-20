package com.aifule.jxc.core.sms;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/26.
 */
public enum SmsType {
    //您好！ 您正在使用的是爱福泺考勤管理系统的游客登录，验证码为%s。
    AFL_LOGIN(1, "4002100"),;
    private Integer type;
    private String templateId;

    private SmsType(Integer type, String templateId) {
        this.type = type;
        this.templateId = templateId;
    }

    public Integer getType() {
        return type;
    }

    public String getTemplateId() {
        return templateId;
    }

    private static final Map<Integer, SmsType> lookup = new HashMap<>();

    static {
        for (SmsType s : EnumSet.allOf(SmsType.class)) {
            lookup.put(s.getType(), s);
        }
    }

    public static SmsType getSmsType(int type) {
        return lookup.get(type);
    }
}
