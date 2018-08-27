package com.swkj.mapdisplay.contorller.longincontorller;

import com.swkj.mapdisplay.enitiy.Boundary;
import com.swkj.mapdisplay.service.login.EntryPlayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EntryContorller {
       @Autowired
       private EntryPlayServiceImpl entryPlayService;
        @RequestMapping(value = "/longinUrl",method = RequestMethod.GET)
        @ResponseBody
        public void longin(String user,String password){
            user="界桩界碑001";
            password="0003";
           Boundary enty= entryPlayService.LonginUser(user, password);
           if (enty==null){
               System.out.print("0");
           }else{
               System.out.print("1");
           }
        }
}
