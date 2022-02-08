package 多个客户端;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author ***
 * @create 2021-11-17 20:02
 */
public class Sorcket {
    public static void main(String[] args) throws IOException {
//建立客户端对象
        Socket socket = new Socket("192.168.14.93", 10000);
        //创建通讯流对象
        OutputStream os = socket.getOutputStream();
        //输出-->循环给服务器发信息,发完后关闭
        FileInputStream fis = new FileInputStream("E:\\原.txt");
        byte[] bys=new byte[1024];
        int len1=fis.read(bys);
        while ((len1)!=-1){
            os.write(bys,0,len1);
        }




        //接受服务器回显  一次读一个字符组
        InputStream is = socket.getInputStream();
        byte[] bys1=new byte[1024];
        int len=is.read(bys);
        String back = new String(bys, 0, len);
        System.out.println("服务器返回的信息是" + back);

        //关闭
        os.close();
        is.close();
    }
}
