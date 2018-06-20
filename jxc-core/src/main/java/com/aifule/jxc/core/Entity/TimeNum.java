package com.aifule.jxc.core.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeNum {

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

    List<NameNum> nameNum = new ArrayList<>();

    public List<NameNum> getNameNum() {
        return nameNum;
    }

    public void setNameNum(List<NameNum> nameNum) {
        this.nameNum = nameNum;
    }
}
