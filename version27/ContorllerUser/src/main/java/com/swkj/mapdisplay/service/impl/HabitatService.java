package com.swkj.mapdisplay.service.impl;

import com.swkj.mapdisplay.enitiy.BaseDict;
import com.swkj.mapdisplay.enitiy.SpreadHabitatSub;
import com.swkj.mapdisplay.enitiy.SpreadHabitatsubMark;

import java.util.List;

public interface HabitatService {
        //生境信息的展示
         public SpreadHabitatSub selectHabitat(String SPID, String PatrolId);
        //查询生境信息中所有的代号
         public SpreadHabitatsubMark selectHabitatMark(String SPID, String PatrolId);
         //生境信息中所有的代号转换成指定的值
         public List<BaseDict> selectMarkValue(SpreadHabitatsubMark spreadHabitatsubMark);
         //利用坐标查询生境信息
         public SpreadHabitatSub queryCoordinate(String SmSdriw,String SmSdriN);
         //删除生境信息
         public boolean droHabitatSub(String SPID,String PatrolId);
}
