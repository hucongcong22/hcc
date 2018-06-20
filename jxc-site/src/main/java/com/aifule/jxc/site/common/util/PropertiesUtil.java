package com.aifule.jxc.site.common.util;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    private static Properties p = new Properties();

    static {
        try {
            p.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return p.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertiesUtil.getValue("uploadDir"));
    }
}
