package socket.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV3 {
    private ServerSocket serverSocket = null;

    public HttpServerV3(int port) throws IOException {
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
        try {
            //1.读取请求并解析
            HttpRequestV3 request = HttpRequestV3.build(clientSocket.getInputStream());
            HttpResponseV3 response = HttpResponseV3.build(clientSocket.getOutputStream());
            //2.根据请求计算响应  按照不同的HTTP 方法,拆分成多个不同的逻辑
            if ("GET".equalsIgnoreCase(request.getMethod())) {
                doGet(request, response);
            } else if ("POST".equalsIgnoreCase(request.getMethod())) {
                doPost(request, response);
            } else {
                //其他方法, 返回一个405
                response.setStatus(405);
                response.setMessage("Method Not Allowed");
            }
            //3.把响应写回客户端
            response.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void doGet(HttpRequestV3 request, HttpResponseV3 response) throws IOException {
        //响应是一个index.html文件
        if (request.getUrl().startsWith("/index.html")) {
            //把文件内容写到响应的body中
            InputStream inputStream = HttpServerV3.class.getClassLoader().getResourceAsStream("index.html");
            //HttpServerV3.class获取一个类对象,getClassLoader()获取到当前类的"类加载器"
            //一个类想要工作,需要先由JVM 把这个类的.class 文件找到,然后读取内容,加载到内存中(类加载过程)
            //JVM借助类加载器完成这件事,类加载器是一个JVM中的内置对象,负责加载工作,
            // 加载工作中的一个环节,就是在指定的目录中查找和给定类名匹配的.class文件
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            response.setStatus(200);
            response.setMessage("OK");
            response.setHeader("Content-Type", "text/html; charset=utf-8");
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                response.writeBody(line + "\n");
            }
            bufferedReader.close();
        }
    }
    private void doPost(HttpRequestV3 request, HttpResponseV3 response) {
        //实现一个/login的处理
        if(request.getUrl().startsWith("/login")) {
            //读取用户提交的用户名和密码
            String username = request.getParameter("username");
            String password = request.getParameter("password");
//            System.out.println("username: " + username);
//            System.out.println("password: " + password);
            if ("drr".equals(username) && "123456".equals(password)) {
                //登录成功
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                response.writeBody("<html>");
                response.writeBody("<div>" + "恭喜你" + username + "登录成功" + "</div>");
                response.writeBody("<html>");
            } else {
                //登录失败
                response.setStatus(403);
                response.setMessage("Forbidden");
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                response.writeBody("<html>");
                response.writeBody("<div>" + "登录失败" + "</div>");
                response.writeBody("<html>");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV3 server = new HttpServerV3(9090);
        server.start();
    }
}
