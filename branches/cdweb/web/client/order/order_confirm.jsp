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
                <li><a href="#">疑义订单确认</a></li>
            </ul>
        </div>
        <div class="blank"></div>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0" >
            <tr>
                <td height="26" class="nav_cartbg2">
                    <table width="947" style="height:26px;" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="23%" align="center" >1 查看购物车</td>
                            <td width="25%" align="center" class="nav_carthot">2.进入结算中心</td>
                            <td width="24%" align="center">3.订单确定</td>
                            <td width="28%" align="center">4.查看订单</td>
                        </tr>
                    </table></td>
            </tr>
        </table>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35" align="center"><label>
                        <input type="submit" name="Submit22" value="订单确认"	 class="btn_2" />
                    </label></td>
            </tr>
        </table>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0" >
            <tr>
                <td width="681"><table width="660" border="0" cellpadding="0" cellspacing="1" class="common_table">
                        <tr>
                            <td  class="common_title">配送详情</td>
                        </tr>
                        <tr>
                            <td class="common_value2">配送到： &nbsp;<input  class="btn_2" type="submit" name="Submit42" value="修改" /></td>
                        </tr>
                        <tr>
                            <td class="common_value">名称：A 客户<br />
                                地址：上海市虹桥路 1
                                号<br />
                                邮编：201201<br />
                                电话：021-5102357 </td>
                        </tr>
                        <tr>
                            <td class="common_value2">送货方式： &nbsp;&nbsp;<input type="submit" name="Submit4" value="修改"  class="btn_2"/>(<a href="http://172.16.214.11:8080/cd/site/order_confirm.jsp#">了解更多</a>）</td>
                        </tr>
                        <tr>
                            <td class="common_value">
                                <input id="radio" type="radio" checked="checked" value="0" name="r_ship" />
                                客户自提
                                &nbsp;&nbsp;运输工具:
                                <input id="radio" size="5" name="Input" />
                                &nbsp;&nbsp;证件号码:
                                <input id="radio" size="15" name="Input" />          </td>
                        </tr>
                        <tr>
                            <td class="common_value" >
                                <input id="radio" type="radio" value="1500" name="r_ship" />送货上门 </td>
                        </tr>
                        <tr>
                            <td  class="common_value">
                                <input id="radio" type="radio" checked="checked" value="0"  name="r_settlement" />货到付款</td>
                        </tr>
                        <tr>
                            <td class="common_value2"><input id="radio" type="radio" value="0" name="r_settlement" />款到发货</td>
                        </tr>
                        <tr>
                            <td class="common_value">
                                <input id="radio" type="radio" value="500" name="r_settlement" />赊销
                                &nbsp;&nbsp;还款期:<input id="radio" size="5" name="Input" /></td>
                        </tr>
                        <tr>
                            <td class="common_value2">支付方式： &nbsp;&nbsp;<span class="tiny">(<a href="http://172.16.214.11:8080/cd/site/order_confirm.jsp#">了解更多</a>）</span> </td>
                        </tr>
                        <tr>
                            <td class="common_value"><input id="radio" type="radio" checked="checked" value="0" name="r_payment" />现金</td>
                        </tr>
                        <tr>
                            <td class="common_value">
                                <input id="radio" type="radio" value="200" name="r_payment" />汇票&nbsp;&nbsp;到帐日期:
                                <input id="radio" size="10" name="Input" /></td>
                        </tr>
                        <tr>
                            <td class="common_value2">加工服务： &nbsp;&nbsp;(<a href="http://172.16.214.11:8080/cd/site/order_confirm.jsp#">了解更多</a>）</td>
                        </tr>
                        <tr>
                            <td class="common_value">剪切:
                                <input id="Input" type="checkbox" value="100" name="Input" /></td>
                        </tr>

                    </table></td>
                <td width="266" valign="top">
                    <table cellspacing="1" cellpadding="0" width="100%" border="0"  class="common_table">
                        <tr style="height:20px;">
                            <td colspan="2"   class="common_value2">订单摘要</td>
                        </tr>
                        <tr style="height:20px;">
                            <td width="42%"  class="common_value">订单合计金额：</td>
                            <td width="58%" align="right" class="common_value"><font color="red">+</font>￥<span id="order_amount"></span> 元</td>
                        </tr>
                        <tr style="height:20px;">
                            <td  class="common_value" nowrap="nowrap" height="10" >配送服务费用：</td>
                            <td  class="common_value" nowrap="nowrap" align="right"height="10" ><font color="red">+</font>￥<span id="ship_fee">0.00</span> 元</td>
                        </tr>
                        <tr style="height:20px;">
                            <td  class="common_value" nowrap="nowrap" height="10" >汇票到帐附加费：</td>
                            <td  class="common_value" nowrap="nowrap" align="right"  height="10"><font color="red">+</font>￥<span id="payment_fee">0.00</span> 元</td>
                        </tr>
                        <tr style="height:20px;">
                            <td  class="common_value">加工服务费用：</td>
                            <td class="common_value" nowrap="nowrap" align="right"><font color="red">+</font>￥<span id="service_fee">0.00</span> 元</td>
                        </tr>
                        <tr style="height:20px;">
                            <td  class="common_value"nowrap="nowrap" height="10"><font color="#194F8F">提前还款优惠：</font></td>
                            <td class="common_value" nowrap="nowrap" align="right" height="10"><font color="#194F8F">-</font>￥<font color="#194F8F"><span id="settlement_fee">0.00</span></font> 元</td>
                        </tr>
                        <tr style="height:20px;">
                            <td  class="common_value"nowrap="nowrap"><font color="#194F8F">订单优惠金额：</font></td>
                            <td  class="common_value"nowrap="nowrap" align="right"><font color="#194F8F">-</font>￥<font color="#194F8F"><span id="order_amount_fee">0.00</span></font> 元</td>
                        </tr>
                        <tr style="height:20px;">
                            <td  nowrap="nowrap" class="common_value2">订单实际金额：</td>
                            <td  nowrap="nowrap" align="right" class="common_value2">￥<font id="order_amount_fact" color="red"></font> 元 </td>
                        </tr>
                    </table>	  </td>
            </tr>
        </table>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellspacing="1" bgcolor="#cccccc"  class="common_table">
            <tr>
                <td class="common_title">品名</td>
                <td class="common_title">品牌</td>
                <td class="common_title">规格</td>
                <td class="common_title">等级</td>
                <td class="common_title">销售价格</td>
                <td class="common_title">会员价格</td>
                <td class="common_title">库存</td>
                <td class="common_title">单位</td>
                <td width="100" class="common_title">选购</td>
            </tr>
            <tr>
                <td  class="common_value">双面铜版纸</td>
                <td  class="common_value">长鹤</td>
                <td  class="common_value">889*1194</td>
                <td  class="common_value">A</td>
                <td  class="common_value">5,000.00</td>
                <td  class="common_value">4500.00</td>
                <td  class="common_value">5000</td>
                <td  class="common_value">件</td>
                <td  class="common_value">加入购物车 加入收藏</td>
            </tr>
            <tr>
                <td  class="common_value2">双面铜版纸</td>
                <td  class="common_value2">长鹤</td>
                <td  class="common_value2">889*1194</td>
                <td  class="common_value2">A</td>
                <td  class="common_value2">5,000.00</td>
                <td  class="common_value2">4500.00</td>
                <td  class="common_value2">5000</td>
                <td  class="common_value2">件</td>
                <td  class="common_value2">加入购物车 加入收藏</td>
            </tr>
            <tr>
                <td  class="common_value">双面铜版纸</td>
                <td  class="common_value">长鹤</td>
                <td  class="common_value">889*1194</td>
                <td  class="common_value">A</td>
                <td  class="common_value">5,000.00</td>
                <td  class="common_value">4500.00</td>
                <td  class="common_value">5000</td>
                <td  class="common_value">件</td>
                <td  class="common_value">加入购物车 加入收藏</td>
            </tr>
            <tr>
                <td  class="common_value2">双面铜版纸</td>
                <td  class="common_value2">长鹤</td>
                <td  class="common_value2">889*1194</td>
                <td  class="common_value2">A</td>
                <td  class="common_value2">5,000.00</td>
                <td  class="common_value2">4500.00</td>
                <td  class="common_value2">5000</td>
                <td  class="common_value2">件</td>
                <td  class="common_value2"><span class="common_value">加入购物车 加入收藏</span></td>
            </tr>
        </table>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35" align="center"><label>
                        <input type="submit" name="Submit2" value="订单确认"	 class="btn_4" />
                    </label></td>
            </tr>
        </table>
        <!--空23px--->
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#cccccc"  class="help_table ">
            <tr>
                <td width="20%" align="center" bgcolor="#efefef" class="help_title">新手上路</td>
                <td width="20%" align="center" bgcolor="#efefef" class="help_title">会员中心</td>
                <td width="20%" align="center" bgcolor="#efefef" class="help_title">如何付款</td>
                <td width="20%" align="center" bgcolor="#efefef" class="help_title">如何送货</td>
                <td width="20%" align="center" bgcolor="#efefef" class="help_title">售后服务</td>
            </tr>
            <tr>
                <td valign="top" class="help_value "><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td width="116" class="help_value ">购物演示</td>
                        </tr>
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td class="help_value ">新会员注册</td>
                        </tr>
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td class="help_value ">搜索商品</td>
                        </tr>
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td class="help_value ">会员制</td>
                        </tr>
                    </table></td>
                <td class="help_value "><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td width="115" class="help_value ">账户信息</td>
                        </tr>
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td class="help_value ">忘记密码</td>
                        </tr>
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td class="help_value ">我的积分</td>
                        </tr>
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td class="help_value ">推荐好友</td>
                        </tr>
                    </table></td>
                <td valign="top" class="help_value "><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td width="116" class="help_value ">付款方式</td>
                        </tr>
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td class="help_value ">货到付款</td>
                        </tr>
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td class="help_value ">邮局汇款</td>
                        </tr>
                    </table></td>
                <td valign="top" class="help_value "><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td width="115" class="help_value ">送货方式</td>
                        </tr>
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td class="help_value ">直送城市</td>
                        </tr>
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td class="help_value ">订单查询</td>
                        </tr>
                    </table></td>
                <td valign="top" class="help_value "><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td width="115" class="help_value ">退货/换货 </td>
                        </tr>
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td class="help_value ">缺货登记</td>
                        </tr>
                        <tr>
                            <td width="60" align="right" class="padding5"><img alt="img" src="../images/icon.gif" width="3" height="5" /></td>
                            <td class="help_value ">联系我们</td>
                        </tr>
                    </table></td>
            </tr>
        </table>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
