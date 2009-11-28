/**
 * 商品基本属性/扩展属性 修改窗口
 *
 * @author shiyan.wu
 *
 *
 */
function ProductAttrWin(productId){

    this.productId = productId;
    
    //底部工具条按钮定义
    var btnOk = new Ext.Button({
        text: '保存当前属性页',
        iconCls: 'confirm',
        handler: (function() {
            var curTab = tabpnl.getActiveTab();
            if(curTab.getId() == '_product_core_attr_tab'){  //保存基本属性
                this.saveCoreAttr();
            }
        }).createDelegate(this)
    });
    var btnClose = new Ext.Button({
        text: '关闭',
        iconCls: 'close',
        handler: function() {
            //todo
        }
    });

    //商品图片上传表单
    this.frmUpload = new Ext.FormPanel({
        id: '_product_photo_upload_form',
        region: 'south',
        fileUpload: true,
        items: [{
            xtype: 'textfield',
            name: "photo",
	    fieldLabel: "产品图片",
            inputType: "file",
            blankText:"请选择图片."
        }],
        buttons: [{
            text: '上传',
            handler: function() {
                /*
                form.getForm().submit({
                    success: function(form, action){
                        Ext.Msg.alert('信息', action.result.msg);
                    },
                    failure: function(){
                        Ext.Msg.alert('错误', '失败');
                    }
                });*/
            }
        }]
    });

    //商品基本属性修改表单
    this.frmCoreAttr = new Ext.FormPanel({
        id: '_product_core_attr_form',
        region: 'center',
        defaultType: 'textfield',
        items: []
    });

    //基本属性标签页
    this.pnlCoreAttr = new Ext.Panel({
        id: '_product_core_attr_tab',
        title: '基本属性',
        layout: 'border',
        defaults: {
            labelWidth: 80,
            labelAlign: "right",
            bodyStyle: 'padding:5px 5px 5px 0'
        },
        items: [this.frmCoreAttr, this.frmUpload]
    });

    var tabpnl = new Ext.TabPanel({
        height: 400,
        border: true,
        layoutOnTabChange: true,   //重要
        bbar: ['->', btnOk, '-', btnClose],
        items: [this.pnlCoreAttr,{
                id: '_product_extend_attr_tab',
                title: '扩展属性',
                xtype: 'form',
                defaults: {
                    anchor: '98%',
                    labelWidth: 80,
                    labelAlign: "right",
                    bodyStyle: 'padding:5px 5px 5px 0'
                },
                defaultType: 'textfield',
                items: [{  //必须有元素，否则切换回其他标签页会错误
                    name: "fuckext",
                    xtype: 'label'
                }]
        }]

    });
    tabpnl.activate(0);
    tabpnl.on("beforetabchange", (function(tbp, newTab, currentTab){
        if(newTab.getId() == '_extend_tab' && !this.blExtendTabReady){
            this.initExtendTab(newTab);
        }
    }).createDelegate(this));

    //弹出窗口
    this.win = new Ext.Window({
        title: '编辑商品属性',
        width: 350,    //如果不在Window设置高度，IE会撑开，非常郁闷啊
        autoHeight: true,
        resizable: false,
        modal: true,
        closeAction: 'close',
        items: [tabpnl],
        layout: 'fit'
    });
}
ProductAttrWin.prototype = {

    //显示窗口
    show: function(){
       this.initCoreTab(this.frmCoreAttr);
    },

    /**
     * 初始化基本属性标签页
     *
     */
    initCoreTab: function(frm){
       Ext.Ajax.request({
           url: 'product/product-list-base-attributes',
           method: 'GET',
           params: 'id='+this.productId,
           success: function(resp){
               var objResp = Ext.util.JSON.decode(resp.responseText);
               if(!objResp)
                   return;
               
               this.win.show();

               if(typeof objResp == 'object'){

                   this.action_save_core_attr = 'product/'+objResp.actionName;  //保存基本属性的URL
                   
                   var _fields = objResp.fields;   //基本属性表单元素数组
                   for(var ia=0; ia<_fields.length; ia++){
                       var kk = _fields[ia];
                       if(typeof kk == 'object'){
                           frm.add({
                              xtype: kk['xtype'],
                              name: kk['fieldName'],
	                      fieldLabel: kk['fieldLabel'],
                              value: kk['value'],
                              disabled: kk['disabled'],
                              anchor: '98%'
                           });
                       }
                   }
                   if(objResp.actionName.indexOf('paper')>0){  //根据保存的是纸张或纸浆来设置ID隐藏域
                       frm.add({
                            xtype: 'hidden',
                            name: 'paper.id',
                            value: this.productId
                       });
                   }else{
                       frm.add({
                            xtype: 'hidden',
                            name: 'pulp.id',
                            value: this.productId
                       });
                   }
                   frm.doLayout();
               }
           },
           scope: this
        });
    },

    /**
     * 初始化扩展属性标签页
     * 动态添加表单元素
     *
     */
    initExtendTab: function(frm){
        Ext.Ajax.request({
           url: 'testjson/product_extend_attribute.json',
           method: 'GET',
           params: 'id='+this.productId,
           success: function(resp){
               var objResp = Ext.util.JSON.decode(resp.responseText);
               if(!objResp)
                   return;

               //this.reset();    //重置所有表单元素
               
               if(typeof objResp == 'object' && objResp.indexOf != undefined){
                   for(var ia=0; ia<objResp.length; ia++){
                       var kk = objResp[ia];
                       if(typeof kk == 'object'){
                           frm.add({
                              name: "extendValueList["+ia+"]",
	                      fieldLabel: kk['name'],
                              value: kk['value']
                           });
                       }
                   }
                   frm.doLayout();   //动态添加元素后如果没有重新布局，不会显示
                   this.blExtendTabReady = true;
               }
           },
           scope: this
        });
    },

    saveCoreAttr: function(){
        this.frmCoreAttr.getForm().submit({
            url: this.action_save_core_attr,
            waitTitle: '请稍候',
            waitMsg: '正在提交数据,请稍候...',
            success: function(form, action){
                Ext.Msg.show({
                    title: '系统消息',
                    msg: '保存成功!',
                    buttons: {ok:'返回'}
                });
            },
            failure: function(form, action){
                if(!action.result.timeout){  //SESSION超时 留给全局监听器处理
                    Ext.Msg.show({
                        title: '系统消息',
                        msg: '保存失败! '+ (action.result.message || ''),
                        buttons: Ext.Msg.OK,
                        icon : Ext.Msg.ERROR
                    });
                }
            }
        });
    },

    reset: function(){
        //TODO
    }
}

