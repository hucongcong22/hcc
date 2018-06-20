package com.aifule.jxc.core.Entity;

import java.util.List;

public class PurchaseStoreInOrderBy {

    private String goodsName;


    private int num;

    private List<NameNum> timeNum;

    public List<NameNum> getTimeNum() {
        return timeNum;
    }

    public void setTimeNum(List<NameNum> timeNum) {
        this.timeNum = timeNum;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
