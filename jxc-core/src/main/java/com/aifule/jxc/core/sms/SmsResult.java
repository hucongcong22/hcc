package com.aifule.jxc.core.sms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by libiao on 2016/12/26.
 */
public class SmsResult {
//    private static final int CODE_SUCCESS=200;

    private Integer code;
    private String msg;
    private String obj;
    private String desc;

    public static SmsResult getSmsResult(String sourStr) {
        JSONObject object = JSON.parseObject(sourStr);
        return JSONObject.toJavaObject(object, SmsResult.class);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "SmsResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", obj='" + obj + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
