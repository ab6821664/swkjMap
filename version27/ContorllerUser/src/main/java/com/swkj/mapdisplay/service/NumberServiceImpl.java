package com.swkj.mapdisplay.service;

import com.swkj.mapdisplay.enitiy.BaseDict;
import com.swkj.mapdisplay.enitiy.SpreadFindQty;
import com.swkj.mapdisplay.mapper.NumberMapper;
import com.swkj.mapdisplay.service.impl.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NumberServiceImpl implements NumberService {
     @Autowired
     private NumberMapper numberMapper;
    //展示动物数量信息
    @Override
    public List<SpreadFindQty> selectSpreadFindQty(String SPID, String PatrolId) {
        return numberMapper.getNumberqty(SPID,PatrolId);
    }
    //查询动物数量代号信息
    @Override
    public List<BaseDict> queryNumber(String SPID, String PatrolId) {
        return numberMapper.selectanAnimalNuber(SPID, PatrolId);
    }
}
