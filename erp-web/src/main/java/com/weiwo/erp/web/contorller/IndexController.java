package com.weiwo.erp.web.contorller;


import com.weiwo.erp.Interface.business.ContractInterface;
import com.weiwo.erp.Interface.system.SystemInterface;
import com.weiwo.erp.dto.RespDto;
import com.weiwo.erp.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private SystemInterface systemInterface;
    @Autowired
    private ContractInterface businessInterface;

    @RequestMapping("index")
    public String index(){
        return "index";
    }


    @RequestMapping("page")
    public String page(String url){
        return url;
    }


    @RequestMapping("/*.html")
    public String repage(String url){
        return url;
    }

    @RequestMapping("/hell")
    @ResponseBody
    public RespDto hell(String url){
        return new RespDto();
    }

/*    @RequestMapping("/findAll")
    @ResponseBody
    public RespDto findAll(ContractDao dao){
        ResultUtil page=businessInterface.findAll(dao);
        List<Contract> contracts=page.getData();
        return new RespDto();
    }

    @RequestMapping("/findOnId")
    @ResponseBody
    public RespDto findOnId(Long id){
        Contract contract=businessInterface.findOne(id);
        return new RespDto();
    }

    @RequestMapping("/findPage")
    @ResponseBody
    public RespDto findPage(ContractDao dao){
        ResultUtil page=businessInterface.findPage(dao);
        List<Contract> contracts=page.getData();
        return new RespDto();
    }

    @RequestMapping("/findOne")
    @ResponseBody
    public RespDto findOne(ContractDao dao){
         Contract list=businessInterface.findOne(dao);
        return new RespDto();
    }

    @RequestMapping("/findCustomMapper")
    @ResponseBody
    public RespDto findCustomMapper(ContractDao dao){
        ResultUtil list=businessInterface.findCustomMapper(dao);
        return new RespDto(list);
    }
*/



}
