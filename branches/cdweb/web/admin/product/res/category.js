Ext.onReady(function(){

    var curParentInfo = {};   //当前选中的商品分类树的节点信息

    //----------------------工具栏按钮定义---------------------------
    var btnAddProductCat = new Ext.Button({
        text: '新增',
        iconCls: 'add',
        handler: function() {
            if(!curParentInfo.id){
                Ext.Msg.alert('系统提示', '新增商品分类时请先选择上级类别.');
                return;
            }
            var winAddProductCat = new CdForm.AddForm({
                title: '新增商品分类',
                width: 300,
                //url: 'testjson/get_parameters.jsp',
                url: 'product/category-save',
                items: [{
                   xtype: 'hidden',
	           id: 'add_product_cat_parentId',
                   name: 'parentId',
                   value: -1
                 },{
                   fieldLabel: '编码',
                   name: 'code',
                   allowBlank : false,
                   blankText: '分类编码'+ValidationRule.errorText.empty,
                   vtype: 'code',
                   width: 150
                 },{
                   fieldLabel: '名称',
                   name: 'name',
                   allowBlank: false,
                   blankText: '分类名称'+ValidationRule.errorText.empty,
                   vtype: 'name',
                   width: 150
                 },{
                   id: 'add_product_cat_parentTitle',
                   fieldLabel: '上级分类',
                   value: '',
                   disabled: true,   //disabled==true的元素不会提交
                   width: 150
                 },{
                      xtype: 'textarea',
                      fieldLabel: '备注',
                      name: 'description',
                      height: 60,
                      width: 150
                 }
               ],
              successFn: function(){
                 pnlProductCatTree.reload(curParentInfo.path, function(){
                     gridProductCat.load();
                 });
              }
            });
            winAddProductCat.show();
            winAddProductCat.setValue('add_product_cat_parentId', curParentInfo.id);
            winAddProductCat.setValue('add_product_cat_parentTitle', curParentInfo.name);
        }
    });
    var btnEditProductCat = new Ext.Button({
        text: '修改',
        iconCls: 'edit',
        handler: function(){
            
            var sel = gridProductCat.getSelectionForEdit();
            if(sel === false)
                return;

            var winEditProductCat = new CdForm.EditForm({
                entityId: sel.get('id'),
                title: '编辑商品分类',
                width: 300,
                btnOkText: '确定',
                getUrl: 'product/category-edit',
                //url: 'testjson/get_parameters.jsp',
                url: 'product/category-save',
                items: [{
                   xtype: 'hidden',
                   name: 'id'
                 },{
                   xtype: 'hidden',
                   name: 'parentId'
                 },{
                   fieldLabel: '编码',
                   name: 'code',
                   disabled: true,   //不允许修改商品分类的编码
                   width: 150
                 },{
                   fieldLabel: '名称',
                   name: 'name',
                   allowBlank: false,
                   blankText: '分类名称'+ValidationRule.errorText.empty,
                   vtype: 'name',
                   width: 150
                 },{
                   name: 'parentTitle',
                   fieldLabel: '上级分类',
                   value: curParentInfo.name,
                   disabled: true,
                   width: 150
                },{
                   xtype: 'textarea',
                   fieldLabel: '备注',
                   name: 'description',
                   height: 60,
                   width: 150
                }
              ],
             successFn: function(){
                pnlProductCatTree.reload(curParentInfo.path, function(){
                     gridProductCat.load();
                 });
             }
           });
           winEditProductCat.show();
        }
    });
    var btnDelProductCat = new Ext.Button({
        text: '删除',
        iconCls: 'delete',
        handler: function(){
            var sels = gridProductCat.grid.getSelectionModel().getSelections();
            CdForm.Del(sels, function(){
                pnlProductCatTree.reload(curParentInfo.path, function(){
                     gridProductCat.load();
                 });
            }, 'product/category-delete');
        }
    });
    var btnAttrOther = new Ext.Button({
        text: '扩展属性',
        iconCls: 'columns',
        handler: function() {
            var sel = gridProductCat.getSelectionForEdit();
            if(sel === false)
                return;

            new AttrOtherItemSelector(sel.get('id'), sel.get('name'), function(){
                gridProductCat.load();
            });
        }
    });

    //----------------------------------------------------------

    //--------------------------商品分类列表---------------------

    var sm = new Ext.grid.CheckboxSelectionModel();
    var gridProductCat = new SimpleGrid.Panel({
        region: 'center',
        layout: 'fit',
        height: Ext.get("product-category-panel").getHeight(),
        sm: sm,
        cm: [
            sm,
            {header: '分类编码', dataIndex: 'code', width:120, sortable: true},
            {header: '分类名称', dataIndex: 'name', width:120, sortable: true},
            {header: '扩展属性', dataIndex: 'hasExtendAttributes', width: 80, renderer: function(val){
                 return val == true? '是':'否';
            }}
        ],
        recordFn: [
            {name: 'id', type: 'int'},
            {name: 'code'},
            {name: 'name'},
            {name: 'hasExtendAttributes', type: 'boolean'}
        ],
        //url: 'testjson/product_category_list.jsp',
        url: 'product/category-list',
        tbar: [
            btnAddProductCat, '-', btnEditProductCat, '-', btnDelProductCat,'-',btnAttrOther,
            '->',
            '当前上级类别：', 
            {id: 'lb_product_cat_current_parent', xtype: 'label', text: '未选择'}
        ]
    });

    //---------------------------------------------------------------------

    //-----------------------商品分类树-------------------------------------
    var pnlProductCatTree = new CdForm.ProductCatTree();
    pnlProductCatTree.on('click', function(tnode){

         //点击树节点时默认指定了新增商品分类的所属的上级分类
        if(tnode.id != '-1'){
           curParentInfo.id = tnode.id;
           curParentInfo.name = tnode.text;
           curParentInfo.path = tnode.getPath();
        }

        Ext.getCmp('lb_product_cat_current_parent').setText(curParentInfo.name || '未选择');
        
        gridProductCat.bindBaseParam({parentId: tnode.id});
        gridProductCat.load();
    });

    //--------------------------------------------------------------------

    //-----------------主体面板-------------------------------------------

    var productCatPanel = new Ext.Panel({
        renderTo: 'product-category-panel',
        height: Ext.get("product-category-panel").getHeight(),
        layout: 'border',
        items: [pnlProductCatTree.tree, gridProductCat.grid]
    });
});


