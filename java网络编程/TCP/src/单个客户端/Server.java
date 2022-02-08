package 单个客户端;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author ***
 * @create 2021-11-17 17:59
 * 服务端
 * 1.0-->单次接受客户端发来的请求
 * 2.0-->循环接受客户端发来的请求
 * 3.0-->
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //创建 服务段对象
        ServerSocket serverSocket = new ServerSocket(10000);
        System.out.println("数据库已启动\n等待客户连接...");
        while (true) {

            //阻塞
            Socket accept = serverSocket.accept();
            //创建监听器
            InputStream is = accept.getInputStream();
            //创建输入流-读------>读取由客户端传来的数据
            byte[] bytes = new byte[1024];
            int len = is.read(bytes);
            //数据转换成字符串
            String line = new String(bytes, 0, len);

            //获取Sorcket对象的IP地址
            InetAddress inetAddress = accept.getInetAddress();
            String hostAddress = inetAddress.getHostAddress();
            String hostName = inetAddress.getHostName();
            //打印输出
            System.out.println("主机名是:" + hostName);
            System.out.println("主机IP地址是:" + hostAddress);
            System.out.println("信息内容是:" + line);
            //吧内容存到目标文件夹中
            FileOutputStream fos = new FileOutputStream("E:\\目标.txt",true);
            fos.flush();
            fos.write(bytes);

//服务端一般不关流is.close();
//数据回显--输出到客户端
            OutputStream os = accept.getOutputStream();
            os.write("服务器收到信息:".getBytes(StandardCharsets.UTF_8));


        }
    }
}
