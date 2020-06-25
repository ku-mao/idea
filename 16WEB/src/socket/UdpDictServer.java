package socket;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDictServer extends UdpEchoServer {
    private Map<String, String> map = new HashMap <>();

    private UdpDictServer(int port) throws SocketException {
        super(port);
        map.put("cat", "小猫");
        map.put("dog", "小狗");
        map.put("fighting", "加油");
    }

    @Override
    public String process(String request) {
        return map.getOrDefault(request, "这超出我的能力范围");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}
