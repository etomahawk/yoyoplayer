<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>建发纸业网上营销系统</title>
        <link rel="stylesheet" type="text/css" href="<s:url value="/abcommon/resources/css/ext-all.css"/>" />
        <script type="text/javascript" src="<s:url value="/abcommon/js/ext-base.js" />"></script>
        <script type="text/javascript" src="<s:url value="/abcommon/js/ext-all.js" />"></script>
        <script language="javascript">
            Ext.onReady(function(){
                Ext.QuickTips.init();   //初始化一个全局悬停提示控件

                //登录表单
                var frmLogin = new Ext.FormPanel({
                    labelWidth: 70,
                    url: 'login',   //  /admin/login/  对应到LoginAction
                    //url: 'testjson/login_admin.json',
                    frame: true,
                    bodyStyle: 'padding:5px 5px 0',
                    defaultType: 'textfield',
                    items: [{
                            fieldLabel: '登录用户',
                            name: 'username',
                            allowBlank : false,
                            blankText: '登录用户不能为空.',
                            anchor: '98%',
                            value: 'admin'
                        }, {
                            inputType:'password',
                            fieldLabel: '登录密码',
                            allowBlank : false,
                            blankText : '登录密码不能为空.',
                            name: 'password',
                            anchor: '98%',
                            value: 'admin'
                        }],
                    buttons: [{
                            text: '确认',
                            handler: function(){
                                if (frmLogin.getForm().isValid()) {
                                    frmLogin.getForm().submit({
                                        waitTitle: '请稍候',
                                        waitMsg: '正在提交数据,请稍候...',
                                        success : function(form, action) {
                                            window.location.replace('admin.jsp');
                                        },
                                        failure : function(form, action) {
                                            Ext.Msg.alert('登陆失败', action.result.message);
                                        }
                                    });
                                }
                            }
                        },{
                            text: '关闭',
                            handler: function(){
                               window.close();
                            }
                        }]
                });

                //登录窗口
                var winLogin = new Ext.Window({
			title: '用户登录',
			width: 300,
			height: 440,
			resizable: false,
			autoHeight: true,
			modal: true,
			closeAction: 'hide',
			items: [ frmLogin ],
			html: '<br/><p align="center"><font color="red">忘记您的密码？</font></p><br/>'
		});
		winLogin.show();
            });
        </script>
    </head>
    <body style="background-image:url(<s:url value="/abcommon/images/background.gif" />);background-repeat:repeat;background-position:center;">
        <p>&nbsp;</p>
    </body>
</html>