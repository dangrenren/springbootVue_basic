package com.example.spring_basic.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@Data
@TableName("file")
public class Files {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
    private String type;
    private Long size;
    private String url;
    private Boolean enable;
    private Boolean isDelete;
    private String md5;
}
