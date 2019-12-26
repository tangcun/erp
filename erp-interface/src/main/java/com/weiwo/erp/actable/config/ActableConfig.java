package com.weiwo.erp.actable.config;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;


/**
 * 配置
 **/
//@Configuration
//@ConfigurationProperties(prefix = "starmark.actable")//前缀
@Data
@Component
public class ActableConfig {

    /**
     * 要扫描的model所在的pack
     */

    private String pack="com.weiwo.erp.entity" ;


    /**
     * 默认主键
     */
    private String primarykey="id";

    /**
     * 自动创建模式：update表示更新，create表示删除原表重新创建
     */

    private String tableAuto = "update";

}
