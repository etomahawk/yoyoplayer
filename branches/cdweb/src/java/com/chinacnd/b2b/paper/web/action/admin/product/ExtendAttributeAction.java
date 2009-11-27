/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.web.action.admin.product;

import com.chinacnd.b2b.paper.entities.product.ExtendAttribute;
import com.chinacnd.b2b.paper.exception.ServiceException;
import com.chinacnd.b2b.paper.helper.form.admin.product.ExtendAttributeForm;
import com.chinacnd.b2b.paper.helper.json.OperationResultJson;
import com.chinacnd.b2b.paper.helper.json.admin.product.ExtendAttributeJson;
import com.chinacnd.b2b.paper.service.product.ExtendAttributeService;
import com.chinacnd.framework.struts.BaseAction;
import com.chinacnd.framework.util.StringUtils;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;

/**
 *
 * @author Hadeslee
 */
public class ExtendAttributeAction extends BaseAction implements ModelDriven<ExtendAttributeForm> {

    private ExtendAttributeForm form = new ExtendAttributeForm();
    @Resource
    private ExtendAttributeService extendAttributeService;

    @Action(value = "extend-attribute-list")
    public String list() {
        List<ExtendAttribute> temp = extendAttributeService.getExtendAttributesByName(form);
        List<ExtendAttributeJson> jsons = new ArrayList<ExtendAttributeJson>();
        for (ExtendAttribute extendAttribute : temp) {
            jsons.add(new ExtendAttributeJson(extendAttribute));
        }
        setJsonList(jsons, form.getTotalSize());
        return JSON_RESULT;
    }

    @Action(value = "extend-attribute-edit")
    public String edit() {
        ExtendAttribute extendAttribute = extendAttributeService.findById(form.getId());
        if (extendAttribute == null) {
            OperationResultJson json = new OperationResultJson();
            json.setSuccess(false);
            json.setMessage("编码的扩展属性非法");
            setJsonObject(json);
        } else {
            setJsonObject(new ExtendAttributeJson(extendAttribute));
        }
        return JSON_RESULT;
    }

    @Action(value = "extend-attribute-save")
    public String save() throws Exception {
        OperationResultJson operationResult = new OperationResultJson();
        if (form.getMaxLength() <= 0) {
            operationResult.setSuccess(false);
            operationResult.setMessage("属性长度只允许输入正整数");
        } else {
            try {
                extendAttributeService.save(form);
            } catch (ServiceException ex) {
                log.error(null, ex);
                operationResult.setSuccess(false);
                operationResult.setMessage(ex.getMessage());
            }
        }
        setJsonObject(operationResult);
        return JSON_RESULT;
    }

    @Action(value = "extend-attribute-delete")
    public String delete() {
        OperationResultJson operationResult = new OperationResultJson();
        String[] temp = StringUtils.split(form.getDeleteIds(), ",");
        Long[] ids = new Long[temp.length];
        try {
            for (int i = 0; i < temp.length; i++) {
                ids[i] = Long.valueOf(temp[i]);
            }
            extendAttributeService.deleteByIds(ids);
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(null, ex);
            operationResult.setSuccess(false);
            operationResult.setMessage(ex.getMessage());
        }
        setJsonObject(operationResult);
        return JSON_RESULT;
    }

    public ExtendAttributeForm getModel() {
        return form;
    }
}
