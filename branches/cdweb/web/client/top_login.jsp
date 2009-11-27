<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/client/js/jquery-1.3.2.js"></script>
<script type="text/javascript">
    $(init);
    
    function init() {
        var offset = $("#companyList").offset();
        $("#companyListDiv").css(
            { left : offset.left + 23, top : offset.top + 18 }
        ).find("td").css("height", "25px")
        .mouseover(
            function() {
                $(this).css("backgroundColor", "#ddd");
            }
        ).mouseout(function() {
                $(this).css("backgroundColor", "");
        }).click(function() {
            //处理分公司切换事件
        });

        $("#companyList").click(
            function(e) {
                $("#companyListDiv").show();
                return false;
            }
        );

        $(document.body).click(
            function(e) {
                $("#companyListDiv").hide();
            }
        );
    }
</script>
<div id="companyListDiv" style="border:solid 1px #ccc;position:absolute;display:none;background-color:#fff;width:200px;">
    <table border="0" cellpadding="5" cellspacing="5" width="200">
        <tr>
            <td><a href="javascript:">建发纸业北京分公司</a></td>
        </tr>
        <tr>
            <td><a href="javascript:">建发纸业浙江分公司</a></td>
        </tr>
    </table>
</div>
<div class="head">
    <div class="logo"></div>
    <div class="head_info">
        <ul>
            <li class="text1">目前登录用户：<strong>林琴科</strong> 厦门金百汇印刷有限公司&nbsp;&nbsp;&nbsp;| <a href="<%=request.getContextPath()%>/client/order/car_list.jsp">查看购物车</a> |  结帐 | <a href="<%=request.getContextPath()%>/client/order/order_history_list.jsp">快速订购</a> | <a href="">网上业助</a></li>
            <li class="text2">
                <span class="login_info" id="companyList"><a href="javascript:;">+ 厦门纸业福建分公司</a></span>
                <span class="search"><input name="" type="text"  />&nbsp;<input name="" type="image" src="<%=request.getContextPath()%>/client/images/go.gif"  />&nbsp;<a href="<%=request.getContextPath()%>/client/products/productSearch.jsp">高级搜索</a></span></li>
            <li class="text3"></li>
        </ul>
    </div>
</div>
<div class="mainmenu">
    <ul>
        <li  class="menu1"><a href="<%=request.getContextPath()%>/client/index.jsp">首页</a></li>
        <li class="line"></li>
        <li class="menu1"><a href="<%=request.getContextPath()%>/client/products/product_list.jsp">商品</a></li>
        <li class="line"></li>
        <li class="menu3"><a href="<%=request.getContextPath()%>/client/order/car_list.jsp">购物</a></li>
        <li class="line"></li>
        <li class="menu3"><a href="<%=request.getContextPath()%>/client/order/order_list.jsp">我的订单</a></li>
        <li class="line"></li>
        <li class="menu3"><a href="<%=request.getContextPath()%>/client/ship/ship_list.jsp">我的发货</a></li>
        <li class="line"></li>
        <li class="menu3"><a href="<%=request.getContextPath()%>/client/member/favorite.jsp">会员中心</a></li>
        <li class="line"></li>
        <li class="menu3"><a href="<%=request.getContextPath()%>/client/help/index.jsp">帮助中心</a></li>
    </ul>
</div>
<div class="blank"></div>