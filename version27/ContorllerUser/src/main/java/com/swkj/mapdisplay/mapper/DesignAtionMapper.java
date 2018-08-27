package com.swkj.mapdisplay.mapper;


import com.swkj.mapdisplay.enitiy.*;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DesignAtionMapper {
    //查询巡护过程中代号的信息
    public Designation selectBymark(@Param("patroid")String patroid);
    //把查询巡护过程中代号的信息转换成指定的信息
    @MapKey("id")
    public List<BaseDict> selectByappoint(@Param("appointlist")Designation appointlist);
    //查询巡护过程中动物分布的信息
    public List<PatrolFindInfoSub> queryBySpread(@Param("spid")String spid, @Param("PatrolSubId")Integer PatrolSubId);
    //查询巡护过程中植物分布的信息
     public List<SpreadSubXhPlant> GainSpreadXhPlant(@Param("spid")String spid, @Param("PatrolSubId")Integer PatrolSubId);
     //查询巡护过程中BHQ_SpreadSub表中的代号的信息
     public SpreadSubMark getBymark(@Param("markspid")String markspid, @Param("PatrolSubId")Integer PatrolSubId);
    //将BHQ_SpreadSub表中的代码转换成具体的值
    public List<BaseDict> getBybaseDict(@Param("spreadSubMark") SpreadSubMark spreadSubMark);
}
