package com.swkj.mapdisplay.contorller.appendcontorller;
import com.swkj.mapdisplay.enitiy.Boundary;
import com.swkj.mapdisplay.enitiy.Brand;
import com.swkj.mapdisplay.service.appendservice.BoundaryPostServiceImpl;
import com.swkj.mapdisplay.utils.utilsImpl.Constants;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BoundaryPostController {
        private Map<String,Object> map=new HashMap<>();
       @Autowired
       private BoundaryPostServiceImpl boundaryPostService;
        //增加界牌界碑信息                     //从前端传进来的json对象
       @RequestMapping("/raiseBoundaryIfonUrl/{json}")
       public String raiseBoundaryIfonUrl(@PathVariable("json") String json, Boundary boundary){
           map.put("DataCode",Constants.BHQ_BOUNDA);
           map.put("AsHeader",Constants.ASHEADER);
           String BoundaId= boundaryPostService.selectBounId(map);
           map.put("BoundaryID",BoundaId);
           map.put("BHQID",Integer.valueOf(BoundaId));
           Boundary boun=(Boundary) ShiroConfiguration.convertJsonObject(json,boundary);
           map.put("Boundary",boun);
           //将json对象转换成界牌界碑对象
            boolean isok= boundaryPostService.raiseBoundaryIfon(map);
           if (isok){
                return BoundaId;
            }
            return null;
       }
        //增加牌栏信息
        @RequestMapping("/raiseBotanyIfonUrl/{json}")
        public String raiseBotanyIfonUrl(@PathVariable("json") String json, Brand brand){
            map.put("DataCode",Constants.BHQ_BRAND);
            map.put("AsHeader",Constants.ASHEADER);
            //获取BrandID
            String BrandID= boundaryPostService.selectBounId(map);
            //获取BHQID的值
            Integer BHQID=Integer.valueOf(BrandID);
            //将json对象转换成界牌界碑对象
            Brand boun=(Brand) ShiroConfiguration.convertJsonObject(json,brand);
            map.put("BrandID",BrandID);
            map.put("BHQID",BHQID);
            map.put("Botany",boun);
            boolean isok= boundaryPostService.raiseBotanyIfon(map);
           if (isok) {
               return BrandID;
           }
            return BrandID;
        }
}
