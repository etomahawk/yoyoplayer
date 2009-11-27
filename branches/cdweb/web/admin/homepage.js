/**
 * 登陆总公司平台后的页面框架
 *
 * 
 */
Ext.onReady(function(){
    
    Ext.QuickTips.init();   //初始化一个全局悬停提示控件
    

    //设置全局监听器处理SESSION过期
    Ext.util.Observable.observeClass(Ext.data.Connection);
    Ext.data.Connection.on('requestcomplete', function(conn, resp, options){
        var headers = resp.getAllResponseHeaders();
        if(headers && (headers.indexOf('Content-Type: application/json') >= 0 || headers.indexOf('Content-Type: text/json') >= 0)){
            var respText = Ext.util.JSON.decode(resp.responseText);
            if (respText && respText['timeout'] === true) {
                window.location.href = 'index.jsp';   //session过期重定向到登陆页面
            }
        }
    });


    //-------------------------系统菜单定义------------------------------
    var product_menu = new Ext.tree.TreePanel({
        id: 'product-menu',
        title: '商品管理',
        split: false,
        autoScroll: true,
        rootVisible: false,
        lines: false,
        singleExpand: true,
        useArrows: true,
        loader: new Ext.tree.TreeLoader({
            dataUrl:'leftmenu/product.json'
        }),
        root: new Ext.tree.AsyncTreeNode()
    });
    product_menu.on('click', function(n){
        var sn = this.selModel.selNode || {};
        if(n.leaf){
            Ext.getCmp('content-panel').load({
                url: "product/" + n.id + ".jsp",
                callback: function(){
                    Ext.getCmp('content-panel').setTitle(n.text);
                },
                scripts:true
            });
        }
    });

    var enterprise_menu = new Ext.tree.TreePanel({
        id: 'enterprise_menu',
        title: '企业管理',
        split: false,
        autoScroll: true,
        rootVisible: false,
        lines: false,
        singleExpand: true,
        useArrows: true,
        loader: new Ext.tree.TreeLoader({
            dataUrl:'leftmenu/enterprise.json'
        }),
        root: new Ext.tree.AsyncTreeNode()
    });
    enterprise_menu.on('click', function(n){
        var sn = this.selModel.selNode || {};
        if(n.leaf){
            Ext.getCmp('content-panel').load({
                url: "enterprise/" + n.id + ".jsp",
                callback: function(){
                    Ext.getCmp('content-panel').setTitle(n.text);
                },
                scripts:true
            });
        }
    });

    //-------------------------------------------------------------------

    //注销按钮
    var btnLogout = new Ext.Button({
        text: '注销',
        iconCls: 'logout',
        handler: function() {
            Ext.Ajax.request({
                url: 'logout',
                method: 'GET',
                success: function(resp){
                    Ext.Msg.show({
                        title: '系统消息',
                        msg: '注销成功!',
                        buttons: {ok:'确定'},
                        fn: function(){
                            window.location.replace('./');
                        }
                    });
                }
            });
        }
    });

    //顶部LOGO
    var pnlLogo = {
        region: 'center',
        collapsible: false,
        split: true,
        layout: 'fit',
        margins: '0 1 0 0',
        border: false,
        tbar: [
           '  ',
           '<font size=2><b> 建发纸业网上销售系统 - 总部 </b></font>',
           '->',
           ' 欢迎',
           ' ',
           '<b>'+Constants.adminUserName+'</b>',
           ' ',
           ' ',
           ' ',
           ' ',
           '->',
           btnLogout
        ]
     };

     //中间的工作台，以后可能会放Portlet
     var contentPanel = {
        id: 'content-panel',
        title: '工作台',
        region: 'center',
        layout: 'card',
        xtype: 'panel',
        margins:'0 5 5 0',
        activeItem: 0,
        border: false
        //items: [desktop],
     };

     //页面框架
     var viewport = new Ext.Viewport({
        layout: 'border',
        items:[{
            region:'north',
            id:'north-panel',
            split:true,
            height: 25,
            minSize: 25,
            maxSize: 25,
            collapsible: true,
            margins: '0 5 0 5',
            cmargins: '0 5 0 5',
            layout: 'fit',
            layoutConfig:{
                animate:true
            },
            items: [pnlLogo]
        },{
            region: 'west',
            id: 'west-panel',
            title: '功能导航',
            split: true,
            width: 150,
            minSize: 125,
            maxSize: 400,
            collapsible: true,
            margins: '0 0 5 5',
            cmargins: '0 5 5 5',
            layout: 'accordion',
            layoutConfig:{
                animate:true
            },
            items: [product_menu,enterprise_menu]
        },
        contentPanel
       ]
    });
});