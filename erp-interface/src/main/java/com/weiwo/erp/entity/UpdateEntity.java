package com.weiwo.erp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * 可修改实体类的基类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class UpdateEntity extends BaseEntity{

    /**
     *  最后修改人id(登录表的id)
     */
    @Column(name = "update_id")
    private Integer updateId;
    /**
     *  最后修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

}
