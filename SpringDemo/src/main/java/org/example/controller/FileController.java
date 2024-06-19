package org.example.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

/**
 * @Project: SpringDemo
 * @Package: org.example.controller
 * @Description: 文件上传下载
 * @author: xiaoMa
 * @Email:17320080198@163.com
 * @date: 2024年04月24日 8:41
 */

@Controller
public class FileController {
    @GetMapping("/toUpload")
    public String toUpload() {
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile[] fileUpload, Model model) {
        model.addAttribute("uploadStatus", "上传成功！");
        for (MultipartFile file : fileUpload) {
            String fileName = file.getOriginalFilename();
            fileName = UUID.randomUUID() + "_" + fileName;
            String dirPath = "D:/file/";
            File filePath = new File(dirPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }
            try {
                file.transferTo(new File(dirPath + fileName));
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("uploadStatus", "上传失败： " + e.getMessage());
            }
        }
        return "upload";
    }

    @GetMapping("/toDownload")
    public String toDownload() {
        return "download";
    }

    //下载功能
    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(String filename) {
        String dirPath = "D:/Mydownload/";
        File file = new File(dirPath + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        //指定下载文件名和字段
        headers.setContentDispositionFormData("attachment", filename);
        //设置请求头
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file),
                    headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(),
                    HttpStatus.EXPECTATION_FAILED);
        }
    }


}

