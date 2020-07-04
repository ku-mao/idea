package socket.http;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
// HTTP 响应 进行构造
public class HttpResponse {
    private String version = "HTTP/1.1";
    private int status;  //状态码
    private String message;   //状态码信息
    private Map<String, String> headers = new HashMap <>();
    private StringBuffer body = new StringBuffer();//方便后面拼接
    private OutputStream outputStream = null;//当代码需要写回给客户端的时候,往OutputStream中写

    public static HttpResponse build(OutputStream outputStream) {
        HttpResponse response = new HttpResponse();
        response.outputStream = outputStream;
        //除了OutputStream之外,其他的属性的内容,暂时都无法确认,
        // 需要根据代码的业务逻辑来确定(服务器的"根据请求计算响应"阶段来进行设置的)
        return response;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeader(String key, String value) {
        headers.put(key, value);
    }

    public void writeBody(String content) {
        body.append(content);
    }

    //以上设置属性的操作都是在内存中, 还需要一个专门的方法 按照 HTTP 协议写回到socket中
    public void flush () throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(version + " " + status + " " + message + "\n" );
        headers.put("Content-Length", body.toString().getBytes().length + "");
        for (Map.Entry<String, String> header : headers.entrySet()) {
            bufferedWriter.write(header.getKey()+ ": " + header.getValue()+ "\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();
    }
}
