package 多线程_TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author ***
 * @create 2021-11-18 1:08
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1创建一个服务器serversocket对象,和系统指定的端口号(绑定端口)
        ServerSocket server = new ServerSocket(10888);
        //让服务器一直处于监听状态.(死循环accept方法)有一个客户端上传文件就保存在文件中
        while (true){
            //使用ServerSocket对象中的方法accept.获取到请求的客户端Socket对象
            Socket socket = server.accept();//获取客户端请求
            /*
            使用多线程技术，提高程序的效率
            有一个客户端上传文件就开启一个线程完成文件的上传
             */
            new Thread(new Runnable() {
                //run方法完成上传任务--->一次一个线程---->如一次多个线程亦可(因为有whiile())
                @Override
                public void run() {
                   //通过socket对象中的方法getInputStream获取网络字节输入流
                    try {
                        InputStream is = socket.getInputStream();//从客户端输入
                        File file = new File("D:\\UpLoad");
                        if (!file.exists()){
                            file.mkdirs();
                        }
                     /*
        自定；义一个文件的命名规则：防止同名的文件被覆盖
        规则：域名+毫秒值+随机数
                     */
                        String filename="anran"+System.currentTimeMillis()+new Random().nextInt(1999)+"jpg";
                        //(目的从网络读(网络输入流InputStream)然后写(FileOutputStream)到本地文件夹中) 5、创建一个本地的字节输出流对象FileOutputStream 构造方法中绑定要输出的目的地
                        FileOutputStream fos = new FileOutputStream(file + "\\" + filename);
                        //从网络读(循环读--一次读一个字符数组)
                        // 6.使用网络字节输入流InputStream对象中的方法read,读取客户端上传的文件
                        byte[] bys=new byte[1024];
                        //记录读取的个数
                        int len=0;
                        while ((len=is.read(bys))!=-1){
                            // 7、使用本地字节输出流FileOutputStream对象中的方法write，把读取到的文件保存在服务器的硬盘上
                            fos.write(bys,0,len);
                        }
                        //8.使用socket对象中的getoutputstream  获取网络字节输出流,,/注意这里使用客户端的流来写入
                        //
                        OutputStream os = socket.getOutputStream();//输出到客户端
                        os.write("上传成功~".getBytes());
                        os.close();
                        is.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();


        }
    }
}
