package com.weiwo.erp.entity;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 预算表
 */
@Data
@Entity
@Table(name = "biz_budget_business")
public class BudgetBusiness extends BaseEntity {


    private String contractNumber;//合同编号
    private Date dateOfContract;//合同签订日期
    private String businessRelationId;//合同业务员id
    private String businessRelationName;//合同业务员
    //private int contractCreateId;//合同创建人id
    //private String contractCreateName;//合同创建人
    private String purchaseOrderNumber;//采购单号
    private int purchaseCreateId;//采购单创建人id
    private String purchaseCreateName;//采购单创建人
    private Date shipStartDate;//发货日期
    private String payOrderWayTypeName;//付款方式
    private double procurementPrice;//采购合同金额
    private double accountPaid;//已付款
    private double nonPayment;//未付款
    private double budget;//预算金额
    private String budgeTime;//预算日期
    private int manageId;//创建人的领导Id
    private String relationId;//关联人Id
    //private String budgeDetails;//预算详情
}
