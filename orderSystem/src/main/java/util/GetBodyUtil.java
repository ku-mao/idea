package util;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * 读取body 构造一个字符串
 * 得到的字符串才能转化为json
 */
public class GetBodyUtil {
    public  String  getBody(HttpServletRequest request) throws UnsupportedEncodingException {
        int length = request.getContentLength();
        byte[] buffer = new byte[length];
        try(InputStream inputStream = request.getInputStream()) {
            inputStream.read(buffer, 0, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //构造 String 的时候 把字节流转字符流, 最好指定编码方式  要不然可能会乱码
        return new String(buffer, "utf-8");
    }
}
