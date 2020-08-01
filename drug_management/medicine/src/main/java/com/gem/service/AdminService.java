package com.gem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gem.entity.Admin;



public interface AdminService extends IService<Admin> {

     void register(Admin admin);

}
