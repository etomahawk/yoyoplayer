<%-- 
    Document   : message-block
    Created on : 2009-11-19, 10:27:47
    Author     : Hadeslee
--%>
<%@ tag language="java" body-content="empty" %>
<%@ tag import="com.opensymphony.xwork2.*" %>
<%@ tag import="com.chinacnd.framework.struts.BaseAction" %>
<%@ tag import="com.chinacnd.framework.util.StringUtils" %>
<%@ tag import="java.util.*" %>
<div id="message-area">
    <ul class="message_block">
        <%
            ActionContext context = ActionContext.getContext();
            System.out.println("context="+context);
            if(context == null){
                return ;
                }
            ActionInvocation invocation = context.getActionInvocation();
            if(invocation == null){
                return;
            }
            BaseAction action = (BaseAction) context.getActionInvocation().getAction();
            if(action == null){
                return ;
            }
            Collection<String> actionErrors = action.getActionErrors();
            if (actionErrors != null && !actionErrors.isEmpty()) {
                for (String error : actionErrors) {%>
        <li class="error_message"><%=error%></li>
        <%}
            }%>
        <%
            Map<String, List<String>> fieldErrors = action.getFieldErrors();
            if (fieldErrors != null && !fieldErrors.isEmpty()) {
        %>
        <%
                for (Map.Entry<String, List<String>> entry : fieldErrors.entrySet()) {
        %>
        <li class="error_message"><%=entry.getKey()%>|<%= entry.getValue()%></li>
        <%
                }
            }
        %>
    </ul>
</div>
