package com.swkj.mapdisplay.contorller;

import com.swkj.mapdisplay.enitiy.SpreadFindQty;
import com.swkj.mapdisplay.service.NumberServiceImpl;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NumberController {
       @Autowired
       private NumberServiceImpl numberService;
        //查询动物数量信息
       @RequestMapping(value = "/animalNumber/{SPID}/{PatrolId}",method =RequestMethod.GET)
       public String animalNumber(@PathVariable("SPID") String SPID, @PathVariable("PatrolId") String PatrolId){
          List<SpreadFindQty> spreadFindQties= numberService.selectSpreadFindQty(SPID,PatrolId);
          return ShiroConfiguration.getgson(spreadFindQties,null);
       }
       //查询动物数量代号信息
       @RequestMapping("/queryNumberMark/{SPID}/{PatrolId}")
       public String queryNumberMark(@PathVariable("SPID") String SPID, @PathVariable("PatrolId") String PatrolId){
           return ShiroConfiguration.getgson(numberService.selectSpreadFindQty(SPID, PatrolId),null);
       }
}
