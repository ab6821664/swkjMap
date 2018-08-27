package com.swkj.mapdisplay.contorller.calamity;

import com.swkj.mapdisplay.enitiy.SpreadSubnature;
import com.swkj.mapdisplay.service.DropBaseServiceImpl;
import com.swkj.mapdisplay.service.RogatoryServiceImpl;
import com.swkj.mapdisplay.service.updateplatifonservice.AmendBotaServiceImpl;
import com.swkj.mapdisplay.utils.Determine;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
  @ 灾害监测信息的操作
 */
@RestController
public class CalamitiesContorller {
     @Autowired
     private AmendBotaServiceImpl amendBotaService;
     @Autowired
     private RogatoryServiceImpl animalService;
    @Autowired
    private DropBaseServiceImpl dropBaseService;
     //修改灾害监测信息
     @RequestMapping("/amendtheDisaster/{spreadJson}")
     public String amendtheDisaster(@PathVariable("spreadJson") String spreadJson, SpreadSubnature spread){
        // spreadJson="{\"MArea\":\"\",\"SPID\":\"e95dc359-94e5-4f10-9d65-3889a9cabe07\",\"altitude\":\"63.0\",\"disasterDegree\":\"3501\",\"disasterTime\":\"\",\"disasterType\":\"3402\",\"findContent\":\"\",\"lat\":\"28.1941676\",\"lng\":\"112.980314\",\"monitorAddress\":\"定王台12345\",\"monitorTime\":\"2018-03-22 19:01:30\",\"patrolId\":\"a04c8017-bb2c-47f8-949d-7a1afa99f8de\",\"patrolLineId\":\"\",\"patrolLineName\":\"\"}";
         SpreadSubnature subnature=(SpreadSubnature)ShiroConfiguration.convertJsonObject(spreadJson,spread);
         return Determine.updateSuccess(amendBotaService.selectDisaster(subnature));
     }
    //灾害监测信息查询
    @RequestMapping("/queryDisasterSpreadSub/{SPID}/{PatrolId}")
    public String queryDisasterSpreadSub(@PathVariable("SPID") String SPID,@PathVariable("PatrolId") String PatrolId){
        //查询灾害监测信息
        List<SpreadSubnature> spreadSubnatures =animalService.selectSubdisaster(SPID, PatrolId);
        return ShiroConfiguration.getjson(spreadSubnatures,null);
    }
    //加载灾害监测信息中灾害程度，灾害类型，灾害时间下拉框中的值
    @RequestMapping("/selectXhDisaster")
    public String selectXhDisaster(){
        return ShiroConfiguration.xhDisaster(dropBaseService.ActionIfon("disasterDegree"),dropBaseService.ActionIfon("disasterType"),dropBaseService.ActionIfon("disasterTime "));
    }
    //删除灾害监测信息
    @RequestMapping("/deleteXhDisaster/{SPID}/{PatrolId}")
    public String deleteXhDisaster(@PathVariable("SPID") String SPID,@PathVariable("PatrolId") String PatrolId){
        boolean droJamming = amendBotaService.droJamming(SPID, PatrolId);
        return Determine.updateSuccess(droJamming);
    }
    //灾害信息的增加
    @RequestMapping("/addXhdisaster/{json}")
    public String addXhdisaster(@PathVariable("json")String json,SpreadSubnature subnature){
            return amendBotaService.redisXhDisaster(json,subnature);
    }

}
