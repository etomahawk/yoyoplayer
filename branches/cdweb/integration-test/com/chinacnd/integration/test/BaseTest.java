/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chinacnd.integration.test;

import org.springframework.test.AbstractTransactionalSpringContextTests;

/**
 * 所有集成测试的父类
 * @author Hadeslee
 */
public abstract class BaseTest extends AbstractTransactionalSpringContextTests {

    @Override
    protected String[] getConfigLocations() {
        return new String[]{"/spring.xml"};
    }
}
