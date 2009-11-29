
Ext.onReady(function(){

    //---------------------------工具栏按钮定义-------------------------

    var btnAddAttrExtend = new Ext.Button({
        text: '新增',
        iconCls: 'add',
        handler: function(){
            var winAddAttrExtend = new CdForm.AddForm({
                title: '新增扩展属性',
                width: 300,
                //url: 'testjson/get_parameters.jsp',
                url: 'product/extend-attribute-save',
                items: [{
                   fieldLabel :'编码',
                   name: 'code',
                   allowBlank: false,
                   blankText: '编码'+ValidationRule.errorText.empty,
                   vtype: 'code',
                   width: 150
                 },{
                   fieldLabel: '名称',
                   name: 'name',
                   allowBlank: false,
                   blankText: '名称'+ValidationRule.errorText.empty,
                   vtype: 'name',
                   width: 150
                 }, CdForm.createCombo({
                      id: 'x_add_attr_other_valueType',
                      hiddenName: 'valueType',
                      fieldLabel: '类型',
                      data: Constants.ValueType
                 }),{
                      fieldLabel:'长度',
                      name: 'maxLength',
                      vtype: 'maxlength',
                      width: 150
                 },{
                      fieldLabel:'默认值',
                      name: 'defaultValue',
                      width: 150
                 },{
                      xtype: 'textarea',
                      fieldLabel: '备注',
                      name: 'description',
                      height: 60,
                      width: 150
                 },CdForm.createCombo({
                      id: 'x_add_attr_other_enabled',
                      hiddenName: 'enabled',
                      fieldLabel: '状态',
                      data: Constants.Enabled
                 })
                ],
                successFn: function(){
                    gridAttrExtend.load();
                }
            });
            winAddAttrExtend.show();
            winAddAttrExtend.setValue('x_add_attr_other_valueType', Constants.ValueType[1][0]);
            winAddAttrExtend.setValue('x_add_attr_other_enabled', true);
        }
    });
    var btnEditAttrExtend = new Ext.Button({
        text: '修改',
        iconCls: 'edit',
        handler: function(){
            var sels = gridAttrExtend.grid.getSelectionModel().getSelections();
            if(sels.length==0 || sels.length>1){
                Ext.Msg.alert('系统消息', '请选择需要修改的记录，只能修改单条记录!');
                return;
            }

            var winEditAttrExtend = new CdForm.EditForm({
                entityId: sels[0].get('id'),
                title: '编辑扩展属性',
                width: 300,
                btnOkText: '确定',
                //getUrl: 'testjson/attribute_other.json',
                getUrl: 'product/extend-attribute-edit',
                //url: 'testjson/get_parameters.jsp',
                url: 'product/extend-attribute-save',
                items: [{
                   xtype: 'hidden',
                   name: 'id'
                 },{
                   fieldLabel: '编码',
                   name: 'code',
                   disabled: true,    //编码不允许修改
                   width: 150
                 },{
                   fieldLabel: '名称',
                   name: 'name',
                   allowBlank: false,
                   blankText: '名称'+ValidationRule.errorText.empty,
                   vtype: 'name',
                   width: 150
                 }, CdForm.createCombo({
                      id: 'x_edit_attr_other_valueType',
                      hiddenName: 'valueType',
                      fieldLabel: '类型',
                      data: Constants.ValueType,
                      disabled: true             //类型不允许修改
                 }),{
                      fieldLabel:'长度',
                      name: 'maxLength',
                      disabled: true,    //长度不允许修改
                      width: 150
                 },{
                      fieldLabel:'默认值',
                      name: 'defaultValue',
                      width: 150
                 },{
                      xtype: 'textarea',
                      fieldLabel: '备注',
                      name: 'description',
                      height: 60,
                      width: 150
                 },CdForm.createCombo({
                      id: 'x_edit_attr_other_enabled',
                      hiddenName: 'enabled',
                      fieldLabel: '状态',
                      data: Constants.Enabled
                 })
              ],
              successFn: function(){
                 gridAttrExtend.load();
              }
           });
           winEditAttrExtend.show(function(kk, vv){
             if(kk == 'valueType'){  //只能自己填充下拉框了，相当郁闷，fuck
                 this.setValue('x_edit_attr_other_valueType', vv);
             }
             if(kk == 'enabled'){
                 this.setValue('x_edit_attr_other_enabled', vv);
             }
           });
        }
    });
    var btnDelAttr = new Ext.Button({
        text: '删除',
        iconCls: 'delete',
        handler: function(){
            var sels = gridAttrExtend.grid.getSelectionModel().getSelections();
            CdForm.Del(sels, function(){
                gridAttrExtend.load();
            }, 'product/extend-attribute-delete');
        }
    });
    var txQtitle = new Ext.form.TextField({
        width: 80
    });
    var btnSearchAttr = new Ext.Button({
        text: '查询',
        iconCls: 'search',
        handler: function(){
            gridAttrExtend.bindBaseParam({name: txQtitle.getValue().trim()});  //绑定查询参数
            gridAttrExtend.load();
        }
    });

    //------------------------------------------------------------------

    //扩展属性列表
    var sm = new Ext.grid.CheckboxSelectionModel();
    var gridAttrExtend = new SimpleGrid.Panel({
        renderTo: 'attribute-extend-panel',
        sm: sm,
        cm: [
            sm,
            {header: '编码', dataIndex: 'code', width:120},
            {header: '名称', dataIndex: 'name', width:120},
            {header: '类型', dataIndex: 'valueType', width:80, renderer: function(val){
                 return Constants.getValueByKey(val, Constants.ValueType);
            }},
            {header: '长度', dataIndex: 'maxLength', width:60},
            {header: '状态', dataIndex : 'enabled', width:60, renderer: function(val){
                 return Constants.getValueByKey(val, Constants.Enabled);
            }},
            {header: '默认值', dataIndex: 'defaultValue', width:120},
            {header: '备注', id: 'description', dataIndex: 'description',width:180}
        ],
        recordFn: [
            {name: 'id', type: 'int'},
            {name: 'code'},
            {name: 'name'},
            {name: 'valueType'},
            {name: 'maxLength'},
            {name: 'defaultValue'},
            {name: 'enabled', type: 'boolean'},
            {name: 'description'}
        ],
        //url: 'testjson/attribute_other_list.json',
        url: 'product/extend-attribute-list',
        autoExpandColumn: 'description',
        tbar: [
           btnAddAttrExtend, '-', btnEditAttrExtend, '-', btnDelAttr,
           '->',
           '名称', txQtitle, '-', btnSearchAttr
        ]
    });
    gridAttrExtend.load();
});


