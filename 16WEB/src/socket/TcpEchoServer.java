package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpEchoServer {

//    1.初始化服务器
    ServerSocket serverSocket = null;
    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    //    2.进入主循环
    public void start() throws IOException {
        while (true) {
            System.out.println("服务器启动");
            // 1)先从内核中获取到一个TCP的连接
            Socket clientSocket = serverSocket.accept();
                 // serverSocket 相当于小哥哥 处理客户端的连接
                //  clientSocket 相当于小姐姐  和客户端进行具体的交互

            // 2)处理这个TCP的连接
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线\n ", clientSocket.getInetAddress().toString(),
                   clientSocket.getPort());
        //通过clientSocket 来和客户端交互, 先要获取到clientSocket 中的流对象,在回显服务器中以文本数据的形式交互
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {

            //在这里用while循环实现一个"长连接" 版本的服务器  一次连接的过程需要处理多个请求和响应
            //这个循环何时结束?当客户端断开连接时，就结束了。
           //当客户端断开连接的时候，服务器再去调用readLine 或者write 方法都会触发异常(IOException)
            while (true) {
                //  a)读取请求并解析(客户端发送的信息也必须是按行发送)
                String request = bufferedReader.readLine();
                //  b)根据请求计算响应
                String response = process(request);
                //  c)把响应写回给客户端(客户端要按行来读)
                bufferedWriter.write(response + "\n");
                bufferedWriter.flush();
                System.out.printf("[%s:%d] req:%s;resp:%s \n", clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(), request, response);
            }

        } catch (IOException e) {
            System.out.printf("[%s:%d] 客户端下线\n ", clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(9090);
        tcpEchoServer.start();
    }
}
