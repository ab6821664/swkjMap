package com.swkj.mapdisplay.contorller;

import com.swkj.mapdisplay.enitiy.SpreadHabitatSub;
import com.swkj.mapdisplay.enitiy.SpreadHabitatsubMark;
import com.swkj.mapdisplay.service.DropBaseServiceImpl;
import com.swkj.mapdisplay.service.HabitatServiceImpl;
import com.swkj.mapdisplay.service.appendservice.BoundaryPostServiceImpl;
import com.swkj.mapdisplay.service.updateplatifonservice.AmendBotaServiceImpl;
import com.swkj.mapdisplay.utils.Determine;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HabitatController {
        @Autowired
        private HabitatServiceImpl habitatService;
        @Autowired
        private BoundaryPostServiceImpl boundaryPostService;
        @Autowired
        private AmendBotaServiceImpl amendBotaService;
        @Autowired
        private DropBaseServiceImpl dropBaseService;
        //生境信息的展示
        @RequestMapping(value = "/obtainHabitat/{SPID}/{PatrolId}",method = RequestMethod.GET)
        public String obtainHabitat(@PathVariable("SPID") String SPID, @PathVariable("PatrolId") String PatrolId){
            return ShiroConfiguration.getjson(null,habitatService.selectHabitat(SPID, PatrolId));
        }
        //查询生境信息中所有的代号转换成值
       /* @RequestMapping(value = "/obtainHabitatMark/{SPID}/{PatrolId}",method = RequestMethod.GET)
        public String obtainHabitatMark(@PathVariable("SPID") String SPID,@PathVariable("PatrolId") String PatrolId){
               SpreadHabitatsubMark spreadHabitatsubMark= habitatService.selectHabitatMark(SPID, PatrolId);
               return ShiroConfiguration.getobjectadd(habitatService.selectMarkValue(spreadHabitatsubMark));
        }*/
        //加载生境信息下拉框中植被类型，生境类型，地形特征，土壤类型，土壤孔隙，土壤结构体，土壤胶体，坡向的值
        @RequestMapping(value = "/selectsJYZ",method = RequestMethod.GET)
        public String selectsJYZ(){
            return ShiroConfiguration.sJYZ(dropBaseService.ActionIfon("PlantType"),dropBaseService.ActionIfon("HabitatId"),dropBaseService.ActionIfon("Terrain "),dropBaseService.ActionIfon("CovertType"),dropBaseService.ActionIfon("CoverPorosity"),dropBaseService.ActionIfon("CoverStructural "),dropBaseService.ActionIfon("CoverColloid"),dropBaseService.ActionIfon("SlopeId"));
        }

        //利用坐标查询生境信息
        @RequestMapping(value = "/useCoordinatequery/{SmSdriw}/{SmSdriN}",method = RequestMethod.GET)
        public String useCoordinatequery(@PathVariable("SmSdriw") String SmSdriw,@PathVariable("SmSdriN") String SmSdriN){
           SpreadHabitatSub sprea=habitatService.queryCoordinate(SmSdriw, SmSdriN);
            return ShiroConfiguration.getjsonlist(null,sprea);
        }
        //生境信息的增加
        @RequestMapping("/raiseSpreadUrl/{json}")
        public String raiseSpreadUrl(@PathVariable("json")String json){
            String state= boundaryPostService.raiseSjyzIfon(json);
            return state;
        }
        //修改生境信息
        @RequestMapping("/updateHabitatSub/{json}")
        public String updateHabitatSub(@PathVariable("json") String json,SpreadHabitatSub sub){
            SpreadHabitatSub srea=(SpreadHabitatSub) ShiroConfiguration.convertJsonObject(json,sub);
            boolean isok=amendBotaService.selectSjyz(srea);
            return Determine.updateSuccess(isok);
        }
        //删除生境信息
        @RequestMapping("/deleteSpreadRelation/{SPID}/{PatrolId}")
        public String deleteSpreadRelation(@PathVariable("SPID") String SPID,@PathVariable("PatrolId") String PatrolId){
          boolean isok=  habitatService.droHabitatSub(SPID, PatrolId);
          return Determine.updateSuccess(isok);
        }
}
