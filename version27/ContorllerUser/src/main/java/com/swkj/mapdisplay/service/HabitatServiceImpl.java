package com.swkj.mapdisplay.service;

import com.swkj.mapdisplay.enitiy.BaseDict;
import com.swkj.mapdisplay.enitiy.SpreadHabitatSub;
import com.swkj.mapdisplay.enitiy.SpreadHabitatsubMark;
import com.swkj.mapdisplay.mapper.HabitatMapper;
import com.swkj.mapdisplay.service.impl.HabitatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitatServiceImpl implements HabitatService {
    @Autowired
    private HabitatMapper habitatMapper;
    //生境信息的展示
    @Override
    public SpreadHabitatSub selectHabitat(String SPID, String PatrolId) {
        return habitatMapper.queryHabitat(SPID,PatrolId);
    }
    //查询生境信息中所有的代号
    @Override
    public SpreadHabitatsubMark selectHabitatMark(String SPID, String PatrolId) {

        return habitatMapper.queryHabitatMark(SPID, PatrolId);
    }
    //生境信息中所有的代号转换成指定的值
    @Override
    public List<BaseDict> selectMarkValue(SpreadHabitatsubMark spreadHabitatsubMark) {
        return habitatMapper.queryMarkValue(spreadHabitatsubMark);
    }
    //利用坐标信息查询生境信息
    @Override
    public SpreadHabitatSub queryCoordinate(String SmSdriw, String SmSdriN) {
        return habitatMapper.coordinateHabSub(SmSdriw, SmSdriN);
    }
     //删除生境信息
    @Override
    public boolean droHabitatSub(String SPID, String PatrolId) {
        Integer nuber= habitatMapper.deleteHabSub(SPID, PatrolId);
       if (nuber>0){
            Integer relation = habitatMapper.droRelation(SPID, PatrolId);
            if (relation>0){
               return true;
            }
        }else{
           return false;
       }
        return true;
    }
}
