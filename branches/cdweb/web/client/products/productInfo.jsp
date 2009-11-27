<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
        <title>商品</title>
        <link href="../css/blue/product.css" rel="stylesheet" type="text/css" />
        <script src="../js/tab.js" type="text/javascript"></script>
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
                <li><a href="#">金东铜版纸</a></li>
                <li><a href="#">21569</a></li>
            </ul>
        </div>
        <div class="blank23"></div>
        <div class="main_content">

            <div class="product_left">
                <div class="nav_title">产品目录</div>
                <div class="nav_class">
                    <ul>
                        <li><a href="#" class="hot">-> 工业用纸</a></li>
                        <li><a href="product1.jsp" > --> 铜版纸</a></li>
                        <li><a href="#"> --> 白板纸</a></li>
                        <li> <a href="#">--> 白卡纸</a></li>
                        <li> <a href="#">--> 双胶纸</a></li>
                        <li><a href="#"> --> 轻涂纸</a></li>
                        <li><a href="#"> --> 瓦楞纸</a></li>
                        <li> <a href="#">--> 牛卡纸</a></li>
                        <li><a href="#">--> 中涂纸</a></li>
                        <li><a href="#">--> 灰板纸</a></li>
                        <li><a href="#">-> 纸浆</a></li>
                        <li><a href="#">-> 废纸和原料</a></li>
                        <li><a href="#">-> 生活用纸</a></li>
                        <li><a href="#">-> 打印和书写纸</a></li>
                    </ul>
                </div>
                <div class="blank23"></div>
                <div class="nav_title">品名</div>
                <div class="nav_class"><a href="product2.jsp">双面铜版纸</a> <a href="product2.jsp">单面铜版纸</a></div>
                <div class="blank23"></div>

                <div class="nav_title">品牌</div>
                <div class="nav_class"><a href="product3.jsp">长鹤</a> 神盾 太空梭 东帆 无品牌 </div>
                <div class="blank23"></div>

                <div class="nav_title">规格</div>
                <div class="nav_class">
                    <input type="text" size="16"  />
                    <input type="submit" name="Submit3" value=" 更 新 " />
                </div>
            </div>
            <!--右边产品列表-->
            <div class="product_right">
                <div class="product_nav">商品信息</div>
                <div class="blank23"></div>

                <div class="product_list">
                    <!--产品席新年页面-->
                    <div 	class="productinfo">
                        <div class="pic">
                            <a href="productInfo.jsp" target="_blank"><img alt="img" src="../images/product1.jpg" width="81" height="90" border="0"  /></a><br /> 建发编码：21569
                        </div>
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

                <div class="blank23"></div>
                <div class="product_list">
                    <div class=Productbox>
                        <ul>
                            <li class=hover id=one1 onMouseOver="setTab('one',1,2)">产品信息</li>
                            <li id=one2 onMouseOver="setTab('one',2,2)">其它属性</li>
                        </ul>
                    </div>
                    <div class="tab"	 id=con_one_1  >
					建发纸业仍然延续了其母公司建发集团的供应链经营模式，定位做造纸印刷产业供应链服务商。经过17年的发展，公司已经发展成为中国最大的纸张和纸浆的经销商。就是这样一家公司，选择在2009年补充自己的供应链体系，采取和设备制造商通力合作的模式，进军印刷设备销售业，业务范围不仅囊括纸张、纸浆、纸品、造纸设备，还涉足到了印刷设备领域。
                    </div>
                    <div class="tab"	 id="con_one_2" style="DISPLAY: none ;">
					建发纸业仍然延续了其母公司建发集团的供应链经营模式，定位做造纸印刷产业供应链服务商。采取和设备制造商通力合作的模式，进军印刷设备销售业，业务范围不仅囊括纸张、纸浆、纸品、造纸设备，还涉足到了印刷设备领域。
                    </div>
                </div>

                <!---循环结束-->
                <div class="blank23"></div>
                <!--空23行-->
                <!--最近浏览-->
                <div class="product_nav">推荐商品&nbsp;&gt;</div>
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
                </div>
                <!---->

            </div>
        </div>
        <!--空23px--->
        <div class="blank23"></div>
        <%@ include file="../help.jsp" %>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
