<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>帮助中心</title>
        <link href="../css/blue/help.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <%@ include file="../top_login.jsp" %>
        <div class="position">
            <ul>
                <li>当前位置:</li>
                <li><a href="#">首页</a> </li>
                <li><a href="#">帮助中心</a> </li>
            </ul>
        </div>
        <div class="blank23"></div>

        <div class="main_content">

            <div class="help_left">
                <div class="nav_title">帮助中心导航</div>
                <div class="nav_class">
                    <ul>
                        <li class="parentClass_jian"><a href="#" class="hot">新手上路</a></li>
                        <li class="chilcClass"><a href="product1.jsp" >购物演示</a></li>
                        <li	class="chilcClass"><a href="#">新会员注册</a></li>
                        <li	class="chilcClass"><a href="#">搜索商品</a></li>
                        <li	class="chilcClass"><a href="#">会员制</a></li>
                        <li	class="parentClass_jia"><a href="#"	class="hot">会员中心</a></li>
                        <li	class="chilcClass"><a href="#">账户信息</a></li>
                        <li	class="chilcClass"><a href="#">忘记密码</a></li>
                        <li	class="chilcClass"><a href="#">我的积分</a></li>
                        <li	class="chilcClass"><a href="#">推荐好友</a></li>
                        <li	class="parentClass_jia"><a href="#"	class="hot">如何付款</a></li>
                        <li	class="chilcClass"><a href="#">付款方式</a></li>
                        <li	class="chilcClass"><a href="#">货到付款</a></li>
                        <li	class="chilcClass"><a href="#">邮局汇款</a></li>
                        <li	class="parentClass_jia"><a href="#"	class="hot">如何送货</a></li>
                        <li	class="chilcClass"><a href="#">送货方式</a></li>
                        <li	class="chilcClass"><a href="#">直送城市</a></li>
                        <li	class="chilcClass"><a href="#">订单查询</a></li>
                        <li	class="parentClass_jia"><a href="#"	class="hot">售后服务</a></li>
                        <li	class="chilcClass"><a href="#">退货/换货</a></li>
                        <li	class="chilcClass"><a href="#">缺货登记</a></li>
                        <li	class="chilcClass"><a href="#">联系我们</a></li>
                    </ul>
                </div>
                <div class="blank23"></div>
            </div>
            <!--右边产品列表-->
            <div class="help_right">
                <div class="nav_positon">
                    <ul>
                        <li><a href="#">帮助中心首页</a> </li>
                        <li><a href="#">帐号与认证</a> </li>
                        <li><a href="#">帐户注册及管理</a> </li>
                        <li><a href="#">帐户注册</a> </li>
                        <li>帮助内容</li>
                    </ul>
                </div>
                <div class="blank23"></div>
                <div class="help_title">如何注册会员？</div>
                <div class="help_content">
                    <p><b>注册淘宝会员名,您可以按以下方式来操作哦:  </b></p>
                    <p>1、登陆淘宝网，点击页面顶部“免费注册”； </p>
                    <p>2、进入注册页面，填写会员名和密码； </p>
                    <p>3、输入一个您常用的电子邮件地址，用于激活您的会员名； </p>
                    <p>4、将校验码添入右侧的输入框中； </p>
                    <p>5、仔细阅读淘宝网服务协议，同意条款后点击提交； </p>
                    <p>6、此时，淘宝将发送一封确认信到刚才您所填写的电子邮箱中； </p>
                    <p>7、请登录该邮箱，完成您的淘宝会员注册。 </p>

                    <p>为了您能顺利地完成注册，请您在填写会员注册表时，注意以下各项要求： </p>

                    <p>会员名：5-20个字符(包括小写字母、数字、下划线、中文)，一个汉字为两个字符，推荐您使用中文会员名。如果不能确认您注册的会员名是否已有人使用，可以点击“检查会员名是否可用”按钮来查看。 一旦注册成功您的会员名将不能修改，请留意填写。
		  密码：密码由6-16个字符组成，请使用英文字母加数字或符号的组合密码，不能单独使用英文字母、数字或符号作为您的密码。建议您不要使用自己的生日、手机号码、姓名以及连续的数字作为密码，以防被盗取。 </p>
                    <p>确认密码：需要跟上面填写的密码完全一致。 </p>
                    <p>电子邮件：由于无法正常收取激活信，我们暂不接受qq.com的电子邮件。请您填写除此以外的您最常用且有效的邮件地址。此邮箱用来激活您的会员名，它是您和淘宝网、会员之间交流的重要工具。注册邮箱具有唯一性，也是淘宝网鉴别会员身份的一个重要条件。因此，请您填写真实有效的信息。
		  校验码：出于安全考虑，您需要按照图片显示的字符输入校验码。校验码请务必在英文状态或半角模式下输入，否则系统将会提示您校验码出错。</p>
                </div>
                <!--end -->
                <div class="blank23"></div>
            </div>
        </div>
        <!--空23px--->
        <div class="blank23"></div>
        <%@ include file="../help.jsp" %>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
