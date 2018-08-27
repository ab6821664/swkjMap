package com.swkj.mapdisplay.contorller.updateplatifoncontorller;

import com.swkj.mapdisplay.enitiy.PatrolFindInfoSub;
import com.swkj.mapdisplay.enitiy.SpreadSubXhPlant;
import com.swkj.mapdisplay.service.updateplatifonservice.UpdateIfonServiceImpl;
import com.swkj.mapdisplay.utils.Determine;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PropagationController {
        @Autowired
         private UpdateIfonServiceImpl updateIfonService;
        //修改动物信息
        @RequestMapping("/updateAnimalIfon/{json}")
        public String updateAnimalIfon(@PathVariable("json")String json, PatrolFindInfoSub patro){
           PatrolFindInfoSub patrolFindInfoSub=(PatrolFindInfoSub)ShiroConfiguration.convertJsonObject(json,patro);
           boolean isok= updateIfonService.updateAnimalScatter(patrolFindInfoSub);
            return Determine.updateSuccess(isok);
        }
        //修改植物信息
        @RequestMapping("/updatePlantIfonUrl/{json}")
        public String updatePlantIfonUrl(@PathVariable("json")String json, SpreadSubXhPlant patro){
            //转换对象
           SpreadSubXhPlant spea=(SpreadSubXhPlant) ShiroConfiguration.convertJsonObject(json,patro);
           boolean isok=updateIfonService.updatePlantIfon(spea);
            return Determine.updateSuccess(isok);
        }
}
