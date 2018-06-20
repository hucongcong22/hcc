package com.aifule.jxc.site.common.util;

import com.aifule.jxc.site.common.constant.SysConstant;

/**
 * Created by libiao on 2016/5/5.
 */
public class RedisKeyUtil {
    public static String getUserMsgKey(int uid, byte type) {
        return SysConstant.MSG_USER_PRE + uid + "." + type;
    }
}
