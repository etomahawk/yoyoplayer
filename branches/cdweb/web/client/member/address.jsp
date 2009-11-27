<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>当前位置:首页&gt;&gt; 会员中心&gt;&gt; 地址信息</title>
        <link href="../css/blue/member.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <%@ include file="../top_login.jsp" %>
        <div class="position">
            <ul>
                <li>当前位置:</li>
                <li><a href="#">会员中心</a></li>
                <li><a href="#">地址信息</a></li>
            </ul>
        </div>
        <div class="blank23"></div>
        <table width="947" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td width="220" height="300" valign="top">
                    <%@include file="nav.jsp" %>
                </td>
                <td valign="top">
                    <table id="Repeater1"  border="0" cellspacing="1"  class="common_table">
                        <tbody>
                            <tr>
                                <td colspan="2"  class="common_value">选择默认送货地址, 您也可以<a href="#new-address">添加一个新的默认地址</a>。 （在订单确认页面系统会自动显示将您的货物发送到此处设定的默认送货地址，减少您购物的时间，<br />
                                    当然您也可以在下单时选择其他送货地址）</td>
                            </tr>
                            <tr class="common_value">
                                <td><table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
                                        <tbody>
                                            <tr>
                                                <td width="40px"><input class="other_input" name="addressId" value="2893112"  type="radio" /></td>
                                                <td align="left">张竹</td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td align="left"> 上海市浦东新区 </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td align="left"> 201201
                                                    &nbsp;&nbsp;上海市浦东新区东方路1369号 </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td align="left"> 电话：021-5102357 </td>
                                            </tr>
                                        </tbody>
                                    </table></td>
                                <td><table width="99%" align="center" border="0" cellpadding="0" cellspacing="0">
                                        <tbody>
                                            <tr>
                                                <td width="40px"><input class="other_input" name="addressId" value="2893338" checked="checked" type="radio" />
                                                </td>
                                                <td align="left"> 时候 </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td align="left"> 上海市浦东新区 </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td align="left"> 201201
                                                    &nbsp;&nbsp;上海市浦东新区蓝村路12号 </td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td align="left"> 电话：021-5102357 </td>
                                            </tr>
                                        </tbody>
                                    </table></td>
                            </tr>
                        </tbody>
                    </table>
                    <table  width="100%">
                        <tbody>
                            <tr>
                                <td class="align_center" align="center"><input type="submit" 	class="btn_4" name="Submit" value="删除地址" /></td>
                            </tr>
                        </tbody>
                    </table>
                    <table  width="100%" border="0" cellpadding="0" cellspacing="1"  class="common_table">
                        <tbody>
                            <tr>
                                <td colspan="2"  align="left" class="common_title"><span>（带＊号为必填项）</span></td>
                            </tr>
                            <tr class="common_value">
                                <td  width="120" height="25" align="right"><font color="#ff0000">*</font>收货人姓名： </td>
                                <td  height="25"><input name="tbName" maxlength="64" id="tbName" size="30" type="text" />            </td>
                            </tr>
                            <tr class="common_value2"><td  width="120" height="25" align="right">&nbsp;&nbsp;收货人性别： </td>
                                <td  height="25">
                                    <input id="tMale" name="rGender" value="tMale" checked="checked" type="radio" class="other_input"/>男
                                    <input id="tFemale" name="rGender" value="tFemale" type="radio" class="other_input"/>女 </td>
                            </tr>
                            <tr class="common_value">
                                <td  width="120" height="25" align="right"><font color="#ff0000">*</font>收货人地区： </td>
                                <td  height="25"><!-- 省市 选择 开始-->
                                    <select name="DropDownList1" id="DropDownList1" style="width: 110px;">
                                        <option value="-1">选择国家/地区</option>
                                        <option selected="selected" value="3260">中国大陆 </option>
                                        <option value="3261">中国港澳台 </option>
                                    </select>
                                    <select name="DropDownList2" id="DropDownList2" style="width: 110px;">
                                        <option selected="selected" value="-1">选择省/直辖市</option>
                                        <option value="1">北京市</option>
                                        <option value="2">天津市</option>
                                        <option value="3">河北省</option>
                                        <option value="4">山西省</option>
                                        <option value="5">内蒙古自治区</option>
                                        <option value="6">辽宁省</option>
                                        <option value="7">吉林省</option>
                                        <option value="8">黑龙江省</option>
                                        <option value="9">上海市</option>
                                        <option value="10">江苏省</option>
                                        <option value="11">浙江省</option>
                                        <option value="12">安徽省</option>
                                        <option value="13">福建省</option>
                                        <option value="14">江西省</option>
                                        <option value="15">山东省</option>
                                        <option value="16">河南省</option>
                                        <option value="17">湖北省</option>
                                        <option value="18">湖南省</option>
                                        <option value="19">广东省</option>
                                        <option value="20">广西壮族自治区</option>
                                        <option value="21">海南省</option>
                                        <option value="22">重庆市</option>
                                        <option value="23">四川省</option>
                                        <option value="24">贵州省</option>
                                        <option value="25">云南省</option>
                                        <option value="26">西藏藏族自治区</option>
                                        <option value="27">陕西省</option>
                                        <option value="28">甘肃省</option>
                                        <option value="29">青海省</option>
                                        <option value="30">宁夏回族自治区</option>
                                        <option value="31">新疆维吾尔族自治区</option>
                                    </select>
                                    <!-- 省市 选择 结束-->            </td>
                            </tr>
                            <tr class="common_value2">
                                <td height="27" align="right" valign="top">&nbsp;</td>
                                <td align="left"> 建发纸业网上营销系统送货上门范围详见：<a href="#" target="_blank">送货上门</a> <br />
                                    友情提示：<br />
                                    如果您所在地址为高新区或开发区，<br />
                                    请您先选择相应的行政区域，正确填写邮编及地址，以免包裹地址有误，谢谢您的配合！</td>
                            </tr>
                            <tr class="common_value">
                                <td  width="120" align="right">&nbsp;<font color="#ff0000">*</font>收货人地址： </td>
                                <td ><!-- 地址 开始 -->
                                    [请先选择上面地区]
                                    <input name="tbAddress" maxlength="300" id="tbAddress" class="adinput adinput2" style="width: 300px;" type="text" />
                                    <!-- 地址 结束 -->            </td>
                            </tr>
                            <tr class="common_value2">
                                <td  width="120" align="right"><font color="#ff0000">*</font> 收货人邮政编码： </td>
                                <td align="left">
                                    <!-- 邮编 选择控制 开始-->
                                    <input name="tbZipcode" maxlength="10" id="tbZipcode" type="text" />
                                    <!-- 邮编 选择控制 结束 -->            </td>
                            </tr>
                            <tr class="common_value">
                                <td  width="120" align="right"> 会员电子邮件： </td>
                                <td ><input name="tbEmail" id="tbEmail" type="text" />            </td>
                            </tr>
                            <tr class="common_value2">
                                <td align="right"><font color="#ff0000">*</font> 收货人电话：</td>
                                <td align="left"><input name="tbPhone" maxlength="60" id="tbPhone" type="text" />
                                    （电话请填写区号，如：021-54960808）联系电话和手机必填一项 </td>
                            </tr>
                            <tr class="common_value">
                                <td align="right">&nbsp;</td>
                                <td align="left"><input type="submit" name="Submit2" value="增加地址"		class="btn_4"  /></td>
                            </tr>
                        </tbody>
                    </table></td>
            </tr>
        </table>
        <table  width="100%">
        </table>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
