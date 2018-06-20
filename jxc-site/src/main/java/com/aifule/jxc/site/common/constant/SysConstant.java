package com.aifule.jxc.site.common.constant;

public class SysConstant {
    public final static String USER_ID = "_USER_ID";
    public final static String CURRENT_USER = "_CURRENT_USER";
    public final static String IMG_CODE = "_IMG_CODE";
    public final static String CSRF_TOKEN = "_CSRF_TOKEN";

    public final static String COOKIE_USER_NAME = "_sessionId";
    public final static String COOKIE_USER_DOMAIN = "localhost";
    public final static String COOKIE_USER_PATH = "/qzmm/";
    public final static Integer COOKIE_USER_MAX_AGE = 18;

    //上传文件(图片)类型
    public final static String FILE_TYPE_ALL = "file.type.all";
    public final static String FILE_TYPE_COM = "file.type.com";
    public final static String FILE_TYPE_IMG = "file.type.img";
    public final static String FILE_TYPE_USER_ICON = "file.type.user.icon"; //用户自定义头像

    public final static String FILE_ROOTPATH = "file.rootpath";

    public final static String FILE_MAX_SIZE = "file.max.size";


    public final static byte MSG_STATUS_READ = 1;// 状态 0：未读 1：已读
    public final static byte MSG_STATUS_UNREAD = 0;// 状态 0：未读 1：已读
    public final static String MSG_USER_PRE = "msg.user.";// 消息key前缀


    public final static String SEARCH_TYPE_TOPIC = "1";// 话题
    public final static String SEARCH_TYPE_ATTACHMENT = "2";// 共享资源
    public final static String SEARCH_TYPE_LABLE = "3";// 标签名

    // 返回json代码
    public final static String _JSON_RETURN_DATA = "data";
    public final static String _JSON_RETURN_PAGE = "page";
    public final static String _JSON_RETURN_RSPCODE = "rspCode";
    public final static String _JSON_RETURN_RSP_MSG = "msg";
    public final static String _JSON_RETURN_RSPHEADER = "rspHeader";
    public final static String _JSON_RETURN_RSPCODE_SUCCESS = "000000";
    public final static String _JSON_RETURN_RSPCODE_POP = "666666";
    public final static String _JSON_RETURN_RSPCODE_EXCEPTION = "777777";
    public final static String _JSON_RETURN_RSPCODE_LOGINFAIL = "888888";
    public final static String _JSON_RETURN_RSPCODE_OVERDUE = "900000";
    public final static String _JSON_RETURN_RSPCODE_AMOUNTLESS = "910000";
    public final static String _JSON_RETURN_RSPCODE_FAIL = "999999";


    public final static String NGINX_RESOURCE_URL = "nginx.resource.url";// 静态资源地址
    public final static String WEB_VERSION = "web.version";// 版本
    // 静态资源图标路径
    public final static String STATIC_ICON_TOPIC_PATH = "static.icon.topic.path";
    public final static String STATIC_ICON_ATTACHMENT_PATH = "static.icon.attachment.path";
    public final static String STATIC_ICON_USER_PATH = "static.icon.user.path";
    public final static String STATIC_ICON_USER_ANONYMITY_PATH = "static.icon.user.anonymity.path";

    //server return code
    public final static String _RETURN_RSPMSG_ERR = "server err";
}
