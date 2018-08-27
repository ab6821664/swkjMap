package com.swkj.mapdisplay.mapper.updateplatifon;

import com.swkj.mapdisplay.enitiy.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface AmendBotaMapper {
    //修改界牌界碑信息
     public Integer updateBoundary(Boundary boundary);
    //修改牌栏信息
     public Integer updateBrand(Brand brand);
    //修改灾害监测信息
     public Integer updateDisaster(SpreadSubnature spreadSubnature);
    //修改人为干扰信息
     public Integer updateJamming(SpreadSubhuman spreadSubhuman);
     //修改生境信息
     public Integer updateSjyz(SpreadHabitatSub sub);
     //增加人为干扰信息
     public Integer addJamming(Map<String,Object> map);
     //增加灾害监测信息
     public Integer addXhdisaster(Map<String,Object> map);
     //删除人为干扰信息
     public Integer deleteJamming(@Param("SPID")String SPID,@Param("PatrolId") String PatrolId);

}
