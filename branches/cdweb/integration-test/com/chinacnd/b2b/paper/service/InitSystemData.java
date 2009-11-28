/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.service;

import com.chinacnd.b2b.paper.entities.common.ValueType;
import com.chinacnd.b2b.paper.entities.product.Category;
import com.chinacnd.b2b.paper.entities.product.CategoryType;
import com.chinacnd.b2b.paper.entities.product.CoreAttribute;
import com.chinacnd.b2b.paper.entities.product.CoreAttributeType;
import com.chinacnd.b2b.paper.entities.product.ExtendAttribute;
import com.chinacnd.b2b.paper.entities.product.MeasureUnit;
import com.chinacnd.b2b.paper.entities.product.Paper;
import com.chinacnd.b2b.paper.entities.product.Pulp;
import com.chinacnd.b2b.paper.entities.user.AdminUser;
import com.chinacnd.b2b.paper.entities.user.Gender;
import com.chinacnd.framework.db.DataAccess;
import com.chinacnd.framework.util.MD5;
import com.chinacnd.integration.test.BaseTest;
import java.util.Date;
import java.util.Random;
import javax.annotation.Resource;

/**
 * 初始化系统的一些测试用数据
 * 调用此类之前要确定数据库是刚刚建的
 * 里面一条数据也没有
 * @author Hadeslee
 */
public class InitSystemData extends BaseTest {

    @Resource
    private DataAccess dataAccess;

    public void testAddAdminUser() {
        AdminUser user = new AdminUser();
        user.setAddress("北京东路339号");
        user.setDescription("测试用户");
        user.setEmail("hadeslee@vip.qq.com");
        user.setEnabled(true);
        user.setFax("3339887");
        user.setFullname("千里冰封");
        user.setGender(Gender.MALE);
        user.setPassword(MD5.digest("admin"));
        user.setPostcode("330029");
        user.setTelephone("15959285230");
        user.setUsername("admin");
        dataAccess.save(user);
        setComplete();
    }

    public void testAddCategory() {
        Category c1 = new Category();
        c1.setCode("001");
        c1.setDescription("纸张的顶级分类");
        c1.setLastUpdateDate(new Date());
        c1.setLeaf(false);
        c1.setName("纸张");
        c1.setType(CategoryType.PAPER);

        Category c2 = new Category();
        c2.setCode("002");
        c2.setDescription("纸浆的顶级分类");
        c2.setLastUpdateDate(new Date());
        c2.setLeaf(false);
        c2.setName("纸浆");
        c2.setType(CategoryType.PULP);

        dataAccess.save(c1);
        dataAccess.save(c2);
        c1.setFullCode(String.valueOf(c1.getId()));
        c2.setFullCode(String.valueOf(c2.getId()));
        setComplete();
    }

    public void testAddProduct() {
        for (int i = 0; i < 100; i++) {
            Paper p1 = new Paper();
            p1.setProductName("雪山白凤凰" + i);
            p1.setBrand("firebird" + i);
            p1.setGrammage("100" + i);
            p1.setGrade("22" + i);
            p1.setSpec("大只" + i);
            p1.setGrade("300级" + i);
            p1.setNetCode("10000" + i);
            p1.setCode("08900_x" + i);
            p1.setFullName("超级无敌火鸟" + i);
            p1.setGtinNumber("gggggg" + i);
            p1.setSupplierCode("ooiiee" + i);
            p1.setSupplierName("日光岩" + i);
            p1.setSupplierNumber("xxxxx11" + i);
            p1.setDescription("这就是描述" + i);
            p1.setCategory(null);
            dataAccess.save(p1);
        }
        for (int i = 0; i < 100; i++) {
            Pulp p1 = new Pulp();
            p1.setPulpTechnics("印染" + i);
            p1.setBrand("firebird" + i);
            p1.setBleachTechnics("水洗" + i);
            p1.setGrade("22" + i);
            p1.setFibresource("丽白" + i);
            p1.setGrade("100级" + i);
            p1.setNetCode("10000" + i);
            p1.setCode("08900_x" + i);
            p1.setFullName("超级马丽" + i);
            p1.setGtinNumber("gggggg" + i);
            p1.setSupplierCode("ooiiee" + i);
            p1.setSupplierName("Konami" + i);
            p1.setSupplierNumber("xxxxx11" + i);
            p1.setDescription("desc1" + i);
            p1.setCategory(null);
            dataAccess.save(p1);
        }
        setComplete();
    }

    public void testAddCoreAttributes() {
        for (int i = 0; i < 10; i++) {
            CoreAttribute c = new CoreAttribute();
            c.setAttributeType(CoreAttributeType.values()[new Random().nextInt(3)]);
            c.setCode("1222" + i);
            c.setDefaultValue("Hello" + i);
            c.setDescription("World" + i);
            c.setMaxLength(10 + i);
            c.setName("基属名" + i);
            c.setPropertyName("PropertyName" + i);
            c.setValueType(ValueType.values()[new Random().nextInt(3)]);
            dataAccess.save(c);
        }
        setComplete();
    }

    public void testAddExtendAttributes() {
        for (int i = 0; i < 20; i++) {
            ExtendAttribute e = new ExtendAttribute();
            e.setCode("1333" + i);
            e.setDefaultValue("DefaultValue" + i);
            e.setDescription("这就是描述，哈哈" + i);
            e.setEnabled(new Random().nextInt(10) > 3);
            e.setMaxLength(30 + i);
            e.setName("扩属" + i);
            e.setValueType(ValueType.values()[new Random().nextInt(3)]);
            dataAccess.save(e);
        }
        setComplete();
    }

    public void testAddMeasureUnits() {
        String[] names = {"吨", "令", "件", "包", "张", "捆"};
        for (int i = 0; i < names.length; i++) {
            MeasureUnit mu = new MeasureUnit();
            mu.setBenchmark(i == 0);
            mu.setCode("1444" + i);
            mu.setDescription("计量单位的备注，哈哈哈哈" + i);
            mu.setEnabled(true);
            mu.setName(names[i]);
            dataAccess.save(mu);
        }
        setComplete();
    }
}
