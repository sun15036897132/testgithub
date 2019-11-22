package com.huidian.controller;

import com.huidian.domain.Stu;
import com.huidian.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StuController {

    @Autowired
    StuService stuService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Stu> stus = stuService.findAll();
        model.addAttribute("stus",stus);
        return "index";
    }

    @RequestMapping("/findById")
    public String findById(Model model,int sno){
        Stu byId = stuService.findById(sno);
        model.addAttribute("byId",byId);
        return "update";
    }

    @RequestMapping("/insertStu")
    public String insertStu(Stu stu){
        stuService.insertStu(stu);
        return "redirect:findAll";
    }

    @RequestMapping("/deleteStu")
    public String deleteStu(int sno){
        stuService.deleteStu(sno);
        return "redirect:findAll";
    }

    @RequestMapping("/updateStu")
    public String updateStu(Stu stu){
        stuService.updateStu(stu);
        return "redirect:findAll";
    }

    @RequestMapping("/add")
    public String add(){
        return "insert";
    }

}
