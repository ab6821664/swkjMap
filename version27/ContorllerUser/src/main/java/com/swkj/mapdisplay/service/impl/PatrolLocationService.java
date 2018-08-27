package com.swkj.mapdisplay.service.impl;

import com.swkj.mapdisplay.enitiy.PatrolFindInfoSub;
import com.swkj.mapdisplay.enitiy.PatrolFindInfoSubSJYZ;
import com.swkj.mapdisplay.enitiy.PatrolLocationInfo;
import com.swkj.mapdisplay.enitiy.PatrolManageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatrolLocationService {
     //查询所有的patrolId
     public List<String> query();
     //根据id查询出lat,lng
      public List<PatrolLocationInfo> querypatrolIdifon(String patrolId);
      //根据id删除信息
      public boolean delectpatrolIdinfo(@Param("patrolId") String patrolId);
      //增加数据
      public boolean addpatrolIdinfomapper(PatrolLocationInfo patrolLocationInfo);
      //查询巡护轨迹展示
      public List<PatrolManageInfo> queryPatrol();
      //根据巡护id查询出相应的值
      public List<PatrolManageInfo> manageInfoid(String patrolId);
      //查询在巡护过程中动物的信息
      public List<PatrolFindInfoSub> patroprocess(String SubpatrolId);
     //查询出生物因子的信息
      public List<PatrolFindInfoSubSJYZ> patrocessList(String patroid);




}
