package com.huidian.mapper;

import com.huidian.domain.Stu;
import org.springframework.data.jpa.repository.JpaRepository;


//不用@mapper 注释
public interface StuMapper extends JpaRepository<Stu,Integer> {

}
