/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.web.action.admin.enterprise;

import com.chinacnd.b2b.paper.exception.ServiceException;
import com.chinacnd.b2b.paper.helper.json.OperationResultJson;
import com.chinacnd.b2b.paper.entities.enterprise.Enterprise;
import com.chinacnd.b2b.paper.helper.form.admin.enterprise.EnterpriseForm;
import com.chinacnd.b2b.paper.helper.json.admin.enterprise.EnterpriseJson;
import com.chinacnd.b2b.paper.service.enterprise.EnterpriseService;
import com.chinacnd.framework.struts.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.Action;

/**
 *
 * @author Genius
 */
public class EnterpriseAction extends BaseAction implements ModelDriven<EnterpriseForm> {

    private EnterpriseForm form = new EnterpriseForm();
    @Resource
    private EnterpriseService enterpriseService;

    @Action(value = "enterprise-list")
    public String loadEnterpriseList() {
        List<EnterpriseJson> enterpriseJsonList = new ArrayList<EnterpriseJson>();
        List<Enterprise> enterpriseList = enterpriseService.loadListByAreaFullCode(form);
        for (Enterprise enterprise : enterpriseList) {
            enterpriseJsonList.add(new EnterpriseJson(enterprise));
        }
        setJsonList(enterpriseJsonList, form.getTotalSize());
        return JSON_RESULT;
    }

    @Action(value = "enterprise-save")
    public String saveEnterprise() {
        OperationResultJson operationResult = new OperationResultJson();
        try {
            enterpriseService.saveEnterprise(form);
            operationResult.setSuccess(true);
        } catch (ServiceException e) {
            operationResult.setSuccess(false);
            operationResult.setMessage(e.getMessage());
        }

        setJsonObject(operationResult);
        return JSON_RESULT;
    }

    @Action(value = "enterprise-update")
    public String updateEnterprise() {
        OperationResultJson operationResult = new OperationResultJson();
        try {
            enterpriseService.updateEnterprise(form);
            operationResult.setSuccess(true);
        } catch (ServiceException e) {
            operationResult.setSuccess(false);
            operationResult.setMessage(e.getMessage());
        }

        setJsonObject(operationResult);
        return JSON_RESULT;
    }

    @Action(value = "enterprise-delete")
    public String deleteEnterprise() {
        OperationResultJson operationResult = new OperationResultJson();
        enterpriseService.deleteEnterprise(form);
        operationResult.setSuccess(true);
        setJsonObject(operationResult);
        return JSON_RESULT;
    }

    public EnterpriseForm getModel() {
        return form;
    }
}
