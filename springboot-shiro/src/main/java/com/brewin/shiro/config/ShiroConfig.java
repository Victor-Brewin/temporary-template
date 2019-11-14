package com.brewin.shiro.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfig {
	//创建ShiroFileterFactoryBean
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//添加shiro内置过滤器
		/**
		 * anno:无需认证(登录)可以访问
		 * authc:必须认证才可以访问
		 * user:如果使用rememberMe的功能可以直接访问
		 * perms:该资源必须得到资源权限才可以访问
		 * role:该资源必须得到角色权限才可以访问
		 */
		
		Map<String,String> filterMap = new LinkedHashMap<String,String>();
        //配置记住我或认证通过可以访问的地址
		filterMap.put("/testThymeleaf", "user");
		
		
		
		//设置放行页面
		filterMap.put("/testThymeleaf","anon");
		filterMap.put("/login","anon");

		//授权过滤器
		filterMap.put("/add","perms[user:add]");
		filterMap.put("/update","perms[user:update]");
		filterMap.put("/*", "authc");
		
		//拦截后默认跳转到login.jsp,修改跳转页面
		shiroFilterFactoryBean.setLoginUrl("/toLogin");
		//设置未授权提示页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
		
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		return shiroFilterFactoryBean;
	}
	
	//创建DefaultWebSecurityManager
	@Bean("securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
		//关联Realm
		securityManager.setRealm(userRealm);
		return securityManager;
	}
	//创建Realm
	@Bean(name="userRealm")
	public UserRealm getRealm() {
		return new UserRealm();
	}
	
	/**
     * 配置ShiroDialect，用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

    /**
     2   * cookie对象;
     3   * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
     4   * @return
     5  */
     @Bean
     public SimpleCookie rememberMeCookie(){
       //System.out.println("ShiroConfiguration.rememberMeCookie()");
       //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
       SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
       //<!-- 记住我cookie生效时间30天 ,单位秒;-->
       simpleCookie.setMaxAge(259200);
       return simpleCookie;
     }

        /**
        * cookie管理对象;
        * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
        * @return
       */
        @Bean
        public CookieRememberMeManager rememberMeManager(){
               //System.out.println("ShiroConfiguration.rememberMeManager()");
               CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
               cookieRememberMeManager.setCookie(rememberMeCookie());
               //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
               cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
               return cookieRememberMeManager;
         }

}
