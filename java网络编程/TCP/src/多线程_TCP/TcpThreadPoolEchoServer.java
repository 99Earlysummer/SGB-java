package 多线程_TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ***
 * @create 2021-11-17 21:01
 *
//用线程池来解决服务器频繁创建线程和销毁线程的问题
 */
public class TcpThreadPoolEchoServer {
    private ServerSocket serverSocket = null;

    public TcpThreadPoolEchoServer(int port) throws IOException {
        //端口绑定
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        //创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            if (clientSocket.isBound()){//判断套接字的绑定状态
                System.out.println("[%s:%d]  客户端上线~");
            }
//            if (clientSocket.isBound()){//判断套接字的绑定状态
//                System.out.println("[%s:%d]  客户端下线\n", clientSocket.getInetAddress().toString(),
//                        clientSocket.getPort());
//            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
        }
    }

    private void processConnection(Socket clientSocket) {
        try {
            //把字节流转成字符流，再套上缓冲区
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            //长连接版本的服务器：一次连接可以处理多次请求，当客户端断开连接的时候，服务器再去调用readline或write方法都会触发异常
            while (true) {

                //1.读取请求并解析(readline对应客户端发送数据的格式，必须是按行发送)
                String request = bufferedReader.readLine();
                //2.根据请求计算响应。
                String response = process(request);
                //3.把响应写回给客户端
                bufferedWriter.write("服务端反馈信息:"+response + "\n");
                //缓冲区刷新：调用flush方法，就是把内存缓冲区中的内容写入到socket文件中，才真的通过网卡来发送数据
                bufferedWriter.flush();
                //打印日志
                System.out.printf("log:[%s:%d] req: %s; resp: %s\n", clientSocket.getInetAddress(),
                        clientSocket.getPort(), request, response);

            }
        } catch (IOException e) {
            System.out.printf("[%s:%d]  客户端下线\n", clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadPoolEchoServer server = new TcpThreadPoolEchoServer(9090);
        server.start();
    }
}
