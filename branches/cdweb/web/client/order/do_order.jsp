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
            <div class="step2">
                <div class="col1">1.查看购物车</div>
                <div class="col2	nav_carthot">2.进入结算中心</div>
                <div class="col3">3.订单确定</div>
                <div class="col4">4.订单完成</div>
            </div>
        </div>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35" align="right">
                    <input type="button"  class="btn_4" onclick="window.location='definite_order.jsp'" name="Submit2" value="订单确认" />
                </td>
            </tr>
        </table>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0" >
            <tr>
                <td align="left" ><table width="100%" border="0" cellpadding="0" cellspacing="1" class="common_table">
                        <tr>
                            <td  class="common_title">订单详情</td>
                        </tr>
                        <tr>
                            <td class="common_value2">送货地址： &nbsp;
                                <input type="submit" name="Submit42"  class="btn_2" value="修改" /></td>
                        </tr>
                        <tr>
                            <td class="common_value">名称：A 客户<br />
                                地址：厦门市海滨大厦<br />
                                邮编：361000<br />
                                电话：0592-5102357 </td>
                        </tr>
                        <tr>
                            <td class="common_value2">送货方式： &nbsp;&nbsp;<input type="submit"  class="btn_2" name="Submit4" value="修改" />(<a href="http://172.16.214.11:8080/cd/site/order_confirm.jsp#">了解更多</a>）</td>
                        </tr>
                        <tr>
                            <td class="common_value">
                                <input name="r_ship" type="radio" class="other_input" id="radio" value="0" checked="checked" />
                                客户自提
                                &nbsp;&nbsp;运输公司
                                <input id="Input2" size="15" name="Input2" />
                                车/船号
                                <input id="Input3" size="10" name="Input3" />
                                &nbsp;&nbsp;证件号码:
                                <input id="radio" size="15" name="Input" />
                                <label>
                                    <select name="select2">
                                        <option value="">提货仓库</option>
                                    </select>
                                </label></td>
                        </tr>
                        <tr>
                            <td class="common_value" >
                                <input id="radio" type="radio" value="1500" name="r_ship" class="other_input"/>
		  送货上门 运费承担方：		  
                                <input id="radio2" type="radio" value="1500" name="r_ship1" class="other_input"/>
                                客户承担
                                <input id="radio3" type="radio" value="1500" name="r_ship1"class="other_input" />
                                供方承担</td>
                        </tr>
                        <tr>
                            <td class="common_value2">附加费用</td>
                        </tr>
                        <tr>
                            <td class="common_value">装车费:
                                <input id="radio4" type="radio" value="1500" name="r_ship1" class="other_input"/>
                                客户承担
                                <input id="radio5" type="radio" value="1500" name="r_ship1" class="other_input"/>
                                供方承担</td>
                        </tr>
                        <tr>
                            <td class="common_value2">结算方式:<span class="common_value">&nbsp;月结60天&nbsp;&nbsp;&nbsp;&nbsp; 支付方式：汇票</span></td>
                        </tr>

                        <tr>
                            <td class="common_value2">加工服务： &nbsp;&nbsp;(<a href="http://172.16.214.11:8080/cd/site/order_confirm.jsp#">了解更多</a>）</td>
                        </tr>
                        <tr>
                            <td class="common_value">分切:
                                <input id="Input" type="checkbox" value="100" name="Input" class="other_input"/> </td>
                        </tr>
                        <tr>
                            <td class="common_value2">备注</td>
                        </tr>
                        <tr>
                            <td class="common_value margin10">
                                <textarea name="textarea" cols="104" rows="5" style="width:100%"></textarea></td>
                        </tr>


                    </table></td>
                <td width="276" align="right" valign="top">
                    <table cellspacing="1" cellpadding="0" width="266" border="0"  class="common_table">
                        <tr style="height:20px;">
                            <td colspan="2"   class="common_value2">订单摘要</td>
                        </tr>
                        <tr style="height:20px;" class="common_value">
                            <td height="10" align="right"   nowrap="nowrap" >总吨数：</td>
                            <td  nowrap="nowrap" align="left"height="10" >34.00</td>
                        </tr>
                        <tr style="height:20px;" class="common_value">
                            <td width="42%" align="right"  >订单合计金额：</td>
                            <td width="58%" align="left" ><font color="red">+</font>￥<span id="order_amount">195000.00</span> 元</td>
                        </tr>
                        <tr style="height:20px;" class="common_value">
                            <td height="10" align="right"   nowrap="nowrap" >配送服务费用：</td>
                            <td   nowrap="nowrap" align="left"height="10" ><font color="red">+</font>￥<span id="ship_fee">0.00</span> 元</td>
                        </tr>
                        <tr style="height:20px;" class="common_value">
                            <td height="10" align="right"   nowrap="nowrap" >汇票到帐附加费：</td>
                            <td   nowrap="nowrap" align="left"  height="10"><font color="red">+</font>￥<span id="payment_fee">0.00</span> 元</td>
                        </tr>
                        <tr style="height:20px;" class="common_value">
                            <td align="right"  >加工服务费用：</td>
                            <td  nowrap="nowrap" align="left"><font color="red">+</font>￥<span id="service_fee">0.00</span> 元</td>
                        </tr>
                        <tr style="height:20px;" class="common_value">
                            <td align="right"  nowrap="nowrap">装卸费:</td>
                            <td  nowrap="nowrap" align="left"><font color="red">+</font>￥<span id="service_fee">0.00</span> 元</td>
                        </tr>
                        <tr style="height:20px;" class="common_value">
                            <td align="right"  nowrap="nowrap"><font color="#194F8F">订单优惠金额：</font></td>
                            <td  nowrap="nowrap" align="left"><font color="#194F8F">-</font>￥<font color="#194F8F"><span id="order_amount_fee">0.00</span></font> 元</td>
                        </tr>
                        <tr style="height:20px;" class="common_value2">
                            <td align="right"  nowrap="nowrap" class="common_value2">订单实际金额：</td>
                            <td  nowrap="nowrap" align="left" class="common_value2">￥<font id="order_amount_fact" color="red">195000.00</font> 元 </td>
                        </tr>
                    </table>	  </td>
            </tr>
        </table>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellspacing="1" bgcolor="#cccccc"  class="common_table">
            <tr	class="common_title">
                <td >品名</td>
                <td >品牌</td>
                <td >规格</td>
                <td >等级</td>
                <td >克重</td>
                <td >销售价格</td>
                <td >数量</td>
                <td >单位</td>
                <td >小计</td>
            </tr>
            <tr	class="common_value">
                <td  >双面铜版纸</td>
                <td  >长鹤</td>
                <td  >889*1194</td>
                <td  >A</td>
                <td  >120G</td>
                <td   align="right">4500.00 </td>
                <td   align="right">10.00</td>
                <td  >件</td>
                <td   align="right">45000.00 </td>
            </tr>
            <tr	class="common_value2">
                <td  >双面铜版纸</td>
                <td  >长鹤</td>
                <td  >889*1194</td>
                <td  >A</td>
                <td  >120G</td>
                <td   align="right">6000.00 </td>
                <td   align="right">10.00</td>
                <td  >吨</td>
                <td   align="right">60000.00 </td>

            </tr>
            <tr	class="common_value">
                <td  >双面铜版纸</td>
                <td  >长鹤</td>
                <td  >889*1194</td>
                <td  >A</td>
                <td  >120G</td>
                <td   align="right">4500.00 </td>
                <td   align="right">10.00</td>
                <td  >件</td>
                <td   align="right">45000.00 </td>
            </tr>
            <tr	class="common_value2">
                <td  >双面铜版纸</td>
                <td  >长鹤</td>
                <td  >889*1194</td>
                <td  >A</td>
                <td  >120G</td>
                <td   align="right">4500.00 </td>
                <td   align="right">10.00</td>
                <td  >件</td>
                <td   align="right">45000.00 </td>

            </tr>
            <tr>
                <td   style="background-color:#fff;" colspan="7"></td>
                <td   style="background-color:#fff;" ><b>总计</b></td>
                <td   style="background-color:#fff;"  align="right"><b>195000.00</b> </td>
            </tr>
        </table>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35" align="right"><label>
                        <input type="button"  class="btn_4" onclick="window.location='definite_order.jsp'" name="Submit2" value="订单确认" />
                    </label></td>
            </tr>
        </table>
        <!--空23px--->
        <div class="blank23"></div>
        <%@ include file="../help.jsp" %>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
