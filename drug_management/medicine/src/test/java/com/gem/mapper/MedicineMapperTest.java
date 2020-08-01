package com.gem.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.entity.Medicine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



//springboot测试
@SpringBootTest
//使用测试运行器
@RunWith(SpringRunner.class)

public class MedicineMapperTest {
  @Autowired
  MedicineMapper medicineMapper;

  //单个查找
    @Test
    public void selectById() {
       Medicine medicine = medicineMapper.selectById(1L);
        System.out.println(medicine);
    }

    //多个查找
    @Test
    public void selectList() {
        medicineMapper.selectList(null).forEach(System.out::println);

    }

    //插入
    @Test
    public void insert() {
       Medicine  medicine = new Medicine();
        medicine.setName("");
        medicine.setMsg("");
        int result = medicineMapper.insert(medicine);
        System.out.println(result);
    }

    //更改
    @Test
    public void updateById() {
        Medicine  medicine = new Medicine();
        medicine.setName("");
        medicine.setMsg("");
        int result = medicineMapper.updateById(medicine);
        System.out.println(result);
    }

    @Test
    public void delete() {

        //逻辑删除
        int result = medicineMapper.deleteById(6L);
        System.out.println(result);
    }


    //MP分页插件使用
    @Test
    public void page() {

        QueryWrapper<Medicine> queryWrapper = new QueryWrapper<>();
        queryWrapper.notLike("name","a");
        Page<Medicine> page = medicineMapper.selectPage(new Page<>(2, 3), queryWrapper);

        page.getRecords().forEach(System.out::println);
        System.out.println("当前页: " + page.getCurrent());
        System.out.println("总页数: " + page.getPages());
        System.out.println("每页记录数: " + page.getSize());
        System.out.println("是否有上一页: " + page.hasPrevious());
        System.out.println("是否有下一页: " + page.hasNext());
        System.out.println("总记录数: " + page.getTotal());
    }


}