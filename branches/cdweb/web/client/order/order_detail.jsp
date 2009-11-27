<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>订单详情</title>
        <link href="../css/blue/order.css" rel="stylesheet" type="text/css" />
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
        <table width="947" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35" align="center" style="font-size:16pt;" id="buyer_title">采购方:A 客户</td>
            </tr>
            <tr>
                <td height="35" align="center">条款及说明</td>
            </tr>
        </table>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellpadding="1" cellspacing="1"   class="common_table">
            <tr style="height:25px;">
                <td width="20%" align="left" class="common_title">订单编号</td>
                <td width="30%" align="left" class="common_value" id="order_number">106135</td>
                <td width="20%" align="left" class="common_title" id="supplier_code_label">版本号</td>
                <td width="30%" align="left" class="common_value" id="supplier_code">2</td>
            </tr>
            <tr style="height:25px;">
                <td width="20%" align="left" class="common_title">供应商编号</td>
                <td width="30%" align="left" class="common_value" id="order_number">106135</td>
                <td width="20%" align="left" class="common_title" id="supplier_code_label">供应商名称</td>
                <td width="30%" align="left" class="common_value" id="supplier_code">XXX</td>
            </tr>
            <tr style="height:25px;">
                <td width="20%" align="left" class="common_title">采购商编号</td>
                <td width="30%" align="left" class="common_value" id="order_number">106135</td>
                <td width="20%" align="left" class="common_title" id="supplier_code_label">订单金额</td>
                <td width="30%" align="left" class="common_value" id="supplier_code">9999.00</td>
            </tr>
            <tr style="height:25px;">
                <td width="20%" align="left" class="common_title">付款日期</td>
                <td width="30%" align="left" class="common_value" id="order_number">2010-2-1</td>
                <td width="20%" align="left" class="common_title" id="supplier_code_label">供方业务经办人</td>
                <td width="30%" align="left" class="common_value" id="supplier_code">林先生</td>
            </tr>
            <tr style="height:25px;">
                <td align="left" class="common_title" width="20%" id="version_label">需方授权提取人</td>
                <td align="left" class="common_value" width="30%" id="version">吴先生</td>
                <td align="left" class="common_title" width="20%" id="supplier_title_label">身份证号</td>
                <td align="left" class="common_value" width="30%" id="supplier_title">3505838251212598</td>
            </tr>
            <tr style="height:25px;">
                <td align="left" class="common_title" width="20%" id="dt_label">发（提）货日期</td>
                <td align="left" class="common_value" width="30%" id="dt">2009-12-1</td>
                <td align="left" class="common_title" width="20%" id="currency_label">货物存放仓库</td>
                <td align="left" class="common_value" width="30%" id="currency">建发二库</td>
            </tr>
            <tr style="height:25px;">
                <td align="left" class="common_title" width="20%" id="dt_label">订单提交日期</td>
                <td align="left" class="common_value" width="30%" id="dt">2009-12-1</td>
                <td align="left" class="common_title" width="20%" id="currency_label">订单确认日期</td>
                <td align="left" class="common_value" width="30%" id="currency">2009-12-1</td>
            </tr>
            <tr style="height:25px;">
                <td align="left" class="common_title" width="20%" id="dt_label">实际发货日期</td>
                <td align="left" class="common_value" width="30%" id="dt">2009-12-1</td>
                <td align="left" class="common_title" width="20%" id="currency_label">实际收货日期</td>
                <td align="left" class="common_value" width="30%" id="currency">2009-12-1</td>
            </tr>
            <tr style="height:25px;">
                <td align="left" class="common_title" width="20%" id="buyer_code_label">装车费</td>
                <td colspan="3" align="left" class="common_value" id="buyer_code">300.00 元由 甲方承担</td>
            </tr>
            <tr style="height:25px;">
                <td width="20%" align="left" class="common_title" id="sent_date_label">交付方式</td>
                <td colspan="3" align="left" class="common_value" id="sent_date">需方自提，运输公司：
                    <label>盛辉物流</label>
                    <label> &nbsp;&nbsp;车/船号:
                        闽D-3635 </label></td>
            </tr>
        </table>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellspacing="1"   class="common_table">
            <tr bgcolor="#DDDDDD"  style="height:25px;">
                <td nowrap="nowrap" class="common_title"  id="product_code_label" width="250">品名</td>
                <td nowrap="nowrap" class="common_title"  id='number_label'>件重</td>
                <td nowrap="nowrap" class="common_title"  id="unit_price_label">件数</td>
                <td nowrap="nowrap" class="common_title"  id="money_label">数量(吨)</td>
                <td nowrap="nowrap" class="common_title"  id="plan_date_label">单价</td>
                <td nowrap="nowrap" class="common_title"  id="confirm_status_label">金额(元)</td>
                <td nowrap="nowrap" class="common_title"  id="confirm_status_label">实发数量</td>
                <td nowrap="nowrap" class="common_title"  id="money_label">预核状态</td>
                <td nowrap="nowrap" class="common_title"  id="plan_date_label">预核日期</td>
                <td nowrap="nowrap" class="common_title"  id="money_label">原因代码</td>
                <td nowrap="nowrap" class="common_title"  id="plan_date_label">预核说明</td>
            </tr>
            <tr>
                <td  class="common_value" align="left">金东双面铜版纸-长鹤-200G-889*1194-A</td>
                <td  class="common_value">0.00</td>
                <td  class="common_value">0.00</td>
                <td  class="common_value">1.622</td>
                <td  class="common_value">3,000.00</td>
                <td  class="common_value">5936.00</td>
                <td  class="common_value">&nbsp;</td>
                <td class="common_value"></td>
                <td class="common_value"></td>
                <td class="common_value"></td>
                <td class="common_value"></td>
            </tr>
            <tr>
                <td  class="common_value2" align="left">宁波双面铜版纸-亚洲酋长-300G-889*1194-A</td>
                <td  class="common_value2">0.00</td>
                <td  class="common_value2">0.00</td>
                <td  class="common_value2">1.633</td>
                <td  class="common_value2">3,000.00</td>
                <td  class="common_value2">4500.00</td>
                <td  class="common_value2">&nbsp;</td>
                <td class="common_value2"></td>
                <td class="common_value2"></td>
                <td class="common_value2"></td>
                <td class="common_value2"></td>
            </tr>
            <tr>
                <td  class="common_value" align="left">金东双面铜版纸-长鹤-157G-889*1194-A</td>
                <td  class="common_value">0.00</td>
                <td  class="common_value">0.00</td>
                <td  class="common_value">1.622</td>
                <td  class="common_value">3,000.00</td>
                <td  class="common_value">5936.00</td>
                <td  class="common_value">&nbsp;</td>
                <td class="common_value"></td>
                <td class="common_value"></td>
                <td class="common_value"></td>
                <td class="common_value"></td>
            </tr>
            <tr>
                <td  class="common_value2" align="left">宁波双面铜版纸-亚洲酋长-350G-787*1092-A</td>
                <td  class="common_value2">0.00</td>
                <td  class="common_value2">0.00</td>
                <td  class="common_value2">1.633</td>
                <td  class="common_value2">3,000.00</td>
                <td  class="common_value2">4500.00</td>
                <td  class="common_value2">&nbsp;</td>
                <td class="common_value2"></td>
                <td class="common_value2"></td>
                <td class="common_value2"></td>
                <td class="common_value2"></td>
            </tr>
            <tr>
                <td colspan="11" align="right"  class="common_value"><b>总吨数：28.064 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;金额总计：￥102,349.89&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></td>
            </tr>
        </table>
        <!--空23px--->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
