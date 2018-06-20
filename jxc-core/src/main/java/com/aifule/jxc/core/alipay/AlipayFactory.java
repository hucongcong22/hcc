package com.aifule.jxc.core.alipay;

import com.aifule.jxc.core.alipay.vo.PaymentResult;
import com.aifule.jxc.core.alipay.vo.TradePrecreateVo;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.*;
import com.alipay.api.response.*;

import java.math.BigDecimal;

/**
 * Created by libiao on 2016/12/28.
 */
public class AlipayFactory {
    private AlipayClient alipayClient;
    private AlipayConfig alipayConfig;

    public AlipayFactory(AlipayConfig alipayConfig) {
        this.alipayConfig = alipayConfig;
        alipayClient = new DefaultAlipayClient(alipayConfig.getAlipayUrl(), alipayConfig.getAppid(), alipayConfig.getPrivateKey(), "JSON", "utf-8", alipayConfig.getAlipayPublicKey());
    }

    public String checkPaymentResult(PaymentResult paymentResult) {
        if (!paymentResult.getSeller_id().equals(alipayConfig.getSellerId())) {
            return "sellerId err";
        }
        if (!paymentResult.getTrade_status().equals("TRADE_SUCCESS")) {
            return "非交易成功，忽略";
        }
        return null;
    }

    /**
     * 预下单接口
     *
     * @param outTradeNo
     * @param amount
     * @return
     * @throws AlipayApiException
     */
    public TradePrecreateVo tradePrecreate(String outTradeNo, BigDecimal amount) throws AlipayApiException {
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();//创建API对应的request类
        request.setNotifyUrl(alipayConfig.getNotifyUrl());
        request.setBizContent("{" +
                "    \"out_trade_no\":" + outTradeNo + "," +
                "    \"total_amount\":" + amount + "," +
                "    \"subject\":\"充值\"," +
                "    \"timeout_express\":\"90m\"}");//设置付款时限，90m=90min
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        // TODO 根据response中的结果继续业务逻辑处理
        if (response.isSuccess()) {
            TradePrecreateVo tradePrecreateVo = new TradePrecreateVo();
            System.out.println("调用成功: qr_code:" + response.getQrCode());
            tradePrecreateVo.setQrCode(response.getQrCode());
            tradePrecreateVo.setTradeId(outTradeNo);
            return tradePrecreateVo;
        } else {
            System.out.println("调用失败:" + response.getSubMsg());
        }
        return null;
    }

    /**
     * 交易状态查询
     *
     * @param outTradeNo
     * @return
     * @throws Exception
     */
    public PaymentResult tradeQuery(String outTradeNo) throws Exception {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{" +
                "    \"out_trade_no\":" + outTradeNo +
                "  }");
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            PaymentResult paymentResult = new PaymentResult();
            paymentResult.setOut_trade_no(outTradeNo);
            paymentResult.setTrade_status(response.getTradeStatus());
            paymentResult.setBuyer_logon_id(response.getBuyerLogonId());
            return paymentResult;
        }
        return null;
    }

    /**
     * 交易撤销
     *
     * @param outTradeNo
     * @return 撤销操作触发动作: null-用户还没扫码，设置二维码无效，close：已扫码，还没支付，关闭交易，无退款 refund：产已支付，生了退款
     * @throws Exception
     */
    public String tradeCancel(String outTradeNo) throws Exception {
        AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
        request.setBizContent("{" +
                "    \"out_trade_no\":" + outTradeNo +
                "  }");
        AlipayTradeCancelResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            return response.getAction();
        } else {
            throw new Exception("response failed, subMsg:" + response.getSubMsg());
        }
    }

    /**
     * 交易关闭
     *
     * @param outTradeNo
     * @throws Exception
     */
    public boolean tradeClose(String outTradeNo) throws Exception {
        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        request.setBizContent("{" +
                "    \"out_trade_no\":" + outTradeNo +
                "  }");
        AlipayTradeCloseResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            return true;
        }
        return false;
    }

    /**
     * 交易退款接口
     *
     * @param outTradeNo
     * @param amount
     * @return
     * @throws Exception
     */
    public boolean tradeRefund(String outTradeNo, BigDecimal amount) throws Exception {
        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizContent("{" +
                "    \"out_trade_no\":" + outTradeNo + "," +
                "    \"refund_amount\":" + amount + "," +
                "    \"refund_reason\":\"正常退款\"" +
                "  }");
        AlipayTradeRefundResponse response = alipayClient.execute(request);
        if (response.isSuccess() && response.getRefundFee().equals(amount.toString())) {
            return true;
        }
        return false;
    }

    /**
     * 账单查询接口
     *
     * @param date 某月如：2016-10, 某日如：2016-10-03
     * @throws Exception
     */
    public String billQuery(String date) throws Exception {
        AlipayDataDataserviceBillDownloadurlQueryRequest request = new AlipayDataDataserviceBillDownloadurlQueryRequest();
        request.setBizContent("{" +
                "    \"bill_type\":\"trade\"," +
                "    \"bill_date\":\"2016-12\"" +
                "  }");
        AlipayDataDataserviceBillDownloadurlQueryResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            System.out.println("调用成功, url:" + response.getBillDownloadUrl());
            return response.getBillDownloadUrl();
        } else {
            System.out.println("调用失败");
        }
        return null;
    }

}
