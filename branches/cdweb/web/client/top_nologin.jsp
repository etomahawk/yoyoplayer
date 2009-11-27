<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="head">
    <div class="logo"></div>
    <div class="head_info">
        <ul>
            <li class="text1"><a href="<%=request.getContextPath()%>/client/order/car_list.jsp">查看购物车</a> | 结帐 | <a href="<%=request.getContextPath()%>/client/order/order_history_list.jsp">快速订购</a> | 网上业助</li>
            <li class="text2">
                <span class="login_info"></span>
                <span class="search"><input name="" type="text" />&nbsp;<img alt="img" src="<%=request.getContextPath()%>/client/images/go.gif" />&nbsp;<a href="<%=request.getContextPath()%>/client/products/productSearch.jsp">高级搜索</a></span></li>
            <li class="text3"></li>
        </ul>
    </div>
</div>
<div class="mainmenu">
    <ul>
        <li  class="menu1"><a href="<%=request.getContextPath()%>/client/index.jsp">首页</a></li>
        <li class="line"></li>
        <li class="menu1"><a href="<%=request.getContextPath()%>/client/nologinproduct/product_nologinlist.jsp">商品</a></li>
        <li class="line"></li>
        <li class="menu3"><a href="<%=request.getContextPath()%>/client/order/car_list.jsp">购物</a></li>
        <li class="line"></li>
        <li class="menu3"><a href="<%=request.getContextPath()%>/client/help/index.jsp">帮助中心</a></li>
    </ul>
</div>
<div class="blank"></div>
