package com.aifule.jxc.site.gongzhu;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteFile {
    public String write(MultipartFile file, String rootPath) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String res = sdf.format(new Date());
        String originalFileName = file.getOriginalFilename();
        // 新文件名
        String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));
        //新文件
        rootPath = rootPath + "\\";
        File newFile = new File(rootPath + newFileName);
        file.transferTo(newFile);
        if (!newFile.exists()) {
            newFile.mkdirs();
        }
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(rootPath + newFileName);
                InputStream in = file.getInputStream();
                byte[] buffer = new byte[1024];
                int bytesum = 0;
                int byteread = 0;
                while ((byteread = in.read(buffer)) != -1) {
                    bytesum += byteread;
                    fos.write(buffer, 0, byteread);
                    fos.flush();
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.print(rootPath);
        return newFileName;
    }
}
