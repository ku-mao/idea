package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpThreadEchoServer {
    ServerSocket serverSocket = null;

    public TcpThreadEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //针对这个连接, 单独创建一个线程负责处理.
            Socket clientSocket = serverSocket.accept();
            Thread t = new Thread() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            };
            t.start();
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线\n ", clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
                while (true) {
                String request = bufferedReader.readLine();
                String response = process(request);
                bufferedWriter.write(response + "\n");
                bufferedWriter.flush();
                System.out.printf("[%s:%d] req: %s; resp: %s\n", clientSocket.getInetAddress(),
                        clientSocket.getPort(), request, response);
                }
            } catch (IOException e) {
                System.out.printf("[%s:%d] 客户端下线\n", clientSocket.getInetAddress().toString(),
                        clientSocket.getPort());
            }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadEchoServer tcpThreadEchoServer = new TcpThreadEchoServer(9090);
        tcpThreadEchoServer.start();
    }
}
