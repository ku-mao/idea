package socket.http;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class HttpResponseV3 {
    private String version = "HTTP/1.1";
    private int status;
    private String message;
    private Map<String, String> headers = new HashMap <>();
    private StringBuffer body = new StringBuffer();
    private OutputStream outputStream = null;

    public static HttpResponseV3 build(OutputStream outputStream) {
        HttpResponseV3 response = new HttpResponseV3();
        response.outputStream = outputStream;
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

    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(version + " " + status + " " + message + "\n");
        headers.put("Content-Length", body.toString().getBytes().length + "");
        for (Map.Entry<String, String> header : headers.entrySet()) {
            bufferedWriter.write(header.getKey() + ": " + header.getValue() + "\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();
    }
}
