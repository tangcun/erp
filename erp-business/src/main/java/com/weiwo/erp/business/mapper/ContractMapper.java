package com.weiwo.erp.business.mapper;


import com.github.abel533.mapper.Mapper;
import com.weiwo.erp.entity.Contract;


public interface ContractMapper extends Mapper<Contract> {

     Contract findTestEntity(Integer id);


}
