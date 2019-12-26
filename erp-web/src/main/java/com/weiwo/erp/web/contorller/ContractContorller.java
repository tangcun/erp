package com.weiwo.erp.web.contorller;

import com.weiwo.erp.Interface.business.ContractInterface;
import com.weiwo.erp.dao.ContractDao;
import com.weiwo.erp.dto.RespDto;
import com.weiwo.erp.entity.Contract;
import com.weiwo.erp.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractContorller {
    @Autowired
    private ContractInterface contractInterface;


    @RequestMapping("/findPage")
    @ResponseBody
    public RespDto findPage(ContractDao dao){
        ResultUtil page= contractInterface.findPage(dao);
        dao.initBaseEntity();
        List<Contract> contracts=page.getData();
        return new RespDto(page);
    }

    @RequestMapping("/findPage2")
    @ResponseBody
    public RespDto findPage2(ContractDao dao){
        Contract c = contractInterface.findTestEntity(dao.getId());
        int i = contractInterface.save(c);
        RespDto respDto = new RespDto();
        respDto.setResponseData(c);
        return respDto;
    }

    @RequestMapping("/findCustomMapper")
    @ResponseBody
    public RespDto findCustomMapper(ContractDao dao){
        Contract list= contractInterface.findOne(dao);
        return new RespDto();
    }

}
