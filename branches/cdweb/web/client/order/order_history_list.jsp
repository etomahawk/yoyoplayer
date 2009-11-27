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
                <li><a href="#">查看订单</a></li>
            </ul>
        </div>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35" class="h30">
				<b>选择订购方式 :</b><br />
				1 编码订购 <input type="submit" name="Submit22" value="进入" class="btn_2"  onclick="window.location.href='car_list2.jsp'"/><br />
				2 重新订</td>
            </tr>
        </table>
        <table width="947" border="0" align="center" cellspacing="1" bgcolor="#cccccc"  class="common_table">
            <tr>
                <td class="common_title">订单号</td>
                <td class="common_title">版本号</td>
                <td class="common_title">订单日期  </td>
                <td class="common_title">供应商编码</td>
                <td class="common_title">供应商名称</td>
                <td class="common_title">订单金额 </td>
                <td class="common_title">配送方式 </td>
                <td class="common_title">结算方式</td>
                <td class="common_title">支付方式 </td>
                <td class="common_title">订单状态</td>
                <td class="common_title">确认状态</td>
                <td class="common_title">发货状态 </td>
                <td class="common_title">&nbsp;</td>
            </tr>
            <tr>
                <td  class="common_value"><a href="order_detail.jsp">100786</a></td>
                <td  class="common_value">1</td>
                <td  class="common_value">2009-11-06</td>
                <td  class="common_value">001</td>
                <td  class="common_value">福建分公司</td>
                <td  class="common_value">776765</td>
                <td  class="common_value">送货上门</td>
                <td  class="common_value">赊销</td>
                <td  class="common_value">汇票</td>
                <td  class="common_value">已查看</td>
                <td  class="common_value">已确认</td>
                <td  class="common_value">已发货</td>
                <td  class="common_value"><label>
                        <input type="submit" name="Submit" value="重新订购"   class="btn_4" />
                    </label></td>
            </tr>
            <tr>
                <td  class="common_value2"><a href="order_detail.jsp">100788</a></td>
                <td  class="common_value2">2</td>
                <td  class="common_value2">2009-11-06</td>
                <td  class="common_value2">001</td>
                <td  class="common_value2">福建分公司</td>
                <td  class="common_value2">776765</td>
                <td  class="common_value2">送货上门</td>
                <td  class="common_value2">赊销</td>
                <td  class="common_value2">汇票</td>
                <td  class="common_value2">已查看</td>
                <td  class="common_value2">已确认</td>
                <td  class="common_value2">未发货</td>
                <td  class="common_value2"><input type="submit" name="Submit2" value="重新订购"	class="btn_4"/></td>
            </tr>
            <tr>
                <td  class="common_value"><a href="order_detail.jsp">100786</a></td>
                <td  class="common_value">1</td>
                <td  class="common_value">2009-11-06</td>
                <td  class="common_value">001</td>
                <td  class="common_value">福建分公司</td>
                <td  class="common_value">776765</td>
                <td  class="common_value">送货上门</td>
                <td  class="common_value">赊销</td>
                <td  class="common_value">汇票</td>
                <td  class="common_value">已查看</td>
                <td  class="common_value">已确认</td>
                <td  class="common_value">已发货</td>
                <td  class="common_value"><input type="submit" name="Submit3" value="重新订购"	class="btn_4"/></td>
            </tr>
            <tr>
                <td  class="common_value2"><a href="order_detail.jsp">100788</a></td>
                <td  class="common_value2">2</td>
                <td  class="common_value2">2009-11-06</td>
                <td  class="common_value2">001</td>
                <td  class="common_value2">福建分公司</td>
                <td  class="common_value2">776765</td>
                <td  class="common_value2">送货上门</td>
                <td  class="common_value2">赊销</td>
                <td  class="common_value2">汇票</td>
                <td  class="common_value2">已查看</td>
                <td  class="common_value2">已确认</td>
                <td  class="common_value2">未发货</td>
                <td  class="common_value2"><input type="submit" name="Submit4" value="重新订购"	class="btn_4"/></td>
            </tr>
            <tr>
                <td  class="common_value"><a href="order_detail.jsp">100786</a></td>
                <td  class="common_value">1</td>
                <td  class="common_value">2009-11-06</td>
                <td  class="common_value">001</td>
                <td  class="common_value">福建分公司</td>
                <td  class="common_value">776765</td>
                <td  class="common_value">送货上门</td>
                <td  class="common_value">赊销</td>
                <td  class="common_value">汇票</td>
                <td  class="common_value">已查看</td>
                <td  class="common_value">已确认</td>
                <td  class="common_value">已发货</td>
                <td  class="common_value"><input type="submit" name="Submit5" value="重新订购"	class="btn_4"/></td>
            </tr>
            <tr>
                <td  class="common_value2"><a href="order_detail.jsp">100788</a></td>
                <td  class="common_value2">2</td>
                <td  class="common_value2">2009-11-06</td>
                <td  class="common_value2">001</td>
                <td  class="common_value2">福建分公司</td>
                <td  class="common_value2">776765</td>
                <td  class="common_value2">送货上门</td>
                <td  class="common_value2">赊销</td>
                <td  class="common_value2">汇票</td>
                <td  class="common_value2">已查看</td>
                <td  class="common_value2">已确认</td>
                <td  class="common_value2">未发货</td>
                <td  class="common_value2"><input type="submit" name="Submit6" value="重新订购"	class="btn_4"/></td>
            </tr>
        </table>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35"><div class="common" >
				<a href="#">首页</a> <a href="#">上一个</a> <a href="#">下一个</a> <a href="#">尾页</a>
			</div></td>
            </tr>
        </table>
        <!--空23px--->
        <div class="blank23"></div>
        <%@ include file="../help.jsp" %>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>


