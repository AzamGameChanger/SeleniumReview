package com.codewithazam.review05;

import com.codewithazam.pages.WidgetsPageFactory;
import com.codewithazam.utils.CommonMethods;

public class UploadTestUsingPOM extends CommonMethods {
    public static void main(String[] args) {
        setUp();

        WidgetsPageFactory widgets = new WidgetsPageFactory();
        String filePath = System.getProperty("user.dir") + "/screenshots/hrm.png";

        sendText(widgets.chooseFile,filePath);
        wait(2);
        click(widgets.upload);

        wait(5);
        tearDown();
    }
}
