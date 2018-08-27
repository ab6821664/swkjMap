package com.swkj.mapdisplay.service.updateplatifonservice;

import com.swkj.mapdisplay.enitiy.PatrolFindInfoSub;
import com.swkj.mapdisplay.enitiy.SpreadFindQty;
import com.swkj.mapdisplay.enitiy.SpreadSubXhPlant;
import com.swkj.mapdisplay.mapper.updateplatifon.UpdateIfonMapper;
import com.swkj.mapdisplay.service.updateplatifonservice.updateplatifonserviceimpl.UpdateIfonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateIfonServiceImpl implements UpdateIfonService {
        @Autowired
        private UpdateIfonMapper updateIfonMapper;
    //修改动物数量信息
    @Override
    public boolean updateAnimalNumber(String patrolId, List<SpreadFindQty> spreadFindQty) {
        return updateIfonMapper.updateSpreadFindQty(patrolId, spreadFindQty)>0;
    }
    //修改植物的分布信息
    @Override
    public boolean updatePlantIfon(SpreadSubXhPlant sprea) {
        return updateIfonMapper.updatePlant(sprea)>0;
    }

    //修改动物分布信息
    @Override
    public boolean updateAnimalScatter(PatrolFindInfoSub patro) {
        return updateIfonMapper.updateScatter(patro)>0;
    }
}
