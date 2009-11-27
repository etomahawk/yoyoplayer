<%@ page contentType="text/html;charset=utf-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    
    String parentId = request.getParameter("parentId");
    System.out.println("list: parent product category id is: " + parentId);

    String json = "";
    if ("1".equals(parentId)) {
        json += "{list:[{id:11,name:'工业用纸',code:'1401'},{id:12,name:'生活用纸','code':'1402'},{id:13,name:'打印和书写纸','code':'1410'}],totalSize:3,success:true}";
    } else if ("2".equals(parentId)) {
        json += "{list:[{id:21,name:'漂白针叶浆',code:'1501'},{id:22,name:'漂白阔叶浆','code':'1502'}],totalSize:2,success:true}";
    } else if ("11".equals(parentId)) {
        json += "{list:[{id:111,name:'白卡纸',code:'1511'},{id:112,name:'铜板纸',code:'1522'}],totalSize:2,success:true}";
    } else if ("22".equals(parentId)) {
        json += "{list:[{id:221,name:'布阔',code:'1611'},{id:222,name:'虎牌',code:'1622'},{id:223,name:'乔治王子',code:'1633'}],totalSize:3,success:true}";
    } else {
        json = "{list:[],totalSize:0,success:true}";
    }

    response.setContentType("text/json;charset=UTF-8");
    response.getWriter().print(json);
%>
