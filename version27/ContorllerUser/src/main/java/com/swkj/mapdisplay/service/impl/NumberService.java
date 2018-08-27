package com.swkj.mapdisplay.service.impl;

import com.swkj.mapdisplay.enitiy.BaseDict;
import com.swkj.mapdisplay.enitiy.SpreadFindQty;

import java.util.List;

public interface NumberService {
        //展示动物数量信息
       public List<SpreadFindQty> selectSpreadFindQty(String SPID, String PatrolId);
       //查询动物数量的代号信息
       public List<BaseDict> queryNumber(String SPID,String PatrolId);
}
