package com.swkj.mapdisplay.mapper;


import com.swkj.mapdisplay.enitiy.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RogatoryMapper {
        //查询动物的详细信息
       public List<Animal_Basic> animal(@Param("animalCode") String animalCode);
       //查询植物的详细信息
       public List<Botany> getbase(@Param("botanyCode")String botanyCode);
       //查询界桩信息
       public List<Boundary> selectBoundary(@Param("boundaryID") String boundaryID);
       //查询界栏信息
       public List<Brand> selectBrand(@Param("brandID") String brandID);
       //查询人类活动信息
       public List<SpreadSubhuman> selectSpreadsub(@Param("SPID") String SPID, @Param("PatrolId") String PatrolId);
       //查询灾害监测信息
       public List<SpreadSubnature> getSubDisasterInfo(@Param("SPID")String SPID, @Param("PatrolId")String PatrolId);
       //查询动物图片信息
       public List<Animal_BasicImg> selectAnimalImgIfon(@Param("BioImageId") String BioImageId);
       //查询植物图片信息
       public List<BoatImg> sekectBoatImgIfon(@Param("BoatImgId")String BoatImgId);


}
