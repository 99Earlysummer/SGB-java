package com.sgb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
@Controller
public class fileCon2 {

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/file/upload2")
    public String upload2(MultipartFile myFile) throws IOException {
        //MyFile包含上传文件得信息 因为它与前端得name名一致
        //获取upload真实磁盘路径  在servletContext中拿取upload目录得真实路径
        String uploadPath = servletContext.getRealPath("upload");
        //如果没有这个文件怎么办  因此我们要创建
        File file = new File(uploadPath);
        if (!file.exists()){
            file.mkdir();
            System.out.println("file = " + file);
        }
        //文件名
        String originalFilename = myFile.getOriginalFilename();
        //.切割
        String[] fileNames = originalFilename.split("[\\.]");
        //.jpg

        //如果有这个文件就将文件传入这个文件夹(通过io)
        //   uploadPath     File.separator意为加\       myFile.getOriginalFilename()随机文件名以及文件后缀
        File destFile = new File(uploadPath + File.separator + UUID.randomUUID().toString().replaceAll("-","") + "." + fileNames[1]);
        myFile.transferTo(destFile);
/*
        //girl1.jpg获取文件名
        String originalFilename = myFile.getOriginalFilename();
        //fdsafadsfdsaf.jpg按照点做切割
        String[] fileNames = originalFilename.split("[\\.]");
        //获取随机文件名
        String newFileName = UUID.randomUUID().toString().replaceAll("-","") + "." + fileNames[1];
        //目标文件路径
        File destFile = new File(uploadDirPath + File.separator + newFileName);
        //传入;一个目标路径对象
        myFile.transferTo(destFile);
*/
        return "index";
    }
}
