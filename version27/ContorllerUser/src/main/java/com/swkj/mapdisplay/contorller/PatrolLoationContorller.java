package com.swkj.mapdisplay.contorller;
import com.swkj.mapdisplay.enitiy.*;
import com.swkj.mapdisplay.service.PatrolLocationServiceimpl;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/*
    查询路线和巡护信息的控制器
 */
@RestController
public class PatrolLoationContorller {
    @Autowired
    private PatrolLocationServiceimpl patrolLocationServiceimpl;
    //查询所有的patrolId

    @RequestMapping(value = "/queryList",method = RequestMethod.GET)
    public JSONObject queryList() {
        List<String> patrolLocationInfos= patrolLocationServiceimpl.query();
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("data",patrolLocationInfos);
        //返回PatrolLocationInfo集合
        return jsonObject;
    }
    //返回所有的patrolId的数量
    @RequestMapping(value = "/queryListNumber",method = RequestMethod.GET)
    public int queryListunmber() {
        List<String> list = patrolLocationServiceimpl.query();
        int unmber = list.size();
        return unmber;
    }
    //根据id查询出所有的lat,lng
    @RequestMapping(value = "/selectList",method = RequestMethod.GET)
    public String queryPatrol(String patrolId) {
             List<PatrolLocationInfo> list = patrolLocationServiceimpl.querypatrolIdifon(patrolId);
            JSONObject jsonObject=new JSONObject();
          // 将一个集合转换成一个二维数组
         Object[][] objects = new Object[list.size()][2];
         for (int i = 0; i < list.size(); i++) {
            PatrolLocationInfo locationInfo = list.get(i);
            objects[i][0] = locationInfo.getLng();
            objects[i][1] = locationInfo.getLat();
    }
        JSONArray jsonArray=JSONArray.fromObject(objects);
        String str= jsonArray.toString();
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+list.size()+",\"data\":"+str+"}";
        return  jso;
    }
        //根据id删除信息
        @RequestMapping(value = "/deleteData",method = RequestMethod.GET)
        public int delectPatrolLocationInfo(String patrolId){
          boolean status=  patrolLocationServiceimpl.delectpatrolIdinfo(patrolId);
          //返回表中影响的行数，1代表删除成功，0代表删除失败
          if (status){
              return 1;
          }else{
              return 0;
          }
        }
        //增加数据
        @RequestMapping(value = "/lineData",method = RequestMethod.GET)
       public int addPatrolLocation(PatrolLocationInfo patrolLocationInfo) {
            //获取随机生成的PatrolId
            patrolLocationInfo.setPatrolId(ShiroConfiguration.getUUID());
            List<String> list = patrolLocationServiceimpl.query();
            for (int i = 0; i < list.size(); i++) {
                String content = list.get(i);
                if (patrolLocationInfo.getPatrolId().equals(content)) {
                    //返回2提示用户增加失败，提示patrolId重复
                    return 2;
                }
                }
                patrolLocationInfo.setLocationTime(new Date());
                patrolLocationInfo.setLocationId("49");
                patrolLocationInfo.setUserId("18");
                patrolLocationInfo.setAltitude("0.0");
                patrolLocationInfo.setGravity("");
                patrolLocationInfo.setSpeed(0.00000000);
                patrolLocationInfo.setLength(0.00000000);
                patrolLocationInfo.setInfoState(1);
                patrolLocationInfo.setTaskState(0);
                patrolLocationInfo.setReciverDate(new Date());
                // patrolLocationInfo.setLocationTime(ShiroConfiguration.getdata().toString());
                // patrolLocationInfo.setReciverDate(ShiroConfiguration.getdata());
                System.out.print(patrolLocationInfo.getPatrolId());
                boolean msg=  patrolLocationServiceimpl.addpatrolIdinfomapper(patrolLocationInfo);
                //返回1代表增加成功，返回0代表增加失败
                if (msg){
                    return 1;
                }
                   return 0;
            }
            //查询巡航轨迹
             @RequestMapping(value = "/contrailInfo",method = RequestMethod.GET)
             //代表当前用户要Constants.AUTHORITY的角色才能访问该方法
            // @RequiresRoles({(Constants.AUTHORITY)})
             public  String queryPatrol(){
                 List<PatrolManageInfo> list= patrolLocationServiceimpl.queryPatrol();
                if (list.size()==0){
                    return ShiroConfiguration.getjson(list,null);
                }
                 return ShiroConfiguration.getjson(list,null);
             }
             //根据巡护id查询出相对应的值
              @RequestMapping(value = "/aboutScroll",method = RequestMethod.GET)
               public String corresponDingdata(String patrolId){
                       List<PatrolManageInfo> list=patrolLocationServiceimpl.manageInfoid(patrolId);
                      if (list.size()==0 && list==null){
                          //返回0表示没有查询到信息
                          return "0";
                      }
                        return ShiroConfiguration.getjson(list,null);
              }
              //查询在巡护过程中动物和生物因子的信息
             @RequestMapping(value = "/patrolInfo",method = RequestMethod.GET)
             public String patrolFindInfoSub(String patrolId) {
                  //查询的动物信息
                  List<PatrolFindInfoSub> sub = patrolLocationServiceimpl.patroprocess(patrolId);
                  List<PatrolFindInfoSubSJYZ> list=patrolLocationServiceimpl.patrocessList(patrolId);
                 CombinAtion combinAtion = new CombinAtion(sub, list);
                 return ShiroConfiguration.getjsonlist(null,combinAtion);
             }
}
