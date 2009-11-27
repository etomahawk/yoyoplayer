<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>无标题文档</title>
        <link href="../css/blue/css.css" rel="stylesheet" type="text/css" />
        <script src="../js/tab.js" type="text/javascript"></script>
    </head>

    <body >
        <%@ include file="../top_nologin.jsp" %>
        <div class="position">
            <ul>
                <li>当前位置:</li>
                <li><a href="#">首页</a></li>
                <li>高级搜索</li>
            </ul>
        </div>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td valign="top">
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr class="common_value">
                            <td align="center">商品类别：</td>
                            <td  >
                                <select name="select"  onchange="window.location.href=this.value">
                                    <option value="productSearch.jsp">铜版纸</option>
                                    <option value="">白板纸</option>
                                    <option value="">白卡纸</option>
                                    <option value="">双胶纸</option>
                                    <option value="">轻涂纸</option>
                                    <option value="">瓦楞纸</option>
                                    <option value="">牛卡纸</option>
                                    <option value="">中涂纸</option>
                                    <option value="">灰板纸</option>
                                    <option value="productSearch2.jsp" selected="selected">纸浆</option>
                                    <option value="">废纸和原料</option>
                                    <option value="">生活用纸</option>
                                    <option value="">打印和书写纸</option>
                                </select></td>
                            <td  >品  牌：</td>
                            <td  ><input type="text" name="textfield22" /></td>
                        </tr>
                        <tr class="common_value2">
                            <td align="center" >fibresource：</td>
                            <td  >
                                <select name="select2">
                                    <option value="1"></option>
                                </select>            </td>
                            <td  >制浆工艺：</td>
                            <td  ><select name="select3">
                                    <option value="1"></option>
                                </select></td>
                        </tr>
                        <tr class="common_value">
                            <td align="center">bleachingProcess：</td>
                            <td  ><select name="select4">
                                    <option value="1"></option>
                                </select></td>
                            <td  >等级：</td>
                            <td  ><input type="text" name="textfield233" /></td>
                        </tr>
                        <tr class="common_value2">
                            <td align="center">库存：</td>
                            <td  ><input name="textfield253" type="text" size="20" /> ~  <input name="textfield2522" type="text" size="20" /></td>
                            <td  >&nbsp;</td>
                            <td  >&nbsp;</td>
                        </tr>
                        <tr class="common_value">
                            <td align="center">价  格：</td>
                            <td  ><input name="textfield25" type="text" size="20" /> ~ <input name="textfield252" type="text" size="20" /></td>
                            <td  >&nbsp;</td>
                            <td  >&nbsp;</td>
                        </tr>
                        <tr>
                            <td align="center">&nbsp;</td>
                            <td colspan="3"  class="h40">
                                <input type="submit" name="Submit432" value="搜索" class="btn_2"/></td>
                        </tr>
                    </table>    </td>
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
