/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.web.action.admin.product;

import com.chinacnd.b2b.paper.entities.product.CoreAttribute;
import com.chinacnd.b2b.paper.helper.form.admin.product.CoreAttributeForm;
import com.chinacnd.b2b.paper.helper.json.admin.product.CoreAttributeJson;
import com.chinacnd.b2b.paper.service.product.CoreAttributeService;
import com.chinacnd.framework.struts.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

/**
 *
 * @author Hadeslee
 */
public class CoreAttributeAction extends BaseAction implements ModelDriven<CoreAttributeForm> {

    private CoreAttributeForm form = new CoreAttributeForm();
    @Resource
    private CoreAttributeService coreAttributeService;

    public String execute() {
        List<CoreAttribute> temp = coreAttributeService.getCoreAttribute(form);
        List<CoreAttributeJson> list = new ArrayList<CoreAttributeJson>();
        for (CoreAttribute c : temp) {
            list.add(new CoreAttributeJson(c));
        }
        setJsonList(list, form.getTotalSize());
        return JSON_RESULT;
    }

    public CoreAttributeForm getModel() {
        return form;
    }
}
