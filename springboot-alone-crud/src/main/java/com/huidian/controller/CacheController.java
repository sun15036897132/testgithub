package com.huidian.controller;


import com.huidian.domain.Stu;
import com.huidian.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
    @Autowired
    StuService stuService;

    @GetMapping("/ById/{sno}")
    public Stu ById(@PathVariable("sno") int sno) {
        Stu byId = stuService.findById(sno);
        return byId;
    }

    @GetMapping("/update")
    public Stu insert(Stu stu){
        stuService.updateStu(stu);
        return stu;
    }

    @GetMapping("/del")
    public String deleet(int sno){
        stuService.deleteStu(sno);
        return "success";
    }

}
