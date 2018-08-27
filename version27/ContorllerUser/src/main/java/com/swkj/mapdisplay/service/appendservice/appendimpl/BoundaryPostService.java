package com.swkj.mapdisplay.service.appendservice.appendimpl;

import com.swkj.mapdisplay.enitiy.Botany;
import com.swkj.mapdisplay.enitiy.Boundary;
import com.swkj.mapdisplay.enitiy.SpreadHabitatSub;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface BoundaryPostService {
    //查询出界牌界碑信息id
    public String selectBounId(Map<String,Object> map);
    //增加界牌界碑信息
    public boolean raiseBoundaryIfon(Map<String,Object> bounMa);
    //增加牌栏信息
    public boolean raiseBotanyIfon(Map<String,Object> botanMap);
    //增加生境信息
    public String raiseSjyzIfon(String json);
}
