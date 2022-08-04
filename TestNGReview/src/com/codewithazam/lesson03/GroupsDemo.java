package com.codewithazam.lesson03;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GroupsDemo {

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        System.out.println("Before Class");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        System.out.println("After Class");
    }

    @Test(groups = "smoke")
    public void test1() {
        System.out.println("Inside test1 method");
    }

    @Test(groups = {"regression","smoke","sanity"})
    public void test2() {
        System.out.println("Inside test2 method");
    }

    @Test(groups = "sanity")
    public void test3() {
        System.out.println("Inside test3 method");
    }

    @Test(groups = "smoke")
    public void test4() {
        System.out.println("Inside test4 method");
    }


}
