package com.swkj.mapdisplay.interceptorbag;

import com.swkj.mapdisplay.enitiy.Boundary;
import com.swkj.mapdisplay.service.login.EntryPlayServiceImpl;
import com.swkj.mapdisplay.utils.utilsImpl.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MyShiroRelam extends AuthorizingRealm {
    @Autowired
    private EntryPlayServiceImpl longin;
    //验证权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
         System.out.print("----验证权限----");
         Subject subject= SecurityUtils.getSubject();
         //创建session对象
         Session session= subject.getSession();
         //将登陆成功的用户存储在session中
         Boundary boundary=(Boundary) session.getAttribute(Constants.SESSION_USER);
         //模拟从数据库中查询出来的用户角色
         List<String> mlist=new ArrayList<>();
         mlist.add("root");
         mlist.add("admin");
         if (mlist !=null && mlist.size()>0){
           SimpleAuthorizationInfo info= new  SimpleAuthorizationInfo();
            //给当前用户分配角色
            info.addRoles(mlist);
            //当前用户的权限
            //info.addStringPermission("admin");
             return info;
         }
        return null;
    }
   //验证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户登录时的用户名
        String user=(String) authenticationToken.getPrincipal();
        Boundary username= longin.Longin(user);
        if (username!=null){
            return new SimpleAuthenticationInfo(username,username.getBoundaryID(),getName());
        }else{
        }
        return null;
    }
}
