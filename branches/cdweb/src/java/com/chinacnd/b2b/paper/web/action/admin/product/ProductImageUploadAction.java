/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.web.action.admin.product;

import com.chinacnd.framework.struts.BaseAction;
import com.chinacnd.framework.struts.ResultType;
import com.chinacnd.framework.util.CollectionUtils;
import com.chinacnd.framework.util.FileUtils;
import com.chinacnd.framework.util.StringUtils;
import com.chinacnd.framework.util.UUIDUtils;
import com.opensymphony.xwork2.inject.Inject;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 * 专门用来上传产品图片的action
 * @author Hadeslee
 */
public class ProductImageUploadAction extends BaseAction {

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
