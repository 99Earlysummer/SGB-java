package 多线程_TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ***
 * @create 2021-11-18 0:32
 * client服务端：
 * 1.启动客户端（不绑定端口号）和服务器建立连接
 * 2.进入主循环
 * a)读取用户输入内容
 * b)构造一个请求发送给服务器
 * c)读取服务器的响应数据
 * d)把响应数据显示到界面上
 */
public class Client{
     Socket socket=null;

    public Client(String serverIp,int serverPort) throws IOException {
        //此处的实例化Socket的过程,就是建立TCP连接
        socket = new Socket(serverIp, serverPort);
    }
    //客户端启动方法
    public void start(){
        System.out.println("客户端已启动");
        Scanner sc = new Scanner(System.in);
        //字节流转字符流外加缓冲流
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                System.out.println("->输入请求(退出:exit):");
                String request = sc.nextLine();
                if ("exit".equals(request)){
                    System.out.println("您已下线~");
                    break;
                }
                //构造请求并发送给服务器此处用 \n 是为了和服务器中的readLine相对应
                //把响应写到服务端
                bufferedWriter.write(request+"\n");
                bufferedWriter.flush();
                //读取服务器的响应
                String response = bufferedReader.readLine();
                System.out.println(response);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Client c=new Client("192.168.14.93",9090);
        c.start();
    }
}
