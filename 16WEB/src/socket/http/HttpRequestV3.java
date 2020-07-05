package socket.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestV3 {
    private String method;
    private String url;
    private String version;
    private Map<String, String> headers = new HashMap <>();//解析请求头
    private Map<String, String> parameters = new HashMap <>();//解析url中的参数
    private Map<String, String> cookies = new HashMap <>();//解析cookie
    private String body = null;

    public static HttpRequestV3 build(InputStream inputStream) throws IOException {
        HttpRequestV3 request = new HttpRequestV3();
        //解析首行
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String firstLine = bufferedReader.readLine();
        String[] firstLineTokens = firstLine.split(" ");
        request.method = firstLineTokens[0];
        request.url = firstLineTokens[1];
        request.version = firstLineTokens[2];
        //解析url
        int pos = request.url.indexOf("?");
        if (pos != -1) {
            String queryString = request.url.substring(pos + 1);
            parseKV(queryString, request.parameters);
        }
        //解析header
        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() != 0 ) {
            String [] tokens = line.split(": ");
            request.headers.put(tokens[0], tokens[1]);
        }
        //解析cookie
        String cookie = request.headers.get("Cookie");
        if (cookie != null) {
            parseCookie(cookie, request.cookies);
        }
        //解析body
        if ("POST".equalsIgnoreCase(request.method) || "PUT".equalsIgnoreCase(request.method)){
            //这两个方法里需要处理body, 其他方法暂时不考虑
            int contentLength = Integer.parseInt(request.headers.get("Content-Length"));//字节数目
            char[] buffer = new char[contentLength];//contentLength 为100 body有100个字节,缓冲区的字符char的长度是100但是字节数是200
            int len = bufferedReader.read(buffer);
            request.body = new String(buffer, 0, len);
            //body 的格式形如: username=drr&password=123456
            parseKV(request.body, request.parameters);
        }
        return request;
    }

    private static void parseCookie(String cookie, Map<String, String> cookies) {
        //cookie之间是用分号空格分成多个键值对
        String[] parameter = cookie.split("; ");
        for (String kv : parameter) {
            String[] kvTokens = kv.split("=");
            cookies.put(kvTokens[0], kvTokens[1]);
        }
    }

    private static void parseKV(String queryString, Map<String, String> parameters) {
        String[] parameter = queryString.split("&");
        for (String kv : parameter) {
            String[] kvTokens = kv.split("=");
            parameters.put(kvTokens[0], kvTokens[1]);
        }
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public String getBody() {
        return body;
    }

    public String getParameter(String key) {
        return  parameters.get(key);
    }

    public String getCookie(String key) {
        return cookies.get(key);
    }

    public String getHeader(String key) {
        return headers.get(key);
    }
}
