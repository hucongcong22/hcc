package com.aifule.jxc.site.common.util;

import com.alibaba.fastjson.JSON;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by libiao on 2017/2/20.
 */
public class ProjectConfig {
    private static String projectPath = null;
    private static Map<String, String> staticHashNameMap = new HashMap<>();

    public static String getProjectPath() {
        if (projectPath == null) {
            WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
            ServletContext servletContext = webApplicationContext.getServletContext();
            projectPath = servletContext.getRealPath("/");
            if (projectPath.charAt(projectPath.length() - 1) != '/') {
                projectPath += '/';
            }
        }
        return projectPath;
    }

    public static Map<String, String> getStaticHashNameMap() {
        if (staticHashNameMap == null || staticHashNameMap.isEmpty()) {
            String jsHashFilePath = getProjectPath() + "manifest.json";
            String manifestStr = FileUtil.readJsonFile(jsHashFilePath);
            String[] jsonStrArray = manifestStr.split(";");
            for (String jsonStr : jsonStrArray) {
                staticHashNameMap.putAll((Map<String, String>) JSON.parse(jsonStr));
            }
        }
        return staticHashNameMap;
    }
}
