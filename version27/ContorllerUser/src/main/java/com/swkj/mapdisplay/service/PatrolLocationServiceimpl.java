package com.swkj.mapdisplay.service;

import com.swkj.mapdisplay.enitiy.PatrolFindInfoSub;
import com.swkj.mapdisplay.enitiy.PatrolFindInfoSubSJYZ;
import com.swkj.mapdisplay.enitiy.PatrolLocationInfo;
import com.swkj.mapdisplay.enitiy.PatrolManageInfo;
import com.swkj.mapdisplay.mapper.PatrolLoationMapper;
import com.swkj.mapdisplay.service.impl.PatrolLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatrolLocationServiceimpl implements PatrolLocationService {
    @Autowired
    private PatrolLoationMapper patrolLoationMapper;

    //查询所有的patrolId
    @Override
    public List<String> query() {
        return patrolLoationMapper.querypatro();
    }

    //根据id查询出lat,lng
    @Override
    public List<PatrolLocationInfo> querypatrolIdifon(String patrolId) {
        return patrolLoationMapper.querypatrolId(patrolId);
    }

    //根据id删除信息
    @Transactional
    @Override
    public boolean delectpatrolIdinfo(String patrolId) {
        return patrolLoationMapper.deletcpatrolId(patrolId) > 0;
    }

    //增加数据
    @Transactional
    @Override
    public boolean addpatrolIdinfomapper(PatrolLocationInfo patrolLocationInfo) {
        return patrolLoationMapper.addPatrolLocationInfo(patrolLocationInfo) > 0;
    }

    //查询出巡护轨迹展示
    @Override
    public List<PatrolManageInfo> queryPatrol() {
        return patrolLoationMapper.PatrolLocationInfoquery();
    }

    //根据巡护id查询出相应的值
    @Override
    public List<PatrolManageInfo> manageInfoid(String patrolId) {
        return patrolLoationMapper.ManageInfoid(patrolId);
    }

    //查询在巡护过程中动物的信息
    @Override
    public List<PatrolFindInfoSub> patroprocess(String patrolId) {
        List<PatrolFindInfoSub> patrolFindInfoSub= patrolLoationMapper.processlist(patrolId);
        return patrolFindInfoSub;
    }
    //查询出生物因子的信息
    @Override
    public List<PatrolFindInfoSubSJYZ> patrocessList(String patroid) {
       List<PatrolFindInfoSubSJYZ> patrolFindInfoSubSJYZ= patrolLoationMapper.paraList(patroid);
        return patrolFindInfoSubSJYZ;
    }

}

