package com.aifule.jxc.core.common.util;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by libiao on 2017/8/15 0015.
 */
public class ConfigXmlUtil {
    private static ConfigXmlUtil _instance = null;

    public static ConfigXmlUtil Instance(String xmlPath) {
        if (_instance == null) {
            _instance = new ConfigXmlUtil(xmlPath);
        }
        return _instance;
    }

    private String version;

    private ConfigXmlUtil(String xmlPath) {
        //创建DocumentBuilderFactory对象
        DocumentBuilderFactory a = DocumentBuilderFactory.newInstance();
        try {
            //创建DocumentBuilder对象
            DocumentBuilder b = a.newDocumentBuilder();
            //通过DocumentBuilder对象的parse方法返回一个Document对象
            Document document = b.parse(xmlPath);
            //通过Document对象的getElementsByTagName()返根节点的一个list集合
            version = document.getElementsByTagName("version").item(0).getFirstChild().getNodeValue();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
