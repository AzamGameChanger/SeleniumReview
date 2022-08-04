package com.codewithazam.lesson04;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.Listeners.class)
public class ListenerDemo {

    @Test
    public void test1(){
        System.out.println("The test 1.");
        Assert.assertTrue(true);
    }

    @Test
    public void test2() {
        System.out.println("The test 2.");
        Assert.assertTrue(false);
    }
}
