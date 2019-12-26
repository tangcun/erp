package com.weiwo.erp.baseService;



import com.weiwo.erp.entity.BaseEntity;
import com.weiwo.erp.util.ResultUtil;

import java.util.List;

public interface BaseService<T extends BaseEntity> {

     int save(T t);
     int save(List<T> list);
     int delete(Integer id);
     int delete(List<Integer> idList);
     int update(T t);

     T findOne(Object parameter);
     T findOne(Integer id);

     List<T> findAll(Object parameter);
     List<T> findAll();

     ResultUtil<T> findPage(Object parameter);
     ResultUtil<T> findPage();


     ResultUtil<T> findCustomMapper(String key,Object parameter);





}
