package IO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 测试带缓冲区和不带缓冲区的读写文件的效率
 */
public class IODemo4 {
    public static void main(String[] args)  {
        //noBuffer();
        hasBuffer();
    }

    private static void noBuffer()  {
        long beg = System.currentTimeMillis();
        try (FileInputStream fileInputStream = new FileInputStream("d:/test/s.jpg")) {
            int ch = -1;
            while ((ch = fileInputStream.read()) != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("no buffer " + (end - beg) + " ms" );
    }
    private static void hasBuffer() {
        long beg = System.currentTimeMillis();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/test/s.jpg")) ) {
            int ch = -1;
            while ((ch = bufferedInputStream.read()) != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("has buffer " + (end - beg) + " ms" );
    }


}
