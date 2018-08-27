package com.swkj.mapdisplay.mapper.updateplatifon;

import com.swkj.mapdisplay.enitiy.PatrolFindInfoSub;
import com.swkj.mapdisplay.enitiy.SpreadFindQty;
import com.swkj.mapdisplay.enitiy.SpreadSubXhPlant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpdateIfonMapper {
        //修改动物分布信息
        public Integer updateScatter(PatrolFindInfoSub patro);
        //修改植物分布信息
        public Integer updatePlant(SpreadSubXhPlant sprea);
        //修改动物数量信息
        public Integer updateSpreadFindQty(@Param("patrolId")String patrolId, @Param("list")List<SpreadFindQty> list);
}
