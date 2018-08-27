package com.swkj.mapdisplay.service.updateplatifonservice.updateplatifonserviceimpl;

import com.swkj.mapdisplay.enitiy.*;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface AmendBotaService {
       //修改界牌界碑信息
        public boolean AmendBoundaryIfon(Boundary boundary);
       //修改牌栏信息
       public boolean AmendBrandIfon(Brand brand);
       //修改灾害监测信息
       public boolean selectDisaster(SpreadSubnature spreadSubnature);
      //修改人为干扰信息
       public boolean selectJamming(SpreadSubhuman spreadSubhuman);
      //修改生境信息
       public boolean selectSjyz(SpreadHabitatSub sub);
       //增加人为干扰信息
       public String redisJamming(String json,SpreadSubhuman spreadSubhuman);
       //增加灾害监测信息
       public String redisXhDisaster(String xhdjson,SpreadSubnature subnature);
       //删除人为干扰信息
       public boolean droJamming(String SPID,  String PatrolId);
}
