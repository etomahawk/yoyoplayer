<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>高级搜索</title>
        <link href="../css/blue/search.css" rel="stylesheet" type="text/css" />
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
                            <td align="center" >品名：</td>
                            <td  ><input type="text" name="textfield232" /></td>
                            <td  >规格：</td>
                            <td  ><input type="text" name="textfield23" /></td>
                        </tr>
                        <tr class="common_value2">
                            <td align="center">克重：</td>
                            <td  ><input type="text" name="textfield24" /></td>
                            <td  >等级：</td>
                            <td  ><input type="text" name="textfield233" /></td>
                        </tr>
                        <tr class="common_value">
                            <td align="center">库存：</td>
                            <td  ><input name="textfield253" type="text" size="20" /> 
                            ~ 
                              <input name="textfield2522" type="text" size="20" /></td>
                            <td  >&nbsp;</td>
                            <td  >&nbsp;</td>
                        </tr>
                        <tr class="common_value2">
                            <td align="center">价  格：</td>
                            <td  ><input name="textfield25" type="text" size="20" /> ~ <input name="textfield252" type="text" size="20" /></td>
                            <td  >&nbsp;</td>
                            <td  >&nbsp;</td>
                        </tr>
                        <tr>
                            <td align="center">&nbsp;</td>
                            <td colspan="3"  class="h40">
                                <input type="submit" name="Submit432" value="搜索"   class="btn_2"/></td>
                        </tr>
                    </table>    </td>
            </tr>
        </table>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <div class="blank23"></div>
        <!--空23px--->
        <div class="blank23"></div>
        <%@ include file="../help.jsp" %>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
