package com.epam.rd.java.basic.practice2;


import org.junit.Assert;
import org.junit.Test;

public class ArrayImplTest {

     @Test
    public void CheckGet() {
        ArrayImpl array=new ArrayImpl();
        array.add(2);
        array.add(3);
        Object s=array.get(1);
        Assert.assertEquals(3,s);
    }


}
