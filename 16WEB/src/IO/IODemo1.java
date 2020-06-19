package IO;

import java.io.File;

public class IODemo1 {
    public static void main(String[] args) {
//        File file = new File("d:/test.txt");
//        System.out.println("文件是否存在" + file.exists());
//        System.out.println("是否是普通文件" + file.isFile());
//        System.out.println("是否是目录" + file.isDirectory());

        /**
         * 创建多层目录
         */
//        File file = new File("d:/test/1/2/3/4");
//        file.mkdirs();
//        System.out.println(file.exists());


        File file = new File("d:/test");
        //File[] files = file.listFiles();
//        for (File f : files) {
//            System.out.println(f); //这个只能输出当前目录下的文件和目录
//        }
        listAllFiles(file);
    }
    public static  void listAllFiles(File file){
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                listAllFiles(f);
            }
        } else {
            System.out.println(file);
        }
    }
}
