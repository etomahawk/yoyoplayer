<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>发货单详情</title>
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
        <table width="947" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35" align="center" id="buyer_title">发货单详情</td>
            </tr>
        </table>
        <table width="947" border="0" align="center" cellpadding="1" cellspacing="1"   class="common_table">
            <tr style="height:25px;">
                <td width="20%" align="left" class="common_title">发货单编号</td>
                <td width="30%" align="left" class="common_value" id="order_number">70007</td>
                <td width="20%" align="left" class="common_title" id="supplier_code_label">供应商代码</td>
                <td width="30%" align="left" class="common_value" id="supplier_code">001</td>
            </tr>
            <tr style="height:25px;">
                <td align="left" class="common_title" width="" id="version_label">所属订单编号</td>
                <td align="left" class="common_value" width="" id="version">100788</td>
                <td align="left" class="common_title" width="" id="supplier_title_label">供应商名称</td>
                <td align="left" class="common_value" width="" id="supplier_title">福建分公司</td>
            </tr>
            <tr style="height:25px;">
                <td align="left" class="common_title" width="" id="dt_label">发货日期</td>
                <td align="left" class="common_value" width="" id="dt">2009-11-07</td>
                <td align="left" class="common_title" width="" id="currency_label">货单金额</td>
                <td align="left" class="common_value" width="" id="currency">776765</td>
            </tr>
            <tr style="height:25px;">
                <td align="left" class="common_title" width="" id="buyer_code_label">附加费用</td>
                <td align="left" class="common_value" width="" id="buyer_code">776</td>
                <td align="left" class="common_title" width="" id="acknowledged_date_label">物流公司</td>
                <td align="left" class="common_value" width="" id="acknowledged_date">厦门物流公司</td>
            </tr>
        </table>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellspacing="1"   class="common_table">
            <tr bgcolor="#DDDDDD" style="height:25px;">
                <td nowrap="nowrap" class="common_title"  id="product_code_label" width="250">品名</td>
                <td nowrap="nowrap" class="common_title"  id='number_label'>件重</td>
                <td nowrap="nowrap" class="common_title"  id="unit_price_label">件数</td>
                <td nowrap="nowrap" class="common_title"  id="money_label">数量(吨)</td>
                <td nowrap="nowrap" class="common_title"  id="plan_date_label">单价</td>
                <td nowrap="nowrap" class="common_title"  id="confirm_status_label">金额(元)</td>
                <td nowrap="nowrap" class="common_title"  id="confirm_status_label">实发数量</td>
                <td nowrap="nowrap" class="common_title"  id="money_label">收货状态</td>
                <td nowrap="nowrap" class="common_title"  id="plan_date_label">收货数量</td>
                <td nowrap="nowrap" class="common_title"  id="plan_date_label">收货说明</td>
            </tr>
            <tr>
                <td  class="common_value" align="left">金东双面铜版纸-长鹤-200G-889*1194-A</td>
                <td  class="common_value">0.00</td>
                <td  class="common_value">0.00</td>
                <td  class="common_value">1.622</td>
                <td  class="common_value">3,000.00</td>
                <td  class="common_value">5936.00</td>
                <td  class="common_value">1.622</td>
                <td class="common_value">接受</td>
                <td class="common_value">1.622</td>
                <td class="common_value"></td>
            </tr>
            <tr>
                <td  class="common_value2" align="left">宁波双面铜版纸-亚洲酋长-300G-889*1194-A</td>
                <td  class="common_value2">0.00</td>
                <td  class="common_value2">0.00</td>
                <td  class="common_value2">1.633</td>
                <td  class="common_value2">3,000.00</td>
                <td  class="common_value2">4500.00</td>
                <td  class="common_value2">1.633</td>
                <td class="common_value2">接受</td>
                <td class="common_value2">1.633</td>
                <td class="common_value2"></td>
            </tr>
            <tr>
                <td  class="common_value" align="left">金东双面铜版纸-长鹤-157G-889*1194-A</td>
                <td  class="common_value">0.00</td>
                <td  class="common_value">0.00</td>
                <td  class="common_value">1.622</td>
                <td  class="common_value">3,000.00</td>
                <td  class="common_value">5936.00</td>
                <td  class="common_value">1.622</td>
                <td class="common_value">接受</td>
                <td class="common_value">1.622</td>
                <td class="common_value"></td>
            </tr>
            <tr>
                <td  class="common_value2" align="left">宁波双面铜版纸-亚洲酋长-350G-787*1092-A</td>
                <td  class="common_value2">0.00</td>
                <td  class="common_value2">0.00</td>
                <td  class="common_value2">1.633</td>
                <td  class="common_value2">3,000.00</td>
                <td  class="common_value2">4500.00</td>
                <td  class="common_value2">1.633</td>
                <td class="common_value2">接受</td>
                <td class="common_value2">1.633</td>
                <td class="common_value2"></td>
            </tr>
            <tr>
                <td colspan="10" align="right"  class="common_value"><b>总吨数：28.064 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;金额总计：￥102,349.89&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
            </tr>
        </table>
        <!--空23px--->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
