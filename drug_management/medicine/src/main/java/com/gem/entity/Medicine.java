package com.gem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 药品实体类
 */
@Data
@TableName("tbl_medicine")
public class Medicine {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String msg;
    private String fordisease;
    private String factory;

    //逻辑删除字段
    @TableLogic
    private int deleted;
}
