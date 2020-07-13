package com.epam.rd.java.basic.practice2;

import org.junit.Assert;
import org.junit.Test;

public class ListImplTest {
    @Test
    public void CheckTop() {
        ListImpl list = new ListImpl();
        list.addFirst(56);
        list.addFirst(89);
        list.addFirst(34);
        Object s = list.size();
        Assert.assertEquals(3, s);

    }
}
