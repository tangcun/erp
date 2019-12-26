package com.weiwo.erp.util;


import com.github.pagehelper.PageHelper;
import com.weiwo.erp.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.shiro.SecurityUtils;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageUtil extends BaseEntity implements Serializable {
    private Integer pageNo;
    private Integer length;
    private String orderBy;

    public  void initializationPage(){
        PageHelper.startPage(1,10);
    }

    public PageUtil(Integer id){
        super(id);
    }

//    public void page(){
//        if(pageNo==0||pageNo==null){
//            pageNo=1;
//        }else {
//            pageNo+=1;
//        }
//        if(length==0||length==null){
//            length=10;
//        }
//        System.out.println("page执行");
//        PageHelper.startPage(pageNo,length,orderBy);
//    }

}
