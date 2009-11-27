<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>当前位置:首页&gt;&gt; 会员中心&gt;&gt; 基本信息</title>
        <link href="../css/blue/member.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <%@ include file="../top_login.jsp" %>
        <div class="position">
            <ul>
                <li>当前位置:</li>
                <li><a href="#">会员中心</a></li>
                <li><a href="#">密码管理</a></li>
            </ul>
        </div>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td width="220" height="300" valign="top">
                    <%@include file="nav.jsp" %>
                </td>
                <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="common_table">
                        <tbody>
                            <tr class="common_value">
                                <td width="21%" height="25" align="right">&nbsp;*用 户 名：</td>
                                <td width="79%" height="25"><input name="tbEmail" value="abc@163.com" id="tbEmail" type="text" /></td>
                            </tr>

                            <tr class="common_value2">
                                <td height="27" align="right">* 原 密 码：</td>
                                <td align="left"><input name="tbMobilephone23" maxlength="30" id="tbMobilephone23" type="password" /></td>
                            </tr>
                            <tr class="common_value">
                                <td align="right">新 密 码：</td>
                                <td align="left"><input name="tbMobilephone2" maxlength="30" id="tbMobilephone2" type="password" /></td>
                            </tr>
                            <tr class="common_value2">
                                <td height="27" align="right">确认密码：</td>
                                <td align="left"><input name="tbMobilephone22" maxlength="30" id="tbMobilephone22" type="password" /></td>
                            </tr>
                            <tr class="common_value">
                                <td height="27" align="right">&nbsp;</td>
                                <td align="left">
                                        <input type="submit" name="Submit" value="修改密码" class="btn_4" />
                                        <input type="reset" name="Submit2" value="重置"  class="btn_2" />
                                    </td>
                            </tr>
                        </tbody>
                    </table></td>
            </tr>
        </table>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
