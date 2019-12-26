package com.weiwo.erp.business.service;



import com.weiwo.erp.baseService.BaseService;
import com.weiwo.erp.entity.Contract;

public interface ContractService extends BaseService<Contract> {

    Contract findTestEntity(Integer id);

}
