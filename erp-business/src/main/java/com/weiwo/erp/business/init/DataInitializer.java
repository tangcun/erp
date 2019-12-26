package com.weiwo.erp.business.init;

import com.weiwo.erp.actable.service.SysMysqlCreateTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class DataInitializer {
 //   @Autowired
  //  private SysMysqlCreateTableService sysMysqlCreateTableService;

    @PostConstruct
    public void initMethod() throws Exception {
     //   System.out.println("initMethod 被执行");
     //   sysMysqlCreateTableService.createMysqlTable();
    }
    @PreDestroy
    public void destroyMethod() throws Exception {
    //    System.out.println("destroyMethod 被执行");
    }
}
