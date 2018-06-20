package com.aifule.jxc.core.bo;

import com.aifule.jxc.core.common.util.BeanUtil;
import com.aifule.jxc.core.domain.Odersxiang;

public class OdersxingVo extends Odersxiang {

    public OdersxingVo(Odersxiang odersxiang) {
        BeanUtil.copyProperties(odersxiang, this);
    }

    public OdersxingVo() {
    }

    private String gname;
    private String tupian;
    private String miao;

    public String getMiao() {
        return miao;
    }

    public void setMiao(String miao) {
        this.miao = miao;
    }

    public String getTupian() {
        return tupian;
    }

    public void setTupian(String tupian) {
        this.tupian = tupian;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
