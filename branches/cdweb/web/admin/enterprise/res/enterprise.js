Ext.onReady(function(){
    var limit = 20;

    Ext.QuickTips.init();
    //-----------------------------添加企业信息----------------------------
    //Ext.FormPanel
    var form_add_enterprise = new Ext.FormPanel({
        labelWidth: 70,
        labelAlign: "right",
        url: "enterprise/enterprise-save",
        border: false,
        baseCls: "x-plain",
        bodyStyle: "padding:5px 5px 0",
        anchor: "100%",
        defaultType: "textfield",
        items: [{
            xtype: "hidden",
            id: "areaID",
            name: "areaID",
            value: -1
        }, {
            fieldLabel: "编码",//编码,
            name: "code",
            allowBlank: false,
            anchor: "98%",
            maxLength: 20
        }, {
            fieldLabel: "企业名称",//"名称",
            name: "name",
            allowBlank: false,
            anchor: "98%",
            maxLength: 50
        }, CdForm.createCombo({
            id: "x_enterprise_type2",
            hiddenName: "type",
            fieldLabel: "企业类型",
            data: Constants.EnterpriseType
        }), CdForm.createCombo({
            id: "x_enterprise_kind2",
            hiddenName: "kind",
            fieldLabel: "企业性质",
            data: Constants.EnterpriseKind
        }), {
            fieldLabel: "地址", //地址
            name: "address",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }, {
            fieldLabel: "邮编", //邮编
            name: "postcode",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }, {
            fieldLabel: "联系人", //联系人
            name: "linkman",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }, {
            fieldLabel: "电话", //电话
            name: "telephone",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }, {
            fieldLabel: "传真", //传真
            name: "fax",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }, {
            fieldLabel: "E-Mail", //E-Mail
            name: "email",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }, {
            fieldLabel: "描述", //描述
            xtype: "textarea",
            name: "description",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }],
        buttonAlign: "right",
        minButtonWidth: 60,
        buttons: [{
            text: "添加",//"添加",
            handler: function(btn){
                alert(this.ownerCt.url);
                var frm = form_add_enterprise.getForm();
                if (frm.isValid()) {
                    btn.disable();
                    var codeField = frm.findField("code");
                    var titleField = frm.findField("name");
                    frm.submit({
                        waitTitle: "请稍候",
                        waitMsg: "正在提交数据,请稍候...",
                        success: function(form, action){
                            gridAttr.getStore().reload();
                            Ext.Msg.show({
                                title: "成功提示",
                                msg: "企业信息新增成功！",
                                buttons: Ext.Msg.OK,
                                fn: function(){
                                    btn.enable();
                                },
                                icon: Ext.Msg.INFO
                            });
                            window_add_enterprise.hide();
                        },
                        failure: function(){
                            Ext.Msg.show({
                                title: "系统消息",
                                msg: "企业信息新增失败！",
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
            text: "重置",//"重置",
            handler: function(){
                this.ownerCt.form.reset();
            }
        }, {
            text: "取消",// "取消",
            handler: function(){
                window_add_enterprise.hide();
            }
        }]
    })
    var window_add_enterprise = new Ext.Window({
        title: "新增企业信息",// "添加企业信息",
        width: 450,
        closeAction: "hide",
        listeners: {
            "hide": function(){
                resetForm(form_add_enterprise.getForm(), ["areaID", "code", "name", "type", "kind", "address", "postcode", "linkman", "telephone", "fax", "email", "description"]);
            }
        },
        resizable: false,
        autoHeight: true,
        modal: true,
        items: [form_add_enterprise]
    });

    var form_edit_enterprise = new Ext.FormPanel({
        url: "enterprise/enterprise-update",
        labelWidth: 70,
        labelAlign: "right",
        border: false,
        baseCls: "x-plain",
        bodyStyle: "padding:5px 5px 0",
        anchor: "100%",
        defaultType: "textfield",
        items: [{
            xtype: "hidden",
            name: "id"
        }, {
            fieldLabel: "企业名称",//"名称",
            name: "name",
            allowBlank: false,
            anchor: "98%",
            maxLength: 50
        }, {
            fieldLabel: "地址", //地址
            name: "address",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }, {
            fieldLabel: "邮编", //邮编
            name: "postcode",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }, {
            fieldLabel: "联系人", //联系人
            name: "linkman",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }, {
            fieldLabel: "电话", //电话
            name: "telephone",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }, {
            fieldLabel: "传真", //传真
            name: "fax",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }, {
            fieldLabel: "E-Mail", //E-Mail
            name: "email",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }, {
            fieldLabel: "描述", //描述
            xtype: "textarea",
            name: "description",
            allowBlank: true,
            anchor: "98%",
            maxLength: 200
        }],
        buttonAlign: "right",
        minButtonWidth: 60,
        buttons: [{
            text: "确认",//"确认",
            handler: function(btn){
                if (form_edit_enterprise.getForm().isValid()) {
                    btn.disable();
                    form_edit_enterprise.getForm().submit({
                        waitTitle: "请稍候",
                        waitMsg: "正在提交数据,请稍候...",
                        success: function(form, action){
                            gridAttr.getStore().reload();
                            Ext.Msg.show({
                                title: "成功提示",
                                msg: "企业信息保存成功！",
                                buttons: Ext.Msg.OK,
                                fn: function(){
                                    btn.enable()
                                },
                                icon: Ext.Msg.INFO
                            });
                            window_edit_enterprise.hide();
                        },
                        failure: function(form, action){
                            Ext.Msg.show({
                                title: "系统消息",
                                msg: "企业信息更新失败",
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
                    form_edit_enterprise.getForm().loadRecord(record);
                }
            }
        }, {
            text: "取消",
            handler: function(){
                window_edit_enterprise.hide();
            }
        }]
    });
    var window_edit_enterprise = new Ext.Window({
        title: "企业信息编辑",//"地区编辑",
        width: 350,
        height: 440,
        resizable: false,
        autoHeight: true,
        modal: true,
        closeAction: "hide",
        items: [form_edit_enterprise]
    });
    var btn_add_enterprise = new Ext.Button({
        text: "新增",//"新增",
        iconCls: "add",
        handler: function(){
            window_add_enterprise.show();
            window_add_enterprise.center();
        }
    });
    var btn_edit_enterprise = new Ext.Button({
        text: "编辑",//"编辑",
        iconCls: "edit",
        handler: function(){
            var record = gridAttr.getSelectionModel().getSelected();
            if (record) {
                window_edit_enterprise.show();
                window_edit_enterprise.center();
                form_edit_enterprise.getForm().loadRecord(record);
            }
            else {
                Ext.MessageBox.show({
                    title: "系统消息",
                    msg: "请选择企业信息记录",
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
            }
        }
    });
    var btn_del_enterprise = new Ext.Button({
        text: "删除",//"删除",
        iconCls: "delete",
        handler: function(){
            var records = gridAttr.getSelectionModel().getSelections();
            if (records.length < 1) {
                Ext.MessageBox.show({
                    title: "系统消息",
                    msg: "请选择企业信息记录",
                    buttons: Ext.MessageBox.OK,
                    icon: Ext.MessageBox.INFO
                });
            }
            else {
                Ext.MessageBox.confirm("系统消息", "确定删除选中的企业信息记录?", function(btn){
                    if (btn == "yes") {
                        var ids = "";
                        for (var i = 0; i < records.length; i++) {
                            var record = records[i];
                            if (record.data.id) {
                                ids += record.data.id + ",";
                            }
                            else {
                                gridAttr.getStore().remove(record);
                            }//end if
                        }//enf for
                        if (ids.length > 1) {
                            ids = ids.substring(0, ids.length - 1);
                        }

                        //发送删除请求
                        Ext.lib.Ajax.request("POST", "enterprise/enterprise-delete", {
                            success: function(request){
                                Ext.MessageBox.show({
                                    title: "系统消息",
                                    msg: "删除企业信息成功！",
                                    buttons: Ext.MessageBox.OK,
                                    icon: Ext.MessageBox.INFO
                                });
                                gridAttr.getStore().reload();
                            },
                            failure: function(){
                                Ext.MessageBox.show({
                                    title: "系统消息",
                                    msg: "删除企业信息失败！",
                                    buttons: Ext.MessageBox.OK,
                                    icon: Ext.MessageBox.ERROR
                                });
                            }
                        }, "enterpriseIds=" + ids);
                    }
                });
            }
        }
    });

    var sm = new Ext.grid.CheckboxSelectionModel();
    var gridAttr = new SimpleGrid.Panel({
        region: "center",
        layout: "fit",
        height: Ext.get("area-panel").getHeight(),
        autoWidth: true,
        sm: sm,
        cm: [sm, {
            header: "企业编码",
            id: "code",
            dataIndex: "code",
            width: 80
        }, {
            header: "企业名称",
            id: "name",
            dataIndex: "name",
            width: 120
        }, {
            header: "企业类型",
            id: "type",
            dataIndex: "type",
            width: 80,
            renderer: function(val){
                return Constants.getValueByKey(val, Constants.EnterpriseType);
            }
        }, {
            header: "企业性质",
            id: "kind",
            dataIndex: "kind",
            width: 80,
            renderer: function(val){
                return Constants.getValueByKey(val, Constants.EnterpriseKind);
            }
        }, {
            header: "联系人",
            id: "linkman",
            dataIndex: "linkman",
            width: 80
        }, {
            header: "电话",
            id: "telephone",
            dataIndex: "telephone",
            width: 100
        }, {
            header: "传真",
            id: "fax",
            dataIndex: "fax",
            width: 120
        }, {
            header: "E-mail",
            id: "email",
            dataIndex: "email",
            width: 120
        }, {
            header: "启用状态",
            id: "enabled",
            dataIndex: "enabled",
            width: 55,
            renderer: function(val){
                return val ? "<span style='color:green'>启用</span>" : "<span style='color:red'>禁用</span>";
            }
        }],
        recordFn: [{
            name: "id",
            type: "int"
        }, {
            name: "code"
        }, {
            name: "name"
        }, {
            name: "type"
        }, {
            name: "kind"
        }, {
            name: "linkman"
        }, {
            name: "telephone"
        }, {
            name: "fax"
        }, {
            name: "email"
        }, {
            name: "enabled"
        }],
        url: "enterprise/enterprise-list",
        autoExpandColumn: "enabled",
        tbar: [btn_add_enterprise, "-", btn_edit_enterprise, "-", btn_del_enterprise]
    });
    //gridAttr.load();

    var tree_area = new Ext.tree.TreePanel({
        title: "",
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
            id: "-1"
        })
    });

    gridAttr.getStore().load({
        params: {
            areaID: "-1",
            start: 0,
            limit: limit
        }
    });

    tree_area.on("beforeload", function(node){
        var url = "enterprise/area-tree?parentAreaID=" + node.id;
        tree_area.loader.dataUrl = url;
    });

    tree_area.getRootNode().select();
    // Assign the changeLayout function to be called on tree node click.
    tree_area.on("click", function(n){
        var sn = this.selModel.selNode || {}; // selNode is null on initial selection
        if (n.id != sn.id) { // ignore clicks on folders and currently selected node
            gridAttr.getStore().on("beforeload", function(){
                Ext.apply(this.baseParams, {
                    areaID: n.id
                });
            });
            gridAttr.getStore().load({
                params: {
                    areaID: n.id,
                    start: 0,
                    limit: limit
                }
            });
            //此值用于辅助查询
            form_add_enterprise.findById("areaID").setValue(n.id);
        }
    });

    var tree_area_panel = {
        region: "west",
        collapsible: true,
        split: true,
        width: 225,
        minSize: 175,
        maxSize: 400,
        layout: "card",
        margins: "0 0 0 0",
        activeItem: 0,
        border: false,
        items: [tree_area]
    };

    var grid_enterprise_panel = {
        region: "center",
        collapsible: false,
        split: true,
        width: 225,
        minSize: 175,
        maxSize: 400,
        layout: "card",
        margins: "0 0 0 0",
        activeItem: 0,
        border: false,
        items: [gridAttr.grid]
    };
    var panel = new Ext.Panel({
        renderTo: "area-panel",
        height: Ext.get("area-panel").getHeight(),
        layout: "border",
        items: [tree_area_panel, grid_enterprise_panel]
    });

});
