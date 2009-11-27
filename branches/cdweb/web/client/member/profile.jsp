<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>无标题文档</title>
        <link href="../css/blue/member.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <%@ include file="../top_login.jsp" %>
        <div class="position">
            <ul>
                <li>当前位置:</li>
                <li><a href="#">会员中心</a></li>
                <li><a href="#">基本信息</a></li>
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
                                <td height="25" align="right"><font color="#ff0000">*</font>用 户 名： </td>
                                <td height="25"><input name="tbEmail" value="abc@163.com" id="tbEmail" type="text" /></td>
                            </tr>
                            <tr class="common_value2">
                                <td height="25" align="right"><font color="#ff0000">*</font>会员姓名： </td>
                                <td height="25"><input name="tbName" maxlength="64" id="tbName" size="30" type="text" />          </td>
                            </tr>
                            <tr class="common_value">
                                <td height="25" align="right">性别： </td>
                                <td height="25"><input value="tMale" type="radio"  class="other_input"/>男
                                    <input id="tFemale" name="rGender" value="tFemale" checked="checked" type="radio" class="other_input"/>女 </td>
                            </tr>
                            <tr class="common_value2">
                                <td height="25" align="right"><font color="#ff0000">*</font>出生日期： </td>
                                <td height="25"><select name="sYear" id="sYear">
                                        <option selected="selected" value="">年</option>
                                        <option value="2008">2008</option>
                                        <option value="2007">2007</option>
                                        <option value="2006">2006</option>
                                        <option value="2005">2005</option>
                                        <option value="2004">2004</option>
                                        <option value="2003">2003</option>
                                        <option value="2002">2002</option>
                                        <option value="2001">2001</option>
                                        <option value="2000">2000</option>
                                        <option value="1999">1999</option>
                                        <option value="1998">1998</option>
                                        <option value="1997">1997</option>
                                        <option value="1996">1996</option>
                                        <option value="1995">1995</option>
                                        <option value="1994">1994</option>
                                        <option value="1993">1993</option>
                                        <option value="1992">1992</option>
                                        <option value="1991">1991</option>
                                        <option value="1990">1990</option>
                                        <option value="1989">1989</option>
                                        <option value="1988">1988</option>
                                        <option value="1987">1987</option>
                                        <option value="1986">1986</option>
                                        <option value="1985">1985</option>
                                        <option value="1984">1984</option>
                                        <option value="1983">1983</option>
                                        <option value="1982">1982</option>
                                        <option value="1981">1981</option>
                                        <option value="1980">1980</option>
                                        <option value="1979">1979</option>
                                        <option value="1978">1978</option>
                                        <option value="1977">1977</option>
                                        <option value="1976">1976</option>
                                        <option value="1975">1975</option>
                                        <option value="1974">1974</option>
                                        <option value="1973">1973</option>
                                        <option value="1972">1972</option>
                                        <option value="1971">1971</option>
                                        <option value="1970">1970</option>
                                        <option value="1969">1969</option>
                                        <option value="1968">1968</option>
                                        <option value="1967">1967</option>
                                        <option value="1966">1966</option>
                                        <option value="1965">1965</option>
                                        <option value="1964">1964</option>
                                        <option value="1963">1963</option>
                                        <option value="1962">1962</option>
                                        <option value="1961">1961</option>
                                        <option value="1960">1960</option>
                                        <option value="1959">1959</option>
                                        <option value="1958">1958</option>
                                        <option value="1957">1957</option>
                                        <option value="1956">1956</option>
                                        <option value="1955">1955</option>
                                        <option value="1954">1954</option>
                                        <option value="1953">1953</option>
                                        <option value="1952">1952</option>
                                        <option value="1951">1951</option>
                                        <option value="1950">1950</option>
                                        <option value="1949">1949</option>
                                        <option value="1948">1948</option>
                                        <option value="1947">1947</option>
                                        <option value="1946">1946</option>
                                        <option value="1945">1945</option>
                                        <option value="1944">1944</option>
                                        <option value="1943">1943</option>
                                        <option value="1942">1942</option>
                                        <option value="1941">1941</option>
                                        <option value="1940">1940</option>
                                        <option value="1939">1939</option>
                                        <option value="1938">1938</option>
                                        <option value="1937">1937</option>
                                        <option value="1936">1936</option>
                                        <option value="1935">1935</option>
                                        <option value="1934">1934</option>
                                        <option value="1933">1933</option>
                                        <option value="1932">1932</option>
                                        <option value="1931">1931</option>
                                        <option value="1930">1930</option>
                                        <option value="1929">1929</option>
                                        <option value="1928">1928</option>
                                        <option value="1927">1927</option>
                                        <option value="1926">1926</option>
                                        <option value="1925">1925</option>
                                        <option value="1924">1924</option>
                                        <option value="1923">1923</option>
                                        <option value="1922">1922</option>
                                        <option value="1921">1921</option>
                                        <option value="1920">1920</option>
                                        <option value="1919">1919</option>
                                        <option value="1918">1918</option>
                                        <option value="1917">1917</option>
                                        <option value="1916">1916</option>
                                        <option value="1915">1915</option>
                                        <option value="1914">1914</option>
                                        <option value="1913">1913</option>
                                        <option value="1912">1912</option>
                                        <option value="1911">1911</option>
                                        <option value="1910">1910</option>
                                        <option value="1909">1909</option>
                                        <option value="1908">1908</option>
                                    </select>
                                    <select name="sMonth" id="sMonth">
                                        <option value="">月</option>
                                        <option selected="selected" value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                    </select>
                                    <select name="sDay" id="sDay">
                                        <option value="">日</option>
                                        <option selected="selected" value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                        <option value="7">7</option>
                                        <option value="8">8</option>
                                        <option value="9">9</option>
                                        <option value="10">10</option>
                                        <option value="11">11</option>
                                        <option value="12">12</option>
                                        <option value="13">13</option>
                                        <option value="14">14</option>
                                        <option value="15">15</option>
                                        <option value="16">16</option>
                                        <option value="17">17</option>
                                        <option value="18">18</option>
                                        <option value="19">19</option>
                                        <option value="20">20</option>
                                        <option value="21">21</option>
                                        <option value="22">22</option>
                                        <option value="23">23</option>
                                        <option value="24">24</option>
                                        <option value="25">25</option>
                                        <option value="26">26</option>
                                        <option value="27">27</option>
                                        <option value="28">28</option>
                                        <option value="29">29</option>
                                        <option value="30">30</option>
                                        <option value="31">31</option>
                                    </select></td>
                            </tr>
                            <tr class="common_value">
                                <td height="25" align="right"><font color="#ff0000">*</font>所在地区： </td>
                                <td height="25"><select name="DropDownList1" id="DropDownList1" style="width: 110px;">
                                        <option selected="selected" value="-1">选择国家/地区</option>
                                        <option value="3260">中国大陆 </option>
                                        <option value="3261">中国港澳台 </option>
                                    </select>          </td>
                            </tr>
                            <tr class="common_value2">
                                <td height="27" align="right" valign="top"></td>
                                <td align="left"> 建发纸业网上营销系统送货上门范围详见：<a href="#" target="_blank">送货上门</a> <br />
                                    友情提示：<br />
                                    如果您所在地址为高新区或开发区，<br />
                                    请您先选择相应的行政区域，正确填写邮编及地址，以免包裹地址有误，谢谢您的配合！</td>
                            </tr>
                            <tr class="common_value">
                                <td align="right"><font color="#ff0000">*</font>详细地址： </td>
                                <td style="height: 25px;"><input name="tbAddress" maxlength="300" id="tbAddress" class="adinput adinput2" style="width: 300px;" type="text" />          </td>
                            </tr>
                            <tr class="common_value2">
                                <td height="27" align="right"><font color="#ff0000">*</font> 邮政编码：</td>
                                <td align="left"><input name="tbZipcode" maxlength="10" id="tbZipcode"  type="text" /></td>
                            </tr>
                            <tr class="common_value">
                                <td align="right"><font color="#ff0000">*</font> 联系电话：</td>
                                <td align="left"><input name="tbPhone" maxlength="60" id="tbPhone" type="text" />（请填写区号，如：021-54960808）联系电话和手机必填一项 </td>
                            </tr>
                            <tr class="common_value2">
                                <td height="27" align="right"><font color="#ff0000">*</font> 手机：</td>
                                <td align="left"><input name="tbMobilephone" maxlength="30" id="tbMobilephone" type="text" /></td>
                            </tr>
                            <tr class="common_value">
                                <td align="right">证件类型：</td>
                                <td align="left"><select name="sCertificateType" id="sCertificateType">
                                        <option selected="selected" value="0">请选择</option>
                                        <option value="1">身份证</option>
                                        <option value="2">学生证</option>
                                        <option value="3">军官证</option>
                                        <option value="4">其它</option>
                                    </select></td>
                            </tr>
                            <tr class="common_value2">
                                <td height="27" align="right">证件号：</td>
                                <td align="left"><input name="tbCertificateNo" maxlength="30" id="tbCertificateNo" type="text" /></td>
                            </tr>
                            <tr class="common_value">
                                <td height="27" align="right">&nbsp;</td>
                                <td align="left"><label>
                                        <input type="submit" name="Submit" value="提交" class="btn_2"/>
                                        <input type="reset" name="Submit2" value="重置" class="btn_2"/>
                                    </label></td>
                            </tr>
                        </tbody>
                    </table></td>
            </tr>
        </table>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
