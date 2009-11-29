
Ext.onReady(function(){

    //---------------------------工具条定义-------------------------

    //属性类型下拉框，由于是作为GET查询参数所以可以不定义hiddenName

    var comboCat = new Ext.form.ComboBox({
        store: new Ext.data.SimpleStore({
	   fields: ["value", "title"],
	   data: Constants.CoreAttrType
	}),
        valueField: "value",
        displayField: "title",
        mode: 'local',
        triggerAction: 'all',
        editable: false,
        fieldLabel: '属性类型：',
        width: 120,
        //emptyText: ''
        value: ''
    });

    var btnSearch = new Ext.Button({
        text: '查询',
        iconCls: 'search',
        handler: function(){
            gridAttr.bindBaseParam({attributeType: comboCat.getValue()});  //绑定查询参数
            gridAttr.load();
        }
    });

    //-----------------------------------------------------------

    //基本属性列表

    var gridAttr = new SimpleGrid.Panel({
        renderTo: 'core-attribute-panel',
        cm: [
            {header: '编码', dataIndex: 'code', width:120, sortable: true},
            {header: '名称', dataIndex: 'name', width:120, sortable: true},
            {header: '类型', dataIndex: 'valueType', width:80, renderer: function(val){
                 return Constants.getValueByKey(val, Constants.ValueType);
            }, sortable: true},
            {header: '长度', dataIndex: 'maxLength', width:60, sortable: true},
            {header: '分类', dataIndex: 'attributeType', width: 100, sortable: true},
            {header: '默认值', dataIndex: 'defaultValue', width: 120, sortable: true},
            {header: '备注', id: 'description', dataIndex: 'description', width: 120}
        ],
        recordFn: [
          {name: 'code'},
          {name: 'name'},
          {name: 'valueType'},
          {name: 'maxLength'},
          {name: 'defaultValue'},
          {name: 'description'},
          {name: 'attributeType'}
        ],
        autoId: true,
        //url: 'testjson/attribute_basic_list.json',
        url: 'product/core-attribute',
        autoExpandColumn: 'description',
        tbar: [
           '选择属性类型', ' ', comboCat, '-', btnSearch
        ]
    });
    gridAttr.load({sort: 'code', dir: 'ASC'});  //默认按编码列升序排列
});