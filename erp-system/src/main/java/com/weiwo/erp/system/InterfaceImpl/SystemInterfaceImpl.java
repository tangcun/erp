package com.weiwo.erp.system.InterfaceImpl;

import com.weiwo.erp.Interface.system.SystemInterface;

import com.weiwo.erp.entity.Role;

import com.weiwo.erp.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemInterfaceImpl implements SystemInterface {

    @Autowired
    private RoleService roleService;



    @Override
    public List<Role> findAll() {
        return roleService.findAll();
    }


}
