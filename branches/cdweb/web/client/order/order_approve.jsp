<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>订单疑义确认</title>
        <link href="../css/blue/order.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <%@ include file="../top_login.jsp" %>
        <div class="position">
            <ul>
                <li>当前位置:</li>
                <li><a href="#">首页</a></li>
                <li><a href="#">疑义订单确认</a></li>
            </ul>
        </div>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellpadding="1" cellspacing="1"   class="common_table">
            <tr style="height:25px;">
                <td width="20%" align="left" class="common_title">订单编号</td>
                <td width="30%" align="left" class="common_value" id="order_number">106135</td>
                <td width="20%" align="left" class="common_title" id="supplier_code_label">供应商代码</td>
                <td width="30%" align="left" class="common_value" id="supplier_code"></td>
            </tr>
            <tr style="height:25px;">
                <td align="left" class="common_title" width="" id="version_label">版本号</td>
                <td align="left" class="common_value" width="" id="version"></td>
                <td align="left" class="common_title" width="" id="supplier_title_label">供应商名称</td>
                <td align="left" class="common_value" width="" id="supplier_title"></td>
            </tr>
            <tr style="height:25px;">
                <td align="left" class="common_title" width="" id="dt_label">单据日期</td>
                <td align="left" class="common_value" width="" id="dt"></td>
                <td align="left" class="common_title" width="" id="currency_label">货币</td>
                <td align="left" class="common_value" width="" id="currency"></td>
            </tr>
            <tr style="height:25px;">
                <td align="left" class="common_title" width="" id="buyer_code_label">采购方编码</td>
                <td align="left" class="common_value" width="" id="buyer_code"></td>
                <td align="left" class="common_title" width="" id="amount_label">金额</td>
                <td align="left" class="common_value" width="" id="amount"></td>
            </tr>
            <tr style="height:25px;">
                <td align="left" class="common_title" width="" id="sent_date_label">发送日期</td>
                <td align="left" class="common_value" width="" id="sent_date"></td>
                <td align="left" class="common_title" width="" id="acknowledged_date_label">确认日期</td>
                <td align="left" class="common_value" width="" id="acknowledged_date"></td>
            </tr>
            <tr style="height:25px;">
                <td align="left" class="common_title" width="" id="shipped_date_label">发货日期</td>
                <td align="left" class="common_value" width="" id="shipped_date"></td>
                <td align="left" class="common_title" width="" id="received_date_label">收货日期</td>
                <td align="left" class="common_value" width="" id="received_date"></td>
            </tr>
        </table>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellspacing="1"   class="common_table">
            <tr bgcolor="#DDDDDD" style="height:25px;">
                <td nowrap="nowrap" class="common_title"><input name="checkbox" type="checkbox"/></td>
                <td nowrap="nowrap" class="common_title"  id="product_code_label" width="150">品名</td>
                <td nowrap="nowrap" class="common_title"  id='number_label'>件重</td>
                <td nowrap="nowrap" class="common_title"  id="unit_price_label">件数</td>
                <td nowrap="nowrap" class="common_title"  id="money_label">数量(吨)</td>
                <td nowrap="nowrap" class="common_title"  id="money_label">计划日期</td>
                <td nowrap="nowrap" class="common_title"  id="plan_date_label">单价</td>
                <td nowrap="nowrap" class="common_title"  id="confirm_status_label">金额(元)</td>
                <td nowrap="nowrap" class="common_title"  id="confirm_status_label">预核状态</td>
                <td nowrap="nowrap" class="common_title"  id="money_label">可供数量</td>
                <td nowrap="nowrap" class="common_title"  id="plan_date_label">可供日期</td>
                <td nowrap="nowrap" class="common_title"  id="money_label">原因代码</td>
                <td nowrap="nowrap" class="common_title"  id="plan_date_label">预核说明</td>
            </tr>
            <tr>
                <td nowrap="nowrap" class="common_value"></td>
                <td  class="common_value" align="left">金东双面铜版纸-长鹤-200G-889*1194-A</td>
                <td  class="common_value">0.00</td>
                <td  class="common_value">0.00</td>
                <td  class="common_value">1.75</td>
                <td  class="common_value" nowrap="nowrap">09-11-11</td>
                <td  class="common_value">3,000.00</td>
                <td  class="common_value">5936.00</td>
                <td  class="common_value">&nbsp;</td>
                <td class="common_value">1.75</td>
                <td class="common_value" nowrap="nowrap">09-11-11</td>
                <td class="common_value"></td>
                <td class="common_value"></td>
            </tr>
            <tr>
                <td nowrap="nowrap" class="common_value2"><input name="checkbox" type="checkbox"/></td>
                <td  class="common_value2" align="left">宁波双面铜版纸-亚洲酋长-300G-889*1194-A</td>
                <td  class="common_value2">0.00</td>
                <td  class="common_value2">0.00</td>
                <td  class="common_value2">2.00</td>
                <td  class="common_value">09-11-11</td>
                <td  class="common_value2">3,000.00</td>
                <td  class="common_value2">4500.00</td>
                <td  class="common_value2">有疑义</td>
                <td class="common_value2">1.80</td>
                <td class="common_value2">09-11-11</td>
                <td class="common_value2"></td>
                <td class="common_value2"></td>
            </tr>
            <tr>
                <td nowrap="nowrap" class="common_value"><input name="checkbox" type="checkbox"/></td>
                <td  class="common_value" align="left">金东双面铜版纸-长鹤-157G-889*1194-A</td>
                <td  class="common_value">0.00</td>
                <td  class="common_value">0.00</td>
                <td  class="common_value">2.20</td>
                <td  class="common_value">09-11-11</td>
                <td  class="common_value">3,000.00</td>
                <td  class="common_value">5936.00</td>
                <td  class="common_value">有疑义</td>
                <td class="common_value">2.20</td>
                <td class="common_value">09-11-13</td>
                <td class="common_value"></td>
                <td class="common_value"></td>
            </tr>
            <tr	class="common_value3">
                <td nowrap="nowrap">&nbsp;</td>
                <td    align="left">宁波双面铜版纸-亚洲酋长-350G-787*1092-A</td>
                <td   >0.00</td>
                <td   >0.00</td>
                <td   >2.18</td>
                <td   >09-11-11</td>
                <td   >3,000.00</td>
                <td   >4500.00</td>
                <td   >有疑义</td>
                <td   >0.00</td>
                <td   ></td>
                <td   ></td>
                <td   ></td>
            </tr>
            <tr>
                <td colspan="13" align="right"  class="common_value"><b>总吨数：28.064 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;金额总计：￥102,349.89&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
            </tr>
        </table>
        <!--空23px--->
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35" align="right">
                        <input type="button" name="Submit2" value="确认订单"  class="btn_4" onclick="window.location.href='../order/order_detail.jsp'" />
                        <input type="button" name="Submit2" value="撤消订单"  class="btn_4"onclick="window.location.href='../order/order_list.jsp'" />
                    </td>
            </tr>
        </table>
        <%@ include file="../foot.jsp" %>
    </body>
</html>

