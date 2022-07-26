package com.codewithazam.review02;

import com.codewithazam.utils.ConfigsReader;
import com.codewithazam.utils.Constants;

public class Test1 {
    public static void main(String[] args) {
        ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        String browser =  ConfigsReader.getProperty("browser");
        System.out.println(browser);
    }
}
