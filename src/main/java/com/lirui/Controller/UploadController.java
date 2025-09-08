package com.lirui.Controller;

import com.lirui.Pojo.Result;
import com.lirui.ultis.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UploadController {

    private static final String fileDir = "D:/Java/demoProject/tlias_web/image/";
//    本地存储:
//    @PostMapping("/upload")
//    public Result upload(MultipartFile file) throws Exception {
//        if (!file.isEmpty()) {
//            log.info("文件上传：{}", file);
//            String fileOriginalFilename = file.getOriginalFilename();
//            String extName = fileOriginalFilename.substring(fileOriginalFilename.lastIndexOf("."));
//            String newFileName = UUID.randomUUID().toString().replace("-", "") + extName;
//            File targetFile = new File(fileDir + newFileName);
//            if (!targetFile.getParentFile().exists()) {
//                targetFile.getParentFile().mkdirs();
//            }
//            file.transferTo(targetFile);
//        }
//        return Result.success();
//    }
//    阿里云OSS存储:
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        if (!file.isEmpty()) {
            log.info("文件上传：{}", file);
            String fileOriginalFilename = file.getOriginalFilename();
            byte[] content = file.getBytes();
            String upload = aliyunOSSOperator.upload(content, fileOriginalFilename);
            return Result.success(upload);
        }
        return Result.error("文件上传失败");
    }
}