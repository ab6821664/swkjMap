package com.swkj.mapdisplay.contorller.appendcontorller;

import com.swkj.mapdisplay.enitiy.PatrolFindInfoSub;
import com.swkj.mapdisplay.enitiy.SpreadFindQty;
import com.swkj.mapdisplay.enitiy.SpreadSubXhPlant;
import com.swkj.mapdisplay.service.appendservice.AddanimalIfonServiceImpl;
import com.swkj.mapdisplay.utils.Determine;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@RestController
public class AddanimalIfonController{
    @Autowired
       private AddanimalIfonServiceImpl addanimalIfonService;
       //增加动物分布信息
       @RequestMapping(value = "/raiseAnimalIfon/{basic}")         //获取前端传到后台的json对象
       public String raiseAnimalIfon(@PathVariable("basic") String basic,PatrolFindInfoSub animal){
          PatrolFindInfoSub animal_basic=(PatrolFindInfoSub)ShiroConfiguration.convertJsonObject(basic,animal);
          String js= ShiroConfiguration.getUUID();
         boolean auanimal= addanimalIfonService.augmentAnimal(js,animal_basic,ShiroConfiguration.getUUID());
          return js;
       }
       //增加植物信息
       @RequestMapping("/raisePlankIfon/{basicPlank}")
       public String raisePlankIfon(@PathVariable("basicPlank")String basicPlank, SpreadSubXhPlant animal){
           SpreadSubXhPlant animal_basic=(SpreadSubXhPlant)ShiroConfiguration.convertJsonObject(basicPlank,animal);
           String js= ShiroConfiguration.getUUID();
           boolean isok= addanimalIfonService.augmentPlantIfon(js,animal_basic,ShiroConfiguration.getUUID());
           return js;
       }
       //增加动物数量信息
        @RequestMapping("/raiseAnimalNumberIfon/{animalNuber}")
       public Map<String, Object> raiseAnimalNumberIfon(@PathVariable("animalNuber")String animalNuber){
            //animalNuber="[{\"growthState\":2303,\"maleQty\":1,\"femaleQty\":1,\"totalQty\":0},{\"growthState\":2302,\"maleQty\":1,\"femaleQty\":1,\"totalQty\":0}]";
            List<SpreadFindQty> spare=(List<SpreadFindQty>) JSONArray.toCollection(JSONArray.fromObject(animalNuber),SpreadFindQty.class);
            boolean isok= addanimalIfonService.addAnimalNumber(ShiroConfiguration.getUUID(),spare);
            return Determine.success(isok,null);
       }
}
