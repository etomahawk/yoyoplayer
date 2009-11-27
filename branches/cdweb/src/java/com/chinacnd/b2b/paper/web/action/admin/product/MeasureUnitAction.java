/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.web.action.admin.product;

import com.chinacnd.b2b.paper.entities.product.MeasureUnit;
import com.chinacnd.b2b.paper.exception.ServiceException;
import com.chinacnd.b2b.paper.helper.form.admin.product.MeasureUnitForm;
import com.chinacnd.b2b.paper.helper.json.OperationResultJson;
import com.chinacnd.b2b.paper.helper.json.admin.product.MeasureUnitJson;
import com.chinacnd.b2b.paper.service.product.MeasureUnitService;
import com.chinacnd.framework.struts.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;

/**
 *
 * @author Hadeslee
 */
public class MeasureUnitAction extends BaseAction implements ModelDriven<MeasureUnitForm> {

    @Resource
    private MeasureUnitService measureUnitService;
    private MeasureUnitForm form = new MeasureUnitForm();

    @Action(value = "measure-unit-delete")
    public String delete() {
        OperationResultJson json = new OperationResultJson();
        try {
            measureUnitService.deleteById(form.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(null, ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
        }
        setJsonObject(json);
        return JSON_RESULT;
    }

    @Action(value = "measure-unit-save")
    public String save() {
        OperationResultJson json = new OperationResultJson();
        try {
            measureUnitService.save(form);
        } catch (ServiceException ex) {
            ex.printStackTrace();
            log.error(null, ex);
            json.setMessage(ex.getMessage());
            json.setSuccess(false);
        }
        setJsonObject(json);
        return JSON_RESULT;
    }

    @Action(value = "measure-unit-edit")
    public String edit() {
        MeasureUnit mu = measureUnitService.findById(form.getId());
        if (mu == null) {
            OperationResultJson json = new OperationResultJson();
            json.setSuccess(false);
            json.setMessage("编辑的计量单位非法");
            setJsonObject(json);
        } else {
            setJsonObject(new MeasureUnitJson(mu));
        }
        return JSON_RESULT;
    }

    @Action(value = "measure-unit-list")
    public String list() {
        List<MeasureUnit> list = measureUnitService.list(form);
        List<MeasureUnitJson> jsonList = new ArrayList<MeasureUnitJson>();
        for (MeasureUnit mu : list) {
            jsonList.add(new MeasureUnitJson(mu));
        }
        setJsonList(jsonList, form.getTotalSize());
        return JSON_RESULT;
    }

    public MeasureUnitForm getModel() {
        return form;
    }
}
