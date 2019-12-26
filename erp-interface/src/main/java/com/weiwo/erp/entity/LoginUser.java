package com.weiwo.erp.entity;

import lombok.Data;

import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "biz_login_user")
public class LoginUser extends DeleteEntity {
    /**
     * 系统登录表
     * 系统登录方有三个
     * 1.员工
     * 2.客户
     * 3.供应商
     * 多角色，号隔开
     */
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String nickName;
    private String userRole;
    private String loginUserRoleId;
    private Boolean activationState;
    private Boolean cancellationState;
    private Long gender;
    private Date registrationTime;


}
