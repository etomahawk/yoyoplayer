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
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0" >
            <tr>
                <td height="26" class="nav_cartbg4">
                    <table width="947" style="height:26px;" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td width="23%" align="center" >1 查看购物车</td>
                            <td width="25%" align="center" >2.进入结算中心</td>
                            <td width="24%" align="center">3.订单确定</td>
                            <td width="28%" align="center" class="nav_carthot">4.查看订单</td>
                        </tr>
                    </table></td>
            </tr>
        </table>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td height="35">查看订单
                    <select name="select2">
                        <option value="类别">选择订单状态</option>
                    </select>
                    <input type="submit" name="Submit22" value="查看订单" 	class="btn_4"/>    </td>
            </tr>
        </table>
        <table width="947" border="0" align="center" cellspacing="1" bgcolor="#cccccc"  class="common_table">
            <tr>
                <td width="100" class="common_title">订单号</td>
                <td class="common_title">版本号</td>
                <td class="common_title">订单日期  </td>
                <td class="common_title">供应商编码</td>
                <td class="common_title">供应商名称</td>
                <td class="common_title">订单金额 </td>
                <td class="common_title">订单状态</td>
                <td class="common_title">确认状态</td>
                <td class="common_title">发货状态 </td>
                <td class="common_title">支付状态 </td>
                <td class="common_title">配送方式 </td>
                <td class="common_title">结算方式</td>
                <td class="common_title">支付方式 </td>
            </tr>
            <tr>
                <td  class="common_value">106135</td>
                <td  class="common_value">双面铜版纸</td>
                <td  class="common_value">长鹤</td>
                <td  class="common_value">889*1194</td>
                <td  class="common_value">A</td>
                <td  class="common_value">5,000.00</td>
                <td  class="common_value">4500.00</td>
                <td  class="common_value">5000</td>
                <td  class="common_value">件</td>
                <td  class="common_value">&nbsp;</td>
                <td  class="common_value">&nbsp;</td>
                <td  class="common_value">&nbsp;</td>
                <td  class="common_value">&nbsp;</td>
            </tr>
            <tr>
                <td  class="common_value2">106135</td>
                <td  class="common_value2">双面铜版纸</td>
                <td  class="common_value2">长鹤</td>
                <td  class="common_value2">889*1194</td>
                <td  class="common_value2">A</td>
                <td  class="common_value2">5,000.00</td>
                <td  class="common_value2">4500.00</td>
                <td  class="common_value2">5000</td>
                <td  class="common_value2">件</td>
                <td  class="common_value2">&nbsp;</td>
                <td  class="common_value2">&nbsp;</td>
                <td  class="common_value2">&nbsp;</td>
                <td  class="common_value2">&nbsp;</td>
            </tr>
            <tr>
                <td height="66"  class="common_value">106135</td>
                <td  class="common_value">双面铜版纸</td>
                <td  class="common_value">长鹤</td>
                <td  class="common_value">889*1194</td>
                <td  class="common_value">A</td>
                <td  class="common_value">5,000.00</td>
                <td  class="common_value">4500.00</td>
                <td  class="common_value">5000</td>
                <td  class="common_value">件</td>
                <td  class="common_value">&nbsp;</td>
                <td  class="common_value">&nbsp;</td>
                <td  class="common_value">&nbsp;</td>
                <td  class="common_value">&nbsp;</td>
            </tr>
            <tr>
                <td  class="common_value2">106135</td>
                <td  class="common_value2">双面铜版纸</td>
                <td  class="common_value2">长鹤</td>
                <td  class="common_value2">889*1194</td>
                <td  class="common_value2">A</td>
                <td  class="common_value2">5,000.00</td>
                <td  class="common_value2">4500.00</td>
                <td  class="common_value2">5000</td>
                <td  class="common_value2">件</td>
                <td  class="common_value2">&nbsp;</td>
                <td  class="common_value2">&nbsp;</td>
                <td  class="common_value2">&nbsp;</td>
                <td  class="common_value2">&nbsp;</td>
            </tr>
        </table>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td height="35"><div class="common"><a href="#">首页</a> <a href="#">上一个</a> <a href="#">下一个</a> <a href="#">尾页</a></div>                <label></label></td>
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
