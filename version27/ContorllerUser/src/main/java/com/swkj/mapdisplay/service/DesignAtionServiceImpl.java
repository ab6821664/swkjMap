package com.swkj.mapdisplay.service;
import com.swkj.mapdisplay.enitiy.*;
import com.swkj.mapdisplay.mapper.DesignAtionMapper;
import com.swkj.mapdisplay.service.impl.DesignAtionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignAtionServiceImpl implements DesignAtionService {
    @Autowired
     private DesignAtionMapper designationMapper;
    //查询巡护过程中代号的信息
    @Override
    public Designation selectBydesig(String patroid) {
        return designationMapper.selectBymark(patroid);
    }
    //把查询巡护过程中代号的信息转换成指定的信息
    @Override
    public List<BaseDict> selectByappoint(Designation list) {
        return designationMapper.selectByappoint(list);
    }
    //查询巡护过程中SpreadSub表动物分布的信息
    @Override
    public List<PatrolFindInfoSub> queryBySpreadSub(String spid, Integer PatrolSubId) {
       List<PatrolFindInfoSub> patrolFindInfoSub= designationMapper.queryBySpread(spid,PatrolSubId);
        return patrolFindInfoSub;
    }
    //查询巡护过程中SpreadSub表的植物分布的信息
    @Override
    public List<SpreadSubXhPlant> getBySpreadSubifon(String spid, Integer PatrolSubId) {
       List<SpreadSubXhPlant> spreadSubXhPlant= designationMapper.GainSpreadXhPlant(spid,PatrolSubId);
        return spreadSubXhPlant;
    }
    //查询巡护过程中BHQ_SpreadSub表中的代号的信息
    @Override
    public SpreadSubMark getSubMark(String markspid, Integer PatrolSubId) {
       SpreadSubMark spreadSubMark= designationMapper.getBymark(markspid,PatrolSubId);
       if (spreadSubMark==null){
           return null;
       }
        return spreadSubMark;
    }
    //将BHQ_SpreadSub表中的代码信息转换成具体的值
    @Override
    public List<BaseDict> selectbaseMark(SpreadSubMark mark) {
        return designationMapper.getBybaseDict(mark);
    }

}
