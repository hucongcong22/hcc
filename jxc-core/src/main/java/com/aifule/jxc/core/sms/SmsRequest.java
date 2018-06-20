package com.aifule.jxc.core.sms;

import com.alibaba.fastjson.JSONArray;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by libiao on 2016/12/23.
 */
public class SmsRequest {
    public static HttpPost getHttpPost(String url) {
        HttpPost httpPost = new HttpPost(url);

        String appKey = "b1ed67d6288b52b4a29dbd41cfd2f4cb";
        String appSecret = "1251772f79ba";
        String nonce = "12345";
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);//参考 计算CheckSum的java代码

        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
        return httpPost;
    }

    public static String register() throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = getHttpPost("https://api.netease.im/nimserver/user/create.action");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", "jxc-site"));
        nvps.add(new BasicNameValuePair("token", "123456abc"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果
        return EntityUtils.toString(response.getEntity(), "utf-8");
    }

    public static SmsResult sendCode(String mobile, String templateId) throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = getHttpPost("https://api.netease.im/sms/sendcode.action");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        nvps.add(new BasicNameValuePair("mobile", mobile));
        nvps.add(new BasicNameValuePair("templateid", templateId));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        return SmsResult.getSmsResult(EntityUtils.toString(response.getEntity(), "utf-8"));
    }

    public static SmsResult verifyCode(String mobile, String code) throws Exception {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = getHttpPost("https://api.netease.im/sms/verifycode.action");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        nvps.add(new BasicNameValuePair("mobile", mobile));
        nvps.add(new BasicNameValuePair("code", code));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        return SmsResult.getSmsResult(EntityUtils.toString(response.getEntity(), "utf-8"));
    }

    public static SmsResult notify(String mobile, String templateId, JSONArray args) throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = getHttpPost("https://api.netease.im/sms/sendtemplate.action");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        JSONArray mobiles = new JSONArray();
        mobiles.add(mobile);

        nvps.add(new BasicNameValuePair("mobiles", mobiles.toJSONString()));
        nvps.add(new BasicNameValuePair("templateid", templateId));
        nvps.add(new BasicNameValuePair("params", args.toJSONString()));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);
        return SmsResult.getSmsResult(EntityUtils.toString(response.getEntity(), "utf-8"));
    }
}
