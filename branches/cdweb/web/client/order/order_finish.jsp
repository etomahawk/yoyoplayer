<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>订单完成</title>
        <link href="../css/blue/css.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <%@ include file="../top_login.jsp" %>
        <div class="position">
            <ul>
                <li>当前位置:</li>
                <li><a href="#">首页</a></li>
                <li><a href="#">查看订单</a></li>
            </ul>
        </div>
        <div class="blank"></div>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0" >
            <tr>
                <td height="26" class="nav_cartbg4">
                    <table width="947"  style="height:26px;"border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="23%" align="center">1.查看购物车</td>
                            <td width="25%" align="center">2.进入结算中心</td>
                            <td width="24%" align="center">3.订单确定</td>
                            <td width="28%" align="center" class="nav_carthot">4.订单完成</td>
                        </tr>
                    </table></td>
            </tr>
        </table>
        <table width="947" border="0" align="center" cellspacing="1" bgcolor="#cccccc"  class="common_table">
            <tr>
                <td class="common_title" align="center">
                    <br/>
                    <div class="blank23"></div>
                    <table width="99%" border="0" align="center"  style="height:250px;" cellspacing="1"   class="common_table">
                        <tr  style="height:25px;">
                            <td class="common_value" style="font-size:15pt;">订单已成功提交！</td>
                        </tr>
                    </table>
                    <div class="blank23"></div></td>
            </tr>
        </table>
        <!--空23px--->
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35" align="right"><label>
                        <input type="button" name="Submit2" value="继续购物"  class="btn_4" onclick="window.location.href='../products/product.jsp'" />
                        <input type="button" name="Submit2" value="订单列表"  class="btn_4"	onclick="window.location.href='../order/order_list.jsp'" />
                    </label></td>
            </tr>
        </table>
        <%@ include file="../foot.jsp" %>
    </body>
</html>

