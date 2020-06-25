package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //对于一个服务器来说,核心分为2步
    //1.进行初始化操作(实例化 Socket 对象)
    private DatagramSocket socket ;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
        //new这个Socket对象的时候
        // 就会让当前的socket对象和一个IP地址以及-个端口号关联起来. (绑定端口)
        //在构造socket 对象的时候, 没写IP,默认是0.0.0.0(特殊IP)会连接所有的网卡,一个主机可能有很多网卡
        //未来客户端就按照这个IP+端口来访问服务器.

    }
    //2.进入主循环, 接受并处理请求 (主循环就是一个死循环)
    public void start() throws IOException {
        System.out.println("启动服务器");
        while (true) {
            //   a) 读取数据并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);//给数据报对象创建一个缓冲区对象
            socket.receive(requestPacket);//大概率的情况是,调用receive的时候,客户端还没谱呢,还没发任何数据.
            //此时receive操作就会阻塞-直阻塞到,真的有数据过来了为止(此处的阻塞时间完全不可预期)
            //此处是要把请求数据转成一个 String (本来请求是一个byte[)
            String request = new String(requestPacket.getData(), 0,
                    requestPacket.getLength()).trim();//用户实际发送的数据可能远远小于4096.
            // 而此处getLength得到的长度就是4096,通过trim就可以干掉不必要的空白字符.

            //   b) 根据请求计算响应
            String response = process(request);

            //   c) 把响应结果返回给客户端,响应数据是response ,需要包装成一个Packet对象
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),
                    response.getBytes().length, requestPacket.getSocketAddress());
            //response.getBytes().length 得到的是字节数, 这里不能写成response.length()得到的是字符数
            //requestPacket.getSocketAddress() 需要知道这个响应发给谁, 这里得到的是客户端的目的IP和端口

            socket.send(requestPacket);

            //打印一条请求信息
            System.out.printf("[%s:%d] req: %s; resp: %s\n", requestPacket.getAddress().toString(),
                    requestPacket.getPort(), request, response);
        }

    }

    private String process(String request) {
        //由于此处是一个 echo server 回显服务器, 请求内容是什么,就回应什么
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }


}
