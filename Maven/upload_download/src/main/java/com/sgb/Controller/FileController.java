package com.sgb.Controller;


import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletContext;
import java.io.*;
import java.util.UUID;

/**
 * @author 沈功波
 */
@Controller
public class FileController {

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/file/upload")
    public String upload12(MultipartFile fileName) throws IOException {

        String contextPath = servletContext.getRealPath("upload");
        System.out.println("contextPath = " + contextPath);
        File file = new File(contextPath);
        if (!file.exists()) {
            file.mkdir();
        }
        String originalFilename = fileName.getOriginalFilename();
        String[] fileNames = originalFilename.split("[\\.]");
        String newFileName = UUID.randomUUID().toString().replaceAll("-","") + "." + fileNames[1];
        File destFile = new File(contextPath + File.separator + newFileName);
        fileName.transferTo(destFile);
        return "index";
    }

    @RequestMapping("/file/download")
    public ResponseEntity<byte[]> download(String fileName) throws Exception {
        final val filePath = servletContext.getRealPath("upload") + File.separator + fileName;
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream(filePath));
        byte[] bytes=new byte[bis.available()];
        bis.read(bytes);
        MultiValueMap<String,String> headers=new HttpHeaders();
        headers.add("Content-type",servletContext.getMimeType(fileName));
        headers.add("Content-Disposition","attachement;fileName="+fileName);
        HttpStatus status=HttpStatus.OK;
        return new ResponseEntity<>(bytes,headers,status);

    }
}
