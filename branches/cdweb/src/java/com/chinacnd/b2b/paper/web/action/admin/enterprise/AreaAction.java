/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.web.action.admin.enterprise;

import com.chinacnd.b2b.paper.entities.enterprise.Area;
import com.chinacnd.b2b.paper.exception.ServiceException;
import com.chinacnd.b2b.paper.helper.form.admin.enterprise.AreaForm;
import com.chinacnd.b2b.paper.helper.json.OperationResultJson;
import com.chinacnd.b2b.paper.helper.json.TreeJson;
import com.chinacnd.b2b.paper.helper.json.admin.enterprise.AreaJson;
import com.chinacnd.b2b.paper.service.enterprise.AreaService;
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
public class AreaAction extends BaseAction implements ModelDriven<AreaForm> {

    private AreaForm form = new AreaForm();
    @Resource
    private AreaService areaService;

    /*
     * 返回树JSON
     */
    @Action(value = "area-tree")
    public String treeArea() {
        List<Area> areaList = null;
        List<TreeJson> treeJsonList = new ArrayList<TreeJson>();
        //判断是否为根节点
        if (form.getParentAreaID() == -1) {
            areaList = areaService.loadRootList();
        } else {
            areaList = areaService.loadListByParentAreaID(form.getParentAreaID());
        }
        for (Area area : areaList) {
            TreeJson treeJson = new TreeJson();
            treeJson.setId(String.valueOf(area.getId()));
            treeJson.setText(area.getName());
            //看看是否有待优化
            List<Area> tmpAreaList = areaService.loadListByParentAreaID(area.getId());
            treeJson.setLeaf(tmpAreaList.size() == 0);

            treeJsonList.add(treeJson);
        }
        setJsonTree(treeJsonList);
        return JSON_RESULT;
    }

    @Action(value = "area-list")
    public String loadAreas() {
        List<Area> areaList = null;
        if (form.getParentAreaID() == -1) {
            areaList = areaService.loadRootList(form);
        } else {
            areaList = areaService.loadListByParentAreaID(form.getParentAreaID(), form);
        }
        List<AreaJson> list = new ArrayList<AreaJson>();
        for (Area area : areaList) {
            list.add(new AreaJson(area));
        }
        setJsonList(list, form.getTotalSize());
        return JSON_RESULT;
    }

    @Action(value = "area-save")
    public String saveArea() {
        OperationResultJson operationResult = new OperationResultJson();
        try {
            areaService.saveArea(form);
            operationResult.setSuccess(true);
        } catch (ServiceException e) {
            operationResult.setSuccess(false);
            operationResult.setMessage(e.getMessage());
        }
        setJsonObject(operationResult);
        return JSON_RESULT;
    }

    @Action(value = "area-update")
    public String updateArea() {
        OperationResultJson operationResult = new OperationResultJson();
        areaService.updateArea(form);
        operationResult.setSuccess(true);
        setJsonObject(operationResult);
        return JSON_RESULT;
    }

    @Action(value = "area-delete")
    public String deleteAreas() {
        OperationResultJson operationResult = new OperationResultJson();
        try {
            areaService.deleteArea(form);
            operationResult.setSuccess(true);
        } catch (ServiceException e) {
            operationResult.setSuccess(false);
            operationResult.setMessage(e.getMessage());
        }
        setJsonObject(operationResult);
        return JSON_RESULT;
    }

    public AreaForm getModel() {
        return form;
    }
}
