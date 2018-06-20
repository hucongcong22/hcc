package com.aifule.jxc.core.common;

/**
 * Created by libiao on 2016/8/19.
 */
public enum MsgType {
    /**
     * 定义格式：类型枚举名(发送对象类型，接受对象类型)
     * 对象类型：0-系统 1-妈妈 2-企业 3-双方
     */
    //系统推送消息
    USER_BIND_ALIPAY_FAIL(0, 3),//绑定支付宝失败
    USER_BIND_ALIPAY_SUCCESS(0, 3),//绑定支付宝成功
    TASK_STOP_M(0, 1),//任务中止给妈妈的消息
    TASK_STOP_C(0, 2),//任务中止给企业的消息
    TASK_FROZEN_M(0, 1),//任务冻结给妈妈的消息
    TASK_FROZEN_C(0, 2),//任务冻结给企业的消息
    TASK_PRECEED_M(0, 1),//任务继续进行妈妈的消息
    TASK_PRECEED_C(0, 2),//任务继续进行给企业的消息
    CASE_STAGE_AUTO_PASS_M(0, 1),//自动通过验收给妈妈业的消息
    CASE_STAGE_AUTO_PASS_C(0, 2),//自动通过验收给企业的消息
    SYS_TASK(0, 1),//系统推荐任务
    TASK_FINISH(0, 1),//任务完成
    CASE_STAGE_DELAY_M(0, 1),//妈妈逾期
    MOTHER_LASTDAY_REMIND(0, 1),//最后一天提醒妈妈不要逾期
    TASK_VERIFY_PASS(0, 2),//任务审核通过
    TASK_VERIFY_FAIL(0, 2),//任务审核失败


    //公司推送消息
    COMPANY_OPEN_CASE(2, 1),//企业查看了你的报价案例
    COMPANY_CANDIDATE_CASE(2, 1),//企业把妈妈设为候选人
    COMPANY_REFUSE_CASE(2, 1),//企业拒绝了你的报价案例
    COMPANY_AGREE_CASE(2, 1),//企业同意了你的报价案例
    COMPANY_CONSULT_CASE(2, 1),//企业对报价发起协商
    COMPANY_ADD_TASK_FILE(2, 1),//企业添加了新的任务附件
    COMPANY_AGREE_CASE_STAGE(2, 1),//企业通过了第X阶段的验收
    COMPANY_REJECT_CASE_STAGE(2, 1),//企业未通过了第X阶段的验收
    COMPANY_REPLY_CASE(2, 1),//企业对案例回复

    //妈妈推送消息
    CASE_STAGE_DELAY_C(1, 2),//妈妈逾期
    MOTHER_COMMIT_CASE(1, 2),//收到妈妈报价
    MOTHER_RECOMMIT_CASE(1, 2),//重新收到妈妈报价
    MOTHER_CANCEL_CASE(1, 2),//妈妈退出了报价任务
    MOTHER_STAGE_COMMIT(1, 2),//妈妈申请验收
    MOTHER_REPLY_CASE(1, 2),//妈妈对案例发表回复
    ;
    private Byte sendType;
    private Byte desType;

    private MsgType(Integer sendType, Integer desType) {
        this.sendType = sendType.byteValue();
        this.desType = desType.byteValue();
    }

    /**
     * 入库类型名为枚举名小写
     *
     * @return
     */
    public String getType() {
        return name();
    }

    public Byte getSendType() {
        return sendType;
    }

    public Byte getDesType() {
        return desType;
    }
}
