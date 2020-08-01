package com.gem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gem.entity.Admin;


import com.gem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    /**
     * 登陆方法[异步]
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(String username, String password, HttpSession session) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).eq("password", password);
        Admin admin = adminService.getOne(queryWrapper);
        if (admin != null) {
            session.setAttribute("admin", admin);
            return "1";
        }
        return "0";
    }

    /**
     * 注册
     */
    @RequestMapping ("/register")
    public String register(Admin admin) {
        try {
           adminService.register(admin);

            return "redirect:/";
        } catch (Exception e) {
            return "error";
        }

    }

    /**
     * 显示用户信息
     */
    @GetMapping("/adminList")
    public String adminList(@SessionAttribute Admin admin , Model model) {
        adminService.saveOrUpdate(admin);
        model.addAttribute("admin",admin);
        return "adminList";

    }

    /**
     * 完善用户信息
     */
    @RequestMapping("/adminEdit")
    public String adminEdit(Model model,Long id) {
        Admin admin=adminService.getById(id);

        model.addAttribute("admin", admin);
        return "adminEdit";
    }

    /**
     * 编辑用户信息
     */
    @RequestMapping("/edit")
    public String edit(Admin admin) {
       adminService.saveOrUpdate(admin);
        return "redirect:/detail/list";
    }


}
