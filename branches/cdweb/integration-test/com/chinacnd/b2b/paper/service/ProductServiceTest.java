/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.service;

import com.chinacnd.b2b.paper.entities.product.Category;
import com.chinacnd.b2b.paper.entities.product.CategoryType;
import com.chinacnd.b2b.paper.entities.product.Paper;
import com.chinacnd.b2b.paper.entities.product.Pulp;
import com.chinacnd.b2b.paper.helper.form.admin.product.CategoryForm;
import com.chinacnd.b2b.paper.service.product.CategoryService;
import com.chinacnd.b2b.paper.service.product.ProductService;
import com.chinacnd.framework.db.DataAccess;
import com.chinacnd.integration.test.BaseTest;
import javax.annotation.Resource;
import org.junit.Test;

/**
 *
 * @author Hadeslee
 */
public class ProductServiceTest extends BaseTest {

    @Resource
    private ProductService productService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private DataAccess dataAccess;

    @Test
    public void testFindProduct() {
        Category c1 = new Category();
        c1.setCode("123");
        c1.setName("纸张");
        c1.setType(CategoryType.PAPER);
        Category c2 = new Category();
        c2.setCode("222");
        c2.setName("纸浆");
        c2.setType(CategoryType.PULP);
    }

    @Test
    public void testAddProduct() {
        for (int i = 0; i < 100; i++) {
            Paper p1 = new Paper();
            p1.setProductName("雪山白凤凰"+i);
            p1.setBrand("firebird");
            p1.setGrammage("100");
            p1.setGrade("22");
            p1.setSpec("大只");
            p1.setGrade("300级");
            p1.setNetCode("10000");
            p1.setCode("08900_x"+i);
            p1.setFullName("超级无敌火鸟"+i);
            p1.setGtinNumber("gggggg");
            p1.setSupplierCode("ooiiee");
            p1.setSupplierName("日光岩");
            p1.setSupplierNumber("xxxxx11");
            p1.setDescription("desc1");
            p1.setCategory(null);
            dataAccess.save(p1);
        }
        for (int i = 0; i < 100; i++) {
            Pulp p1 = new Pulp();
            p1.setPulpTechnics("印染");
            p1.setBrand("firebird");
            p1.setBleachTechnics("水洗");
            p1.setGrade("22");
            p1.setFibresource("丽白");
            p1.setGrade("100级");
            p1.setNetCode("10000");
            p1.setCode("08900_x"+i);
            p1.setFullName("超级马丽"+i);
            p1.setGtinNumber("gggggg");
            p1.setSupplierCode("ooiiee");
            p1.setSupplierName("Konami");
            p1.setSupplierNumber("xxxxx11");
            p1.setDescription("desc1");
            p1.setCategory(null);
            dataAccess.save(p1);
        }
        setComplete();
        
    }
}
