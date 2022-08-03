package com.codewithazam.lesson01;

import org.testng.annotations.Test;

public class TestNGDemo {

    @Test
    public void testOne(){
        System.out.println("Test One!");
    }

    @Test
    public void testTwo(){
        System.out.println("Test Two!");
    }

    @Test
    public void testThree(){
        System.out.println("Test Three!");

        String path = System.getProperty("user.dir");
        System.out.println(path);
    }
}
