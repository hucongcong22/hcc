package com.aifule.jxc.site.common.util;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;

import java.util.TreeSet;

/**
 * Created by libiao on 2016/9/6.
 */
public class StringUtil {
    public static String addToJsonArrayStr(String jsonStr, Integer e) {
        if (e == null) {
            return jsonStr;
        }
        TreeSet<Integer> set = new TreeSet<>(JSONArray.parseArray(jsonStr, Integer.class));
        set.add(e);
        String result = JSONUtils.toJSONString(set);
        return result;
    }

    /**
     * 规格值拼接
     *
     * @param type
     * @param value
     * @return
     */
    public String specificationValue(String type, String value) {
        String[] typeList = type.split("&&");
        String[] valueList = value.split("&&");
        String specification = "";
        for (int i = 0; i < typeList.length; i++) {
            specification = specification + typeList[i] + ":" + valueList[i] + ";";
        }
        return specification;
    }
}
