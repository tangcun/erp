package com.weiwo.erp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Karen on 2018/3/13.
 * 角色表
 */
@Data
@Entity
@Table(name = "sys_role")
public class Role extends UpdateEntity{

    private Integer sort;//排序
    private String name;//角色名称
    private Integer status;//状态0.启用,1.禁用
    private Boolean checked;


}
