package com.gem.service;

import com.gem.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminServiceImplTest {

    @Autowired
    AdminService adminService;


    @Test
    public void insert() {
        Admin admin = new Admin();
        admin.setUsername("aa");
        admin.setPassword("666");
        adminService.register(admin);

    }


}