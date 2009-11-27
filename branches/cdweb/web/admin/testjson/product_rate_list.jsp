<%@ page contentType="text/html;charset=utf-8"%>
<%
    request.setCharacterEncoding("UTF-8");

    String catId = request.getParameter("catId");
    System.out.println("list: product category id is: " + catId);

    String json = "";

    if(catId == null || "0".equals(catId) || Integer.parseInt(catId) == -1){

        json += "{list:[";
        json += "{id:1,fullName:'双面铜版纸',code:'Z1401',gtinNumber:'0000',supplierCode:'111',rate:100},{id:2,fullName:'双胶纸','code':'Z1402',gtinNumber:'0000',supplierCode:'111',rate:100},{id:3,fullName:'灰底白板纸','code':'Z1410',gtinNumber:'0000',supplierCode:'111',rate:100}";
        json += ",{id:4,fullName:'轻型纸',code:'Z1501',gtinNumber:'0000',supplierCode:'111',rate:100},{id:5,fullName:'静电复印纸','code':'Z1502',gtinNumber:'0000',supplierCode:'111',rate:100}";
        json += ",{id:6,fullName:'白面牛卡',code:'Z1511',gtinNumber:'0000',supplierCode:'111',rate:100},{id:7,fullName:'瓦楞纸',code:'Z1522',gtinNumber:'0000',supplierCode:'111',rate:100}";
        json += ",{id:8,fullName:'画刊纸',code:'Z1611',gtinNumber:'0000',supplierCode:'111',rate:100},{id:9,fullName:'打字纸',code:'Z1622',gtinNumber:'0000',supplierCode:'111',rate:100},{id:10,fullName:'草纸',code:'Z1633',gtinNumber:'0000',supplierCode:'111',rate:100}";
        json += "],totalSize:50,success:true}";
    }else if ("11".equals(catId)) {
        json += "{list:[{id:1,fullName:'双面铜版纸',code:'Z1401',gtinNumber:'0000',supplierCode:'111',rate:100},{id:2,fullName:'双胶纸','code':'Z1402',gtinNumber:'0000',supplierCode:'111',rate:100},{id:3,fullName:'灰底白板纸','code':'Z1410',gtinNumber:'0000',supplierCode:'111',rate:100}],totalSize:3,success:true}";
    } else if ("22".equals(catId)) {
        json += "{list:[{id:4,fullName:'轻型纸',code:'Z1501',gtinNumber:'0000',supplierCode:'111',rate:100},{id:5,fullName:'静电复印纸','code':'Z1502',gtinNumber:'0000',supplierCode:'111',rate:100}],totalSize:2,success:true}";
    } else if ("111".equals(catId)) {
        json += "{list:[{id:6,fullName:'白面牛卡',code:'Z1511',gtinNumber:'0000',supplierCode:'111',rate:100},{id:7,fullName:'瓦楞纸',code:'Z1522',gtinNumber:'0000',supplierCode:'111',rate:100}],totalSize:2,success:true}";
    } else if ("221".equals(catId)) {
        json += "{list:[{id:8,fullName:'画刊纸',code:'Z1611',gtinNumber:'0000',supplierCode:'111',rate:100},{id:9,fullName:'打字纸',code:'Z1622',gtinNumber:'0000',supplierCode:'111',rate:100},{id:10,fullName:'草纸',code:'Z1633',gtinNumber:'0000',supplierCode:'111',rate:100}],totalSize:3,success:true}";
    }

    System.out.println("json string here: " + json);
    response.setContentType("text/json;charset=UTF-8");
    response.getWriter().print(json);
%>
