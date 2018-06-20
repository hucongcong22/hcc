package com.aifule.jxc.site.common.util;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;

/**
 * Created by libiao on 2016/8/26.
 */
public class QiniuUploadUtil {
    private static Logger log = LoggerFactory.getLogger(QiniuUploadUtil.class);

    private static Configuration cfg;
    private static UploadManager uploadManager;

    private static final String AK = PropertiesUtil.getValue("qiniu.ak");
    private static final String SK = PropertiesUtil.getValue("qiniu.sk");
    private static final String BucketName = PropertiesUtil.getValue("qiniu.bucketName");

    static {
        String zoneStr = PropertiesUtil.getValue("qiniu.zone");
        Zone zone = Zone.zone0();
        if (zoneStr.equals("zone2")) {
            zone = Zone.zone2();
        }
        cfg = new Configuration(zone);
        uploadManager = new UploadManager(cfg);
    }

    /**
     * 文件上传
     *
     * @param multiFile 图片流
     * @param fileName  图片名称
     */
    public static String upload(MultipartFile multiFile, String fileName) throws Exception {
        Auth auth = Auth.create(AK, SK);
        String token = auth.uploadToken(BucketName, fileName);
        Response response = uploadManager.put(multiFile.getBytes(), fileName, token);
        String res = response.bodyString();
        JSONObject jsonObject = JSONObject.parseObject(res);
        String key = jsonObject.getString("key");
        return URLEncoder.encode(key, "UTF-8").replaceAll("\\+", "%20");
    }

    /**
     * 文件流方式上传文件
     *
     * @param data
     * @param fromType
     * @return 返回上传文件key名字
     * @throws Exception
     */
    public static String fileUpload(byte[] data, FileUtil.FromType fromType, String[] args) throws Exception {
        String fileName = FileUtil.getLocalFilePath(fromType, args);
        Auth auth = Auth.create(AK, SK);
        String token = auth.uploadToken(BucketName, fileName);
        Response response = uploadManager.put(data, fileName, token);

        String res = response.bodyString();
        JSONObject jsonObject = JSONObject.parseObject(res);
        return jsonObject.getString("key");
    }

    /**
     * 文件删除
     *
     * @param fileName
     * @return 成功返回null, 出错返回错误信息
     */
    public static String delete(String fileName) {
        Auth auth = Auth.create(AK, SK);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(BucketName, fileName);
        } catch (QiniuException e) {
            Response response = e.response;
            return response.toString();
        }
        return null;
    }

    /**
     * 删除文件url同目录下的其它文件
     *
     * @param fileUrl
     */
    public static void delOthersInCurDir(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return;
        }

        String dir = fileUrl.substring(0, fileUrl.lastIndexOf("/"));
        Auth auth = Auth.create(AK, SK);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            FileListing fileListing = bucketManager.listFiles(BucketName, dir, null, 1000, null);
            for (FileInfo fileInfo : fileListing.items) {
                if (!fileInfo.key.equals(fileUrl)) {
                    delete(fileInfo.key);
                }
            }
        } catch (QiniuException e) {
            log.error("delOthersInCurDir err, fileUrl:" + fileUrl, e);
        }
    }

    /**
     * 文件移动
     *
     * @param sourKey 源文件url
     * @param deskey  目标文件url
     * @param userId  用户id
     * @return 成功返回目标文件url, 失败返回null
     */
    public static String move(String sourKey, String deskey, int userId) {
        Auth auth = Auth.create(AK, SK);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.move(BucketName, sourKey, BucketName, deskey);
            return deskey;
        } catch (QiniuException e) {
            Response r = e.response;
            log.error("move err:" + r.toString());
        }
        return null;
    }

    public static void main(String[] args) throws QiniuException {
        Auth auth = Auth.create("QlTzVl6nT_4Rcq4_KHemVaZIkDgzr4icJp7qrZs9", "6xFi_M8_ObJQamVzm8vJFvMU5S1sSAiXvbaECvXD");
        BucketManager bucketManager = new BucketManager(auth, cfg);
        FileListing fileListing = bucketManager.listFiles("jzmm-dev", "mother1/1/info/idCard", null, 100, null);
        for (FileInfo fileInfo : fileListing.items) {
            System.out.println(fileInfo.key);
        }
    }

}
