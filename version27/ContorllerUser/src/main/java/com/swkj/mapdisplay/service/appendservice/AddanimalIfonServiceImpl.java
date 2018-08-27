package com.swkj.mapdisplay.service.appendservice;

import com.swkj.mapdisplay.enitiy.SpreadSubXhPlant;
import com.swkj.mapdisplay.mapper.appendmapper.AddanimalIfonMapper;
import com.swkj.mapdisplay.service.DesignAtionServiceImpl;
import com.swkj.mapdisplay.service.appendservice.appendimpl.AddanimalIfonService;
import com.swkj.mapdisplay.enitiy.PatrolFindInfoSub;
import com.swkj.mapdisplay.enitiy.SpreadFindQty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AddanimalIfonServiceImpl implements AddanimalIfonService {
     @Autowired
     private AddanimalIfonMapper mapper;

    //增加动物分布信息
    @Override
    @Transactional
    public boolean augmentAnimal(String SPID, PatrolFindInfoSub basic, String PatrolMedioId) {

        return mapper.addAnimal(SPID,basic,PatrolMedioId)>0;
    }
    //增加植物分布信息
    @Override
    @Transactional
    public boolean augmentPlantIfon(String SPID, SpreadSubXhPlant sprea, String PatrolMedioId) {
        return mapper.addPlant(SPID, sprea, PatrolMedioId)>0;
    }
    //增加动物数量信息
    @Override
    @Transactional
   public boolean addAnimalNumber(String patrolId,List<SpreadFindQty> sprea) {
       return mapper.raiseFindQty(patrolId,sprea)>0;
    }
}
