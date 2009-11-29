/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.web.action.admin.product;

import com.chinacnd.b2b.paper.entities.product.ExtendAttributeValue;
import com.chinacnd.b2b.paper.entities.product.Paper;
import com.chinacnd.b2b.paper.entities.product.Product;
import com.chinacnd.b2b.paper.entities.product.Pulp;
import com.chinacnd.b2b.paper.exception.ServiceException;
import com.chinacnd.b2b.paper.helper.form.admin.product.ExtendAttributeValueForm;
import com.chinacnd.b2b.paper.helper.form.admin.product.PaperForm;
import com.chinacnd.b2b.paper.helper.form.admin.product.ProductForm;
import com.chinacnd.b2b.paper.helper.form.admin.product.ProductUnitSettingForm;
import com.chinacnd.b2b.paper.helper.form.admin.product.PulpForm;
import com.chinacnd.b2b.paper.helper.json.OperationResultJson;
import com.chinacnd.b2b.paper.helper.json.admin.product.ExtendAttributeValueJson;
import com.chinacnd.b2b.paper.helper.json.admin.product.PaperJson;
import com.chinacnd.b2b.paper.helper.json.admin.product.ProductJson;
import com.chinacnd.b2b.paper.helper.json.admin.product.ProductUnitSettingJson;
import com.chinacnd.b2b.paper.helper.json.admin.product.PulpJson;
import com.chinacnd.b2b.paper.service.product.ProductService;
import com.chinacnd.framework.struts.BaseAction;
import com.chinacnd.framework.struts.ResultType;
import com.chinacnd.framework.util.CollectionUtils;
import com.chinacnd.framework.util.FileUtils;
import com.chinacnd.framework.util.StringUtils;
import com.chinacnd.framework.util.UUIDUtils;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.inject.Inject;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author Hadeslee
 */
public class ProductAction extends BaseAction implements ModelDriven<ProductForm> {

    @Resource
    private ProductService productService;
    private ProductForm form = new ProductForm();
    private PaperForm paper = new PaperForm();
    private PulpForm pulp = new PulpForm();
    private List<ExtendAttributeValueForm> extendAttributeValues = new ArrayList<ExtendAttributeValueForm>();
    private List<ProductUnitSettingForm> productUnitSettings = new ArrayList<ProductUnitSettingForm>();
    private Long productId;//做为传值用
    private File imgFile;//上传的图片文件
    private String fileName;//上传的文件名
    private String contentType;//内容格式
    private Map<String, String> uploadJsonRoot;
    private List<String> allowedImgs;//允许上传的文件后缀

    @Action(value = "product-upload-image", results = {
        @Result(type = ResultType.json, name = "upload",
        params = {"contentType", "text/html", "root", "uploadJsonRoot"})
    })
    public String uploadImage() {
        uploadJsonRoot = new HashMap<String, String>();
        String reason = checkFile();
        if (reason == null) {
            String url = saveFile();
            uploadJsonRoot.put("thumbnailUrl", url);
            uploadJsonRoot.put("success", "true");
            uploadJsonRoot.put("timeout", "false");
        } else {
            uploadJsonRoot.put("success", "false");
            uploadJsonRoot.put("timeout", "false");
            uploadJsonRoot.put("message", reason);
        }
        return "upload";
    }

    /**
     * 把上传过来的图片文件保存起来，并返回
     * 对应的访问URL
     * @return 图片可访问URL
     */
    private String saveFile() {
        log.info("fileName=" + fileName);
        log.info("contentType=" + contentType);
        String path = ServletActionContext.getServletContext().getRealPath("/");
        String url = "/productImages/" + UUIDUtils.uuid() + "." + FileUtils.getExtention(fileName);
        FileUtils.copy(imgFile, path + url);
        return url;
    }

    @Inject(value = "com.chinacnd.allowed.images")
    public void setAllowsImage(String s) {
        allowedImgs = CollectionUtils.makeList(StringUtils.split(s, ","));
    }

    /**
     * 检查文件是否合法
     * 比如文件的后缀等等，因为文件格式很重要
     * @return 错误信息，如果有的话
     */
    private String checkFile() {
        if (imgFile == null) {
            return "上传的文件为空";
        } else {
            String ext = FileUtils.getExtention(fileName);
            boolean find = false;
            for (String s : allowedImgs) {
                if (s.equalsIgnoreCase(ext)) {
                    find = true;
                    break;
                }
            }
            if (find == false) {
                return "上传的文件格式非法:" + ext;
            }
        }
        return null;
    }

    @Action(value = "product-list-measure-units")
    public String listProductMeasureUnits() {
        try {
            List<ProductUnitSettingJson> jsonList = productService.getProductUnitSettings(form);
            setJsonList(jsonList, form.getTotalSize());
        } catch (ServiceException ex) {
            ex.printStackTrace();
            log.error(null, ex);
            OperationResultJson json = new OperationResultJson();
            json.setMessage(ex.getMessage());
            json.setSuccess(false);
            setJsonObject(json);
        }
        return JSON_RESULT;
    }

    @Action(value = "product-save-measure-units",
    interceptorRefs = {@InterceptorRef("json"), @InterceptorRef("adminDefault")})
    public String saveProductMeasureUnits() {
        OperationResultJson json = new OperationResultJson();
        try {
            productService.saveProductUnitSettings(productId, productUnitSettings);
        } catch (ServiceException ex) {
            ex.printStackTrace();
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
        }
        setJsonObject(json);
        return JSON_RESULT;
    }

    @Action(value = "product-list-without-category")
    public String listWithoutCategory() {
        List<Product> list = productService.findProductsWithoutCategory(form);
        List<ProductJson> jsonList = new ArrayList<ProductJson>();
        for (Product product : list) {
            jsonList.add(new ProductJson(product));
        }
        setJsonList(jsonList, form.getTotalSize());
        return JSON_RESULT;
    }

    @Action(value = "product-list-by-category")
    public String listByCategory() {
        List<Product> list = productService.findByCategoryId(form);
        List<ProductJson> jsonList = new ArrayList<ProductJson>();
        for (Product product : list) {
            jsonList.add(new ProductJson(product));
        }
        setJsonList(jsonList, form.getTotalSize());
        return JSON_RESULT;
    }

    @Action(value = "product-list-base-attributes")
    public String listBaseAttributes() {
        try {
            Product product = productService.getValidProduct(form.getId());
            Object json = null;
            if (product instanceof Paper) {
                json = new PaperJson((Paper) product);
            } else if (product instanceof Pulp) {
                json = new PulpJson((Pulp) product);
            } else {
                OperationResultJson rJson = new OperationResultJson();
                rJson.setSuccess(false);
                rJson.setMessage("只能编辑纸张或者纸浆的属性");
                json = rJson;
            }
            setJsonObject(json);
        } catch (ServiceException ex) {
            ex.printStackTrace();
            OperationResultJson json = new OperationResultJson();
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            setJsonObject(json);
        }
        return JSON_RESULT;
    }

    @Action(value = "product-list-extend-attributes")
    public String listExtendAttributes() {
        try {
            List<ExtendAttributeValue> list = productService.getExtendAttributeValuesById(form.getId());
            List<ExtendAttributeValueJson> jsonList = new ArrayList<ExtendAttributeValueJson>();
            for (ExtendAttributeValue value : list) {
                jsonList.add(new ExtendAttributeValueJson(value));
            }
            setJsonList(jsonList);
        } catch (ServiceException ex) {
            ex.printStackTrace();
            log.error(null, ex);
            OperationResultJson json = new OperationResultJson();
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            setJsonObject(json);
        }
        return JSON_RESULT;
    }

    @Action(value = "product-get-category-tree-path")
    public String getCategoryTreePath() {
        try {
            final String path = productService.getCategoryTreePath(form);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("path", path);
            setJsonMap(map);
        } catch (ServiceException ex) {
            log.error(null, ex);
            OperationResultJson json = new OperationResultJson();
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
            setJsonObject(json);
        }
        return JSON_RESULT;
    }

    @Action(value = "product-change-category")
    public String changeCategory() {
        OperationResultJson json = new OperationResultJson();
        try {
            productService.changeProductCategory(form);
        } catch (ServiceException ex) {
            log.error(null, ex);
            json.setSuccess(false);
            json.setMessage(ex.getMessage());
        }
        setJsonObject(json);
        return JSON_RESULT;
    }

    @Action(value = "product-save-paper-base-attributes")
    public String savePaperBaseAttributes() {
        System.out.println("xxx " + getPaper().getDescription());
        productService.saveCoreAttributeOfPaper(getPaper());
        setJsonObject(new OperationResultJson());
        return JSON_RESULT;
    }

    @Action(value = "product-save-pulp-base-attributes")
    public String savePulpBaseAttributes() {
        productService.saveCoreAttributeOfPulp(getPulp());
        setJsonObject(new OperationResultJson());
        return JSON_RESULT;
    }

    @Action(value = "product-save-extend-attributes",
    interceptorRefs = {@InterceptorRef("json"), @InterceptorRef("adminDefault")})
    public String saveExtendAttributeValues() {
        OperationResultJson json = new OperationResultJson();
        try {
            productService.saveExtendAttribute(productId, extendAttributeValues);
        } catch (Exception ex) {
            ex.printStackTrace();
            json.setMessage(ex.getMessage());
            json.setSuccess(false);
        }
        setJsonObject(json);
        return JSON_RESULT;
    }

    public void setPaper(PaperForm paper) {
        this.paper = paper;
    }

    public void setPulp(PulpForm pulp) {
        this.pulp = pulp;
    }

    public void setExtendAttributeValues(List<ExtendAttributeValueForm> extendAttributeValues) {
        this.extendAttributeValues = extendAttributeValues;
    }

    public void setProductUnitSettings(List<ProductUnitSettingForm> productUnitSettings) {
        this.productUnitSettings = productUnitSettings;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductForm getModel() {
        return form;
    }

    public PaperForm getPaper() {
        return paper;
    }

    public PulpForm getPulp() {
        return pulp;
    }

    public void setImgFile(File imgFile) {
        this.imgFile = imgFile;
    }

    public void setImgFileContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setImgFileFileName(String fileName) {
        this.fileName = fileName;
    }

    public Map<String, String> getUploadJsonRoot() {
        return uploadJsonRoot;
    }
}
