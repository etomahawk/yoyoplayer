
Ext.onReady(function(){
    
    //工具栏按钮定义
    var btnAddMu = new Ext.Button({
        text: '新增',
        iconCls: 'add',
        handler: function() {
            var winAddMu = new CdForm.AddForm({
                title: '新增计量单位',
                width: 300,
                //url: 'testjson/get_parameters.jsp',
                url: 'product/measure-unit-save',
                items: [{
                   fieldLabel: '编码',
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
                 },CdForm.createCombo({
                     id: 'x_add_mu_enabled',
                     hiddenName: 'enabled',
                     fieldLabel: '是否有效',
                     data: [
                       [true, '是'],
                       [false, '否']
                     ]
                }),CdForm.createCombo({
                     id: 'x_add_mu_benchmark',
                     hiddenName: 'benchmark',
                     fieldLabel: '是否基准单位',
                     data: [
                       [true, '是'],
                       [false, '否']
                     ]
                }),{
                  xtype: 'textarea',
                  fieldLabel: '备注',
                  name: 'description',
                  height: 60,
                  width: 150
                }
              ],
              successFn: function(){
                  gridMu.load();
              }
           });
           winAddMu.show();
           winAddMu.setValue('x_add_mu_enabled', true);
           winAddMu.setValue('x_add_mu_benchmark', false);
        }
    });
    var btnEditMu = new Ext.Button({
        text: '修改',
        iconCls: 'edit',
        handler: function(){
            var sel = gridMu.getSelectionForEdit();
            if(sel === false)
                return;

            var winEditMu = new CdForm.EditForm({
                entityId: sel.get('id'),
                title: '编辑计量单位',
                width: 300,
                btnOkText: '确定',
                //getUrl: 'testjson/measure_unit.json',
                //url: 'testjson/get_parameters.jsp',
                getUrl: 'product/measure-unit-edit',
                url: 'product/measure-unit-save',
                items: [{
                   xtype: 'hidden',
                   name: 'id'
                 },{
                   fieldLabel: '编码',
                   name: 'code',
                   disabled: true,   //编码不允许修改
                   width: 150
                 },{
                   fieldLabel: '名称',
                   name: 'name',
                   allowBlank: false,
                   blankText: '名称'+ValidationRule.errorText.empty,
                   vtype: 'name',
                   width: 150
                 },CdForm.createCombo({
                     id: 'x_edit_mu_enabled',
                     hiddenName: 'enabled',
                     fieldLabel: '是否有效',
                     data: [
                       [true, '是'],
                       [false, '否']
                     ]
                 }),CdForm.createCombo({
                     id: 'x_edit_mu_benchmark',
                     hiddenName: 'benchmark',
                     fieldLabel: '是否基准单位',
                     data: [
                       [true, '是'],
                       [false, '否']
                     ]
                }),{
                    xtype: 'textarea',
                    fieldLabel: '备注',
                    name: 'description',
                    height: 60,
                    width: 150
                }
               ],
              successFn: function(){
                  gridMu.load();
              }
            });
            winEditMu.show(function(kk, vv){
               if(kk == 'enabled'){  //只能自己填充下拉框了，相当郁闷，fuck
                  this.setValue('x_edit_mu_enabled', vv);
               }
               if(kk == 'benchmark'){
                  this.setValue('x_edit_mu_benchmark', vv);
               }
            });
        }
    });
    var btnDelMu = new Ext.Button({
        text: '删除',
        iconCls: 'delete',
        handler: function(){
            var sels = gridMu.grid.getSelectionModel().getSelections();
            CdForm.Del(sels, function(){
                gridMu.load();
            }, 'product/measure-unit-delete');
        }
    });

    /*
    var btnRate = new Ext.Button({
        text: '换算比例',
        iconCls: 'finance',
        handler: function() {
             Ext.getCmp('content-panel').load({
                url: "product/uom_setting.jsp",
                callback: function(){
                    Ext.getCmp('content-panel').setTitle("换算比例");
                },
                scripts:true
             });
        }
    });*/

    var gridMu = new SimpleGrid.Panel({
        renderTo: 'measure-unit-panel',
        sm: new Ext.grid.RowSelectionModel({singleSelect:true}),
        cm: [
            {header: '编码', dataIndex: 'code', width:120, sortable: true},
            {header: '名称', dataIndex: 'name', width:120, sortable: true},
            {header: '基本单位', dataIndex: 'benchmark', width:80, renderer: function(val){
	    	return val === true?'是':'否'
             }, sortable: true},
            {header: '是否有效', dataIndex: 'enabled', width:60, renderer: function(val){
	    	return val === true?'是':'否'
             }, sortable: true},
            {header: '描述', id: 'description', dataIndex: 'description', width: 120}
        ],
        recordFn: [
          {name: 'id', type: 'int' },
          {name: 'code'},
          {name: 'name'},
          {name: 'benchmark', type: 'boolean'},
          {name: 'enabled', type: 'boolean'},
          {name: 'description'}
        ],
        //url: 'testjson/measure_unit_list.json',
        url: 'product/measure-unit-list',
        autoExpandColumn: 'description',
        tbar: [
           btnAddMu, '-', btnEditMu, '-', btnDelMu
        ]
    });
    gridMu.load();
});

