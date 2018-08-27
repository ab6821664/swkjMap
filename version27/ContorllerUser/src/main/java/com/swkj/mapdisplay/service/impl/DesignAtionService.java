package com.swkj.mapdisplay.service.impl;
import com.swkj.mapdisplay.enitiy.*;

import java.util.List;

public interface DesignAtionService {
      //查询巡护过程中代号的信息
      public Designation selectBydesig(String patroid);
      //把查询巡护过程中代号的信息转换成指定的信息
      public List<BaseDict> selectByappoint(Designation list);
      //查询巡护过程中动物分布的信息
      public List<PatrolFindInfoSub> queryBySpreadSub(String spid, Integer PatrolSubId);
      //查询巡护过程中植物分布的信息
      public List<SpreadSubXhPlant> getBySpreadSubifon(String spid, Integer PatrolSubId);
      //查询巡护过程中BHQ_SpreadSub表中的代号的信息
      public SpreadSubMark getSubMark(String markspid, Integer PatrolSubId);
      //查询BHQ_SpreadSub表中的代码转换成具体的值
      public List<BaseDict> selectbaseMark(SpreadSubMark mark);
}
