package com.gem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 管理员实体类
 */
@Data

//MP指定数据库表名
@TableName("tbl_admin")
public class Admin {
    //主键
    @TableId(type = IdType.AUTO)
    private Long id;
    private String truename;
    private String username;
    private String password;
    private String tel;
    private String sex;
    //逻辑删除字段
    @TableLogic
    private int deleted;
}
