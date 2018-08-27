package com.swkj.mapdisplay.service;
import com.swkj.mapdisplay.enitiy.*;
import com.swkj.mapdisplay.mapper.RogatoryMapper;
import com.swkj.mapdisplay.service.impl.RogatoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RogatoryServiceImpl implements RogatoryService {
     @Autowired
     private RogatoryMapper rogatoryMapperl;
    //查询动物详细的信息
    @Override
    public List<Animal_Basic> selectAnimal(String animalCode) {
        List<Animal_Basic> basic= rogatoryMapperl.animal(animalCode);
        if (basic==null){
            return null;
        }
        return basic;
    }
    //查询植物的详细信息
    @Override
    public List<Botany> queryBase(String botanyCode) {

        return rogatoryMapperl.getbase(botanyCode);
    }
    //查询界桩的信息
    @Override
    public List<Boundary> queryBoundary(String boundaryID) {

        return rogatoryMapperl.selectBoundary(boundaryID);
    }
    //查询界栏信息
    @Override
    public List<Brand> queryBrand(String BrandID) {

        return rogatoryMapperl.selectBrand(BrandID);
    }
    //查询人类活动信息
    @Override
    public List<SpreadSubhuman> queryBspreadsub(String SPID, String PatrolId) {
        return rogatoryMapperl.selectSpreadsub(SPID,PatrolId);
    }
    //查询灾害监测信息
    @Override
    public List<SpreadSubnature> selectSubdisaster(String SPID, String PatrolId) {
        return rogatoryMapperl.getSubDisasterInfo(SPID,PatrolId);
    }
    //查询出动物图片
    @Override
    public List<Animal_BasicImg> queryAnimalImg(String BioImageId) {
        return rogatoryMapperl.selectAnimalImgIfon(BioImageId);
    }
    //查询植物的图片信息
    @Override
    public List<BoatImg> queryBoatImg(String BoatImgId) {
        return rogatoryMapperl.sekectBoatImgIfon(BoatImgId);
    }
}
