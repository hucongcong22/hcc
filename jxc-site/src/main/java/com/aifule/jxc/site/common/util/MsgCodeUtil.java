package com.aifule.jxc.site.common.util;

import java.io.IOException;
import java.util.Properties;

public class MsgCodeUtil {
    private static Properties p = new Properties();

    static {
        try {
            p.load(MsgCodeUtil.class.getClassLoader().getResourceAsStream("msgCode.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key, Object[] objs) {
        String format = p.getProperty(key);
        return String.format(format, objs);
    }

    public static String get(String key) {
        return p.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(MsgCodeUtil.get("field.must", new Object[]{"name"}));
    }
}
