package com.alipay.api.test;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayDataDataserviceBillDownloadurlQueryRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.response.AlipayDataDataserviceBillDownloadurlQueryResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;

/**
 * Created by libiao on 2016/12/9.
 */
public class Test {
    private static String appid = "2016080100142979";
    private static String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCqaTDao+Q4s/xi\n" +
            "9gJXW+0R90aiYBdVVUba/Bj8/vq3ksSTY/khXANqAT0M/zpX7d8Ujlmw0YiqhuaX\n" +
            "1vp++MLm3XJjU/QAyAs3uuqUcPl7w7X/TDzk2THnBGHRKkuchyRu9t5akAxVjsA1\n" +
            "4HBGGChOZCUmDwUugxk7ojOj+HMDjyQkITcF0XvPCvvIojq0CENkzznJk8zmpZZN\n" +
            "v54nUoXU+vJhmHm+7S/TjaWTVTulgD7IjLcSLULu8bKAXF4B9gbHgFN61BiAZRV8\n" +
            "p/WU6qhxxSyKpnLd+p5XH9FgLWVPdKc3zyeMKuq8n+u/mKwwVHUTHsdPMVuT1287\n" +
            "1xzaKXvJAgMBAAECggEBAJffuBKkDjoa7syjw+Jnoxln8CO20BTVM5jnJL4V4QzK\n" +
            "WTei2d3JS6GmCOsUbMMA1NhVJcpYdBzGrayVhBq1Sb7HjbLIl6Y6owTAKWCybybG\n" +
            "feVR5NNwXvEtDqCDuW9/YhEjI3hC+TsnRla9+FIAJav3xMPujwes/0gOf0ebnaWE\n" +
            "8IAIc5vvg4HZbBngDAzBe+OKwG6vlbe/p35x9iihyU+t3JtQHXIeyDRflyBoePnj\n" +
            "s8lyHul1RsRNs5qX6itZR5/5vpWKX/Xfo8ogBxlA+TUnLvBrCmGRkXCCaMs8qqDl\n" +
            "zH8piQn88Zk1xK8ztvT6V9+37T/ZjzwocdBZBDaGqoECgYEA2HD45sfvFk96myzv\n" +
            "acCjjcrfxdf7iXIfziRGqdkviiSHdtQ90TGpNwtphwv5H/bo56rZFP0Smmz3S2G3\n" +
            "cPRjoiXJcFj9jWCYNxTsuENR6mTyiifO7bZlCK/FTd2f1Jl/s1LMxJhmJlD9Luj9\n" +
            "hsOuJ6LtSga9BFeTPcj968obnp0CgYEAyY6DAdrrwsv7MLtXw9Dd0Qi+GdLhAFif\n" +
            "l5JyYJIOJZV9od8jFEH3Gh0Q9YoPu7zFfopEnrNc/2x26hTPnNkZ+KpDka6vSHeR\n" +
            "AfyzRlMRqpAZeuf4U9W6dVnYj9zaZjButIw8l2Rd8d7/fYbMoQ5SlY4jeinQYw/X\n" +
            "kyHxrmHhVB0CgYA4GrCqQdE720ZQywkURJcgviHbSu0s56RO7yBSDrY//NAQgVu0\n" +
            "ykauugqUswnUu1AMHUFAK4mS9gP0SlQet3rMITdiI+81ooBSZt4ltW2acKheH4uI\n" +
            "Gut9oPJoCLbRiSiM9z2VCFwSOpQmgMaXFEokhBs2QSDl6z2DmoIXiMA4EQKBgEG4\n" +
            "Nx1OvZrZmgDsxRQzMXBsMlgHO5g6TWdFuAem9/fnQ3yZXj3HuIOKQLJfHvwu9BJr\n" +
            "kS5R+5vJSQjQWlWhMGe1VKzW0Y6GdgC43derVFJSBAzgQEdNpCuJbSSTdZ7mYeJ6\n" +
            "63LNphgshw/t+SD2o5TiMM0vfyQd0UPHSJ98iNU9AoGBALrwK81bASDg+nGLztY6\n" +
            "uTFnjwx1QKlWMEqOEUGWuKc624XvjnumeJDOwwaZGk9JtO67dQZG/dFCY7f1d4uO\n" +
            "Jq+pXdcjLWjA4A38YF2RJ6C9TOPXF9Sy4MSV86KBDVgcoVQsXk3mkzhpYLS3POsN\n" +
            "K2VNfzMmtg2fjDw4EJgMwj17";
    private static String alipayPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAswJTeyUnDbQUuWz99S750iwfsQW6rE0LRH0Fmtl4ZLApsNFW7cjZ1uHX+K3C2+7BnD20ce8stnz768z5K9IaaTxg/iaDSmt0h/ylc0f7XyCJAbuplsb84e+S59TKv4YCMEFQmLYRZg0cT/jUPeRQzquzXaUUIHQEdda/saUdzwwjSzpTsLBXVQ7xcWhZnUg5dk0VOdQZKQPDTwINV2d+WSTy3MkmHtyDVCwscy3/BtCegr4pUzCyv+tu6KvVLGx7VC5GE1uVO42wBoDSB411l48pRhEyGw+IlayMpE7yyU1uXNzmLNv1DTdzhcVOnZUkUMk5wP39fcMcI1NVBSb0tQIDAQAB";


    public static void main(String[] args) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", appid, privateKey, "JSON", "utf-8", alipayPublicKey, "RSA2");
        AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
        request.setBizContent("{" +
                "    \"bill_type\":\"trade\"," +
                "    \"bill_date\":\"2016-12-30\"" +
                "  }");
        AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            System.out.println("调用成功, url:" + response.getBillDownloadUrl());
        } else {
            System.out.println("调用失败");
        }
    }
}
