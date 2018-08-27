package com.swkj.mapdisplay.utils;

import com.google.gson.GsonBuilder;
import com.swkj.mapdisplay.enitiy.BaseDict;
import com.google.gson.Gson;
import com.swkj.mapdisplay.enitiy.QuadratData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.shiro.crypto.hash.SimpleHash;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;

//一个MD5的加密算法
        public class ShiroConfiguration{
        public static Object Simplmd5(String password){
            String hashAlgorithmName = "MD5";
           // String credentials = "123456";
             int hashIterations = 1024;
             Object object= new SimpleHash(hashAlgorithmName, password, null, hashIterations);
             return object;
        }
        //随机生成一个36位的id
        public static String getUUID(){
          return  UUID.randomUUID().toString ();
        }
        public static String getNumber(){
            Random readable=new Random();
            String number=readable.nextInt(1000)+"";
            int reaLength=number.length();
            for (int i=0;i<=3-reaLength;i++){
                number="0"+number;
            }
           return number;
        }
        //获取当前的日期
        public static String getdata(){
            Date date=new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            String stringdate= dateFormat.format(date);
            return stringdate;
        }
         //将集合和对象转换成json数组的方法
          public static String getjson(List<?> list,Object object){
              String js=null;
              JsonConfig jsonConfig=new JsonConfig();
              JsonDateValueProcessor jsonDateValueProcessor=new JsonDateValueProcessor();
              jsonConfig.registerJsonValueProcessor(Date.class,jsonDateValueProcessor);
              JSONArray array=new JSONArray();
              if (list==null&object==null){
                  js = "{\"code\":0,\"msg\":\"\",\"count\":" +0 + ",\"data\":" + array + "}";
                  return js;
              }else if (object==null){
                        array = array.fromObject(list, jsonConfig);
                        js = "{\"code\":0,\"msg\":\"\",\"count\":" +list.size() + ",\"data\":" + array + "}";
              }else {
                  array = array.fromObject(object, jsonConfig);
                  js = "{\"code\":0,\"msg\":\"\",\"count\":" + 1 + ",\"data\":" + array + "}";
              }
              return js;

          }
    //将集合和对象转换成json对象的方法
    public static String getjsonlist(List<?> list,Object object){
        String js=null;
        JsonConfig jsonConfig=new JsonConfig();
        JsonDateValueProcessor jsonDateValueProcessor=new JsonDateValueProcessor();
        jsonConfig.registerJsonValueProcessor(Date.class,jsonDateValueProcessor);
        JSONObject array= JSONObject.fromObject(list);
        if (list==null&object==null){
            js = "{\"code\":0,\"msg\":\"\",\"count\":" +0 + ",\"data\":" + array + "}";
            return js;
        }else if (object==null){
            js = "{\"code\":0,\"msg\":\"\",\"count\":" +list.size() + ",\"data\":" + array + "}";
        }else {
            array = array.fromObject(object, jsonConfig);
            js = "{\"code\":0,\"msg\":\"\",\"count\":" + 1 + ",\"data\":" + array + "}";
        }
        return js;
    }
      //将代号的信息转换成指定的值
      public static String getobjectadd(List<BaseDict> list){
         JSONObject jsonObject=  new  JSONObject();
          for (int i=0;i<list.size();i++){
              BaseDict baseDict= list.get(i);
              jsonObject.put(baseDict.getId(),baseDict.getName());
          }
         String js = "{\"code\":0,\"msg\":\"\",\"count\":" + list.size() + ",\"data\":" + jsonObject + "}";
            return js;
      }
      //在sjon序列化时自动忽略不需要的属性
      public static String getgson(List<?> list,Object object){
            if (object==null){
                //返回对象信息
                String gson=new Gson().toJson(list);
                String js = "{\"code\":0,\"msg\":\"\",\"count\":" + list.size() + ",\"data\":" + gson + "}";
                return js;
            }else {
                //返回对象集合信息
                String  gson= new Gson().toJson(object);
                String js = "{\"code\":0,\"msg\":\"\",\"count\":" + 1 + ",\"data\":" + gson + "}";
                return js;
            }
      }
            //将json对象转换成对象
            public static Object convertJsonObject(String jsonObject,Object object){
               JSONObject json= JSONObject.fromObject(jsonObject);
               object=JSONObject.toBean(json,object.getClass());
              return object;
        }
        //拼接
        public static String actionTraceTime(List<?> mlist,List<?> list,List<?> mylist){
            //String js = "{\"code\":0,\"msg\":\"\",\"count\":" + list.size() + ",\"data\":{\"Action\":"+new Gson().toJson(mlist)+",\"TraceType\":"+new Gson().toJson(list)+",\"TraceType\":\"+new Gson().toJson(list)+"}}";
            String js = "{\"code\":0,\"msg\":\"\",\"count\":" + list.size() + ",\"data\":{\"Action\":"+new Gson().toJson(mlist)+",\"TraceType\":"+new Gson().toJson(list)+",\"TraceTime\":"+new Gson().toJson(mylist)+"}}";
            return js;
        }
    //拼接
    public static String plantTraceTime(List<?> mlist,List<?> list,List<?> myList){
        String js = "{\"code\":0,\"msg\":\"\",\"count\":" + list.size() + ",\"data\":{\"GrowthSort\":"+new Gson().toJson(mlist)+",\"HealthStatus\":"+new Gson().toJson(list)+",\"Phenological\":"+new Gson().toJson(myList)+"}}";
        return js;
    }
    public static String xhPeopleAction(List<?> mlist,List<?> list,List<?> myList,List<?> ob){
        String js = "{\"code\":0,\"msg\":\"\",\"count\":" + list.size() + ",\"data\":{\"InterfereType\":"+new Gson().toJson(mlist)+",\"InterfereStrg\":"+new Gson().toJson(list)+",\"InterfereTime\":"+new Gson().toJson(myList)+",\"Law\":"+new Gson().toJson(ob)+"}}";
        return js;
    }
    public static String xhDisaster(List<?> mlist,List<?> list,List<?> myList){
        String js = "{\"code\":0,\"msg\":\"\",\"count\":" + list.size() + ",\"data\":{\"disasterDegree\":"+new Gson().toJson(mlist)+",\"disasterType\":"+new Gson().toJson(list)+",\"disasterTime\":"+new Gson().toJson(myList)+"}}";
        return js;
    }
    //生境下拉框中的值
    public static String sJYZ(List<?> list,List<?> mlist,List<?> mylist,List<?> q,List<?> w,List<?> e,List<?> r,List<?> t){
        String js = "{\"code\":0,\"msg\":\"\",\"count\":" + list.size() + ",\"data\":{\"PlantType\":"+new Gson().toJson(list)+",\"HabitatId\":"+new Gson().toJson(mlist)+",\"Terrain\":"+new Gson().toJson(mylist)+",\"CovertType\":"+new Gson().toJson(q)+",\"CoverPorosity\":"+new Gson().toJson(w)+",\"CoverStructural\":"+new Gson().toJson(e)+",\"CoverColloid\":"+new Gson().toJson(r)+",\"SlopeId\":"+new Gson().toJson(t)+"}}";
        return js;
    }
    //摄像机下拉框里面的值
    public static String CameraIfon(List<Map<String,Object>> maps,List<Map<String,Object>> list,List<Map<String,Object>> mylist){
            String js = "{\"code\":0,\"msg\":\"\",\"count\":" + list.size() + ",\"data\":{\"RunState\":"+new Gson().toJson(maps)+",\"Factory\":"+new Gson().toJson(list)+",\"type\":"+new Gson().toJson(mylist)+"}}";
            return js;
    }
}
