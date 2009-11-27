<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>商品</title>
        <link href="../css/blue/product.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <%@ include file="../top_nologin.jsp" %>
        <div class="position">
            <ul>
                <li>当前位置:</li>
                <li><a href="#">会员中心</a></li>
                <li><a href="#">商品</a></li>
            </ul>
        </div>
        <div class="blank23"></div>
        <div class="main_content">

            <div class="product_left">
                <div class="nav_title">产品目录</div>
                <div class="nav_class">
                    <ul>
                        <li><a href="#" class="hot">-> 工业用纸</a></li>
                        <li><a href="product_nologin1.jsp" > --> 铜版纸</a></li>
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
                    <input type="submit" name="Submit3" value=" 更 新 " />
                </div>
            </div>
            <!--右边产品列表-->
            <div class="product_right">
                <div class="product_nav">排列方式：<a href="product_nologinlist.jsp"><img alt="img" src="../images/list_01.gif" width="46" height="16" border="0" /></a><a href="product_nologin.jsp"><img alt="img" src="../images/list_02.gif" width="47" height="16" border="0" /></a></div>
                <div class="blank23"></div>

                <div class="product_list">
                    <!--begin 第一列-->
                    <div 	class="col1">
                        <div class="pic"><a href="productInfo_nologin.jsp" target="_blank"><img alt="img" src="../images/product1.jpg" width="81" height="90" border="0"  /></a><br />
			  建发编码：21569</div>
                        <div class="info">
                            <ul>
                                <li>商品：金东铜版纸</li>
                                <li>品名:双面铜版纸</li>
                                <li>品牌:长鹤</li>
                                <li>规格:33X200</li>
                                <li>克重:1000</li>
                                <li>等级:A</li>
                                <li>件重：0.05</li>
                            </ul>
                        </div>
                        <div class="action">
                            <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value=" 收 藏 " />
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
                            </ul>
                        </div>
                        <div class="action">
                            <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value=" 收 藏 " />
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
                            </ul>
                        </div>

                        <div class="action">
                            <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value=" 收 藏 " />
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
                            </ul>
                        </div>

                        <div class="action">
                            <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value=" 收 藏 " />
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
                            </ul>
                        </div>

                        <div class="action">
                            <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value=" 收 藏 " />
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
                            </ul>
                        </div>

                        <div class="action">
                            <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value=" 收 藏 " />
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
                            </ul>
                        </div>

                        <div class="action">
                            <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value=" 收 藏 " />
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
                            </ul>
                        </div>
                        <div class="action">
                            <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value=" 收 藏 " />
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
                            </ul>
                        </div>
                        <div class="action">
                            <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value=" 收 藏 " />
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
                            </ul>
                        </div>

                        <div class="action">
                            <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value=" 收 藏 " />
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
                            </ul>
                        </div>

                        <div class="action">
                            <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value=" 收 藏 " />
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
                            </ul>
                        </div>

                        <div class="action">
                            <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                            <input type="submit" name="Submit233" value=" 收 藏 " />
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
                                </ul>
                            </div>

                            <div class="action">
                                <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                                <input type="submit" name="Submit233" value=" 收 藏 " />
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
                                </ul>
                            </div>

                            <div class="action">
                                <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                                <input type="submit" name="Submit233" value=" 收 藏 " />
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
                                </ul>
                            </div>

                            <div class="action">
                                <input type="submit" name="Submit43" value=" 选 购 "  onclick="window.location.href='../order/car_list.jsp'"/>&nbsp;&nbsp;
                                <input type="submit" name="Submit233" value=" 收 藏 " />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--空23px--->
        <div class="blank23"></div>
        <%@ include file="../help.jsp" %>
        <!--间隔-->
        <%@ include file="../foot.jsp" %>
    </body>
</html>
