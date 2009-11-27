<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>商品</title>
        <link href="../css/blue/product.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <%@ include file="../top_login.jsp" %>
        <div class="position">
            <ul>
                <li>当前位置:</li>
                <li><a href="#">首页</a></li>
                <li><a href="#">商品</a></li>
            </ul>
        </div>
        <div class="blank23"></div>

        <div class="main_content">

            <div class="product_left">
                <div class="nav_title">产品目录</div>
                <div class="nav_class">
                    <ul>
                        <li class="parentClass_jian"><a href="#" class="hot">工业用纸</a></li>
                        <li class="chilcClass"><a href="product_list1.jsp" >铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">白板纸</a></li>
                        <li	class="chilcClass"><a href="#">白卡纸</a></li>
                        <li	class="chilcClass"><a href="#">双胶纸</a></li>
                        <li	class="chilcClass"><a href="#">轻涂纸</a></li>
                        <li	class="chilcClass"><a href="#">瓦楞纸</a></li>
                        <li	class="chilcClass"><a href="#">牛卡纸</a></li>
                        <li	class="chilcClass"><a href="#">中涂纸</a></li>
                        <li	class="chilcClass"><a href="#">灰板纸</a></li>
                        <li	class="parentClass_jia"><a href="#"	class="hot">纸浆</a></li>
                        <li	class="parentClass_jia"><a href="#">废纸和原料</a></li>
                        <li	class="parentClass_jia"><a href="#">生活用纸</a></li>
                        <li	class="parentClass_jia"><a href="#">打印和书写纸</a></li>
                    </ul>
                </div>
                <div class="blank23"></div>
                <div class="nav_title">品名</div>
                <div class="nav_class">
                    <a href="#">双面铜版纸</a> 单面铜版纸 双胶纸 灰底白板纸 白底白板纸 白卡纸 静电复印纸 瓦楞纸 白面牛卡 画刊纸 打字纸 轻型纸		</div>
                <div class="blank23"></div>

                <div class="nav_title">品牌</div>
                <div class="nav_class">
                    <a href="#">双面铜版纸</a> 单面铜版纸 双胶纸 灰底白板纸 白底白板纸 白卡纸 静电复印纸 瓦楞纸 白面牛卡 画刊纸 打字纸 轻型纸		</div>
                <div class="blank23"></div>

                <div class="nav_title">规格</div>
              <div class="nav_class">
                    <input type="text" size="16"  />
                    <input type="submit" name="Submit3" class="btn_2" value="搜索" />
                </div>
            </div>
            <!--右边产品列表-->
            <div class="product_right">
                <div class="product_nav">排列方式：<a href="product_list.jsp"><img alt="img" src="../images/list_01.gif" width="46" height="16" border="0" /></a><a href="product.jsp"><img alt="img" src="../images/list_02.gif" width="47" height="16" border="0" /></a></div>
                <div class="blank23"></div>

                <div class="product_list">
                    <!--begin 第一列-->
                    <table width="100%" border="0" align="center" cellspacing="1"  class="common_table">
                        <tr	class="common_title">
                            <td >品名</td>
                            <td >品牌</td>
                            <td >规格</td>
                            <td >克重</td>
                            <td >等级</td>
                            <td >件重</td>
                            <td >销售价格</td>
                            <td >库存(吨)</td>
                            <td >会员价格</td>
                            <td >单位</td>
                            <td width="100" >选购</td>
                        </tr>
                        <tr	class="common_value">
                            <td rowspan="2"  >双面铜版纸</td>
                            <td rowspan="2"  >长鹤</td>
                            <td rowspan="2"  >889*1194</td>
                            <td rowspan="2"  >210</td>
                            <td rowspan="2"  >A</td>
                            <td rowspan="2"  >0.01</td>
                            <td rowspan="2"  >5,000.00</td>
                            <td rowspan="2"  >4500.00</td>
                            <td  >5000.00</td>
                            <td  >件</td>
                            <td rowspan="2"  ><a href="#" onclick="window.location.href='../order/car_list.jsp'">选购</a> 收藏</td>
                        </tr>
                        <tr	class="common_value">
                            <td  >4500.00</td>
                            <td  >吨</td>
                        </tr>
                        <tr	class="common_value2">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >100</td>
                            <td  >A</td>
                            <td  >0.02</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >210</td>
                            <td  >A</td>
                            <td  >0.01</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value2">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >100</td>
                            <td  >A</td>
                            <td  >0.02</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >210</td>
                            <td  >A</td>
                            <td  >0.01</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value2">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >100</td>
                            <td  >A</td>
                            <td  >0.02</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >210</td>
                            <td  >A</td>
                            <td  >0.01</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value2">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >100</td>
                            <td  >A</td>
                            <td  >0.02</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >210</td>
                            <td  >A</td>
                            <td  >0.01</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value2">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >100</td>
                            <td  >A</td>
                            <td  >0.02</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >210</td>
                            <td  >A</td>
                            <td  >0.01</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value2">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >100</td>
                            <td  >A</td>
                            <td  >0.02</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >210</td>
                            <td  >A</td>
                            <td  >0.01</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value2">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >100</td>
                            <td  >A</td>
                            <td  >0.02</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >210</td>
                            <td  >A</td>
                            <td  >0.01</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value2">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >100</td>
                            <td  >A</td>
                            <td  >0.02</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >210</td>
                            <td  >A</td>
                            <td  >0.01</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value2">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >100</td>
                            <td  >A</td>
                            <td  >&nbsp;</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                    </table>
                </div>
                <!--end -->
                <div class="blank23"></div>
                <!--空23行-->
                <!--分页开始-->

                <div class="pro_page" >
                    <a href="#">首页</a> <a href="#">上一个</a> <a href="#">下一个</a> <a href="#">尾页</a>
                </div>
                <!--分页结束-->
                <!--begin-->
                <div class="product_nav">最近浏览&nbsp;&gt;</div>
                <div class="blank23"></div>

                <div class="product_list">
                    <table width="100%" border="0" align="center" cellspacing="1"  class="common_table">
                        <tr class="common_title">
                            <td >品名</td>
                            <td >品牌</td>
                            <td >规格</td>
                            <td >克重</td>
                            <td >等级</td>
                            <td >件重</td>
                            <td >销售价格</td>
                            <td >库存(吨)</td>
                            <td >会员价格</td>
                            <td >单位</td>
                            <td width="100" >选购</td>
                        </tr>
                        <tr	class="common_value">
                            <td rowspan="2"  >双面铜版纸</td>
                            <td rowspan="2"  >长鹤</td>
                            <td rowspan="2"  >889*1194</td>
                            <td rowspan="2"  >210</td>
                            <td rowspan="2"  >A</td>
                            <td rowspan="2"  >0.01</td>
                            <td rowspan="2"  >5,000.00</td>
                            <td rowspan="2"  >4500.00</td>
                            <td  >5000.00</td>
                            <td  >件</td>
                            <td rowspan="2"  ><a href="#" onclick="window.location.href='../order/car_list.jsp'">选购</a> 收藏</td>
                        </tr>
                        <tr	class="common_value">
                            <td  >4500.00</td>
                            <td  >吨</td>
                        </tr>
                        <tr	class="common_value2">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >100</td>
                            <td  >A</td>
                            <td  >0.02</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                        <tr	class="common_value">
                            <td  >双面铜版纸</td>
                            <td  >长鹤</td>
                            <td  >889*1194</td>
                            <td  >210</td>
                            <td  >A</td>
                            <td  >0.01</td>
                            <td  >5,000.00</td>
                            <td  >4500.00</td>
                            <td  >5000</td>
                            <td  >件</td>
                            <td  >选购 收藏</td>
                        </tr>
                    </table>
                </div>
                <!--end-->
            </div>
        </div>
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
