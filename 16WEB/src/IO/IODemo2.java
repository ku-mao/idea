package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流为例
 */
public class IODemo2 {
    public static void main(String[] args) throws IOException {
       copyFile("d:/test/sky.jpg", "d:/test/s.jpg");
    }
    private static void copyFile(String srcPath, String destPath) throws IOException {
        //打开文件,才能够读写(创建InputStream / OutputStream 对象的过程)
        FileInputStream fileInputStream = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        //需要读取 srcPath 对应的文件内容
        byte[] buffer = new byte[1024];
        //单次读取的内容是存在上限(缓冲区的长度) 要想把整个文件读完,需要搭配循环使用
        int len = -1;
        //read读取成功,返回正整数,失败返回-1
        while ((len = fileInputStream.read(buffer)) != -1) {
            //读取成功 并写到文件中
            //因为len的值不一定就是缓冲区的长度,所以用write的第三种方式
            //把读到的内容写到destPath 对应的文件中
            fileOutputStream.write(buffer, 0, len);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    private static void copyFile2(String srcPath, String destPath) throws IOException {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);
            //需要读取 srcPath 对应的文件内容
            byte[] buffer = new byte[1024];
            //单次读取的内容是存在上限(缓冲区的长度) 要想把整个文件读完,需要搭配循环使用
            int len = -1;
            //read读取成功,返回正整数,失败返回-1
            while ((len = fileInputStream.read(buffer)) != -1) {
                //读取成功 并写到文件中
                //因为len的值不一定就是缓冲区的长度,所以用write的第三种方式
                //把读到的内容写到destPath 对应的文件中
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
}
