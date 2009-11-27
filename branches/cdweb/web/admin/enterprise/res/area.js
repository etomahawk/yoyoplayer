Ext.onReady(function(){
    var limit = 20;

    Ext.QuickTips.init();
    var form_add_area = new Ext.FormPanel({
        labelWidth: 70,
        labelAlign: 'right',
        url: 'enterprise/area-save',
        border: false,
        baseCls: 'x-plain',
        bodyStyle: 'padding:5px 5px 0',
        anchor: '100%',
        defaultType: 'textfield',
        items: [{
            xtype: 'hidden',
            id: 'parentAreaID',
            name: 'parentAreaID',
            value: -1
        }, {
            fieldLabel: "编码",//'编码',
            name: 'code',
            allowBlank: false,
            anchor: '98%',
            maxLength: 20
        }, {
            fieldLabel: "名称",//'名称',
            name: 'name',
            allowBlank: false,
            anchor: '98%',
            maxLength: 50
        }, {
            fieldLabel : "描述", //描述
            xtype : "textarea",
            name : "description",
            allowBlank: true,
            anchor: '98%',
            maxLength: 200
        }],
        buttonAlign: 'right',
        minButtonWidth: 60,
        buttons: [{
            text: "添加",//'添加',
            handler: function(btn){
                var frm = form_add_area.getForm();
                if (frm.isValid()) {
                    btn.disable();
                    var codeField = frm.findField('code');
                    var titleField = frm.findField('name');
                    frm.submit({
                        waitTitle: "请稍候",
                        waitMsg: "正在提交数据,请稍候...",
                        success: function(form, action){
                            gridAttr.getStore().reload();
                            tree_area.root.reload();
                            Ext.Msg.show({
                                title: "成功提示",
                                msg: "地区信息添加成功！",
                                buttons: Ext.Msg.OK,
                                fn: function(){
                                    btn.enable();
                                },
                                icon: Ext.Msg.INFO
                            });
                            window_add_area.hide();
                        },
                        failure: function(form, action){
                            var msg = "地区信息添加失败";
                            if(action.result && !action.result.sccuess) {
                                msg = action.result.message;
                            }
                            Ext.Msg.show({
                                title: "系统消息",
                                msg: msg,
                                buttons: Ext.Msg.OK,
                                fn: function(){
                                    btn.enable();
                                },
                                icon: Ext.Msg.ERROR
                            });
                        }
                    });
                }
            }
        }, {
            text: "重置",//'重置',
            handler: function(){
                this.ownerCt.form.reset();
            }
        }, {
            text: "取消",// '取消',
            handler: function(){
                window_add_area.hide();
            }
        }]
    })
    var window_add_area = new Ext.Window({
        title: "添加地区",// '添加地区',
        width: 350,
        height: 440,
        closeAction: 'hide',
        listeners: {
            'hide': function(){
                form_add_area.getForm().findField("code").reset();
                form_add_area.getForm().findField("name").reset();
                form_add_area.getForm().findField("description").reset();
            }
        },
        resizable: false,
        autoHeight: true,
        modal: true,
        items: [form_add_area]
    });
    var form_edit_area = new Ext.FormPanel({
        url: 'enterprise/area-update',
        labelWidth: 70,
        labelAlign: 'right',
        border: false,
        baseCls: 'x-plain',
        bodyStyle: 'padding:5px 5px 0',
        anchor: '100%',
        defaultType: 'textfield',
        items: [{
            xtype: 'hidden',
            id: 'id',
            name: 'id'
        }, {
            fieldLabel: "名称",//'名称',
            name: 'name',
            allowBlank: false,
            anchor: '98%',
            maxLength: 50
        }, {
            fieldLabel : "描述", //描述
            xtype : "textarea",
            name : "description",
            allowBlank: true,
            anchor: '98%',
            maxLength: 200
        }],
        buttonAlign: 'right',
        minButtonWidth: 60,
        buttons: [{
            text: "确认",//'确认',
            handler: function(btn){
                if (form_edit_area.getForm().isValid()) {
                    btn.disable();
                    form_edit_area.getForm().submit({
                        waitTitle: "请稍候",
                        waitMsg: "正在提交数据,请稍候...",
                        success: function(form, action){
                            gridAttr.getStore().reload();
                            tree_area.root.reload();
                            Ext.Msg.show({
                                title: "成功提示",
                                msg: "地区信息保存成功！",
                                buttons: Ext.Msg.OK,
                                fn: function(){
                                    btn.enable()
                                },
                                icon: Ext.Msg.INFO
                            });
                            window_edit_area.hide();
                        },
                        failure: function(form, action){
                            var msg = "地区信息保存失败";
                            if(action.result && !action.result.sccuess) {
                                msg = action.result.message;
                            }
                            Ext.Msg.show({
                                title: "系统消息",
                                msg: msg,
                                buttons: Ext.Msg.OK,
                                fn: function(){
                                    btn.enable();
                                },
                                icon: Ext.Msg.ERROR
                            });
                        }
                    });
                }
            }
        }, {
            text: "重置",
            handler: function(){
                var record = gridAttr.getSelectionModel().getSelected();
                if (record) {
                    form_edit_area.getForm().loadRecord(record);
                }
            }
        }, {
            text: "取消",
            handler: function(){
                window_edit_area.hide();
            }
        }]
    });
    var window_edit_area = new Ext.Window({
        title: "地区编辑",//'地区编辑',
        width: 350,
        height: 440,
        resizable: false,
        autoHeight: true,
        modal: true,
        closeAction: 'hide',
        items: [form_edit_area]
    });
    var btn_add_area = new Ext.Button({
        text: "新增",//'新增',
        iconCls: 'add',
        handler: function(){
            window_add_area.show();
        }
    });
    var btn_edit_area = new Ext.Button({
        text: "编辑",//'编辑',
        iconCls: 'edit',
        handler: function(){
            var record = gridAttr.getSelectionModel().getSelected();
            if (record) {
                window_edit_area.show();
                form_edit_area.getForm().loadRecord(record);
            }
            else {
                Ext.MessageBox.show({
                    title: "系统消息",
                    msg: "请选择地区记录",
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
            }
        }
    });
    var btn_del_area = new Ext.Button({
        text: "删除",//'删除',
        iconCls: 'delete',
        handler: function(){
            var records = gridAttr.getSelectionModel().getSelections();
            if (records.length < 1) {
                Ext.MessageBox.show({
                    title: "系统消息",
                    msg: "请选择地区记录",
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
            }
            else {
                Ext.MessageBox.confirm("系统消息", "确定删除记录?", function(btn){
                    if (btn == "yes") {
                        var ids = "";
                        for (var i = 0; i < records.length; i++) {
                            var record = records[i];
                            if (record.data.id) {
                                ids += record.data.id + ',';
                            }
                            else {
                                gridAttr.getStore().remove(record);
                            }//end if
                        }//enf for
                        if (ids.length > 1) {
                            ids = ids.substring(0, ids.length - 1);
                        }

                        //发送删除请求
                        Ext.lib.Ajax.request('POST', 'enterprise/area-delete', {
                            success: function(request){
                                var result = eval("(" + request.responseText + ")");
                                debugger;
                                if(result.success) {
                                    Ext.Msg.alert("系统消息", "删除地区信息成功！");
                                    gridAttr.getStore().reload();
                                    tree_area.root.reload();
                                }
                                else {
                                    Ext.Msg.alert("系统消息", result.message);
                                };
                                gc(result);
                            },
                            failure: function(){
                                Ext.Msg.alert("系统消息", "删除地区信息失败！");
                            }
                        }, 'areaIds=' + ids);
                    }
                });
            }
        }
    });

    var sm = new Ext.grid.CheckboxSelectionModel();
    var gridAttr = new SimpleGrid.Panel({
        region: 'center',
        layout: 'fit',
        height: Ext.get("area-panel").getHeight(),
        autoWidth: true,
        sm : sm,
        cm: [
        sm,
        {
            header: '编码',
            dataIndex: 'code',
            width:120
        },
        {
            header: '名称',
            dataIndex: 'name',
            width:120
        },
        {
            header: '描述',
            id: 'description',
            dataIndex: 'description',
            width: 120
        }
        ],
        recordFn: [
        {
            name: 'id',
            type: 'int'
        },

        {
            name: 'code'
        },

        {
            name: 'name'
        },

        {
            name: 'description'
        }
        ],
        url: 'enterprise/area-list',
        autoExpandColumn: 'description',
        tbar: [
        btn_add_area, '-', btn_edit_area, '-', btn_del_area
        ]
    });
    //gridAttr.load();

    var tree_area = new Ext.tree.TreePanel({
        title: '',
        split: false,
        autoScroll: true,

        // tree-specific configs:
        rootVisible: true,
        lines: false,
        singleExpand: true,
        useArrows: true,
        expanded: true,

        loader: new Ext.tree.TreeLoader({
            dataUrl: "enterprise/area-tree"
        }),

        root: new Ext.tree.AsyncTreeNode({
            text: "地区",
            draggable: false,
            id : "-1"
        })
    });

    gridAttr.getStore().load({
        params: {
            parentAreaID: "-1",
            start: 0,
            limit: limit
        }
    });

    tree_area.on('beforeload', function(node){
        var url = "enterprise/area-tree?parentAreaID=" + node.id;
        tree_area.loader.dataUrl = url;
    });
    tree_area.getRootNode().select();
    // Assign the changeLayout function to be called on tree node click.
    tree_area.on("click", function(n){
        var sn = this.selModel.selNode || {}; // selNode is null on initial selection
        if (n.id != sn.id) { // ignore clicks on folders and currently selected node
            gridAttr.getStore().on('beforeload', function(){
                Ext.apply(this.baseParams, {
                    parentAreaID: n.id
                });
            });
            gridAttr.getStore().load({
                params: {
                    parentAreaID: n.id,
                    start: 0,
                    limit: limit
                }
            });
            //此值用于辅助查询
            form_add_area.findById('parentAreaID').setValue(n.id);
        }
    });

    var tree_area_panel = {
        region: 'west',
        collapsible: true,
        split: true,
        width: 225,
        minSize: 175,
        maxSize: 400,
        layout: 'card',
        margins: '0 0 0 0',
        activeItem: 0,
        border: false,
        items: [tree_area]
    };

    var grid_area_panel = {
        region: 'center',
        collapsible: false,
        split: true,
        width: 225,
        minSize: 175,
        maxSize: 400,
        layout: 'card',
        margins: '0 0 0 0',
        activeItem: 0,
        border: false,
        items: [gridAttr.grid]
    };
    var panel = new Ext.Panel({
        renderTo: 'area-panel',
        height: Ext.get("area-panel").getHeight(),
        layout: 'border',
        items: [tree_area_panel, grid_area_panel]
    });

});
