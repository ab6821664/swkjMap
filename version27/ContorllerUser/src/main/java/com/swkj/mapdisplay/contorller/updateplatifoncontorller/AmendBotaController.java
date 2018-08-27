package com.swkj.mapdisplay.contorller.updateplatifoncontorller;

import com.swkj.mapdisplay.enitiy.*;
import com.swkj.mapdisplay.service.updateplatifonservice.AmendBotaServiceImpl;
import com.swkj.mapdisplay.service.updateplatifonservice.updateplatifonserviceimpl.AmendBotaService;
import com.swkj.mapdisplay.utils.Determine;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//修改界牌界碑信息，和牌栏信息
@RestController
public class AmendBotaController {
     @Autowired
     private AmendBotaServiceImpl amendBotaService;
       //修改界牌界碑信息
      @RequestMapping("/updateBoundaryUrl/{json}")
      public String updateBoundaryUrl(@PathVariable("json") String json, Boundary boundary){

          return Determine.updateSuccess(amendBotaService.AmendBoundaryIfon((Boundary) ShiroConfiguration.convertJsonObject(json,boundary)));
      }
    //修改牌栏信息
    @RequestMapping("/updateBrandUrl/{brandJson}")
    public String updateBrandUrl(@PathVariable("brandJson")String brandJson, Brand brand){
        return Determine.updateSuccess(amendBotaService.AmendBrandIfon((Brand)ShiroConfiguration.convertJsonObject(brandJson,brand)));
    }

}
