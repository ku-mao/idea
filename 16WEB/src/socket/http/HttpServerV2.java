package socket.http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV2 {
    private ServerSocket serverSocket = null;
    private int port;
    public HttpServerV2(int port) throws IOException {
        serverSocket  = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动:");
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
    private  void process(Socket clientSocket) {
        try {
            //1.读取请求并解析请求
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            HttpResponse response = HttpResponse.build(clientSocket.getOutputStream());
            System.out.println("request" + request);
            //2.根据请求计算响应
            response.setHeader("Content-Type", "text/html");
            if (request.getUrl().startsWith("/ok")) {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>Hello</h1>");
            } else if (request.getUrl().startsWith("/calc")){
                String aStr = request.getParameter("a");
                String bStr = request.getParameter("b");
                int a = Integer.parseInt(aStr);
                int b = Integer.parseInt(bStr);
                int res = a + b;
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody(res+"");
            } else if(request.getUrl().startsWith("/cookieUser")){
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Set-Cookie", "drr");
                response.writeBody("<h1>set cookieUser</h1>");
            } else if(request.getUrl().startsWith("/cookieTime")){
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Set-Cookie", System.currentTimeMillis()/1000 + "");
                response.writeBody("<h1>set cookieTime</h1>");
            } else {
                response.setStatus(200);
                response.setMessage("OK");
                response.writeBody("<h1>Default</h1>");
            }
            //3.把响应写回给客户端
            response.flush();
        } catch (IOException  | NullPointerException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV2 server = new HttpServerV2(9090);
        server.start();
    }
}
