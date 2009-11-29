/**
 * 表单相关的常用控件
 *
 * @author shiyan.wu
 *
 */

Ext.namespace("CdForm");


/**
 * 创建一个下拉框控件的config
 *
 * @param options
 *     id            下拉框实际的input文本框的dom id
 *     hiddenName:   required  创建的<input type='hidden' ...>的name
 *     fieldLabel:   标签
 *     width:        宽度
 *     data:         required  下拉框数据 二维数组
 *
 */
CdForm.createCombo = function(options){
    var hiddenName = options['hiddenName']

    return {
        id: options['id'] || 'x_'+hiddenName,
        xtype: "combo",
        fieldLabel: options['fieldLabel'],
        hiddenName: hiddenName,
        width: options['width'] || 150,
        store: new Ext.data.SimpleStore({
             fields: ['value', 'title'],
             data: options['data']
        }),
        valueField: 'value',
        displayField: 'title',
        triggerAction: 'all',
        editable: false,
        allowBlank: false,
        mode: 'local',
        disabled: options['disabled'] || false
    }
}

/**
 * 新增 表单窗口
 * 表单元素单列
 *
 * @param options Array
 *     title:        窗口标题
 *     width:        窗口宽度
 *     height:       窗口高度
 *     url:          表单HTTP请求路径
 *     items:        表单元素数组
 *     btnOkText:    '添加'按钮上的文本
 *     successFn:    请求成功回调函数
 *     scope:        回调函数作用域
 *
 *
 * @see
 *     默认在当前功能页面关闭窗口时用'close'
 */
CdForm.AddForm = function(options){
    if(!options)
        options = [];

    var successFn = options.successFn;
    
    //新增XX 表单
    this.frm = new Ext.FormPanel({
        labelWidth: 80,
        labelAlign: 'right',
        url: options['url'] || 'testjson/get_parameters.jsp',
        bodyStyle: 'padding:5px 5px 0',
        defaultType: 'textfield',
        frame: true,
        items: options['items'] || ['items is empty!'],
        buttonAlign: 'right',
        minButtonWidth: 60,
        buttons: [{
            text: options.btnOkText || '添加',
            handler: (function(){

                var othis = this;   //创建闭包

                var basicFrm = this.frm.getForm();  //得到BasicForm对象
                if (basicFrm.isValid()){
                    basicFrm.submit({
                        waitTitle: '请稍候',
                        waitMsg: '正在提交数据,请稍候...',
                        success: function(form, action){
                            Ext.Msg.show({
                                title: '系统消息',
                                msg: '操作成功!',
                                buttons: {ok:'返回'},
                                fn: successFn || false,
                                scope: options.scope || othis
                            });
                            
                            othis.close();
                        },
                        failure: function(form, action){
                            if(!action.result.timeout){  //SESSION超时 留给全局监听器处理
                                Ext.Msg.show({
                                    title: '系统消息',
                                    msg: '操作失败! '+ (action.result.message || ''),
                                    buttons: Ext.Msg.OK,
                                    icon : Ext.Msg.ERROR
                                });
                            }
                        }
                    });
                }
                }).createDelegate(this)   //把添加事件的响应函数作用域设置为this
            },{
                text: '取消',
                handler: (function() {
                    this.close();
                }).createDelegate(this)   //把取消事件的响应函数作用域设置为this
            }]
    });

    //弹出窗口
    this.win = new Ext.Window({
        title: options['title'] || '',
        width: options['width'] || 300,
        height: options['height'] || 100,
        resizable: false,
        autoHeight: true,
        modal: true,
        closeAction: 'close',
        items: [this.frm]
    });
}
CdForm.AddForm.prototype = {
    show: function(){
        this.win.show();
        this.win.center();
    },
    //隐藏窗口
    hide: function(){
        this.win.hide();
    },
    //销毁窗口并从DOM移除
    close: function(){
        this.win.close();
    },
    reset: function(){
        this.frm.getForm().reset();
    },
    setValue: function(id, value){
        this.frm.findById(id).setValue(value);
    },
    setValueByName: function(name, value){
        
        var field = this.frm.find("name", name);
        
        if(field){
            if(field.length == 1){
                field[0].setValue(value);
            }else{
                //TODO 处理多选表单元素
            }
        }
    }
}


/**
 * 编辑 表单窗口
 * 表单元素单列
 *
 * 继承CdForm.AddForm
 *
 * @param options Array
 *      见CdForm.AddForm的构造函数说明
 *      entityId:    实体ID
 *      getUrl:      查询实体详细信息的url
 *
 * @see 表单元素默认按 json的key -> component的name 自动填充
 *
 */
CdForm.EditForm = function(options){
    
    this.entityId = options.entityId;
    this.getUrl = options.getUrl;

    //调用父类构造函数
    CdForm.EditForm.superclass.constructor.call(this, options);
    
};
Ext.extend(CdForm.EditForm, CdForm.AddForm, {

    /**
     * 显示窗体
     *
     * @Overwrite
     *
     * @param otherFn    自定义回调函数，在自动填充表单时调用
     */
    show: function(otherFn){
        Ext.Ajax.request({
           url: this.getUrl || 'testjson/product_catalog.json',
           method: 'GET',
           params: 'id='+this.entityId,
           success: function(resp){
               var respText = Ext.util.JSON.decode(resp.responseText);
               if(!respText)
                   return;
               
               this.win.show();
               this.win.center();

               if(typeof respText == 'object'){  //自动填充表单元素
                   for(var kk in respText){
                       this.setValueByName(kk, respText[kk]);
                       if(otherFn)
                           otherFn.call(this, kk, respText[kk]);
                   }
               }
           },
           scope: this
        });
    }
});

/**
 * 删除一条或多条记录
 *
 * @param sels         删除记录的选择模型
 * @param successFn    删除成功的回调函数
 */
CdForm.Del = function(sels, successFn, url){
    if(sels.length==0){
        Ext.Msg.alert('系统消息', '请选择需要删除的记录!');
        return;
    }
    var strIds = '';
    for(var i=0;i<sels.length;i++){
        if(i>0)
            strIds += ',';
        strIds += sels[i].get('id');
    }

    Ext.Msg.show({
        title: '系统提示',
        msg: '确定删除记录？',
        buttons: {yes:'确定', no:'取消'},
        fn: function(btnId){
            if(btnId == 'yes'){
                Ext.Ajax.request({
                    url: url,
                    method: 'GET',
                    params: 'deleteIds='+strIds,
                    success: function(resp){
                        var respText = Ext.util.JSON.decode(resp.responseText);
                        if(!respText)
                            return;
                        if(respText.success === true){
                            Ext.Msg.show({
                                title: '系统消息',
                                msg: '删除成功!',
                                buttons: {
                                    ok:'返回'
                                },
                                fn: successFn || false
                            });
                        }else{
                            Ext.Msg.show({
                                title: '系统消息',
                                msg: '删除失败! '+ (respText.message || ''),
                                buttons: {
                                    ok:'返回'
                                },
                                icon : Ext.Msg.ERROR
                            });
                        }
                    }
                });
            }
        },
        icon: Ext.MessageBox.QUESTION
    });
    
};

/**
 * 商品分类树
 * 异步加载
 *
 * @param options  Array
 *    region:   布局区域(目前只支持BorderLayout)
 *    width:    面板宽度
 *    minSize:  当树处于布局中时，允许的最小拖动高度或宽度
 *    maxSize:  当树处于布局中时，允许的最大拖动高度或宽度
 *    title:    面板标题
 *
 * @param blSingle boolean 是否不处于布局中
 */
CdForm.ProductCatTree = function(options, blSingle){
    if(!options)
        options = [];

    this.tree = new Ext.tree.TreePanel({
        width: options['width'] || 225,
        height: options['height'] || false,
        region:	blSingle?false:(options['region'] || 'west'),
        minSize: blSingle?false:(options['minSize'] || 175),
        maxSize: blSingle?false:(options['maxSize'] || 400),
        title: options['title'] || '',
        split: true,
        autoScroll: true,
        
        rootVisible: true,
        lines: false,
        singleExpand: true,
        useArrows: true,

        loader: new Ext.tree.TreeLoader({
            dataUrl: 'product/category-load'
            //dataUrl: 'testjson/product_catalog_tree.jsp'
        }),

        root: new Ext.tree.AsyncTreeNode({
            text: '商品分类',
            draggable: false,
            id: '-1'
        })
    });

    this.tree.on('beforeload', function(node){
        var url = 'product/category-load?parentId='+node.id;
        //var url = 'testjson/product_catalog_tree.jsp?parentId='+node.id;
        this.loader.dataUrl = url;
    });
}

CdForm.ProductCatTree.prototype = {
    on: function(eventName, fn){
        this.tree.on(eventName, fn);
    },

    /**
     * 增加一个子结点
     *
     * @param parentId  父结点ID
     * @param id        添加结点ID
     * @param text      添加结点TEXT
     */
    addNode: function(parentId, id, text){
        var pp = this.tree.getNodeById(parentId);
        if(pp){
            pp.appendChild(new Ext.tree.TreeNode({id: id, text: text}))
        }
    },

    /**
     * 重新加载
     *
     * @path  需要展开的结点
     * @fn    回调函数
     */
    reload: function(path, fn){
        this.tree.root.reload();  //根结点重新加载
        if(path){
            //展开父结点
            this.tree.expandPath(path, 'id', function(){
                if(fn)
                    fn.call();
            }); 
        }
    }
}


/**
 * 商品分类树的选择窗口
 *
 */
CdForm.ProductCatTreeSelector = function(){

    this.tree = new CdForm.ProductCatTree({height: 300}, true).tree;
    this.tree.on('click', (function(tnode){
        this.selN = tnode;  //设置当前选中的商品分类
    }).createDelegate(this));
    
    this.win = new Ext.Window({
        title: '选择商品分类',
        autoWidth: true,
        autoHeight: true,
        resizable: false,
        modal: true,
        items: [this.tree],
        buttons:[{
            text: '保存',
            handler: (function(){
                if(!this.selN)
                    return;
                
                if(this.selN.getDepth()>1){  //根结点和第一级结点不能作为商品分类
                    Ext.Msg.show({
                        title: '系统提示',
                        msg: '确定要将商品分类修改为：'+this.selN.text+'？',
                        buttons: {yes:'确定', no:'取消'},
                        fn: function(btnId){
                            if(btnId == 'yes'){
                                Ext.Ajax.request({
                                    url: 'product/product-change-category',
                                    method: 'GET',
                                    params: 'id='+this.productId+'&categoryId='+this.selN.id,
                                    success: function(resp){
                                        var respText = Ext.util.JSON.decode(resp.responseText);
                                        if(!respText)
                                            return;
                                        if(respText.success === true){
                                            Ext.Msg.show({
                                                title: '系统消息',
                                                msg: '修改成功!',
                                                buttons: {ok:'返回'},
                                                fn: this.successFn || false
                                            });

                                            this.close();   //保存成功后销毁这个窗体
                                        }else{
                                            Ext.Msg.show({
                                                title: '系统消息',
                                                msg: '修改失败! '+ (respText.message || ''),
                                                buttons: {ok:'返回'},
                                                icon : Ext.Msg.ERROR
                                            });
                                        }
                                    },
                                    scope: this
                                });
                            }
                        },
                        scope: this,
                        icon: Ext.MessageBox.QUESTION
                    });
                }
            }).createDelegate(this)
        },{
            text: '关闭',
            handler: (function() {
                this.close();
            }).createDelegate(this)
        }]
    });
}

CdForm.ProductCatTreeSelector.prototype = {

    close: function(){
        this.win.close();
    },

    /**
     * 显示窗口
     *
     * @param expandPath  初始化展开的结点
     * @param productId   需要修改所属类别的商品ID
     * @param successFn   修改成功后的回调函数
     */
    show: function(expandPath, productId, successFn){
        
        if(!expandPath || expandPath.trim() == '')
            return;
        if(!productId)
            return;
        this.productId = productId;
        this.successFn = successFn;
        this.originalCategoryPath = '/-1/' + expandPath;  //当前所属的商品分类的xpath
        
        var indexN = expandPath.indexOf('/');
        var idTypeN = null;     //当前商品类型的结点（纸张/纸浆）的ID
        if(indexN <= 0){
            idTypeN = expandPath;
        }else{
            idTypeN = expandPath.substring(0, indexN);
        }
        
        this.win.show(false, function(){
            var othis = this;  //创建一个闭包

            this.tree.expandPath(this.originalCategoryPath, 'id', function(bSuccess, oLastNode){
                if(bSuccess){
                    oLastNode.getUI().addClass('tree-node-highlight');
                    oLastNode.select();  //高亮选中当前类别

                    var typeN = othis.tree.getNodeById(idTypeN);  //当前商品类型的结点（纸张/纸浆）
                    var otherTypeN = typeN.nextSibling || typeN.previousSibling;
                    
                    if(otherTypeN){  //隐藏互斥的商品类型的结点
                        otherTypeN.getUI().hide();
                    }
                }
            });
        }, this);
    }
}
