/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.b2b.paper.service;

import com.chinacnd.b2b.paper.entities.product.Category;
import com.chinacnd.b2b.paper.entities.product.CategoryType;
import com.chinacnd.framework.db.DataAccess;
import com.chinacnd.integration.test.BaseTest;
import java.util.Date;
import javax.annotation.Resource;
import org.junit.Test;

/**
 *
 * @author Hadeslee
 */
public class CategoryServiceTest extends BaseTest {

    @Resource
    private DataAccess dataAccess;

    @Test
    public void testAddCategory() {
        Category c1 = new Category();
        c1.setCode("001");
        c1.setDescription("纸张的分类");
        c1.setFullCode("001");
        c1.setLastUpdateDate(new Date());
        c1.setLeaf(false);
        c1.setName("纸张");
        c1.setType(CategoryType.PAPER);

        Category c2 = new Category();
        c2.setCode("002");
        c2.setDescription("纸浆的分类");
        c2.setFullCode("002");
        c2.setLastUpdateDate(new Date());
        c2.setLeaf(false);
        c2.setName("纸浆");
        c2.setType(CategoryType.PULP);
        dataAccess.save(c1);
        dataAccess.save(c2);
    }
}
