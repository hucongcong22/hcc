package com.aifule.jxc.core.bo;

import com.aifule.jxc.core.common.util.BeanUtil;
import com.aifule.jxc.core.domain.Orders;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrdersVo extends Orders {
    public OrdersVo(Orders orders) {
        BeanUtil.copyProperties(orders, this);
    }

    public OrdersVo() {

    }

    private String uname;

    public String getDatea() {
        return datea;
    }

    public void setDatea(Date datea) {
        String s = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (datea != null) {
            s = sdf.format(datea);
        }
        this.datea = s;
    }

    private String datea;

    public String getUname() {
        return uname;
    }


    public void setUname(String uname) {
        this.uname = uname;
    }
}
