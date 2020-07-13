package com.epam.rd.java.basic.practice2;

import org.junit.Assert;
import org.junit.Test;

public class QueueImplTest {

    @Test
    public void CheckTop() {
        QueueImpl queue=new QueueImpl();
        queue.enqueue(45);
        queue.enqueue(67);
        Object s=queue.top();
        Assert.assertEquals(45,s);
    }

}
