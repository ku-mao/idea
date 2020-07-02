package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV1 {
    public ServerSocket serverSocket= null;

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
            //   c)解析body(暂时先不考虑)
            //2.根据请求计算响应
            //3.把响应写回给客户端

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

    }
}
