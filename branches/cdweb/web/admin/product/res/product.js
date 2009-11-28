
Ext.onReady(function(){

    

    //---------------------左边的商品分类树------------------------------------
    var pnlProductCatTree = new CdForm.ProductCatTree();

    //自定义"未分类"结点
    pnlProductCatTree.tree.root.on('expand', function(){
        if(!this.blSelfDef){    //根结点是否已经加入“未分类”结点的标志位
           this.appendChild(new Ext.tree.TreeNode({id: -2, text:'未分类'}));
           this.blSelfDef = true;
        }
    });

    pnlProductCatTree.on('click', function(tnode){
        if(tnode.id == '-2'){   // 点击"未分类" 查看其商品列表时调用单独的action url
            gridProduct.changeUrl('product/product-list-without-category');
        }else{
            gridProduct.resetUrl();  //每次点击其他的商品分类时，记得重置回最初的url
            gridProduct.bindBaseParam({categoryId: tnode.id});
        }
        gridProduct.load();
    });

    //------------------------------------------------------------------

    //-----------------------工具栏按钮定义---------------------------------
    var btnEditProduct = new Ext.Button({
        text: '修改',
        iconCls: 'edit',
        handler: function() {
            var sel = gridProduct.getSelectionForEdit();
            if(sel === false)
                return;
            var attrWin = new ProductAttrWin(sel.get('id'));
            attrWin.show();
        }
    });
    var btnChangeCat = new Ext.Button({
        text: '分类',
        iconCls: 'relation',
        handler: function() {
            var sel = gridProduct.getSelectionForEdit();
            if(sel === false)
                return;
            var productId = sel.get('id');
            
            //通过商品ID请求服务器获得分类树的xpath路径
            Ext.Ajax.request({
                url: 'product/product-get-category-tree-path',
                method: 'GET',
                params: 'id='+productId,
                success: function(resp){
                    /*
                     * 商品从ERP导入时，属于"未分类"，但一定归于两种情况：
                     * (1). 保存在T_PRODUCT表、T_PAPER表
                     *         此时如果点"未分类"商品列表中的某一条记录，查询时返回的路径是{path:"纸张结点的ID"}
                     * (2). 保存在T_PRODUCT表、T_PULP表
                     *         此时如果点"未分类"商品列表中的某一条记录，查询时返回的路径是{path:"纸浆结点的ID"}
                     * 这两种情况下都应该在弹出分类选择树时分别把纸浆、纸张结点及所有的后代结点移除
                     *
                     * 对于已经归于categoryType='PAPER'的商品分类的商品，
                     * 返回的路径是例如 {path:"纸张结点的ID/11/112/..."}
                     * 此时应该把纸浆结点及所有的后代结点移除
                     *
                     * 对于已经归于categoryType='PULP'的商品分类的商品，
                     * 返回的路径是例如 {path:"纸浆结点的ID/11/112/..."}
                     * 此时应该把纸张结点及所有的后代结点移除
                     */
                    var respText = Ext.util.JSON.decode(resp.responseText);
                    if(!respText)
                        return;
                    if(respText.success === true){
                        var treeSelector = new CdForm.ProductCatTreeSelector();
                        treeSelector.show(respText.path, productId, function(){
                            gridProduct.load();
                        });
                    }
                }
            });
        }
    });
    var btnQuery = new Ext.Button({
        text: '高级查询',
        iconCls: 'search',
        handler: function() {
            //todo
        }
    });

    //---------------------商品列表----------------------------
    
    var gridProduct = new SimpleGrid.Panel({
        region: 'center',
        layout: 'fit',
        height: Ext.get("product-panel").getHeight(),
        autoWidth: true,
        sm: new Ext.grid.RowSelectionModel({singleSelect:true}),
        cm: [
            {header: '网上编码', dataIndex: 'netCode', width:100},
            {header: '产品编码', dataIndex: 'code', width:100},
            {header: '产品全名', dataIndex: 'fullName', width:120},
            {header: 'GTIN编码', dataIndex: 'gtinNumber', width:80},
            {header: '供应商编码', dataIndex: 'supplierCode', width: 80},
            {header: '供应商编号', dataIndex: 'supplierNumber', width: 80},
            {header: '供应商名称', dataIndex: 'supplierName', width: 120},
            {header: '最后更新日期', dataIndex: 'lastUpdateDate', width: 120}
        ],
        recordFn: [
          {name: 'id', type: 'int' },
          {name: 'netCode'},
          {name: 'code'},
          {name: 'fullName'},
          {name: 'gtinNumber'},
          {name: 'supplierCode'},
          {name: 'supplierNumber'},
          {name: 'supplierName'},
          {name: 'lastUpdateDate'}
        ],
        //url: 'testjson/product_list.jsp',
        url: 'product/product-list-by-category',
        tbar: [btnEditProduct, '-', btnChangeCat, '-', btnQuery]
    });

    var productPanel = new Ext.Panel({
        renderTo: 'product-panel',
        height: Ext.get("product-panel").getHeight(),
        layout: 'border',
        items: [pnlProductCatTree.tree, gridProduct.grid]
    });
    
});

