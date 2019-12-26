package com.weiwo.erp.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "biz_business_tracking")
public class BusinessTracking extends BaseEntity {

    private String contractNumber;//合同号
    private String businessName;//业务员
    private String relationId;//业务员
    private String customerOrder;//客户单号
    private Date shipStartDate;//
    private Date shipEndDate;//客户交期
    private String productId;//产品ID
    private String productCode;//产品代码
    private String productNum;//产品数量
    private String productColor;//产品颜色
    private String stockNum;//库存数量
    private double totalRmb;//总金额
    private String customerCompanyName;//客户公司名称
    private String linkmanPhone;//联系电话
    private String linkmanEmail;//联系邮箱
    private String memo;//合同备注
    private double payment;//付款金额
    private Date paymentDate;//付款日期
    private double tailMoney;//尾款
    private String paymentMethod;//付款方式
    private int paymentStatus;//付款状态
    private String paymentMemo;//付款备注
    private int designSketchStatus;//效果图状态
    private String designSketch;//效果图
    private Date confirmDate;//最晚交期
    private String supplierName;//供应商
    private int productionDays;//生产时间
    private Date latestOrderDate;//最晚下单日期
    private Date orderDate;//订单下单日期
    private Date purchaseDate;//采购单交期
    private String shippingMethod;//运输方式
    private int shippingDays;//运输时间
    private String shippingNumber;//运单号
    private String purchaseMemo;//采购备注
    private Date sendStockDate;//到达仓库日期
    private Date stockSendDate;//仓库发货日期
    private Date arriveDate;//到货日期
    private boolean satisfy;//是否满足

    private double grossVolume;//每箱体积
    private double grossNum;//箱数
    private String quality;//质检情况
    private double grossWeight;//每箱毛重量
    private String qualityMemo;//质检备注
    private String qualityImage;//质检图片
    private Date expectedConfirmationDate;//预计确认日期
    private Date latestConfirmationDate;//最晚确认日期

    private Date proofingDate;//打样日期
    private Date completionProofingDate;//打样日期
    private String purchaseRelationName;//采购员
    private String linkman;//联系人
    private boolean urgentOrder;//是否急单

    private int status;//状态
    private int purchaseStatus;//采购状态
    private int printingSample;//应刷样
    private int factoryDelay;//工厂是否延期
    private int delayDays;//延期天数
    private Date yqhjq;//延期后交期
    private String shippingMemo;//发货备注
    private double purchasePrice;//采购单价
    private double extraCharge;//额外费用
    private double purchaseTotal;//采购总货款

    //合同产品 id
    private String contractProductIds;

    private String transportType; //运输类型
    private String expressWay; //快递方式(运输方式)//跟上面重复，但出运单关联的是此字段
    private String flight;//航班
    private Date flightDate;//航班日期
    private Date deliverDate;//美国派送日期

    //删除标记
    @Column(name = "del_flag",updatable = false)
    private boolean delFlag;//删除标记：1删除2未删除
    private String receiveAddress;//收货地址---------

    private String ccMailbox;//抄送邮箱
}
