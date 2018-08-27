package com.swkj.mapdisplay.service.appendservice.appendimpl;

import com.swkj.mapdisplay.enitiy.PatrolFindInfoSub;
import com.swkj.mapdisplay.enitiy.SpreadFindQty;
import com.swkj.mapdisplay.enitiy.SpreadSubXhPlant;

import java.util.List;

public interface AddanimalIfonService {
        //增加动物分布信息
        public boolean augmentAnimal(String SPID, PatrolFindInfoSub basic, String PatrolMedioId);
        //增加植物分布信息
        public boolean augmentPlantIfon(String SPID, SpreadSubXhPlant sprea, String PatrolMedioId);
        //增加动物数量信息
        public boolean addAnimalNumber(String patrolId,List<SpreadFindQty> sprea);
}
