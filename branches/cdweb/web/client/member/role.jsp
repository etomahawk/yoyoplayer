<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>当前位置:首页&gt;&gt; 会员中心&gt;&gt; 角色管理</title>
        <link href="../css/blue/member.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <%@ include file="../top_login.jsp" %>
        <div class="position">
            <ul>
                <li>当前位置:</li>
                <li><a href="#">会员中心</a></li>
                <li><a href="#">角色管理</a></li>
            </ul>
        </div>
        <div class="blank23"></div>

        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td width="220" valign="top">
                    <%@include file="nav.jsp" %>
                </td>
                <td valign="top"><table  class="h30" width="100%" cellpadding="0" cellspacing="0">
                        <tr  >
                            <td ><input name="checkbox" type="checkbox" id="Checkbox1" class="other_input" />
                                全选/全否 </td>
                            <td align="right">
                                <input type="submit" name="Submit" value="批量删除" class="btn_4" /></td>
                        </tr>
                    </table>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="h30">
                        <tbody>
                            <tr>
                                <td align="left" >共有 <span class="red">1</span> 个，<span class="red">1</span> 页，现在第 <span class="red">1</span> 页 </td>
                                <td align="right">
				首页 | 上一页 | 下一页 | 尾页 | 转到第 <input name="text" type="text" class="pageInput" onkeyup="validNum(this)" size="5" />
                                    页	<input type="image" name="imageField3" src="../images/go.gif" /></td>
                            </tr>
                        </tbody>
                    </table>
                    <table width="100%" border="0" align="center" cellspacing="1"  class="common_table">
                        <tr	class="common_title">
                            <td >角色名称</td>
                            <td width="100" >操作</td>
                        </tr>
                        <tr	class="common_value">
                            <td  >管理员</td>
                            <td  >删除 修改</td>
                        </tr>
                        <tr	class="common_value2">
                            <td  >采购员</td>
                            <td  >删除 修改</td>
                        </tr>
                        <tr	class="common_value">
                            <td  >采购经理</td>
                            <td  >删除 修改</td>
                        </tr>
                    </table>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="h30">
                        <tbody>
                            <tr>
                                <td align="left">共有 <span class="red">1</span> 个，<span class="red">1</span> 页，现在第 <span class="red">1</span> 页 </td>
                                <td align="right">首页 | 上一页 | 下一页 | 尾页 | 转到第
                                    <input name="text2" type="text" class="pageInput" onkeyup="validNum(this)" size="5" />
                                    页
                                    <input type="image" name="imageField2" src="../images/go.gif" /></td>
                            </tr>
                        </tbody>
                    </table>
                </td>
            </tr>
        </table>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
