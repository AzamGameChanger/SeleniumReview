package com.codewithazam.lesson02;

import org.testng.annotations.Test;

public class PriorityDemo {

    @Test(priority = 0)
    public void firstTest() {
        System.out.println("firstTest Method!");
    }

    @Test(priority = 1)
    public void secondTest() {
        System.out.println("secondTest Method!");
    }

    @Test(priority = 0)
    public void thirdTest() {
        System.out.println("thirdTest Method!");
    }

    @Test(priority = 2)
    public void fourthTest() {
        System.out.println("fourthTest Method!");
    }

    @Test
    public void fifthTest() {
        System.out.println("fifthTest Method!");
    }

}
