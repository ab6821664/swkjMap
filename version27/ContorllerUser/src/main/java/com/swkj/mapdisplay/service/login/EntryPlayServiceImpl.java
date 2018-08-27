package com.swkj.mapdisplay.service.login;

import com.swkj.mapdisplay.enitiy.Boundary;
import com.swkj.mapdisplay.mapper.loginmapper.LoginMapper;
import com.swkj.mapdisplay.service.login.Longinimpl.EntryPlayService;
import com.swkj.mapdisplay.utils.utilsImpl.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryPlayServiceImpl implements EntryPlayService {
    @Autowired
     private LoginMapper loginMapper;

    @Override
    public Boundary Longin(String user) {
        return loginMapper.Long(user);
    }
    @Override
    public Boundary LonginUser(String user, String password) {
          Subject subject=SecurityUtils.getSubject();
          Session session= subject.getSession();
          UsernamePasswordToken token=new UsernamePasswordToken(user,password);
           try {
               subject.login(token);
               Boundary boundary=  Longin(user);
               //将登陆的用户存放在session中
               session.setAttribute(Constants.SESSION_USER,boundary);
               return boundary;
           }catch (AuthenticationException e){
               return null;
           }

    }
}
