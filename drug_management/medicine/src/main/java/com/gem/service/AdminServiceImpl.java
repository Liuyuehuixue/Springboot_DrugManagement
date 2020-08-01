package com.gem.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.entity.Admin;
import com.gem.mapper.AdminMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

               @Autowired
               AdminMapper adminMapper;

               @Override
               public void register(Admin admin){

                   adminMapper.insert(admin);
               }

}
