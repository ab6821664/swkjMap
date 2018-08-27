package com.swkj.mapdisplay.service.deleteLivestockservice;

import com.swkj.mapdisplay.mapper.deleteLivestock.DropSpreadSubMapper;
import com.swkj.mapdisplay.service.deleteLivestockservice.deleteLivestockImpl.DropSpreadSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PreDestroy;

@Service
public class DropSpreadSubServiceImpl implements DropSpreadSubService {
    @Autowired
    private DropSpreadSubMapper dropSpreadSubMapper;
    //删除动物信息
    @Override
    @Transactional
    public boolean dropAnimalIfon(String SPID, String PatrolSubId) {
        return dropSpreadSubMapper.dropAnimal(SPID, PatrolSubId)>0;
    }
     //删除界桩界碑的信息
    @Override
    public boolean dropBoundary(String BoundaryID) {
        return dropSpreadSubMapper.dropBoundary(BoundaryID)>0;
    }
    //删除牌栏信息
    @Override
    public boolean dropBrand(String BrandID) {
        return dropSpreadSubMapper.dropBrand(BrandID)>0;
    }
}
