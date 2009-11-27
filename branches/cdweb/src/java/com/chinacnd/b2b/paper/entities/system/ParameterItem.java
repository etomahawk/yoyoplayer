/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.entities.system;

/**
 *系统参数条目
 * @author roger
 */
public enum ParameterItem {

    ORDER_AUDIT("biz", "order_audit"),//订单逾期未审核
    ORDER_PROCESS("biz", "order_process"),//订单逾期未处理
    ORDER_CONFIRM("biz", "order_confirm"),//订单逾期未确认
    NETGATE_PRODUCT("ng", "product"),//网关商品信息同步频率
    NETGATE_ENTERPRISE("ng", "enterprise"),//网关企业信息同步频率
    NETGATE_ORDER("ng", "order"),//网关订单协作同步频率
    NETGATE_FINANCE("ng", "finance"),//网关财务对账同步频率
    NETGATE_PRICE("ng", "price"),//网关价格引擎服务地址
    MAIL_SMTP("mail", "smtp"),//发送邮件服务
    MAIL_ACCOUNT("mail", "account"),//发送邮件帐户
    MAIL_USER("mail", "user"),//发送邮件用户
    MAIL_PASSWORD("mail", "password"),//发送邮件密码
    MAIL_NEED_AUTHENTICATION("mail", "need_authentication"),//是否需要安全认证
    MAIL_FREQUENCY("mail", "frequency"),//邮件发送频率
    MAIL_RETRY_COUNT("mail", "retry_count"),//邮件重发次数
    MAIL_RETRY_INTERVAL("mail", "retry_interval"),//重发间隔时间
    SMS_ADDRESS("sms", "address"),//网关IP地址
    SMS_PORT("sms", "port"),//网关端口号
    SMS_ENTERPRISE_CODE("sms", "enterprise_code"),//企业代码
    SMS_USER("sms", "user"),//登录名称
    SMS_PASSWORD("sms", "password"),//登录密码
    SMS_SERVICE_NUMBER("sms", "service_number"),//服务号码
    SMS_BIZ_CODE("sms", "biz_code");//业务代码
    private String type;
    private String item;

    ParameterItem(String type, String item) {
        this.type = type;
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public String getType() {
        return type;
    }
}
