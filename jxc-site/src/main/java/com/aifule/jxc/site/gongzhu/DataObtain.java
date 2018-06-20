package com.aifule.jxc.site.gongzhu;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataObtain {
    /**
     * 获取年月日方法（YY-MM-DD）
     *
     * @return
     */
    public String dataYear() {
        Calendar cal = Calendar.getInstance();
        String date, day, month, year;
        year = String.valueOf(cal.get(Calendar.YEAR));
        month = String.valueOf(cal.get(Calendar.MONTH) + 1);
        day = String.valueOf(cal.get(Calendar.DATE));
        date = year + "-" + month + "-" + day;
        return date;
    }

    /**
     * 获取年月日方法 具体到秒
     *
     * @return
     */

    public Timestamp dataMos() {
        Date d = new Date();
        Timestamp timestamp = new Timestamp(d.getTime());
        return timestamp;
    }
}
