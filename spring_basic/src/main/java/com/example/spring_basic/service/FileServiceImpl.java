package com.example.spring_basic.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.spring_basic.entity.Files;
import com.example.spring_basic.mapper.FileMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FileServiceImpl extends ServiceImpl<FileMapper, Files> implements IFileService {

    @Autowired
    private FileMapper fileMapper;

}
