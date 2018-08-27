package com.swkj.mapdisplay.contorller;

import com.swkj.mapdisplay.service.DropBaseServiceImpl;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DropBaseContorller {
       @Autowired
        private DropBaseServiceImpl dropBaseService;
        //将动物的行为信息和痕迹类型信息一起返回给前台
       @RequestMapping("/queryActionTraceTimeIfon")
       public String queryActionTraceTimeIfon(){      //动物行为信息                         动物痕迹类型信息                            动物痕迹时间信息
           return ShiroConfiguration.actionTraceTime(dropBaseService.ActionIfon("Action"),dropBaseService.ActionIfon("TraceType"),dropBaseService.ActionIfon("TraceTime"));
       }
       //将植物的生长类型，健康状态，物候期返回给前台
      @RequestMapping(value = "/plantInformation",method = RequestMethod.GET)
       public String plantInformation(){
           //植物下拉框中的值
           return ShiroConfiguration.plantTraceTime(dropBaseService.ActionIfon("GrowthSort"),dropBaseService.ActionIfon("HealthStatus"),dropBaseService.ActionIfon("Phenological"));
       }
       //查询动物名字信息和AnimalCode
       @RequestMapping(value = "/inquiryAnimalCode",method = RequestMethod.GET)
       public String inquiryAnimalCode(){
           return ShiroConfiguration.getjson(dropBaseService.selectAnimalCode(),null);
       }
       //查询植物名字信息和BotanyCode
       @RequestMapping(value = "/inquiryBotanyCode",method = RequestMethod.GET)
      public String inquiryBotanyCode(){
           return ShiroConfiguration.getjson(dropBaseService.selectBotanyCode(),null);
       }

}
