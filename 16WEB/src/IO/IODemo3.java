package IO;

import java.io.*;

public class IODemo3 {
    public static void main(String[] args) throws IOException {
        copyFile();
    }

    private static void copyFile() throws IOException {
        //要想创建的实例是 BufferInputStream  和 BufferOutputStream
        //在创建这样的实例前 ,要先创建FileInputStream 和 FileOutputStream
        FileInputStream fileInputStream = new FileInputStream("d:/test/sky.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("d:/test/sk.jpg");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] buffer = new byte[1024];
        int len = -1;
        while((len = bufferedInputStream.read(buffer)) != - 1) {
            bufferedOutputStream.write(buffer, 0, len);
        }
        //此处涉及到四个流对象
        //调用这一组close 时, 就会自动关闭内部包含的FileInputStream 和 FileOutputStream
        //不需要写4次关闭
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    private static void copyFile2()  {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/test/sky.jpg"));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("d:/test/sk.jpg"))) {
            byte[] buffer = new byte[1024];
            int len = -1;
            while((len = bufferedInputStream.read(buffer)) != - 1) {
                bufferedOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

















}
