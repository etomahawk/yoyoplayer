<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page import="com.chinacnd.framework.struts.*" %>
<%@page import="com.chinacnd.b2b.paper.entities.user.AdminUser" %>
<%
           AdminUser adminUser = SessionContext.getSessionContext().getAdminUser();
           if (adminUser == null) {
               response.sendRedirect("index.jsp");
               return;
           }else{
               pageContext.setAttribute("adminUserName", adminUser.getFullname());
           }
%>
<html>
    <head>
        <title>建发纸业网上营销系统</title>
        <link rel="stylesheet" type="text/css" href="<s:url value="/abcommon/resources/css/ext-all.css"/>" />
        <link rel="stylesheet" type="text/css" href="<s:url value="/abcommon/css/portal.css" />" />
        <link rel="stylesheet" type="text/css" href="<s:url value="/abcommon/css/toolbar.css" />" />

        <script type="text/javascript" src="<s:url value="/abcommon/js/ext-base.js" />"></script>
        <script type="text/javascript" src="<s:url value="/abcommon/js/ext-all.js" />"></script>
        <script type="text/javascript" src="<s:url value="/abcommon/js/common.js" />"></script>
        <script type="text/javascript" src="<s:url value="/abcommon/js/attr-other-itemselector.js" />"></script>
        <script type="text/javascript" src="<s:url value="/abcommon/js/product-attr-win.js" />"></script>
        <script type="text/javascript" src="<s:url value="/abcommon/js/form-widges.js" />"></script>
        <script type="text/javascript" src="<s:url value="/abcommon/js/simple-grid.js" />"></script>
        <script type="text/javascript" src="<s:url value="/abcommon/js/validation.js" />"></script>
        <%--<script type="text/javascript" src="Portal.js"></script>
        <script type="text/javascript" src="PortalColumn.js"></script>
        <script type="text/javascript" src="Portlet.js"></script>--%>
        <script type="text/javascript">
            Ext.BLANK_IMAGE_URL = "<s:url value='/abcommon/resources/images/default/s.gif' />";
            var Constants = {
                adminUserName: "${pageScope.adminUserName}",   //登陆的管理员名称
                psize: 20,

                //属性类型
                ValueType: [
                    ['NUMBER', '数字'],
                    ['STRING', '字符'],
                    ['DATE', '日期']
                ],
                getValueByKey: function(k, arr){
                    for(var i=0;i<arr.length;i++){
                        if(arr[i][0] == k)
                            return arr[i][1];
                    }
                    return '';
                },

                //基本属性分类
                CoreAttrType: [
                    ['', '全部属性'],
                    ['COMMON', '公共属性'],
                    ['PAPER', '纸张属性'],
                    ['PULP', '纸浆属性']
                ],

                Enabled: [
                    [true, '启用'],
                    [false, '禁用']
                ],

                //企业类型
                EnterpriseType : [
                    ["BRANCH", "分公司"],
                    ["CLIENT", "会员"],
                    ["STOREHOUSE", "仓库"],
                    ["LOGISTICS", "物流"],
                    ["BANK", "银行"],
                    ["OTHER", "其他"]
                ],

                /**
                 * 企业性质
                 */
                EnterpriseKind : [
                    ["DEALER", "经销商"],
                    ["PRINTING", "印刷厂"],
                    ["OTHER", "其它"]
                ]
            };

            function resetForm(form, arr) {
                for(var i = 0; i < arr.length; i++) {
                    form.findField(arr[i]).reset();
                }
            }
            
        </script>
        <script type="text/javascript" src="homepage.js"></script>
        <%--<link rel="stylesheet" type="text/css" href="<s:url value="/abcommon/js/Ext.ux.UploadDialog/UploadDialog/css/Ext.ux.UploadDialog.css" />" />

        <script type="text/javascript" src="<s:url value="/abcommon/js/Ext.ux.UploadDialog/Ext.ux.UploadDialog.packed.js" />"></script>--%>
    </head>
    <body>
        <div id="ext-modal-dialog-win" class="x-hidden">
        </div>
    </body>
</html>