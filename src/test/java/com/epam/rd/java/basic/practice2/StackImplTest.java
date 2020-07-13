package com.epam.rd.java.basic.practice2;

import org.junit.Assert;
import org.junit.Test;

public class StackImplTest {

    @Test
    public void CheckTop() {
        StackImpl stack=new StackImpl();
        stack.push(34);
        stack.push(56);
        Object s=stack.top();
        Assert.assertEquals(56,s);
    }

}
