package com.huidian.service;

import com.huidian.domain.Stu;

import java.util.List;

public interface StuService {

    List<Stu> findAll();
    Stu findById(int sno);
    void insertStu(Stu stu);
    void deleteStu(int sno);
    Stu updateStu(Stu stu);
}
