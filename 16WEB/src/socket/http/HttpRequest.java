package socket.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//HTTP 请求 解析请求
public class HttpRequest {
    private String method; //请求的方法
    private String url; //请求的路径
    private String version; //请求协议的版本号
    private Map<String, String> parameters = new HashMap<>();//请求路径中的参数
    private Map<String, String> headers = new HashMap <>(); //请求头

    //请求的构造方法使用工厂模式
    public static HttpRequest build (InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        //此处的逻辑,不能把bufferedReader 写到try() 里面,
        // 一旦写进去就意味着这个流会被关闭,会影响到clientSocket的状态
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //解析请求
        //1.解析首行
        String firstLine = bufferedReader.readLine();
        String[] firstLineToken = firstLine.split(" ");
        request.method = firstLineToken[0];
        request.url = firstLineToken[1];
        request.version = firstLineToken[2];
        //解析url中的参数
        int pos = request.url.indexOf("?");
        if (pos != -1) {
            String parameters = request.url.substring(pos + 1);
            String[] parameterKV = parameters.split("&");
            for (String parameter : parameterKV) {
                String[] kv = parameter.split("=");
                request.parameters.put(kv[0], kv[1]);
            }
        }
        //处理header
        String line = "";
        while ((line = bufferedReader.readLine()) != null && line.length() != 0 ) {
            String[] headerKv= line.split(": ");
            request.headers.put(headerKv[0], headerKv[1]);
        }
        //暂时不解析body
        return request;
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

    public String getParameter(String key) {
        return parameters.get(key);
    }

    public String getHeader(String key) {
        return headers.get(key);
    }


    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", parameters=" + parameters +
                ", headers=" + headers +
                '}';
    }
}
