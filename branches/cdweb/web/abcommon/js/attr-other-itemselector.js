/**
 * 设置商品类别对应的可选扩展属性的窗口
 *
 * @author shiyan.wu
 *
 *
 * @param catId        商品分类的ID
 * @param catName      商品分类的名称
 * @param successFn    保存成功后的回调函数
 *
 */
function AttrOtherItemSelector(catId, catName, successFn){

    this.catId = catId;
    this.successFn = successFn;

    //可选扩展属性列表
    this.fpStore = new Ext.data.Store({
        proxy: new Ext.data.HttpProxy({
            //url: 'testjson/attribute_other_list.json'
            url: 'product/extend-attribute-list',
            method: 'GET'
        }),
        reader: new Ext.data.JsonReader({
            root: 'list',
            totalProperty: 'totalSize',
            id: 'id'
        }, [
            {name: 'id'},
            {name: 'code'},
            {name: 'name'}
        ])
    });

    var txQtitle = new Ext.form.TextField({
        width:80
    });

    var btnSearch = new Ext.Button({
        text: '查询',
        iconCls: 'search',
        handler: (function(){
            this.fpStore.on('beforeload', function(){
                Ext.apply(this.baseParams, {name: txQtitle.getValue().trim()});
            });
            this.fpStore.load({params: {start: 0, limit: 10}});
        }).createDelegate(this)
    });

    var btn2Left = new Ext.Button({
        iconCls: 'to-btn to-left-btn'
    });
    var btn2Right = new Ext.Button({
        iconCls: 'to-btn to-right-btn'
    });
    var btn2Right2 = new Ext.Button({
        iconCls: 'to-btn to-right-2-btn'
    });
    var btn2Left2 = new Ext.Button({
        iconCls: 'to-btn to-left-2-btn'
    });
    var btnSave = new Ext.Button({
        text: '保存',
        iconCls: 'finish',
        handler: (function() {
            this.save();
        }).createDelegate(this)
    });
    var btnToggle = new Ext.Button({
        text: '查看继承的扩展属性',
        iconCls: 'parent-extend-attr-btn',
        handler: (function(btn) {
            if(btn.currentStatus == 'view-self'){
                this.sfp.getStore().on('beforeload', function(){
                    //切换到查看继承扩展属性的URL
                    this.proxy.conn.url = 'product/category-list-parent-extend-attributes';
                });
                this.sfp.getStore().load({
                    params: {id: this.catId},
                    callback: function(r, opt, blSuccess){
                        if(blSuccess){  //禁用"保存"和"添加删除"按钮
                            btnSave.setDisabled(true);
                            this.eachBtn(function(el){
                               el.setDisabled(true);
                            });
                            btn.setIconClass('self-extend-attr-btn');
                            btn.setText('查看自己的扩展属性');

                            btn.currentStatus = 'view-parent';
                        }
                    },
                    scope: this
                });
            }else{
                this.sfp.getStore().on('beforeload', function(){
                    //切换到查看自身扩展属性的URL
                    this.proxy.conn.url = 'product/category-list-self-extend-attributes';
                });
                this.sfp.getStore().load({
                    params: {id: this.catId},
                    callback: function(r, opt, blSuccess){
                        if(blSuccess){  //启用"保存"和"添加删除"按钮
                            btnSave.setDisabled(false);
                            this.eachBtn(function(el){
                               el.setDisabled(false);
                            });
                            btn.setIconClass('parent-extend-attr-btn');
                            btn.setText('查看继承的扩展属性');

                            btn.currentStatus = 'view-self';
                        }
                    },
                    scope: this
                });
            }
        }).createDelegate(this)
    });
    btnToggle.currentStatus = 'view-self';
    

    this.fp = new Ext.grid.GridPanel({
        title: '可选扩展属性',
        columnWidth: .5,
        height: 300,
        ds: this.fpStore,
        columns: [
            {header: "编码", dataIndex: 'code', width: 130},
            {header: "名称", dataIndex: 'name', width: 130}
        ],
        sm: new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        autoScroll: true,
        tbar: ['名称', txQtitle, '-', btnSearch],
        bbar: new Ext.PagingToolbar({
            pageSize: 10,
            store: this.fpStore,
            displayInfo: true,
            displayMsg: '合计：{2}',
            emptyMsg: "没有记录！"
        })
    });

    this.sfp = new Ext.grid.GridPanel({
        title: '已选扩展属性',
        columnWidth: .5,
        ds: new Ext.data.Store({
            proxy: new Ext.data.HttpProxy({
                //url: 'product/category-show-extend-attributes'
                url: 'product/category-list-self-extend-attributes',
                method: 'GET'
            }),
            reader: new Ext.data.JsonReader({
                root: 'list',
                totalProperty: 'totalSize',
                id: 'id'
            }, [
               {name: 'id'},
               {name: 'code'},
               {name: 'name'}
            ])
        }),
        columns: [
            {header: "编码", dataIndex: 'code', width: 130},
            {header: "名称", dataIndex: 'name', width: 130}
        ],
        sm: new Ext.grid.RowSelectionModel({
            singleSelect:true
        }),
        autoScroll: true,
        tbar:[btnSave,'-',btnToggle]
    });

    this.win = new Ext.Window({
        title: '扩展属性设置 - ' + catName,
        width: 600,
        autoHeight: true,
        resizable: false,
        layout: 'column',
        plain: true,
        bodyStyle: 'padding:5px;',
        items: [this.fp, {
             id: 'split_bar',
             width: 23,
             border: false,
             layout: 'table',
             layoutConfig: {
                columns: 1
             },
             items: [
               {html: '<div class="x-toolbar" style="height:100px;"></div>'},
               btn2Left,
               {html: '<div class="x-toolbar" style="height:12px;"></div>'},
               btn2Right,
               {html: '<div class="x-toolbar" style="height:12px;"></div>'},
               btn2Left2,
               {html: '<div class="x-toolbar" style="height:12px;"></div>'},
               btn2Right2,
               {html: '<div class="x-toolbar" style="height:100px;"></div>'}
             ]
          }, this.sfp],
        modal: true
    });

    this.fp.getStore().load({
        params: {start: 0, limit: 10},
        callback: function(){
            this.win.show();
            this.sfp.setHeight(this.fp.getHeight());  //在firefox下要重新调整, 相当的郁闷啊
            this.win.getComponent('split_bar').setHeight(this.fp.getHeight());
            this.addEvent();

            //初始化已选择的扩展属性
            this.sfp.getStore().load({params: {id: this.catId}});
        },
        scope: this
    });

}

AttrOtherItemSelector.prototype = {
        /*
	addEvent: function(){
            this.eachBtnEl(function(el){
	   	  el.on('click', (function(event){
                       var btnEl = Ext.get(event.target);
	   	       if(btnEl.hasClass('to-right-btn')){    // >
	   	  	   this.addIf(this.fp.getSelectionModel().getSelected(), this.fp.getStore(), this.sfp.getStore());
	   	       }else if(btnEl.hasClass('to-right-2-btn')){  // >>
	   	  	   this.addIf(this.fp.getStore().getRange(), this.fp.getStore(), this.sfp.getStore());
	   	       }else if(btnEl.hasClass('to-left-btn')){ // <
	   	  	   this.remove(this.sfp.getSelectionModel().getSelected(), this.sfp.getStore());
	   	       }else{ // <<
	   	  	   this.remove(this.sfp.getStore().getRange(), this.sfp.getStore());
	   	       }
	   	  }).createDelegate(this));
	   });
           
        },*/

        addEvent: function(){
           this.eachBtn(function(btn){
                 btn.on('click', (function(_btn){
	   	       if(_btn.iconCls.indexOf('to-right-btn')>0){    // >
	   	  	   this.addIf(this.fp.getSelectionModel().getSelected(), this.fp.getStore(), this.sfp.getStore());
	   	       }else if(_btn.iconCls.indexOf('to-right-2-btn')>0){  // >>
	   	  	   this.addIf(this.fp.getStore().getRange(), this.fp.getStore(), this.sfp.getStore());
	   	       }else if(_btn.iconCls.indexOf('to-left-btn')>0){ // <
	   	  	   this.remove(this.sfp.getSelectionModel().getSelected(), this.sfp.getStore());
	   	       }else{ // <<
	   	  	   this.remove(this.sfp.getStore().getRange(), this.sfp.getStore());
	   	       }
	   	  }).createDelegate(this));
           });
        },

	addIf: function(records, src, dest){
           if(!records || records.length == 0)
	      return;
	   if(typeof records != 'Array')
              records = [].concat(records);
	   for(var i=0;i<records.length;i++){
	      if(!dest.getById(records[i].get('id'))){
                  dest.add(records[i]);
	      }
	   }
	},

        remove: function(records, src){
           if(!records || records.length == 0)
	      return;
	   if(typeof records != 'Array')
              records = [].concat(records);
           for(var i=0;i<records.length;i++){
	      src.remove(records[i]);
	   }
        },

        /**
         * 对split_bar的每个按钮调用函数
         *
         * @param fn  调用的函数
         *
         * @deprecated 实际操作的是按钮的Ext.Element对象
         * @see eachBtn(fn)
         */
	eachBtnEl: function(fn){
            this.win.getComponent('split_bar').getEl().select('button.to-btn').each(fn, this);
	},

        /**
         * 对split_bar的每个按钮调用函数
         *
         * @param fn  调用的函数
         * 
         */
        eachBtn: function(fn){
            Ext.each(this.win.getComponent('split_bar').findBy(function(cmp){
                return cmp.getXType() == 'button';
            }), fn, this);
        },

        /**
         * 保存商品类别的扩展属性
         *
         */
        save: function(){
            
            var sels = this.sfp.getStore().getRange();
            var strIds = '';   //保存的扩展属性ID，以','隔开
            if(sels && sels.length>0){
                for(var ii=0;ii<sels.length;ii++){
                   if(ii>0)
                      strIds += ',';
                   strIds += sels[ii].get('id');
                }
            }
                
            Ext.Ajax.request({
                url: 'product/category-extend-attribute-save',
                method: 'GET',
                params: 'id='+this.catId+'&extendAttrbiteIds='+strIds,
                success: function(resp){
                   var respText = Ext.util.JSON.decode(resp.responseText);
                   if(!respText)
                      return;
                   if(respText.success === true){
                      Ext.Msg.show({
                        title: '系统消息',
                        msg: '保存成功!',
                        buttons: {ok:'返回'},
                        fn: function(){
                            //TODO 刷新列表
                            this.win.close();
                            if(this.successFn){
                               this.successFn.call();
                            }
                        },
                        scope: this  //作用域为AttrOtherItemSelector类的对象
                      });
                   }else{
                      Ext.Msg.show({
                        title: '系统消息',
                        msg: '保存失败! '+ (respText.message || ''),
                        buttons: {ok:'返回'},
                        icon : Ext.Msg.ERROR
                      });
                  }
                },
                scope: this   //作用域为AttrOtherItemSelector类的对象
            });
        }
};


