package com.gem.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.entity.Medicine;
import com.gem.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/detail")
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "pageCurrent", defaultValue = "1") int pageCurrent, @RequestParam(value = "pageSize", defaultValue = "2") int pageSize) {

        Page<Medicine> page=medicineService.page(new Page<>(pageCurrent,pageSize));


        model.addAttribute("page",page);
        return "list";

    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "medicineAdd";
    }


    @RequestMapping("/add")
    public String add(Medicine medicine) {
       medicineService.save(medicine);
        return "redirect:/detail/list";
    }


    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        Medicine medicine=medicineService.getById(id);
        model.addAttribute("medicine", medicine);
        return "medicineEdit";
    }


    @RequestMapping("/edit")
    public String edit(Medicine medicine) {
       medicineService.saveOrUpdate(medicine);
        return "redirect:/detail/list";
    }


    @RequestMapping("/delete")
    public String delete(Long id) {
       medicineService.removeById(id);
        return "redirect:/detail/list";
    }





}
