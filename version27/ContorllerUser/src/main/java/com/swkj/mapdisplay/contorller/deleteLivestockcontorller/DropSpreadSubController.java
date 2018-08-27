package com.swkj.mapdisplay.contorller.deleteLivestockcontorller;

import com.swkj.mapdisplay.service.deleteLivestockservice.DropSpreadSubServiceImpl;
import com.swkj.mapdisplay.utils.Determine;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DropSpreadSubController {
        //删除动物分布信息,和植物分布信息
        @Autowired
        private DropSpreadSubServiceImpl dropSpreadSubService;
        @RequestMapping("/updateAnimal/{SPID}/{PatrolSubId}")
        public String updateAnimal(@PathVariable("SPID") String SPID, @PathVariable("PatrolSubId") String PatrolSubId){
            boolean isok= false;
            try {
                isok = dropSpreadSubService.dropAnimalIfon(SPID, PatrolSubId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Determine.updateSuccess(isok);
        }
        //删除界桩界碑的信息
        @RequestMapping("/strikeOutBoundary/{BoundaryID}")
        public String strikeOutBoundary(@PathVariable("BoundaryID")String BoundaryID){
              return Determine.updateSuccess(dropSpreadSubService.dropBoundary(BoundaryID));
        }
        //删除牌栏信息
        @RequestMapping("/strikeOutBrand/{BrandID}")
        public String strikeOutBrand(@PathVariable("BrandID") String BrandID){
             return Determine.updateSuccess(dropSpreadSubService.dropBrand(BrandID));
        }
}
