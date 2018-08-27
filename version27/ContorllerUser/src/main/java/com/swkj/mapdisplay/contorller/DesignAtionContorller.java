package com.swkj.mapdisplay.contorller;

import com.swkj.mapdisplay.enitiy.*;
import com.swkj.mapdisplay.service.DesignAtionServiceImpl;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class DesignAtionContorller {
        @Autowired
       private DesignAtionServiceImpl designationService;
      //查询巡护过程中代号的信息
      @RequestMapping(value = "/setDesignationService",method = RequestMethod.GET)
      public String setDesignationService(String patroid) {
           //查询代号信息
           Designation designation = designationService.selectBydesig(patroid);
           //将代号转换成指定的值
           List<BaseDict> list = designationService.selectByappoint(designation);
           return ShiroConfiguration.getobjectadd(list);
      }
      //查询巡护过程中BHQ_SpreadSub表的动物的要素信息和植物的要素信息并同时将它们返回给前端
      @RequestMapping(value = "/getSpreadSubInfo/{spid}/{PatrolSubId}",method = RequestMethod.GET)
      public String getSpreadSubInfo(@PathVariable("spid") String spid,@PathVariable("PatrolSubId")Integer PatrolSubId){
          //动物要素信息
          List<PatrolFindInfoSub> patrolFindInfoSub= designationService.queryBySpreadSub(spid,PatrolSubId);
          //植物要素信息
          List<SpreadSubXhPlant> spreadSubMark=designationService.getBySpreadSubifon(spid,PatrolSubId);
          CombinAtionPart combinAtionPart=new CombinAtionPart(patrolFindInfoSub,spreadSubMark);
          return ShiroConfiguration.getjsonlist(null,combinAtionPart);
      }
     //将BHQ_SpreadSub表中所有动物和植物的代号转换成具体的值
     @RequestMapping(value = "/selectinFormation/{lsid}/{PatrolSubId}",method = RequestMethod.GET)
     public String selectinFormation(@PathVariable("lsid")String lsid,@PathVariable("PatrolSubId")Integer PatrolSubId){
          //查询要素代号的值
          SpreadSubMark spreadSubMark= designationService.getSubMark(lsid,PatrolSubId);
          //将要素代号的值转换成指定的值
          List<BaseDict> baseDict=designationService.selectbaseMark(spreadSubMark);
          return  ShiroConfiguration.getobjectadd(baseDict);
    }
    //查询植物分布信息
    @RequestMapping("/queryBySpreadSubifon/{spid}/{PatrolSubId}")
    public String queryBySpreadSubifon(@PathVariable("spid")String spid,@PathVariable("PatrolSubId")Integer PatrolSubId){
          return ShiroConfiguration.getjson(designationService.getBySpreadSubifon(spid,PatrolSubId),null);
    }
}
