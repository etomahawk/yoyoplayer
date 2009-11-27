<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>建发纸业网上营销系统</title>
        <link href="../css/blue/css.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <%@ include file="../top_login.jsp" %>
        <div class="position">
            <ul>
                <li>当前位置:</li>
                <li><a href="#">首页</a></li>
                <li>发货单详情</li>
            </ul>
        </div>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35">查看发货清单
                    <select name="select2">
                        <option value="类别">选择收货状态</option>
                        <option value="类别">未发货</option>
                        <option value="类别">已发货</option>
                    </select></td>
            </tr>
        </table>
        <table width="947" border="0" align="center" cellspacing="1" bgcolor="#cccccc"  class="common_table">
            <tr>
                <td width="100" class="common_title">发货单号</td>
                <td class="common_title">订单号</td>
                <td class="common_title">供应商编号</td>
                <td class="common_title">供应商名称</td>
                <td class="common_title">发货日期</td>
                <td class="common_title">货单金额</td>
                <td class="common_title">收货状态</td>
                <td class="common_title">物流公司</td>
                <td class="common_title"></td>
            </tr>
            <tr>
                <td  class="common_value"><a href="ship_detail.jsp">70007</a></td>
                <td  class="common_value"><a href="order_detail.jsp">100788</a></td>
                <td  class="common_value">001</td>
                <td  class="common_value">福建分公司</td>
                <td  class="common_value">2009-11-07</td>

                <td  class="common_value" align="right">776.00</td>
                <td  class="common_value">已收货</td>

                <td  class="common_value">厦门物流公司</td>
                <td class="common_value" align="center"><input type="button"	class="btn_2"	 value="收货" onclick="window.location='receive_detail.jsp'"/></td>
            </tr>
            <tr>
                <td  class="common_value2"><a href="ship_detail.jsp">70007</a></td>
                <td  class="common_value2"><a href="order_detail.jsp">100788</a></td>
                <td  class="common_value2">001</td>
                <td  class="common_value2">福建分公司</td>
                <td  class="common_value2">2009-11-07</td>

                <td  class="common_value2" align="right">776.00</td>
                <td  class="common_value2">已收货</td>

                <td  class="common_value2">厦门物流公司</td>
                <td class="common_value2" align="center"><input type="button" value="收货" 	class="btn_2"	onclick="window.location='receive_detail.jsp'"/></td>
            </tr>
            <tr>
                <td  class="common_value"><a href="ship_detail.jsp">70007</a></td>
                <td  class="common_value"><a href="order_detail.jsp">100788</a></td>
                <td  class="common_value">001</td>
                <td  class="common_value">福建分公司</td>
                <td  class="common_value">2009-11-07</td>

                <td  class="common_value" align="right">776.00</td>
                <td  class="common_value">已收货</td>

                <td  class="common_value">厦门物流公司</td>
                <td class="common_value" align="center">
                  <input name="button" type="button" 	class="btn_2"	onclick="window.location='receive_detail.jsp'" value="收货"/>
                </td>
            </tr>
            <tr>
                <td  class="common_value2"><a href="ship_detail.jsp">70007</a></td>
                <td  class="common_value2"><a href="order_detail.jsp">100788</a></td>
                <td  class="common_value2">001</td>
                <td  class="common_value2">福建分公司</td>
                <td  class="common_value2">2009-11-07</td>

                <td  class="common_value2" align="right">776.00</td>
                <td  class="common_value2">已收货</td>

                <td  class="common_value2">厦门物流公司</td>
                <td class="common_value2" align="center"><input name="button2" type="button" 	class="btn_2"	onclick="window.location='receive_detail.jsp'" value="收货"/></td>
            </tr>
            <tr>
                <td  class="common_value"><a href="ship_detail.jsp">70007</a></td>
                <td  class="common_value"><a href="order_detail.jsp">100788</a></td>
                <td  class="common_value">001</td>
                <td  class="common_value">福建分公司</td>
                <td  class="common_value">2009-11-07</td>

                <td  class="common_value" align="right">776.00</td>
                <td  class="common_value">已收货</td>

                <td  class="common_value">厦门物流公司</td>
                <td class="common_value" align="center">
                  <input name="button3" type="button" 	class="btn_2"	onclick="window.location='receive_detail.jsp'" value="收货"/>
                </td>
            </tr>
            <tr>
                <td  class="common_value2"><a href="ship_detail.jsp">70007</a></td>
                <td  class="common_value2"><a href="order_detail.jsp">100788</a></td>
                <td  class="common_value2">001</td>
                <td  class="common_value2">福建分公司</td>
                <td  class="common_value2">2009-11-07</td>

                <td  class="common_value2" align="right">776.00</td>
                <td  class="common_value2">已收货</td>

                <td  class="common_value2">厦门物流公司</td>
                <td class="common_value2" align="center"><input name="button4" type="button" 	class="btn_2"	onclick="window.location='receive_detail.jsp'" value="收货"/></td>
            </tr>
        </table>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35"><div class="common"><a href="#">首页</a> <a href="#">上一个</a> <a href="#">下一个</a> <a href="#">尾页</a></div></td>
            </tr>
        </table>
        <!--空23px--->
        <div class="blank23"></div>
        <%@ include file="../help.jsp" %>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>


