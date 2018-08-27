package com.swkj.mapdisplay.utils;

import java.util.HashMap;
import java.util.Map;

public class Determine {
      //判断修改是否成功
      public static Map<String, Object> success(boolean isok,String js){
          Map<String,Object> map=new HashMap<>();
               if (isok){
                   map.put("code",1);
                   map.put("msg","执行成功");
                   map.put("data",js);
                  return map;
              }else{
                   map.put("code",0);
                   map.put("msg","执行失败");
                  return map;
              }
      }
      //判断修改是否成功
      public static String updateSuccess(boolean isok){
          if (isok){
              return "1";
          }else{
              return "0";
          }
      }
      //拼接
     public static Map<String, Object> MapIfon(String json){
          Map<String,Object> map=new HashMap<>();
          map.put("code",0);
          map.put("msg","");
          map.put("count",1);
          map.put("data",json);
          return map;
     }
}
