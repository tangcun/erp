package com.weiwo.erp.Interface.business;


import com.weiwo.erp.baseService.BaseService;
import com.weiwo.erp.entity.Contract;


public interface ContractInterface extends BaseService<Contract> {

    Contract findTestEntity(Integer id);

}



