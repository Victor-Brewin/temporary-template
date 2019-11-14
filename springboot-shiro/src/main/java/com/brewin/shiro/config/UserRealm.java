package com.brewin.shiro.config;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.brewin.shiro.domain.User;
import com.brewin.shiro.service.UserService;

public class UserRealm extends AuthorizingRealm{
	@Autowired
    private UserService userService;
	//授权逻辑
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		System.out.println("执行授权逻辑");
		//给资源进行授权
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//添加资源的授权字符串
//		info.addStringPermission("user:update");
		
		//获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        //System.out.println(subject.getPrincipal());
        User dbUser = userService.findById(user.getId());
       // info.addStringPermission("user:add");
        info.addStringPermission(dbUser.getPerms());
		return info;
	}
//认证逻辑
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		System.out.println("执行认证逻辑");
		   //编写shiro判断逻辑，判断用户名和密码
        UsernamePasswordToken token  =  (UsernamePasswordToken)authenticationToken;

        User user = userService.findByName(token.getUsername());

        //1、判断用户名
        if(user == null){
            //用户名不存在
            return null; //shiro底层会抛出UnKnowAccountException
        }

        //2、判断密码, 这里的user是principal
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }


}
