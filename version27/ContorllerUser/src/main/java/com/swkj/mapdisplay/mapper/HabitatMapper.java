package com.swkj.mapdisplay.mapper;

import com.swkj.mapdisplay.enitiy.BaseDict;
import com.swkj.mapdisplay.enitiy.SpreadHabitatSub;
import com.swkj.mapdisplay.enitiy.SpreadHabitatsubMark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HabitatMapper {
        //生境信息的展示
        public SpreadHabitatSub queryHabitat(@Param("SPID") String SPID, @Param("PatrolId") String PatrolId);
        //查询生境信息中所有的代号
        public SpreadHabitatsubMark queryHabitatMark(@Param("SPID") String SPID, @Param("PatrolId") String PatrolId);
        //生境信息中所有的代号转换成指定的值
        public List<BaseDict> queryMarkValue(@Param("spreadHabitatsubMark")SpreadHabitatsubMark spreadHabitatsubMark);
        //利用坐标点查询生境信息
        public SpreadHabitatSub coordinateHabSub(@Param("SmSdriw")String SmSdriw,@Param("SmSdriN") String SmSdriN);
        //删除生境信息
        public Integer deleteHabSub(@Param("SPID") String SPID,@Param("PatrolId") String PatrolId);
        //删除关联表的信息
        public Integer droRelation(@Param("SPID") String SPID,@Param("PatrolId") String PatrolId);
}
