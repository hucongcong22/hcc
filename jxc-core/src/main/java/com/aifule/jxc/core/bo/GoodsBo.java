package com.aifule.jxc.core.bo;

import com.aifule.jxc.core.common.util.BeanUtil;
import com.aifule.jxc.core.domain.Goods;

public class GoodsBo extends Goods {
    public GoodsBo(Goods goods) {
        BeanUtil.copyProperties(goods, this);
    }

    public GoodsBo() {

    }

    private String lname;
    private double ymoney;

    public Integer getGaid() {
        return gaid;
    }

    public void setGaid(Integer gaid) {
        this.gaid = gaid;
    }

    private String miao;
    private String tupian;
    private Integer gaid;

    public String getTupian() {
        return tupian;
    }

    public void setTupian(String tupian) {
        this.tupian = tupian;
    }

    public String getMiao() {

        return miao;
    }

    public void setMiao(String miao) {
        this.miao = miao;
    }

    public double getYmoney() {

        return ymoney;
    }

    public void setYmoney(double ymoney) {
        this.ymoney = ymoney;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
