package socket.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 实现V3版本的http服务器.
 * 1.支持返回一个静态的html文件
 * 2.解析处理cookie (把cookie处理成键值对结构)
 * 3.解析处理body (把body中的数据处理成键值对结构)
 * 4.实现-个完整的登陆功能(session的简单实现)
 */
public class HttpServerV3 {
    static class User {
        public String username;
        public int age;
        public String school;
    }
    private ServerSocket serverSocket = null;
    //session会话,指的是同一用户的一组访问服务器的操作,归类到一起,就是一个会话
    //就比如一个记者采访你, 问你一个问题就相当于一个请求,你回答一个问题就相当于一个响应,
    // 在一次采访的过程中,有很多的请求和响应,这一组问题和回答,就是一个"会话",
    // 当有另一个记者再去采访你的时候,就是另一个会话
    private Map<String, User> sessions = new HashMap <>();

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
        } catch (IOException | NullPointerException e) {
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
            //String username = request.getCookie("username");
            String sessionId = request.getCookie("sessionId");
            User user = sessions.get(sessionId);
            if (sessionId == null || user == null) {
                //把文件内容写到响应的body中
                InputStream inputStream = HttpServerV3.class.getClassLoader().getResourceAsStream("index.html");
                //HttpServerV3.class获取一个类对象,
                // getClassLoader()获取到当前类的"类加载器"
                // getResourceAsStream 根据文件名,在Resources目录中找到对应的文件
                //并打开,返回这个文件的InputStream对象.
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
            } else {
                //用户已经登录,无需再登录
                response.setStatus(200);
                response.setMessage("OK");
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                response.writeBody("<html>");
                response.writeBody("<div>" + "您已经登录了,无需再次登录" + "</div>");
                response.writeBody("<div>" + "username: " + user.username + "</div>");
                response.writeBody("<div>" + "age: " + user.age + "</div>");
                response.writeBody("<div>" + "school: " + user.school + "</div>");
                response.writeBody("</html>");
            }
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
                //这个写法是,登录成功后,给浏览器写了一个cookie, cookie中保存的是用户的用户名
                //response.setHeader("Set-Cookie", "username=" + username);

                //randomUUID()这是一个随机生成的字符串,每次访问生成的都不一样
                String sessionId = UUID.randomUUID().toString();
                User user = new User();
                user.username = "drr";
                user.age = 20;
                user.school = "西工院";
                sessions.put(sessionId, user);
                response.setHeader("Set-Cookie","sessionId=" + sessionId );
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
        HttpServerV3 server = new HttpServerV3(9091);
        server.start();
    }
}
