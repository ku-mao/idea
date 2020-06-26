package socket;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
//    1.启动客户端(一定不要绑定端口号)和服务器建立连接
    private Socket socket= null;

    public TcpEchoClient(String serverIP, int serverPort) throws IOException {
        //此处的实例化Socket 过程 就是建立 TCP 连接
        socket = new Socket(serverIP, serverPort);
    }

    public void start() {
        System.out.println("客户端启动");
        Scanner sc= new Scanner(System.in);
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            //    2.进入主循环
            while (true) {
                //  a)读取用户输入内容
                System.out.print("->");
                String request = sc.nextLine();
                if ("exit".equals(request)) {
                    break;
                }
                //  b)构造一个请求发送给服务器
                bufferedWriter.write(request + "\n");//这里的写只是写入到内存中,并没有写入到网卡中
                bufferedWriter.flush();//执行flush操作,是因为缓冲区满了,或者是关闭流,否则就要手动显示调用
                //  c)读取服务器的响应数据
                String response = bufferedReader.readLine();
                //  d)把响应数据显示到界面上.
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1", 9090);
        tcpEchoClient.start();
    }
}
