package com.swkj.mapdisplay.mapper.appendmapper;

import com.swkj.mapdisplay.enitiy.PatrolFindInfoSub;
import com.swkj.mapdisplay.enitiy.SpreadFindQty;
import com.swkj.mapdisplay.enitiy.SpreadSubXhPlant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddanimalIfonMapper {
        //添加动物分布信息
        public Integer addAnimal(@Param("SPID") String SPID, @Param("basic") PatrolFindInfoSub basic, @Param("PatrolMedioId")String PatrolMedioId);
        //添加植物分布信息
        public Integer addPlant(@Param("SPID")String SPID,@Param("basic")SpreadSubXhPlant basic,@Param("PatrolMedioId") String PatrolMedioId);
        //添加动物数量信息
        public Integer raiseFindQty(@Param("patrolId")String patrolId,@Param("list") List<SpreadFindQty> list);
}
