package vn.com.vatekasia.util;

import java.io.File;

public class FileUtil {
    public static void saveFile(String namefile, String path) {
        try {
            File file = new File(namefile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
