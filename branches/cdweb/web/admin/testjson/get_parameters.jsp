<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="java.util.*"  %>
<%
    request.setCharacterEncoding("UTF-8");

    Map map = request.getParameterMap();
    for(Iterator iter = map.entrySet().iterator();iter.hasNext();){
        Map.Entry element = (Map.Entry)iter.next();
        Object strKey = element.getKey();
        String[] value=(String[])element.getValue();

        System.out.print(strKey.toString() +"=");
        for(int i=0;i <value.length;i++){
            System.out.print(value[i]+",");
        }
        System.out.println();
    }
    response.setContentType("text/json;charset=UTF-8");
    response.getWriter().print("{success:true}");
%>
