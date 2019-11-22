package com.huidian.service.impl;

import com.huidian.domain.Stu;
import com.huidian.mapper.StuMapper;
import com.huidian.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;


//@CacheConfig(cacheNames = "Stu") //抽取公共的缓存配置，统一管理
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    StuMapper stuMapper;
    @Override
    public List<Stu> findAll() {
        return stuMapper.findAll();
    }

    /**
     *     @Cacheable 的参数
     *     condition 对缓存的条件进行删选  满足了才缓存
     *      unless  对缓存的条件进行删选  满足了  “不缓存” #id == 1008
     * @param sno
     * @return
     */
    @Cacheable(cacheNames = "Stu",key = "#sno")
    @Override
    public Stu findById(int sno) {
        System.out.println("查询"+sno+"号人物");
        return stuMapper.findById(sno).get();
    }

    @Override
    public void insertStu(Stu stu) {
        stuMapper.save(stu);

    }

    /**
     * 清除数据，之后清除缓存
     *          参数：
     *              allEntries  清除所有缓存
     *              beforeInvocation  先清除缓存，之后清除数据
     *                      默认为 false
     *                      为防止清除数据之后操作出现错误，缓存未清除，影响之后的查询结果
     *                      可以修改为true
     *
     * @param sno
     */

    //@Caching  @Cacheable、@CachePut、@CacheEvict 三者的集合，可以同时配置多个
    @CacheEvict(cacheNames = "Stu",key = "#sno",beforeInvocation = true)
    @Override
    public void deleteStu(int sno) {
        System.out.println("删除"+sno+"号人物");
        //stuMapper.deleteById(sno);
    }

    /**
     * 更新数据并更新缓存
     * @param stu
     * @return
     */
    @CachePut(cacheNames = "Stu",key = "#result.sno")
    @Override
    public Stu updateStu(Stu stu) {

        stuMapper.save(stu);
        return stu;
    }
}
