package com.aifule.jxc.site.common.property;

/**
 * Created by libiao on 2016/7/13.
 */
public class FilePath {
    private String rootPath;
    private String subPath;
    private String fileName;
    private String fileSuffix;

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getSubPath() {
        return subPath;
    }

    public void setSubPath(String subPath) {
        this.subPath = subPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getUrl() {
        return (subPath + fileName + '.' + fileSuffix).replace('\\', '/');
    }

    public String getFullPath() {
        return rootPath + subPath + fileName + '.' + fileSuffix;
    }

}
