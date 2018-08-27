package com.swkj.mapdisplay.mapper.deleteLivestock;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DropSpreadSubMapper {
        //删除动物分布信息
        public Integer dropAnimal(@Param("SPID")String SPID,@Param("PatrolSubId") String PatrolSubId);
        //删除界桩界碑的信息
        public Integer dropBoundary(@Param("boundaryID") String boundaryID);
        //删除牌栏信息
        public Integer dropBrand(@Param("brandID") String brandID);
}
