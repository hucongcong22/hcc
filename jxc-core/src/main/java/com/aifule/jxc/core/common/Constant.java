package com.aifule.jxc.core.common;

import java.math.BigDecimal;

/**
 * Created by libiao on 2016/8/19.
 */
public class Constant {
    public final static String TOKEN_USER_ID = "token_user_id";// 消息key前缀

    public final static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_DAY_FORMAT = "yyyy-MM-dd";

    //task status
    public final static int TASK_STATUS_UN_TODO = 1;
    public final static int TASK_STATUS_NEED_TODO = 2;
    public final static int TASK_STATUS_DOING = 3;
    public final static int TASK_STATUS_FINISHED = 4;

    public final static int MAX_PUBLISH_TASK_NUM = 5;
}
