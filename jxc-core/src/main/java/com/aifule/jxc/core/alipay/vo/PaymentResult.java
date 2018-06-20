package com.aifule.jxc.core.alipay.vo;

import java.math.BigDecimal;

/**
 * Created by libiao on 2016/12/30.
 */
public class PaymentResult {
    private String notify_time;
    private String notify_type;
    private String notify_id;
    private String sign_type;
    private String sign;
    private String trade_no;
    private String appid;
    private String out_trade_no;

    private String out_biz_no;
    private String buyer_id;
    private String buyer_logon_id;
    private String seller_id;
    private String seller_email;
    private String trade_status;
    private BigDecimal total_amount;
    private String receipt_amount;
    private String invoice_amount;
    private String buyer_pay_amount;
    private String point_amount;
    private String refund_fee;
    private String send_back_fee;
    private String subject;

    private String body;
    private String gmt_create;
    private String gmt_payment;
    private String gmt_refund;
    private String gmt_close;
    private String fund_bill_list;

    public String getNotify_time() {
        return notify_time;
    }

    public void setNotify_time(String notify_time) {
        this.notify_time = notify_time;
    }

    public String getNotify_type() {
        return notify_type;
    }

    public void setNotify_type(String notify_type) {
        this.notify_type = notify_type;
    }

    public String getNotify_id() {
        return notify_id;
    }

    public void setNotify_id(String notify_id) {
        this.notify_id = notify_id;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOut_biz_no() {
        return out_biz_no;
    }

    public void setOut_biz_no(String out_biz_no) {
        this.out_biz_no = out_biz_no;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getBuyer_logon_id() {
        return buyer_logon_id;
    }

    public void setBuyer_logon_id(String buyer_logon_id) {
        this.buyer_logon_id = buyer_logon_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getSeller_email() {
        return seller_email;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public String getReceipt_amount() {
        return receipt_amount;
    }

    public void setReceipt_amount(String receipt_amount) {
        this.receipt_amount = receipt_amount;
    }

    public String getInvoice_amount() {
        return invoice_amount;
    }

    public void setInvoice_amount(String invoice_amount) {
        this.invoice_amount = invoice_amount;
    }

    public String getBuyer_pay_amount() {
        return buyer_pay_amount;
    }

    public void setBuyer_pay_amount(String buyer_pay_amount) {
        this.buyer_pay_amount = buyer_pay_amount;
    }

    public String getPoint_amount() {
        return point_amount;
    }

    public void setPoint_amount(String point_amount) {
        this.point_amount = point_amount;
    }

    public String getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(String refund_fee) {
        this.refund_fee = refund_fee;
    }

    public String getSend_back_fee() {
        return send_back_fee;
    }

    public void setSend_back_fee(String send_back_fee) {
        this.send_back_fee = send_back_fee;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }

    public String getGmt_payment() {
        return gmt_payment;
    }

    public void setGmt_payment(String gmt_payment) {
        this.gmt_payment = gmt_payment;
    }

    public String getGmt_refund() {
        return gmt_refund;
    }

    public void setGmt_refund(String gmt_refund) {
        this.gmt_refund = gmt_refund;
    }

    public String getGmt_close() {
        return gmt_close;
    }

    public void setGmt_close(String gmt_close) {
        this.gmt_close = gmt_close;
    }

    public String getFund_bill_list() {
        return fund_bill_list;
    }

    public void setFund_bill_list(String fund_bill_list) {
        this.fund_bill_list = fund_bill_list;
    }

    @Override
    public String toString() {
        return "PaymentResult{" +
                "notify_time='" + notify_time + '\'' +
                ", notify_type='" + notify_type + '\'' +
                ", notify_id='" + notify_id + '\'' +
                ", sign_type='" + sign_type + '\'' +
                ", sign='" + sign + '\'' +
                ", trade_no='" + trade_no + '\'' +
                ", appid='" + appid + '\'' +
                ", out_trade_no='" + out_trade_no + '\'' +
                ", out_biz_no='" + out_biz_no + '\'' +
                ", buyer_id='" + buyer_id + '\'' +
                ", buyer_logon_id='" + buyer_logon_id + '\'' +
                ", seller_id='" + seller_id + '\'' +
                ", seller_email='" + seller_email + '\'' +
                ", trade_status='" + trade_status + '\'' +
                ", total_amount='" + total_amount + '\'' +
                ", receipt_amount='" + receipt_amount + '\'' +
                ", invoice_amount='" + invoice_amount + '\'' +
                ", buyer_pay_amount='" + buyer_pay_amount + '\'' +
                ", point_amount='" + point_amount + '\'' +
                ", refund_fee='" + refund_fee + '\'' +
                ", send_back_fee='" + send_back_fee + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", gmt_create='" + gmt_create + '\'' +
                ", gmt_payment='" + gmt_payment + '\'' +
                ", gmt_refund='" + gmt_refund + '\'' +
                ", gmt_close='" + gmt_close + '\'' +
                ", fund_bill_list='" + fund_bill_list + '\'' +
                '}';
    }
}
