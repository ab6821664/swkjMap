package com.swkj.mapdisplay.contorller;

import com.swkj.mapdisplay.enitiy.SpreadSubhuman;
import com.swkj.mapdisplay.enitiy.SpreadSubnature;
import com.swkj.mapdisplay.service.RogatoryServiceImpl;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
@RestController
public class RogatoryController {
       @Autowired
      private RogatoryServiceImpl animalService;
        //查询出动物详细的信息
       @RequestMapping(value = "/selectBeast/{animalCode}",method = RequestMethod.GET)
       public String selectAnimal(@PathVariable("animalCode") String animalCode){

           return ShiroConfiguration.getjson(null,animalService.selectAnimal(animalCode));
       }
       //查询出植物的信息
       @RequestMapping(value = "/queryPlant/{botanyCode}",method = RequestMethod.GET)
       public String queryPlant(@PathVariable("botanyCode") String BotanyCode){
           return ShiroConfiguration.getjson(null,animalService.queryBase(BotanyCode));
       }
       //查询界桩信息
        @RequestMapping(value = "/selectBoundaryList/{BoundaryID}",method = RequestMethod.GET)
         public String selectBoundaryList(@PathVariable("BoundaryID")String BoundaryID){

           return ShiroConfiguration.getjson(animalService.queryBoundary(BoundaryID),null);
       }
      //查询界栏信息
       @RequestMapping(value = "/selectStone/{BrandID}",method = RequestMethod.GET)
      public String selectStone(@PathVariable("BrandID") String BrandID){
           return ShiroConfiguration.getjson(animalService.queryBrand(BrandID),null);
      }
      //查询动物图片信息
      @RequestMapping("/selectAnimalImgIfon/{BioImageId}")
      public String selectAnimalImgIfon(@PathVariable("BioImageId") String BioImageId){
        return ShiroConfiguration.getgson(animalService.queryAnimalImg(BioImageId),null);
     }
     //查询植物图片信息
     @RequestMapping("/selectBoatImgIfon/{BoatImgId}")
     public String selectBoatImgIfon(@PathVariable("BoatImgId")String BoatImgId){
           return ShiroConfiguration.getgson(animalService.queryBoatImg(BoatImgId),null);
     }
}
