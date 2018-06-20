package com.aifule.jxc.site.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by libiao on 2016/6/20.
 */
@Document
public class MsgSendUser {
    private Integer msgId;
    private Integer userId;
    private String nickName;
    private String realName;
    private Byte isAnonym;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Byte getIsAnonym() {
        return isAnonym;
    }

    public void setIsAnonym(Byte isAnonym) {
        this.isAnonym = isAnonym;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MsgSendUser that = (MsgSendUser) o;

        return userId != null ? userId.equals(that.userId) : that.userId == null;

    }

    @Override
    public int hashCode() {
        return userId != null ? userId.hashCode() : 0;
    }
}
