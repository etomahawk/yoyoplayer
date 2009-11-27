/**
 * 简单的表格控件封装
 *
 * @author shiyan.wu
 *
 *
 * @url            查询的url地址
 * @width          宽度
 * @height         高度
 * @pageSize       分页大小
 * @recordFn       结果集定义      required
 * @cm              显示列信息定义  required
 * @displayMsg     分页条提示信息
 * @emptyMsg       记录数为0的提示信息
 * @sm              SelectionModel定义
 * @editor         是否为可编辑GridPanel  boolean 默认false
 *
 */
Ext.namespace("SimpleGrid");
SimpleGrid.Panel = function(options){
    if(!options)
        options = [];

    var _url = options['url'];
    //this._originalUrl = _url;
    var _width = options['width'];
    var _pageSize = options['pageSize'] || Constants.psize;
    this.pageSize = _pageSize;
    var _recordFn = options['recordFn'];   //Record对象构造函数
    var _store = new Ext.data.Store({
        proxy: new Ext.data.HttpProxy({
            url: _url,
            method: 'GET'
        }),
        reader: new Ext.data.JsonReader({
            root: 'list',
            totalProperty: 'totalSize',
            id: 'id'
        }, _recordFn),
        remoteSort: true
    });
    _store._originalUrl = _url;   //保存最初的URL

    this.pagingBar = new Ext.PagingToolbar({
        pageSize: _pageSize,
        store: _store,
        displayInfo: true,
        displayMsg: options['displayMsg'] || '当前记录：{0} 至 {1} 合计：{2}',
        emptyMsg: options['emptyMsg'] || "没有符合条件的查询"
    });

    var gridConfig = {
        loadMask: {
            msg: '数据加载中...'
        },
        renderTo: options['renderTo'],
        iconCls: 'icon-grid',
        columns: options['cm'],
        ds: _store,
        enableColumnMove: false,
        trackMouseOver: false,
        border: true,
        height: options['height'] || Ext.get('content-panel').getHeight()-25,
        autoExpandColumn: options['autoExpandColumn'] || false,
        tbar: options['tbar'] || false,
        bbar: this.pagingBar
    };

    var extra = {};
    if(options['region'])
        extra['region'] = options['region'];
    if(options['layout'])
        extra['layout'] = options['layout'];
    if(options['autoWidth'] === true)
        extra['autoWidth'] = true;
    if(options['sm'])
        extra['sm'] = options['sm'];
    Ext.apply(gridConfig, extra);

    if(options['editor'] === true){
        this.grid = new Ext.grid.EditorGridPanel(gridConfig);
    }else{
        this.grid = new Ext.grid.GridPanel(gridConfig);
    }
    if(_width) this.grid.setWidth(_width);
    
}
SimpleGrid.Panel.prototype = {

    getStore: function(){
        return this.grid.getStore();
    },

    getSelectionModel : function() {
        return this.grid.getSelectionModel();
    },

    /*
     * 加载表格中用于显示的数据
     *
     * @param extraParams  查询条件 Object
     *         refreshCurrent   刷新当前页  boolean  false
     *
     * @param fn           回调函数
     * @param scope        回调函数作用域
     * 
     */
    load: function(extraParams, fn, scope){
        if(!extraParams)
            extraParams = {};
        if(extraParams['refreshCurrent'] === true){
            //重新设置为当前页面
            extraParams['start'] = this.pagingBar.cursor;
        }
        var objParam = Ext.apply({
                start: 0,
                limit: this.pageSize
            }, extraParams);
        this.getStore().load({
            params: objParam,
            callback: fn,
            scope: scope
        });
    },

    /**
     * 为表格的store绑定查询条件
     *
     */
    bindBaseParam: function(params){
        this.getStore().on('beforeload', function(){
            Ext.apply(this.baseParams, params);
        });
    },

    /**
     * 一个比较变态的要求：改变URL
     * 清空store中绑定的所有的请求参数
     * 用完记得调用resetUrl()重置回最初的URL
     *
     * @param newUrl  新的URL
     */
    changeUrl: function(newUrl){
        this.getStore().on('beforeload', function(){
            this.proxy.conn.url = newUrl;
            this.baseParams = {};
        })
    },
    /**
     * 重置回最初的URL
     * 
     */
    resetUrl: function(){
        this.getStore().on('beforeload', function(){
            this.proxy.conn.url = this._originalUrl;
        });
    },

    removeAll: function(){
        this.getStore().removeAll();
    },

    /**
     * 修改记录前返回选中的单条记录
     *
     * @return Record
     */
    getSelectionForEdit: function(){
        var sels = this.grid.getSelectionModel().getSelections();
        if(sels.length==0 || sels.length>1){
            Ext.Msg.alert('系统消息', '请选择需要修改的记录，只能修改单条记录!');
            return false;
        }
        return sels[0];
    }
    
}
