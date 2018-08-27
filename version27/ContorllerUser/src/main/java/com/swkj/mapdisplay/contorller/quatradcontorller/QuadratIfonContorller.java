package com.swkj.mapdisplay.contorller.quatradcontorller;

import com.swkj.mapdisplay.enitiy.QuadratData;
import com.swkj.mapdisplay.service.quadratifon.QuadratiServiceImpl;
import com.swkj.mapdisplay.service.vidicon.CameraServiceImpl;
import com.swkj.mapdisplay.utils.Determine;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class QuadratIfonContorller {
        @Autowired
        private QuadratiServiceImpl quadratiService;
        //增加样地属性信息
        @RequestMapping("/addQuadratUrl/{json}") //BHQ_QuadratDataList表的信息  主表BHQ_QuadratData的信息
        public Integer addQuadratUrl(@PathVariable("json") String json){

            return quadratiService.same(json);
        }
        //查询样地属性信息
        @RequestMapping("/queryQuadratData/{quadratID}")
        public String queryQuadratData(@PathVariable("quadratID")String quadratID){
            List<QuadratData> query = quadratiService.queryQuadratData(quadratID);

           return ShiroConfiguration.getjson(query,null);
       }
       //查询样地下拉框中土壤类型的信息
       @RequestMapping("/droQuadratDataurl")
      public String droQuadratData(){
          return quadratiService.droQuadratData();
       }

       //删除样地属性信息
      @RequestMapping("/amputateQuaDratData/{QuadratID}")
      public String amputateQuaDratData(@PathVariable("QuadratID") String QuadratID){
            return Determine.updateSuccess(quadratiService.amputateQuadratData(QuadratID));
      }

      //修改样地属性信息
      @RequestMapping(value = "/updateQuaDratDataIfon",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
      public String updateQuaDratDataIfon(@RequestParam("quadratData") String quadratData){
            return quadratiService.reviseQuadratData(quadratData);
      }
      //加载植物名称的代号信息
      @RequestMapping("/plantbaseDict")
      public String plantbaseDict(){
         return ShiroConfiguration.getgson(quadratiService.baseDict(),null);
      }
}
