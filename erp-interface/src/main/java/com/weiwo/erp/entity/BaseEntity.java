package com.weiwo.erp.entity;

import org.apache.shiro.SecurityUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 所有实体类基类
 */
@Data
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    /**
     * 创建人id(登录表的id)
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 所属账户ID
     */
    private Integer accountId;

    public BaseEntity() {
      //  initBaseEntity();
    }

    public BaseEntity(Integer id) {
        this.id = id;
    }

    public void initBaseEntity(){
        BaseEntity baseEntity = (BaseEntity) SecurityUtils.getSubject().getSession().getAttribute("baseEntity");
        this.setCreateId(baseEntity.getCreateId());
        this.setCreateTime(new Date());
        this.setAccountId(baseEntity.getAccountId());
        //this.setCreateName(baseEntity.getCreateName());
    };


}
