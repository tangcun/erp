package com.weiwo.erp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Karen on 2018/3/12.
 * 合同表
 */
@Data
@Table(name = "biz_contract")
public class Contract extends DeleteEntity{
    //----  商城订单带入  ====业务自己填
    private String number;//合同号
    private long priceOrderId;//报价单Id
    private String priceOrderNumber;//报价单号
    private String companyHead;//出口抬头=====
    private long customerId;//客户关联Id-----
    private String customerEmail;//客户邮箱------
    private String customerName;//客户名称------
    private String customerCode;//客户代码------
    private String gradeName;//客户等级--------
    private String companyName;//公司名称-------
    private int companyId;//公司Id-------
    private String linkman;//联系人-------
    private String linkmanPhone;//联系人电话-------
    private String exitCompany;//出口公司名称------
    private String shipWay;//货运方式-------
    private String shipCompany;//装运公司
    private Date shipStartDate;//发货日期
    private Date shipEndDate;//到货日期------
    private String paymentName;//付款方式-----
    private String currency;//币种-----
    private double exchange;//汇率======
    private double total;//合计价格=====
    private double totalRmb;//合计人民币价格======
    private String clause;//条款=======
    private String clauseMemo;//条框备注========
    private String startPlace;//发送地-----
    private String endPlace;//目的地--------
    private String memo;//备注=========
    private int status;//1.处理中,2已审核,3.完结


    private int manageId;//创建人的领导Id
    private String manageName;//创建人的领导name

    private double originalTotal;//第一次最终审核人审核通过之后的金额(美元)
    private String totalRecord;//记录每次审核通过时的金额, 使用逗号隔开(美元)

    private int activityUserId;//审核人Id
    private int branchId; //业务员所属部门Id(精确到是哪个组)
    private String branchName;//业务员所属部门Name(精确到是哪个组)

    private String relationId;//关联人Id=====
    private String customerOrder;//客户订单号=======
    private double depositRatio;//定金比例
    private String businessRelationId;//业务关联Id=====
    private String businessRelationName;//业务关联名称=======
    private String purchaseRelationId;//采购关联Id
    private String purchaseRelationName;//采购关联Id
    private String assistRelationId;//协助关联Id
    private String assistRelationName;//协助关联Id
    private String proveRelationId;//证单关联Id
    private String proveRelationName;//证单关联Id

    private String receiveCompany;//收货公司-----
    private String receiveName;//收货人------
    private String receivePhone;//收货电话----
    private String receiveAddress;//收货地址---------
    private String payOrderWayTypeName;//付款方式--------

    @Column(updatable = false)
    private String randomCode;//随机码，唯一标识

    private double discountAmount;//折扣金额
    private double discountRmb;//折扣人民币
    private String discountExplain;//折扣说明

    @Transient
    private String activityUserName;
    private int receiveId;
    private String fileName;//文件名
    private String fileSize;//文件大小
    private Integer source;//订单来源------
    private Date synchDate;//订单同步时间
    private int accountFlag;//合同是否已结算, 0表示未结算, 1表示已结算
    @Transient
    private String customerAddress;


}
