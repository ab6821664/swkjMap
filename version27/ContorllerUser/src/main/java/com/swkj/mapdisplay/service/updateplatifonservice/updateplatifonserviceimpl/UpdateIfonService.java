package com.swkj.mapdisplay.service.updateplatifonservice.updateplatifonserviceimpl;

import com.swkj.mapdisplay.enitiy.PatrolFindInfoSub;
import com.swkj.mapdisplay.enitiy.SpreadFindQty;
import com.swkj.mapdisplay.enitiy.SpreadSubXhPlant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UpdateIfonService {
    //修改动物分布信息
    public boolean updateAnimalScatter(PatrolFindInfoSub patro);
    //修改植物分布信息
    public boolean updatePlantIfon(SpreadSubXhPlant sprea);
    //修改动物数量信息
    public boolean updateAnimalNumber(String patrolId, List<SpreadFindQty> spreadFindQty);

}
