<%@ page contentType="text/html;charset=utf-8"%>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    // 获得node参数，对应的是正在展开的节点id，Ext自动生成的参数
    //String node = request.getParameter("node");
    String parentId = request.getParameter("parentId");
    System.out.println("tree: parent product category id is: " + parentId);
    
    String json = "";
    if ("-1".equals(parentId)) {
        json += "[{id:1,text:'纸张',cls:'folder'},{id:2,text:'纸浆',cls:'folder'}]";
    } else if ("1".equals(parentId)) {
        json += "[{id:11,text:'工业用纸',cls:'folder',leaf:false},{id:12,text:'生活用纸',leaf:true},{id:13,text:'打印和书写纸',leaf:true}]";
    } else if ("2".equals(parentId)) {
        json += "[{id:21,text:'漂白针叶浆',leaf:true},{id:22,text:'漂白阔叶浆',cls:'folder',leaf:false}]";
    } else if ("11".equals(parentId)) {
        json += "[{id:111,text:'白卡纸',leaf:true},{id:112,text:'铜板纸',leaf:true}]";
    } else if ("22".equals(parentId)) {
        json += "[{id:221,text:'布阔',leaf:true},{id:222,text:'虎牌',leaf:true},{id:223,text:'乔治王子',leaf:true}]";
    }

    response.getWriter().print(json);
%>
