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
        <div class="main_content">
            <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td height="35">查看订单
                        <select name="select2">
                            <option value="类别">选择订单状态</option>
                            <option value="类别">正在处理</option>
                            <option value="类别">取消订单</option>
                            <option value="类别">发货订单</option>
                        </select>
                        <input type="submit" name="Submit22" value="查看订单" class="btn_4"  onclick="window.location.href='order_list.jsp'"/>    </td>
                </tr>
            </table>
            <table width="947" border="0" align="center" cellspacing="1" bgcolor="#cccccc"  class="common_table">
                <tr	class="common_title">
                    <td >订单号</td>
                    <td >版本号</td>
                    <td >订单日期  </td>
                    <td >供应商编码</td>
                    <td >供应商名称</td>
                    <td >订单金额 </td>
                    <td >配送方式 </td>
                    <td >结算方式</td>
                    <td >支付方式 </td>
                    <td >订单状态</td>
                    <td >发货状态 </td>
                    <td >&nbsp;</td>
                </tr>
                <tr	class="common_value">
                    <td  ><a href="order_detail.jsp">100786</a></td>
                    <td  >1</td>
                    <td  >2009-11-06</td>
                    <td  >001</td>
                    <td  >福建分公司</td>
                    <td   align="right">776765.00</td>
                    <td  >送货上门</td>
                    <td  >赊销</td>
                    <td  >汇票</td>
                    <td    style=" color:#ff0000">有疑义</td>
                    <td  >未发货</td>
                    <td  ><input type="submit" name="Submit" value="确认" class="btn_2" onclick="window.location.href='../order/order_approve.jsp';" /></td>
                </tr>
                <tr	class="common_value2">
                    <td  ><a href="order_detail.jsp">100788</a></td>
                    <td  >2</td>
                    <td  >2009-11-06</td>
                    <td  >001</td>
                    <td  >福建分公司</td>
                    <td   align="right">776765.00</td>
                    <td  >送货上门</td>
                    <td  >赊销</td>
                    <td  >汇票</td>
                    <td  >已查看</td>
                    <td  >未发货</td>
                    <td  >&nbsp;</td>
                </tr>
                <tr	class="common_value">
                    <td  ><a href="order_detail.jsp">100786</a></td>
                    <td  >1</td>
                    <td  >2009-11-06</td>
                    <td  >001</td>
                    <td  >福建分公司</td>
                    <td   align="right">776765.00</td>
                    <td  >送货上门</td>
                    <td  >赊销</td>
                    <td  >汇票</td>
                    <td  >新订单</td>
                    <td  >未发货</td>
                    <td  >&nbsp;</td>
                </tr>
                <tr	class="common_value2">
                    <td  ><a href="order_detail.jsp">100788</a></td>
                    <td  >2</td>
                    <td  >2009-11-06</td>
                    <td  >001</td>
                    <td  >福建分公司</td>
                    <td   align="right">776765.00</td>
                    <td  >送货上门</td>
                    <td  >赊销</td>
                    <td  >汇票</td>
                    <td  >处理中</td>
                    <td  >未发货</td>
                    <td  >&nbsp;</td>
                </tr>
                <tr	class="common_value">
                    <td  ><a href="order_detail.jsp">100786</a></td>
                    <td  >1</td>
                    <td  >2009-11-06</td>
                    <td  >001</td>
                    <td  >福建分公司</td>
                    <td   align="right">776765.00</td>
                    <td  >送货上门</td>
                    <td  >赊销</td>
                    <td  >汇票</td>
                    <td  >新订单</td>
                    <td  >未发货</td>
                    <td  >&nbsp;</td>
                </tr>
                <tr	class="common_value2">
                    <td  ><a href="order_detail.jsp">100788</a></td>
                    <td  >2</td>
                    <td  >2009-11-06</td>
                    <td  >001</td>
                    <td  >福建分公司</td>
                    <td   align="right">776765.00</td>
                    <td  >送货上门</td>
                    <td  >赊销</td>
                    <td  >汇票</td>
                    <td  >已接受</td>
                    <td  >未发货</td>
                    <td  >&nbsp;</td>
                </tr>
            </table>
            <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td height="35"><div class="common"><a href="#">首页</a> <a href="#">上一个</a> <a href="#">下一个</a> <a href="#">尾页</a></div> </td>
                </tr>
            </table>
        </div>
        <!--空23px--->
        <div class="blank23"></div>
        <%@ include file="../help.jsp" %>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>


