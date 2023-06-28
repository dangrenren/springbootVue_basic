package com.example.spring_basic.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.spring_basic.entity.Files;
import com.example.spring_basic.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/file")
public class fileUploadController {
    @Value("${files.upload.path}")
    private String fileUploadPath;

    @Value("${files.download.path}")
    private String fileDownloadPath;

    @Autowired
    private IFileService iFileService;

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);//hutool
        long size = file.getSize();
        //先存储在磁盘
        File uploadParentFile = new File(fileUploadPath);
        //判断配置的文件目录是否存在，若不在则创建一个新的文件目录
        if (!uploadParentFile.exists()) {
            uploadParentFile.mkdirs();
        }
        //定义一个文件唯一的标识码
        String uuid = IdUtil.fastSimpleUUID();//hutool
        String fileUuid = uuid + StrUtil.DOT + type;
        File uploadFile = new File(fileUploadPath + fileUuid);
        //获取文件的md5,如果在上传文件夹(D:/img/upload )已经存在，就不在上传了,返回数据库里已经存在的文件url路径
        String md5 = SecureUtil.md5(file.getInputStream());//hutool
        System.out.println("===========" + md5 + "==============");
        String url;
        QueryWrapper<Files> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("md5", md5);
        Files one = iFileService.getOne(queryWrapper, true);//查询数据库库里对应md5的唯一一条数据
        if (one != null) {
            url = one.getUrl();
        } else {
            url = "http://localhost:9090/file/" + fileUuid;
            //String  url="http://localhost:9090/file/"+fileUuid;
            //把获取的文件存储在磁盘目录  MultipartFile.transferTo(targetFile)
            file.transferTo(uploadFile);
            //存储到数据库
            Files saveFile = new Files();
            saveFile.setName(originalFilename);
            saveFile.setType(type);
            saveFile.setSize(size / 1024);//存储单位转变为kb
            saveFile.setUrl(url);
            saveFile.setMd5(md5);
            iFileService.save(saveFile);
        }
        return url;
    }

    @GetMapping("/{fileUuid}")
    public void download(HttpServletResponse response, @PathVariable String fileUuid) throws IOException {
        //根据文件标识码获取文件
        File downlodaFile = new File(fileDownloadPath + fileUuid);
        //设置输出流格式
        ServletOutputStream os = response.getOutputStream();
        response.setContentType("application/octet-stream");
        // response.setCharacterEncoding("utf-8");字符编码格式
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileUuid, "UTF-8"));
        //读取文件的字节流
        os.write(FileUtil.readBytes(downlodaFile));
        os.flush();
        os.close();


    }
}
