package com.example.spring_basic.component;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/*
创建定时任务，查询后台服务器里每个文件夹里剩余的文件数量
* */
@Component
public class FileCountTask {
    @Value(value = "${files.download.path}")
    private String downloadFilePath;
    private static final Logger log = LoggerFactory.getLogger(FileCountTask.class);

    @Scheduled(fixedRate = 6000) // 24小时，以毫秒为单位
    //fixedRate上一次开始执行时间点之后多长时间再执行
    //fixedDelay上一次开始执行完成之后多长时间再执行
    //Scheduled还可以使用corn 表达式。例如：@Scheduled(cron = "0 0 3 * * ?") // 每天凌晨3点执行
    public void countFilesInFolder() {
        String folderPath = downloadFilePath; // 替换成你的文件夹路径
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                int fileCount = files.length;
                log.warn("文件夹中的文件数量为：" + fileCount);
            }
        } else {
            log.error("文件夹不存在");
        }
    }

    @Scheduled(fixedDelay = 6000)//上一个任务执行完毕后，间隔多长时间再次执行
    private void configureTasks() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.warn("执行静态定时任务2时间: " + simpleDateFormat.format(date));

    }
}
