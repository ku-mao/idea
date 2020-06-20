package IO;


import java.io.*;

public class IODemo5 {
    public static void main(String[] args) {
        copyFile3();
    }

    private static void copyFile() {
        try (FileReader fileReader = new FileReader("d:/test/test.txt");
             FileWriter fileWriter = new FileWriter("d:/test/test1.txt")) {

            char[] buffer = new char[1024];
            int len = -1;
            while ((len = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, len);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile2() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/test/test.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/test/test1.txt"))) {
            char[] buffer = new char[1024];
            int len = -1;
            while ((len = bufferedReader.read(buffer)) != -1) {
                bufferedWriter.write(buffer, 0,len);
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFile3() {
        //带缓冲区的字符流有一种特殊的用法 ,按行读取
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/test/test.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/test/test1.txt"))) {
            String line = "";
            //readLine 表示读一行,读到换行符为止, 如果文件读取完毕, 就会返回null
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line + "\n");
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }


}
