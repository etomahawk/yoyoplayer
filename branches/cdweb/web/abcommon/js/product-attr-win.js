/**
 * 商品基本属性/扩展属性 修改窗口
 *
 * @author shiyan.wu
 *
 * @param productId  商品ID
 *
 */
function ProductAttrWin(productId){

    this.productId = productId;

    //底部工具条按钮定义
    var btnOk = new Ext.Button({
        text: '保存当前属性页',
        iconCls: 'confirm',
        handler: function() {
            
        }
    });
    var btnClose = new Ext.Button({
        text: '关闭',
        iconCls: 'close',
        handler: function() {
            //todo
        }
    });

    /**
     * 商品基本属性修改表单
     *
     */
    this.frmCoreAttr = new Ext.FormPanel({
        id: '_core_attr_form',
        title: '基本属性',
        fileUpload: true,
        defaults: {
            anchor: '98%'
        },
        defaultType: 'textfield',
        items: [{  //必须有元素，否则切换回其他标签页会错误
            name: "fuckext1",
            xtype: 'label'
        }]
    });

    /**
     * 上传商品图片的表单
     * 
     */
    this.frmUpload = new Ext.FormPanel({
        id: '_upload_form',
        fileUpload: true,
        defaultType: 'textfield',
        items: [{
            xtype: 'textfield',
            fieldLable: '产品图片',
            name: 'photo',
            inputType: 'file',
            anchor: '98%'
        }]
    });

    
    var tabpnl = new Ext.TabPanel({
        height: 400,
        border: true,
        layoutOnTabChange: true,   //重要
        defaults: {
            labelWidth: 80,
            labelAlign: "right",
            bodyStyle: 'padding:5px 5px 5px 0'
        },
        bbar: ['->', btnOk, '-', btnClose],
        items: [{
                
        },{
                id: '_extend_tab',
                title: '扩展属性',
                xtype: 'form',
                defaults: {
                    anchor: '98%'
                },
                defaultType: 'textfield',
                items: [{  //必须有元素，否则切换回其他标签页会错误
                        name: "fuckext2",
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
        width: 650,    //如果不在Window设置高度，IE会撑开，非常郁闷啊
        autoHeight: true,
        resizable: false,
        modal: true,
        closeAction: 'hide',  //避免重复生成窗口对象
        items: [tabpnl],
        layout: 'fit'
    });
}
ProductAttrWin.prototype = {

    //显示窗口
    show: function(){
        Ext.Ajax.request({
           url: 'testjson/product_core_attribute.json',
           method: 'GET',
           params: 'id='+this.productId,
           success: function(resp){
               var objResp = Ext.util.JSON.decode(resp.responseText);
               if(!objResp)
                   return;

               //this.reset();    //重置所有表单元素
               this.win.show();
               
               if(typeof objResp == 'object'){  //自动填充表单元素
                   for(var kk in objResp){
                       this.setValueByName(this.pnlCoreAttr, kk, objResp[kk]);
                   }
               }
           },
           scope: this
        });
    },
    
    /**
     * 自动填充表单
     * 由于属性都是单一值，所以暂时不考虑多选值的表单元素
     * TODO 处理图片显示
     *
     * @param frm
     * @param name
     * @param value
     */
    setValueByName: function(frm, name, value){
        var field = frm.find("name", name);
        if(field){
            if(field.length == 1)
                field[0].setValue(value);
        }
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

    reset: function(){
        //TODO
    }
}

