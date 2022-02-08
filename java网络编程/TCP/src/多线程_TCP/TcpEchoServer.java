package 多线程_TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ***
 * @create 2021-11-17 20:23
 *  初始化服务器。
 * 进入主循环：（1）先去从内核中获取到一个TCP连接。（2）处理这个TCP的连接
 * a.读取请求并解析。b.根据请求计算响应。c.把响应写回给客户端
 */
public class TcpEchoServer {
    private ServerSocket serverSocket=null;

    public TcpEchoServer(int port) throws IOException {
       //绑定端口号
        serverSocket=new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动..");
        while (true){
            //获取一个TCp连接
            Socket clientSocket = serverSocket.accept();
            //去处理连接
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket)  {
        System.out.printf("[%s:%d]  客户端上线\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        try {
            //通过clientSocket来和客户端交互,获取其中的流对象
            //把字节流转成字符流,再套上缓冲区
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            //长连接版本的服务器:一次连接可以处理多次请求,如果客户端断开连接,服务器则调用readLine()或者write()会触发异常
            while (true){
                //1.读取请求并解析(readline对应客户端发送数据的格式，必须是按行发送)
                String request = bufferedReader.readLine();
                //2.根据请求计算响应。
                String response = process(request);
                //3.把响应写回给客户端
                bufferedWriter.write(response + "\n");
                //缓冲区刷新：调用flush方法，就是把内存缓冲区中的内容写入到socket文件中，才真的通过网卡来发送数据
                bufferedWriter.flush();

                System.out.printf("[%s:%d] req: %s; resp: %s\n",clientSocket.getInetAddress(),
                        clientSocket.getPort(),request,response);
            }
        } catch (IOException e) {
            System.out.printf("[%s:%d]  客户端下线\n",clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(10000);
        server.start();
    }

}
