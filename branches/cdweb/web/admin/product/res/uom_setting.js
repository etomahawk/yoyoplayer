Ext.onReady(function(){
    
    //商品分类树
    var pnlProductCatTree = new CdForm.ProductCatTree();
    pnlProductCatTree.on('click', function(tnode){

        gridProduct.bindBaseParam({catId: tnode.id});
        gridProduct.load(null, function(resultset){
            if(!resultset || resultset.length==0)
                    this.removeAll();
        }, gridProduct);
    });

    //工具栏按钮定义
    var btnEditRate = new Ext.Button({
        text: '批量修改',
        iconCls: 'edit',
        handler: function() {
            
        }
    });
    var btnReturn = new Ext.Button({
        text: '返回',
        iconCls: 'previous',
        handler: function() {

        }
    });
    var txQtitle = new Ext.form.TextField({
        name: 'name',
        allowBlank: true,
        blankText: '',
        width:80
    });
    var btnQuery = new Ext.Button({
        text: '查询',
        iconCls: 'search',
        handler: function() {
        }
    });
    
    var gridProduct = new SimpleGrid.Panel({
        editor: true,
        region: 'center',
        layout: 'fit',
        height: Ext.get("uom-rate-setting-panel").getHeight(),
        autoWidth: true,
        cm: [
            {header: '产品编码', dataIndex: 'code', width:120},
            {header: '产品全名', dataIndex: 'fullName', width:120},
            {header: 'GTIN编码', dataIndex: 'gtinNumber', width:80},
            {header: '供应商编码', dataIndex: 'supplierCode', width: 80},
            {header: '换算比例',dataIndex: 'rate',
                editor: new Ext.grid.GridEditor(new Ext.form.TextField({allowBlank: false})),
                renderer: function(val){
                    return val+"件/吨"
                }
            }
        ],
        recordFn: [
          {name: 'id', type: 'int' },
          {name: 'code'},
          {name: 'fullName'},
          {name: 'gtinNumber'},
          {name: 'supplierCode'},
          {name: 'rate', type: 'float'}
        ],
        url: 'testjson/product_rate_list.jsp',
        tbar: [btnEditRate, '-', btnReturn ,'->', txQtitle, btnQuery]
    });

    var productPanel = new Ext.Panel({
        renderTo: 'uom-rate-setting-panel',
        height: Ext.get("uom-rate-setting-panel").getHeight(),
        layout: 'border',
        items: [pnlProductCatTree.tree, gridProduct.grid]
    });

    gridProduct.load({catId: 0});
});

