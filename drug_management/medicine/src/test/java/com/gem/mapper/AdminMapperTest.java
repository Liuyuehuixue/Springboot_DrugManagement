package com.gem.mapper;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.entity.Admin;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//springboot测试
@SpringBootTest
//使用测试运行器
@RunWith(SpringRunner.class)
public class AdminMapperTest {

    @Autowired
    AdminMapper adminMapper;


    //单个查找
    @Test
    public void selectById() {
        Admin admin = adminMapper.selectById(3L);
        System.out.println(admin);
    }


    //多个查找
    @Test
    public void selectList() {
        adminMapper.selectList(null).forEach(System.out::println);

    }

    //插入
    @Test
    public void insert() {
        Admin admin = new Admin();
        admin.setUsername("aa");
        admin.setPassword("123456");
        int result = adminMapper.insert(admin);
        System.out.println(result);
    }

    //更改
    @Test
    public void updateById() {
        Admin admin = new Admin();
        admin.setId(1L);
        admin.setUsername("bb");
        int result = adminMapper.updateById(admin);
        System.out.println(result);
    }

    @Test
    public void delete() {

        //逻辑删除
        int result = adminMapper.deleteById(6L);
        System.out.println(result);
    }


    //MP分页插件使用
    @Test
    public void page() {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", "a");
        Page<Admin> page = adminMapper.selectPage(new Page<>(2, 3), queryWrapper);

        page.getRecords().forEach(System.out::println);
        System.out.println("当前页: " + page.getCurrent());
        System.out.println("总页数: " + page.getPages());
        System.out.println("每页记录数: " + page.getSize());
        System.out.println("是否有上一页: " + page.hasPrevious());
        System.out.println("是否有下一页: " + page.hasNext());
        System.out.println("总记录数: " + page.getTotal());
    }
}