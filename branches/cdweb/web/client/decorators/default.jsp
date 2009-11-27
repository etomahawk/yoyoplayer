<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>厦门建发纸业有限公司-<decorator:title/></title>
        <link href="<s:url value="/client/css/index.css"/>" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <%@ include file="../top_nologin.jsp" %>
        <decorator:body/>
        <%@ include file="../foot.jsp" %>
    </body>
</html>


