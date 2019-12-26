package com.weiwo.erp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * 可作废实体类的基类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class DeleteEntity extends UpdateEntity{

    /**
     *  作废标记：假，未作废；真，作废
     */
    @Column(name = "del_flag",updatable = false)
    private boolean delFlag;

}
