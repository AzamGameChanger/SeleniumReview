package com.codewithazam.lesson01;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class!");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class!");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method!");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method!");
    }

    @Test
    public void test1(){
        System.out.println("The Test 1!");
    }

    @Test
    public void test2(){
        System.out.println("The Test 2!");
    }
}
