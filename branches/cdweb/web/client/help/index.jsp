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
        <div class="position">当前位置:首页&gt;&gt; 帮助中心 &gt; </div>
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
                <div class="help_nav">快速通道</div>
                <div class="blank23"></div>

                <div class="help_list">
                    <ul>
                        <li><a href="help1.jsp"><img alt="img" src="../images/help_step1.gif" border="0" /></a></li>
                        <li><img alt="img" src="../images/help_step2.gif" /></li>
                        <li><img alt="img" src="../images/help_step3.gif" /></li>
                        <li><img alt="img" src="../images/help_step4.gif" /></li>
                    </ul>
                </div>
                <!--end -->
                <div class="blank23"></div>
                <!--空23行-->
                <!--begin-->
                <div class="help_nav"></div>
                <div class="blank23"></div>

                <div class="help_list"></div>
                <!--end-->
            </div>
        </div>
        <!--空23px--->
        <div class="blank23"></div>
        <%@ include file="../help.jsp" %>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
