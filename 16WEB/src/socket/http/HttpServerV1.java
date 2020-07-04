package socket.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV1 {
    public ServerSocket serverSocket = null;

    public HttpServerV1(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }

    }

    private void process(Socket clientSocket) {
        //获取字符流
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            //1.读取请求并解析
            //   a)解析首行
            String firstLine = bufferedReader.readLine();
            String[] firstLineTokens = firstLine.split(" ");
            String method = firstLineTokens[0];
            String url = firstLineTokens[1];
            String version = firstLineTokens[2];
            //   b)解析header
            Map<String, String> headers = new HashMap <>();
            String line = "";
            while ((line = bufferedReader.readLine()) != null && line.length() != 0 ) {
                String[] headerToken = line.split(": ");
                headers.put(headerToken[0], headerToken[1]);
            }
            //为了验证我们接收到的请求是否解析正确 写一个打印日志
            System.out.printf("%s %s %s\n", method, url, version);
            for (Map.Entry<String, String> header : headers.entrySet()) {
                System.out.println(header.getKey() + ": " + header.getValue());
            }
            System.out.println();
            //   c)解析body(暂时先不考虑)
            //2.根据请求计算响应
            //不管什么情况,都返回一个hello的html页面
            //3.把响应写回给客户端
            String response = "";
            if (url.equals("/ok")) {
                bufferedWriter.write(version + "200 OK\n");
                response = "<h1>hello</h1>";
            } else if (url.equals("/notfound")) {
                bufferedWriter.write(version + "404 Not Found\n");
                response = "<h1>not found</h1>";
            } else if (url.equals("/seeother")) {
                bufferedWriter.write(version + "303 See Other\n");
                bufferedWriter.write("Location: http://www.sogou.com\n");
                response = "";
            } else {
                bufferedWriter.write(version + "200 OK\n");
                response = "<h1>default</h1>";
            }

            bufferedWriter.write("Content-Type: text/html\n");
            bufferedWriter.write("Content-Length: " + response.getBytes().length + "\n");
            bufferedWriter.write("\n");
            bufferedWriter.write(response);
            bufferedWriter.flush();//可以不刷新 因为进行短连接, try结束就会关闭流,就会刷新缓冲区
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //因为是短连接,所以进行一次交互后要关闭流,断开连接
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        HttpServerV1 server = new HttpServerV1(9090);
        server.start();
    }
}
