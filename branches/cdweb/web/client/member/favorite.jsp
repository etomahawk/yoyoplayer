<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>当前位置:首页&gt;&gt; 会员中心&gt;&gt; 我的收藏</title>
        <link href="../css/blue/member.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <%@ include file="../top_login.jsp" %>
        <div class="position">
            <ul>
                <li>当前位置:</li>
                <li><a href="#">会员中心</a></li>
                <li><a href="#">我的收藏</a></li>
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
                                <input type="submit" name="Submit" value="批量删除"   class="btn_4" />
								<input type="submit" name="Submit2" value="清空收藏夹"  class="btn_5"/>
								<input type="submit" name="Submit3" value="放入购物车"  class="btn_5"/>
                            </td>
                        </tr>
                    </table>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="h30">
                        <tbody>
                            <tr>
                                <td align="left" >共有 <span class="red">1</span> 个商品，<span class="red">1</span> 页，现在第 <span class="red">1</span> 页 </td>
                                <td align="right">首页 | 上一页 | 下一页 | 尾页 | 转到第
                                    <input name="text" type="text" class="pageInput" onkeyup="validNum(this)" size="5" />
                                    页
                                    <input type="image" name="imageField3" src="../images/go.gif" /></td>
                            </tr>
                        </tbody>
                    </table>
                    <table  width="100%" border="0" cellpadding="0" cellspacing="1"  class="common_table">
                        <tr class="common_title">
                            <td width="61"><input type="checkbox" name="checkbox3" value="checkbox" class="other_input" /> 选择</td>
                            <td width="127" >商品图片</td>
                            <td >商品名称</td>
                            <td >操作</td>
                        </tr>
                        <tr class="common_value">
                            <td width="61"><input type="checkbox" name="checkbox32" value="checkbox" class="other_input" /></td>
                            <td align="left"><a href="#"><img alt="img" src="../images/product1.jpg" width="100" border="0" height="75" /></a></td>
                            <td width="407" >
                                <table width="100%" border="0" cellpadding="0" cellspacing="0" style="height:90px">
                                    <tr >
                                        <td colspan="2" align="left" >
                                            <a href="#">双胶纸 &nbsp; 白云 &nbsp;  889*1194 &nbsp;  A </a>                                        </td>
                                    </tr>
                                    <tr >
                                        <td  > 原 价：</td>
                                        <td width="80%" align="left" > ￥5500.00 / 吨</td>
                                    </tr>
                                    <tr  >
                                        <td >会员价：</td>
                                        <td align="left" >￥4,999.00 / 吨</td>
                                    </tr>
                          </table></td>
                            <td width="127" ><a href="#">购买</a>&nbsp;<a href="#">删除</a>&nbsp;<a href="#">更新标签</a> </td>
                        </tr>
                        <tr class="common_value2">
                            <td width="61"><input type="checkbox" name="checkbox32" value="checkbox" class="other_input" /></td>
                            <td align="left"><a href="#"><img alt="img" src="../images/product1.jpg" width="100" border="0" height="75" /></a></td>
                            <td width="407" ><table width="100%" border="0" cellpadding="0" cellspacing="0" style="height:90px">
                                    <tr >
                                        <td colspan="2" align="left" >
                                            <a href="#">双胶纸 &nbsp; 白云 &nbsp;  889*1194 &nbsp;  A </a>                                        </td>
                                    </tr>
                                    <tr >
                                        <td  > 原 价：</td>
                                        <td width="80%" align="left" > ￥5500.00 / 吨</td>
                                    </tr>
                                    <tr  >
                                        <td >会员价：</td>
                                        <td align="left" >￥4,999.00 / 吨</td>
                                    </tr>
                          </table></td>
                            <td width="127" ><a href="#">购买</a>&nbsp;<a href="#">删除</a>&nbsp;<a href="#">更新标签</a></td>
                        </tr>
                        <tr class="common_value">
                            <td width="61"><input type="checkbox" name="checkbox32" value="checkbox" class="other_input" /></td>
                            <td align="left"><a href="#"><img alt="img" src="../images/product1.jpg" width="100" border="0" height="75" /></a></td>
                            <td width="407" ><table width="100%" border="0" cellpadding="0" cellspacing="0" style="height:90px;">
                                    <tr >
                                        <td colspan="2" align="left" class="common_value">
                                            <a href="#">双胶纸 &nbsp; 白云 &nbsp;  889*1194 &nbsp;  A </a>                                        </td>
                                    </tr>
                                    <tr >
                                        <td class="common_value" > 原 价：</td>
                                        <td width="80%" align="left"class="common_value" > ￥5500.00 / 吨</td>
                                    </tr>
                                    <tr  >
                                        <td class="common_value">会员价：</td>
                                        <td align="left" class="common_value">￥4,999.00 / 吨</td>
                                    </tr>
                          </table></td>
                            <td width="127" ><a href="#">购买</a>&nbsp;<a href="#">删除</a>&nbsp;<a href="#">更新标签</a></td>
                        </tr>
                        <tr class="common_value2">
                            <td width="61"><input type="checkbox" name="checkbox32" value="checkbox" class="other_input" /></td>
                            <td align="left"><a href="#"><img alt="img" src="../images/product1.jpg" width="100" border="0" height="75" /></a></td>
                            <td width="407" ><table width="100%" border="0" cellpadding="0" cellspacing="0" style="height:90px;">
                                    <tr >
                                        <td colspan="2" align="left" >
                                            <a href="#">双胶纸 &nbsp; 白云 &nbsp;  889*1194 &nbsp;  A </a>                                        </td>
                                    </tr>
                                    <tr >
                                        <td  > 原 价：</td>
                                        <td width="80%" align="left" > ￥5500.00 / 吨</td>
                                    </tr>
                                    <tr  >
                                        <td >会员价：</td>
                                        <td align="left" >￥4,999.00 / 吨</td>
                                    </tr>
                          </table></td>
                            <td width="127" ><a href="#">购买</a>&nbsp;<a href="#">删除</a>&nbsp;<a href="#">更新标签</a></td>
                        </tr>
                        <tr class="common_value">
                            <td width="61"><input type="checkbox" name="checkbox32" value="checkbox" class="other_input" /></td>
                            <td align="left"><a href="#"><img alt="img" src="../images/product1.jpg" width="100" border="0" height="75" /></a></td>
                            <td width="407" ><table width="100%" border="0" cellpadding="0" cellspacing="0"  style="height:90px;">
                                    <tr >
                                        <td colspan="2" align="left" class="common_value">
                                            <a href="#">双胶纸 &nbsp; 白云 &nbsp;  889*1194 &nbsp;  A </a>                                        </td>
                                    </tr>
                                    <tr >
                                        <td class="common_value" > 原 价：</td>
                                        <td width="80%" align="left"class="common_value" > ￥5500.00 / 吨</td>
                                    </tr>
                                    <tr  >
                                        <td class="common_value">会员价：</td>
                                        <td align="left" class="common_value">￥4,999.00 / 吨</td>
                                    </tr>
                          </table></td>
                            <td width="127" ><a href="#">购买</a>&nbsp;<a href="#">删除</a>&nbsp;<a href="#">更新标签</a></td>
                        </tr>
                        <tr class="common_value2">
                            <td width="61"><input type="checkbox" name="checkbox32" value="checkbox" class="other_input" /></td>
                            <td align="left"><a href="#"><img alt="img" src="../images/product1.jpg" width="100" border="0" height="75" /></a></td>
                            <td width="407" ><table width="100%" border="0" cellpadding="0" cellspacing="0"  style="height:90px;">
                                    <tr >
                                        <td colspan="2" align="left" >
                                            <a href="#">双胶纸 &nbsp; 白云 &nbsp;  889*1194 &nbsp;  A </a>                                        </td>
                                    </tr>
                                    <tr >
                                        <td  > 原 价：</td>
                                        <td width="80%" align="left" > ￥5500.00 / 吨</td>
                                    </tr>
                                    <tr  >
                                        <td >会员价：</td>
                                        <td align="left" >￥4,999.00 / 吨</td>
                                    </tr>
                          </table></td>
                            <td width="127" ><a href="#">购买</a>&nbsp;<a href="#">删除</a>&nbsp;<a href="#">更新标签</a></td>
                        </tr>
                    </table>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="h30">
                        <tbody>
                            <tr>
                                <td align="left">共有 <span class="red">1</span> 个商品，<span class="red">1</span> 页，现在第 <span class="red">1</span> 页 </td>
                                <td align="right">首页 | 上一页 | 下一页 | 尾页 | 转到第
                                    <input name="text2" type="text" class="pageInput" onkeyup="validNum(this)" size="5" />
                                    页
                                    <input type="image" name="imageField2" src="../images/go.gif" /></td>
                            </tr>
                        </tbody>
                    </table>
                    <table  width="100%" cellpadding="0" cellspacing="0" class="h30">
                        <tbody>
                            <tr class="titleTable" >
                                <td ><input name="checkbox2" type="checkbox" id="checkbox"  class="other_input" />
                                    全选/全否 </td>
                                <td align="right"><input type="submit" name="Submit4" value="批量删除"   class="btn_4" />
                                  &nbsp;&nbsp;
                                  <input type="submit" name="Submit22" value="清空收藏夹"  class="btn_5"/>
&nbsp;&nbsp;
<input type="submit" name="Submit32" value="放入购物车"  class="btn_5"/></td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="blank23"></div>
                </td>
            </tr>
        </table>
        <!--空23px--->
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
