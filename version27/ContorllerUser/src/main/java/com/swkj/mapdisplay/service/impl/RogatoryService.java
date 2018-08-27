package com.swkj.mapdisplay.service.impl;
import com.swkj.mapdisplay.enitiy.*;

import java.util.List;
import java.util.Map;

/*
  @查询出动物和植物的详细信息
 */
public interface RogatoryService {
       //查询动物的详细信息
       public List<Animal_Basic> selectAnimal(String AnimalCode);
       //查询植物的详细信息表
       public List<Botany> queryBase(String botanyCode);
       //查询界桩信息
       public List<Boundary> queryBoundary(String boundaryID);
       //查询界栏信息
       public List<Brand> queryBrand(String BrandID);
       //查询人类活动信息
       public List<SpreadSubhuman> queryBspreadsub(String SPID, String PatrolId);
       //查询灾害监测信息
       public List<SpreadSubnature> selectSubdisaster(String SPID, String PatrolId);
       //查询出动物图片
       public List<Animal_BasicImg> queryAnimalImg(String BioImageId);
       //查询植物图片信息
       public List<BoatImg> queryBoatImg(String BoatImgId);
}
