package 多个客户端;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author ***
 * @create 2021-11-17 19:57
 */
public class Server {
    public static void main(String[] args) {


        //创建 服务段对象
        ServerSocket serverSocket;
        FileOutputStream fos = null;
        OutputStream os=null;

        {
            try {
                serverSocket = new ServerSocket(10000);
                System.out.println("数据库已启动\n等待用户连接...");
                while (true) {
                    System.out.println("---受阻塞->直到Socket用户启动就释放---");
                    //阻塞--->直到Socket用户启动就释放
                    Socket accept = serverSocket.accept();
                    //创建监听器
                    InputStream is = accept.getInputStream();
                    //创建输入流-读------>读取由客户端传来的数据
                    byte[] bytes = new byte[1024];
                    int len = is.read(bytes);
                    //数据转换成字符串
                    String line = new String(bytes, 0, len);
                    System.out.println("用户已连接..");
                    //获取Sorcket对象的IP地址
                    InetAddress inetAddress = accept.getInetAddress();
                    String hostAddress = inetAddress.getHostAddress();
                    String hostName = inetAddress.getHostName();
                    //打印输出
                    System.out.println("主机名是:" + hostName);
                    System.out.println("主机IP地址是:" + hostAddress);
                    System.out.println("信息内容是:" + line);
                    //吧内容存到目标文件夹中
                    fos = new FileOutputStream("E:\\目标.txt", true);
                    fos.flush();
                    fos.write(bytes);

//服务端一般不关流is.close();
//数据回显--输出到客户端
                    os= accept.getOutputStream();
                    os.write("服务器收到信息:".getBytes(StandardCharsets.UTF_8));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}