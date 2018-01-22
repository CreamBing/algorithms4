package com.bing.algorithms4.fundamentals.programming_model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhaobing on 2018/1/22
 */
public class TestInterger {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: main(String[] args)
     *
     */
    @Test
    public void testInterger() throws Exception {
        Integer a = new Integer(10);
        Integer b = new Integer(10);
        System.out.println(a.equals(b)); //true
        System.out.println(a == b); //false
        Integer c = Integer.valueOf("10");
        Integer d = Integer.valueOf("10");
        System.out.println(c.equals(d)); //true
        System.out.println(c == d); //true
        Assert.assertEquals(a,b);
    }
}
