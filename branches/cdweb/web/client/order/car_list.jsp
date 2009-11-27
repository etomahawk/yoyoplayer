<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>建发纸业网上营销系统</title>
        <link href="../css/blue/order.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <%@ include file="../top_login.jsp" %>
        <div class="position">
            <ul>
                <li>当前位置:</li>
                <li><a href="#">首页</a></li>
                <li><a href="#">购物车</a></li>
            </ul>
        </div>
        <div class="blank23"></div>
        <div class="main_content">
            <div class="step">
                <div class="col1	nav_carthot">1.查看购物车</div>
                <div class="col2">2.进入结算中心</div>
                <div class="col3">3.订单确定</div>
                <div class="col4">4.订单完成</div>
            </div>
        </div>

        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellspacing="1" bgcolor="#cccccc"  class="common_table">
            <tr>
                <td class="common_title">品名</td>
                <td class="common_title">品牌</td>
                <td class="common_title">规格</td>
                <td class="common_title">等级</td>
                <td class="common_title">克重</td>
                <td class="common_title">销售价格</td>
                <td class="common_title">数量</td>
                <td class="common_title">单位</td>
                <td class="common_title">小计</td>
                <td width="100" class="common_title"></td>
            </tr>
            <tr>
                <td  class="common_value">双面铜版纸</td>
                <td  class="common_value">长鹤</td>
                <td  class="common_value">889*1194</td>
                <td  class="common_value">A</td>
                <td  class="common_value">120G</td>
                <td  class="common_value" align="right">4500.00 </td>
                <td  class="common_value"><input type="text" style="width:50px;height:20px;" value="10"/></td>
                <td  class="common_value">件</td>
                <td  class="common_value2" align="right">45000.00 </td>
                <td  class="common_value" align="center"><input type="button"  class="btn_2" value="删除" onclick="confirm('是否删除该产品？')"/></td>
            </tr>
            <tr>
                <td  class="common_value2">双面铜版纸</td>
                <td  class="common_value2">长鹤</td>
                <td  class="common_value2">889*1194</td>
                <td  class="common_value2">A</td>
                <td  class="common_value2">120G</td>
                <td  class="common_value2" align="right">6000.00 </td>
                <td  class="common_value2"><input type="text" style="width:50px;height:20px;" value="10"/></td>
                <td  class="common_value2"><label>
                        <select name="select2">
                            <option value="">吨</option>
                            <option value="">件</option>
                        </select>
                    </label></td>
                <td  class="common_value2" align="right">60000.00 </td>
                <td  class="common_value2" align="center"><input type="button" value="删除"  class="btn_2" onclick="confirm('是否删除该产品？')"/></td>
            </tr>
            <tr>
                <td  class="common_value">双面铜版纸</td>
                <td  class="common_value">长鹤</td>
                <td  class="common_value">889*1194</td>
                <td  class="common_value">A</td>
                <td  class="common_value">120G</td>
                <td  class="common_value" align="right">4500.00 </td>
                <td  class="common_value"><input type="text" style="width:50px;height:20px;" value="10"/></td>
                <td  class="common_value">件</td>
                <td  class="common_value2" align="right">45000.00 </td>
                <td  class="common_value" align="center"><input type="button" value="删除"  class="btn_2" onclick="confirm('是否删除该产品？')"/></td>
            </tr>
            <tr>
                <td  class="common_value2">双面铜版纸</td>
                <td  class="common_value2">长鹤</td>
                <td  class="common_value2">889*1194</td>
                <td  class="common_value2">A</td>
                <td  class="common_value2">120G</td>
                <td  class="common_value2" align="right">4500.00 </td>
                <td  class="common_value2"><input type="text" style="width:50px;height:20px;" value="10"/></td>
                <td  class="common_value2">件</td>
                <td  class="common_value2" align="right">45000.00 </td>
                <td  class="common_value2" align="center"><input type="button" value="删除"  class="btn_2" onclick="confirm('是否删除该产品？')"/></td>
            </tr>
            <tr>
                <td  class="common_value2" style="background-color:#fff;" colspan="7"></td>
                <td  class="common_value2" style="background-color:#fff;" ><b>总计</b></td>
                <td  class="common_value2" style="background-color:#fff;"  align="right"><b>195000.00</b> </td>
                <td  class="common_value2" style="background-color:#fff;" ></td>
            </tr>
        </table>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35" align="right">
                        <input type="submit" name="Submit3" value="更新"   class="btn_2" />
                        <input type="submit" name="Submit" value="继续购物"  class="btn_4" onclick="window.location='../products/product.jsp';" />
                        <input type="submit"  class="btn_6" onclick="window.location='do_order.jsp';" name="Submit2" value="进入结算中心" />
                    </td>
            </tr>
        </table>
        <!--空23px--->
        <div class="blank23"></div>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <%@ include file="../help.jsp" %>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>

