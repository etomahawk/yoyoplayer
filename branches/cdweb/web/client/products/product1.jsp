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
                <li><a href="#">工业用纸</a></li>
                <li><a href="#">铜版纸</a></li>
            </ul>
        </div>
        <div class="blank23"></div>

        <div class="main_content">

            <div class="product_left">
                <div class="nav_title">产品目录</div>
                <div class="nav_class">
                    <ul>
                        <li	class="chilcClass"><a href="subproduct.jsp" >金东铜版纸 </a></li>
                        <li	class="chilcClass"><a href="#" >宁波铜版纸</a></li>
                        <li	class="chilcClass"><a href="#"> 金华盛铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">太阳铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">大宇铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">泉林铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">紫兴铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">晨鸣铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">翰森铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">日本制纸铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">威凯瑞铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">废纸和原料</a></li>
                        <li	class="chilcClass"><a href="#">恒联铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">秋雨铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">博汇铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">秋雨铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">华泰铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">龙丰铜版纸</a></li>
                        <li	class="chilcClass"><a href="#">其他铜版纸</a></li>
                    </ul>
                </div>
                <div class="blank23"></div>
                <div class="nav_title">品牌</div>
                <div class="nav_class"><a href="product3.jsp">长鹤</a> <a href="product3.jsp">大宇</a> 泉林 神盾 彩蝶 金球 太空梭 白云   太阳 江鹰 金贝 金鸥 海龙 雄丰 宏益 华远 亚洲酋长 宁波之星 光芒</div>
                <div class="blank23"></div>

                <div class="nav_title">品名</div>
                <div class="nav_class"><a href="product2.jsp">双面铜版纸</a> <a href="product2.jsp">单面铜版纸</a></div>
                <div class="blank23"></div>

                <div class="nav_title">规格</div>
              <div class="nav_class">
                    <input type="text" size="16"  />
                    <input type="submit" name="Submit3" class="btn_2" value="搜索" />
                </div>
            </div>
            <!--右边产品列表-->
            <div class="product_right">
                <div class="product_nav">排列方式：<a href="product_list1.jsp"><img alt="img" src="../images/list_01.gif" width="46" height="16" border="0" /></a><a href="product1.jsp"><img alt="img" src="../images/list_02.gif" width="47" height="16" border="0" /></a></div>
                <div class="blank23"></div>

                <div class="product_list">
                    <!--begin 第一列-->
                    <div 	class="col1">
                        <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                        <div class="info">
                            <ul>
                                <li>商品：金东铜版纸</li>
                                <li>品名:双面铜版纸</li>
                                <li>品牌:长鹤</li>
                                <li>规格:33X200</li>
                                <li>克重:1000</li>
                                <li>等级:A</li>
                                <li>件重：0.05</li>
                                <li>库存：500吨</li>
                            </ul>
                        </div>

                        <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                        <div class="action">
                            <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />&nbsp;&nbsp;<img alt="img" src="../images/tejia.gif" />
                        </div>
                    </div>
                    <div	class="col2">
                        <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                        <div class="info">
                            <ul>
                                <li>商品：金东铜版纸</li>
                                <li>品名:双面铜版纸</li>
                                <li>品牌:长鹤</li>
                                <li>规格:33X200</li>
                                <li>克重:1000</li>
                                <li>等级:A</li>
                                <li>件重：0.05</li>
                                <li>库存：500吨</li>
                            </ul>
                        </div>



                        <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                        <div class="action">
                            <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                        </div>

                    </div>
                    <div	class="col3">
                        <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                        <div class="info">
                            <ul>
                                <li>商品：金东铜版纸</li>
                                <li>品名:双面铜版纸</li>
                                <li>品牌:长鹤</li>
                                <li>规格:33X200</li>
                                <li>克重:1000</li>
                                <li>等级:A</li>
                                <li>件重：0.05</li>
                                <li>库存：500吨</li>
                            </ul>
                        </div>



                        <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                        <div class="action">
                            <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                        </div>
                    </div>
                    <div class="blank23"></div>
                    <!--空23行-->
                    <!--第一列结束-->

                    <div 	class="col1">
                        <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                        <div class="info">
                            <ul>
                                <li>商品：金东铜版纸</li>
                                <li>品名:双面铜版纸</li>
                                <li>品牌:长鹤</li>
                                <li>规格:33X200</li>
                                <li>克重:1000</li>
                                <li>等级:A</li>
                                <li>件重：0.05</li>
                                <li>库存：500吨</li>
                            </ul>
                        </div>



                        <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                        <div class="action">
                            <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                        </div>
                    </div>
                    <div	class="col2">
                        <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                        <div class="info">
                            <ul>
                                <li>商品：金东铜版纸</li>
                                <li>品名:双面铜版纸</li>
                                <li>品牌:长鹤</li>
                                <li>规格:33X200</li>
                                <li>克重:1000</li>
                                <li>等级:A</li>
                                <li>件重：0.05</li>
                                <li>库存：500吨</li>
                            </ul>
                        </div>



                        <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                        <div class="action">
                            <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                        </div>

                    </div>
                    <div	class="col3">
                        <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                        <div class="info">
                            <ul>
                                <li>商品：金东铜版纸</li>
                                <li>品名:双面铜版纸</li>
                                <li>品牌:长鹤</li>
                                <li>规格:33X200</li>
                                <li>克重:1000</li>
                                <li>等级:A</li>
                                <li>件重：0.05</li>
                                <li>库存：500吨</li>
                            </ul>
                        </div>



                        <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                        <div class="action">
                            <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                        </div>
                    </div>
                    <div class="blank23"></div>
                    <!--空23行-->
                    <div 	class="col1">
                        <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                        <div class="info">
                            <ul>
                                <li>商品：金东铜版纸</li>
                                <li>品名:双面铜版纸</li>
                                <li>品牌:长鹤</li>
                                <li>规格:33X200</li>
                                <li>克重:1000</li>
                                <li>等级:A</li>
                                <li>件重：0.05</li>
                                <li>库存：500吨</li>
                            </ul>
                        </div>



                        <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                        <div class="action">
                            <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                        </div>
                    </div>
                    <div	class="col2">
                        <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                        <div class="info">
                            <ul>
                                <li>商品：金东铜版纸</li>
                                <li>品名:双面铜版纸</li>
                                <li>品牌:长鹤</li>
                                <li>规格:33X200</li>
                                <li>克重:1000</li>
                                <li>等级:A</li>
                                <li>件重：0.05</li>
                                <li>库存：500吨</li>
                            </ul>
                        </div>



                        <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                        <div class="action">
                            <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                        </div>

                    </div>
                    <div	class="col3">
                        <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                        <div class="info">
                            <ul>
                                <li>商品：金东铜版纸</li>
                                <li>品名:双面铜版纸</li>
                                <li>品牌:长鹤</li>
                                <li>规格:33X200</li>
                                <li>克重:1000</li>
                                <li>等级:A</li>
                                <li>件重：0.05</li>
                                <li>库存：500吨</li>
                            </ul>
                        </div>



                        <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                        <div class="action">
                            <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                        </div>
                    </div>
                    <div class="blank23"></div>
                    <!--空23行-->
                    <div 	class="col1">
                        <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                        <div class="info">
                            <ul>
                                <li>商品：金东铜版纸</li>
                                <li>品名:双面铜版纸</li>
                                <li>品牌:长鹤</li>
                                <li>规格:33X200</li>
                                <li>克重:1000</li>
                                <li>等级:A</li>
                                <li>件重：0.05</li>
                                <li>库存：500吨</li>
                            </ul>
                        </div>



                        <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                        <div class="action">
                            <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                        </div>
                    </div>
                    <div	class="col2">
                        <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                        <div class="info">
                            <ul>
                                <li>商品：金东铜版纸</li>
                                <li>品名:双面铜版纸</li>
                                <li>品牌:长鹤</li>
                                <li>规格:33X200</li>
                                <li>克重:1000</li>
                                <li>等级:A</li>
                                <li>件重：0.05</li>
                                <li>库存：500吨</li>
                            </ul>
                        </div>



                        <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                        <div class="action">
                            <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                        </div>

                    </div>
                    <div	class="col3">
                        <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                        <div class="info">
                            <ul>
                                <li>商品：金东铜版纸</li>
                                <li>品名:双面铜版纸</li>
                                <li>品牌:长鹤</li>
                                <li>规格:33X200</li>
                                <li>克重:1000</li>
                                <li>等级:A</li>
                                <li>件重：0.05</li>
                                <li>库存：500吨</li>
                            </ul>
                        </div>



                        <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                        <div class="action">
                            <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                        </div>
                    </div>
                    <!---循环结束-->
                    <div class="blank23"></div>
                    <!--空23行-->
                    <!--分页开始-->
                    <!--分页结束-->
                    <div class="pro_page" >
                        <a href="#">首页</a> <a href="#">上一个</a> <a href="#">下一个</a> <a href="#">尾页</a>
                    </div>
                    <!--最近浏览-->
                    <div class="product_nav">最近浏览&nbsp;&gt;</div>
                    <div class="blank23"></div>

                    <div class="product_list">
                        <!--begin 第一列-->
                        <div 	class="col1">
                            <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                            <div class="info">
                                <ul>
                                    <li>商品：金东铜版纸</li>
                                    <li>品名:双面铜版纸</li>
                                    <li>品牌:长鹤</li>
                                    <li>规格:33X200</li>
                                    <li>克重:1000</li>
                                    <li>等级:A</li>
                                    <li>件重：0.05</li>
                                    <li>库存：500吨</li>
                                </ul>
                            </div>



                            <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                            <div class="action">
                                <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                            </div>
                        </div>
                        <div	class="col2">
                            <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                            <div class="info">
                                <ul>
                                    <li>商品：金东铜版纸</li>
                                    <li>品名:双面铜版纸</li>
                                    <li>品牌:长鹤</li>
                                    <li>规格:33X200</li>
                                    <li>克重:1000</li>
                                    <li>等级:A</li>
                                    <li>件重：0.05</li>
                                    <li>库存：500吨</li>
                                </ul>
                            </div>



                            <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                            <div class="action">
                                <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                            </div>

                        </div>
                        <div	class="col3">
                            <div class="pic"><img alt="img" src="../images/product1.jpg" width="81" height="90"  /><br />建发编码：21569</div>
                            <div class="info">
                                <ul>
                                    <li>商品：金东铜版纸</li>
                                    <li>品名:双面铜版纸</li>
                                    <li>品牌:长鹤</li>
                                    <li>规格:33X200</li>
                                    <li>克重:1000</li>
                                    <li>等级:A</li>
                                    <li>件重：0.05</li>
                                    <li>库存：500吨</li>
                                </ul>
                            </div>



                            <div class="pro_price">市场价:<span class="price1">1000.00</span> 会员价:490.00</div>
                            <div class="action">
                                <input type="submit" name="Submit43" value="选购" class="btn_2"  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value="收藏" class="btn_2" />
                            </div>
                        </div>
                    </div>
                </div>
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
