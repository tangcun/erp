package com.weiwo.erp.system.service;


import com.weiwo.erp.baseService.BaseServiceImpl;
import com.weiwo.erp.entity.Role;
import com.weiwo.erp.system.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService extends BaseServiceImpl<Role> {

    @Resource
    private RoleMapper roleMapper;

    public List<Role> findAll(){
  //      PageHelper.startPage(1, 10);
        return roleMapper.select(null);
    }
}
