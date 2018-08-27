package com.swkj.mapdisplay.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CommonController {
         @RequestMapping("/index")
      public String index(){
             return "home";
         }
         @Autowired
         private StringRedisTemplate redisTemplate;
         List<String> list=new ArrayList<>();

         @RequestMapping("/sun")
         @ResponseBody
         public String sun(){
             if (!redisTemplate.hasKey("ss")) {
                 list.add("张三");
                 list.add("李四");
                 redisTemplate.opsForValue().append("ss", list.toString());
                 return "存储成功!";
             }
             return null;
         }

         @RequestMapping("/get")
         @ResponseBody
      public String get(){
             String ss = redisTemplate.opsForValue().get("ss");
            // System.out.print("redis缓存中的值为:"+ss);
            // redisTemplate.delete("ss");yes
               return ss;
         }

}