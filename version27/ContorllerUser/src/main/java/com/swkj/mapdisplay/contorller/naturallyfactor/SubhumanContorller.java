package com.swkj.mapdisplay.contorller.naturallyfactor;

import com.swkj.mapdisplay.enitiy.SpreadSubhuman;
import com.swkj.mapdisplay.service.DropBaseServiceImpl;
import com.swkj.mapdisplay.service.RogatoryServiceImpl;
import com.swkj.mapdisplay.service.updateplatifonservice.AmendBotaServiceImpl;
import com.swkj.mapdisplay.utils.Determine;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/*
     @人为信息表操作
  */
@RestController
public class SubhumanContorller {
       @Autowired
        private RogatoryServiceImpl animalService;
        @Autowired
        private AmendBotaServiceImpl amendBotaService;
        @Autowired
        private DropBaseServiceImpl dropBaseService;
        //查询人类活动信息
        @RequestMapping(value = "/querySpreadSub/{SPID}/{PatrolId}",method = RequestMethod.GET)
        public String querySpreadSub(@PathVariable("SPID") String SPID, @PathVariable("PatrolId") String PatrolId){
            //查询人类活动信息
            List<SpreadSubhuman> spreadSubhumen = animalService.queryBspreadsub(SPID,PatrolId);
            return ShiroConfiguration.getjson(spreadSubhumen,null);
        }
        // 加载人类活动信息下拉框里面干扰类型,干扰强度,干扰时间,执法依据的值
       @RequestMapping("/selectXhPeopleAction")
       public String selectXhPeopleAction(){
        return ShiroConfiguration.xhPeopleAction(dropBaseService.ActionIfon("InterfereType"),dropBaseService.ActionIfon("InterfereStrg"),dropBaseService.ActionIfon("InterfereTime"),dropBaseService.ActionIfon("Law"));
    }
        //修改人为活动信息
        @RequestMapping("/modification/{subJson}")
        public String modification(@PathVariable("subJson") String subJson, SpreadSubhuman sub){
            SpreadSubhuman convertJsonObject =(SpreadSubhuman) ShiroConfiguration.convertJsonObject(subJson, sub);
            boolean isok = amendBotaService.selectJamming(convertJsonObject);
            return Determine.updateSuccess(isok);
        }
        //增加人为干扰信息
        @RequestMapping("/addModification/{json}")
       public String addModification(@PathVariable("json") String json,SpreadSubhuman subhuman){

            return amendBotaService.redisJamming(json,subhuman);
        }
        //删除人为干扰信息
        @RequestMapping("/deleteModification/{SPID}/{PatrolId}")
        public String deleteModification(@PathVariable("SPID")String SPID,@PathVariable("PatrolId")String PatrolId){
            return Determine.updateSuccess(amendBotaService.droJamming(SPID, PatrolId));
        }
}
