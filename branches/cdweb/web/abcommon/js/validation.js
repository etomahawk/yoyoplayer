/**
 * 自定义验证规则
 *
 * @author: shiyan.wu
 *
 */
Ext.namespace("ValidationRule");

ValidationRule.errorText = {
    empty: '不允许为空,请重新输入'
}

/**
 * 验证：编码
 * 使用场景：扩展属性
 *
 * 规则：允许输入字母、数字、下划线
 */
Ext.apply(Ext.form.VTypes,{
    "code":  Ext.form.VTypes.alphanum,
    "codeText": '编码只允许输入字母、数字和下划线,请重新输入'
});

/**
 * 验证：名称
 * 使用场景：扩展属性
 *
 * 规则：允许输入中文字符、字母、数字、下划线
 */
Ext.apply(Ext.form.VTypes,{
    "name":function(_v){
        if(/^[a-zA-Z0-9_\u4e00-\u9fa5]+$/.test(_v)){
            return true;
        }
        return false;
    },
    "nameText": '名称只允许输入字母、数字、下划线以及汉字,请重新输入'
});

/**
 * 验证：最大长度
 * 使用场景：扩展属性
 *
 * 规则：允许输入正整数
 */
Ext.apply(Ext.form.VTypes,{
    "maxlength":function(_v){
        if(/^[1-9][0-9]*$/.test(_v)){
            return true;
        }
        return false;
    },
    "maxlengthText": '最大长度只允许输入正整数,请重新输入'
});

/**
 * 验证：默认值
 * 使用场景：扩展属性
 *
 * 规则：默认值要根据属性类型来决定其验证规则
 *      属性类型有3种：字符、数字、日期
 */
Ext.apply(Ext.form.VTypes,{
    "defaultvalue":function(_v, _field){
        if(_field.relateTo){    //relateTo是我们自定义的配置参数，一般用来保存另外的组件的id值
            var _rlField = Ext.get(_field.relateTo);   //取得relateTo的那个id的值
            var _rlV = _rlField.getValue();
            this._rlType = _rlV;
            if(_rlV == 'STRING'){
               return /^[a-zA-Z0-9_\u4e00-\u9fa5]+$/.test(_v);
            }else if(_rlV == 'NUMBER'){
               return /^[1-9][0-9]*$/.test(_v);
            }else{
               return /^([0-9]{1,2})[./]{1}([0-9]{1,2})[./]{1}([0-9]{4})$/.test(_v)
            }
        }
        return true;
    },
    "defaultvalueText": '默认值必须根据选择的属性类型来输入'
});