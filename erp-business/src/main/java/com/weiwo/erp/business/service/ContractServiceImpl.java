package com.weiwo.erp.business.service;

import com.weiwo.erp.baseService.BaseServiceImpl;
import com.weiwo.erp.business.mapper.ContractMapper;
import com.weiwo.erp.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContractServiceImpl extends BaseServiceImpl<Contract> {

    @Autowired
    private ContractMapper contractMapper;


    public Contract findTestEntity(Integer id) {
        return contractMapper.findTestEntity(id);
    }

}
