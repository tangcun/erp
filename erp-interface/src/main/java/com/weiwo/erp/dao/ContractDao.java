package com.weiwo.erp.dao;

import com.weiwo.erp.util.PageUtil;
import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;
import java.util.Map;
@Data
public class ContractDao extends PageUtil {
    private Integer id;

    private Integer activityUserId;

    private String assistRelationId;

    private String assistRelationName;

    private Integer branchId;

    private String branchName;

    private String businessRelationId;

    private String businessRelationName;

    private String clause;

    private String clauseMemo;

    private String companyHead;

    private Integer companyId;

    private String companyName;

    private String currency;

    private String customerCode;

    private String customerEmail;

    private Long customerId;

    private String customerName;

    private String customerOrder;

    private Double depositRatio;

    private String endPlace;

    private Double exchange;

    private String exitCompany;

    private String gradeName;

    private String linkman;

    private String linkmanPhone;

    private Integer manageId;

    private String memo;

    private String number;

    private String payOrderWayTypeName;

    private String paymentName;

    private Long priceOrderId;

    private String priceOrderNumber;

    private String proveRelationId;

    private String proveRelationName;

    private String purchaseRelationId;

    private String purchaseRelationName;

    private String receiveAddress;

    private String receiveCompany;

    private String receiveName;

    private String receivePhone;

    private String relationId;

    private String shipCompany;

    private Date shipEndDate;

    private Date shipStartDate;

    private String shipWay;

    private String startPlace;

    private Integer status;

    private Double total;

    private Double totalRmb;

    private String randomCode;

    private Double originalTotal;

    private Double originalTotalRmb;

    private Double discountAmount;

    private String discountExplain;

    private Double discountRmb;

    private String totalRecord;

    private String manageName;

    private Integer receiveId;

    private String fileName;

    private String fileSize;

    private Integer source;

    private Date synchDate;

    private Integer accountFlag;

    private Boolean delFlag;

    private String productNumber;

    private Integer accountId;

    private boolean remove; //0未删除  1.已删除

}
