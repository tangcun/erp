package com.weiwo.erp.web.shiro;


import com.weiwo.erp.entity.BaseEntity;
import com.weiwo.erp.entity.LoginUser;
import com.weiwo.erp.util.SuppBeanUtils;
import io.github.howiefh.cas.dubbo.CustomerGenerateInterface;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class MyShiroRealm extends CasRealm {

    @Autowired
    private CustomerGenerateInterface customerGenerateInterface;

    protected final Map<String, SimpleAuthorizationInfo> roles = new ConcurrentHashMap<String, SimpleAuthorizationInfo>();

    /**
     * 设置角色和权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String account = (String) principals.getPrimaryPrincipal();
        log.info("account={}"+account+"--------------------设置角色和权限信息");
        SimpleAuthorizationInfo authorizationInfo = null;
        if (authorizationInfo == null) {
            authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.addStringPermissions(Arrays.asList(new String[]{"mallcrm Permissions"}));
            authorizationInfo.addRoles(Arrays.asList(new String[]{"mallcrm role"}));
            roles.put(account, authorizationInfo);
        }

        return authorizationInfo;
    }


    /**
     * 1、CAS认证 ,验证用户身份
     * 2、将用户基本信息设置到会话中
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {
        AuthenticationInfo authc = super.doGetAuthenticationInfo(token);



//        AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
//        Map attributes = principal.getAttributes();
//
//        String email=attributes .get("age");


        String account = (String) authc.getPrincipals().getPrimaryPrincipal();

        log.info("account={"+account+"}--------------------CAS认证 ,验证用户身份");

        log.info("--------------------将用户基本信息设置到会话中");
        Map<String,Object> loginUser = customerGenerateInterface.findUserByAccount(Integer.parseInt(account));
        LoginUser user= new LoginUser();

        Map<String,Object> new_map = new HashMap();
        for(String key:loginUser.keySet()){
            new_map.put(SuppBeanUtils.underlineToCamel(key), loginUser.get(key));
        }

            user=   SuppBeanUtils.mapToEntity(new_map,user);
        BaseEntity baseEntity=new BaseEntity();
        baseEntity.setCreateId(user.getId());
        //baseEntity.setCreateName(user.getUserName());
        baseEntity.setAccountId(user.getAccountId());

        log.info("--------------------设置到会话中的用户信息是："+user.toString());
        SecurityUtils.getSubject().getSession().setAttribute("user", user);
        SecurityUtils.getSubject().getSession().setAttribute("baseEntity", baseEntity);

        log.info("--------------------设置到会话中的用户信息成功："+authc.toString());
        return authc;
    }


}
