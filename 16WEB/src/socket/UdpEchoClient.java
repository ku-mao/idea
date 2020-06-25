package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    // 客户端的主要流程分成四步.
    // 1. 从用户这里读取输入的数据.
    // 2. 构造请求发送给服务器
    // 3. 从服务器读取响应
    // 4. 把响应写回给客户端.

    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    // 需要在启动客户端的时候来指定需要连接哪个服务器
    public UdpEchoClient(String serverIp, int serverPort) throws SocketException, SocketException {
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        socket = new DatagramSocket();//客户端创建socket的时候,不需要绑定端口号
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1. 读取用户输入的数据
            System.out.print("-> ");
            String request = scanner.nextLine();
            if (request.equals("exit")) {
                break;
            }
            // 2. 构造请求发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serverIp), serverPort);
            //如果这个Packet用于receive ,只指定缓冲区就行了. (地址是接受数据的时候由内核填充的)
            //如果这个Packet用于send,除了指定缓冲区,还需要指定发给谁(用户手动设定).
            // 一种是直接设定InetAddress对象(里面同时包含了IP和port)
            // 还可以把IP和port分开设置.

                    socket.send(requestPacket);
            // 3. 从服务器读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength()).trim();
            // 4. 显示响应数据
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
         UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
//        UdpEchoClient client = new UdpEchoClient("47.98.116.42", 9090);
        //这是一个特殊的IP (环回IP)自己访问自己.
        // 服务器和客户端都在同一台主机上.客户端写的服务器IP就是环回IP.
        //如果不在同一个主机上,此处的IP就要写成服务器的IP

        client.start();
    }
}
