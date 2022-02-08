import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author ***
 * @create 2021-12-06 22:39
 */
public class demo13 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("\"download\" = " + "download");
        //获取下载文件的名称---因为这样固定死了所以   要灵活的获取文件名称
        String filename="gsot4z52jcb.jpg";
        //②服务器告诉浏览器的下载的文件的mimeType
        //获取下载文件的mimeType
        String mimeType = getServletContext().getMimeType(filename);
        resp.setContentType(mimeType);
        //服务器告诉浏览器必须展示下载窗口(Content-Disposition只显示下载窗口  没有下载功能)
        resp.setHeader("Content-Disposition","attachement;filename="+filename);
        //④通过io流将服务器中的文件拷贝到浏览器中
            //4-1获取下载路径
            getServletContext().getRealPath("/download/"+filename);
            //4-2获取下载文件的输入流
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename));
            //4-3获取高效字节输出
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filename));
            //边读边写
            int len;
            byte[] bys=new byte[8192];
            while ((len=bis.read(bys))!=-1){
                bos.write(bys,0,len);
            }
        //关闭资源
        bis.close();
            bos.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
