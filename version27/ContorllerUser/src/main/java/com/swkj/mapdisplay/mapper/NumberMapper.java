package com.swkj.mapdisplay.mapper;

import com.swkj.mapdisplay.enitiy.BaseDict;
import com.swkj.mapdisplay.enitiy.SpreadFindQty;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface NumberMapper {
        //展示动物信息数量信息
       public List<SpreadFindQty> getNumberqty(@Param("SPID") String SPID, @Param("PatrolId") String PatrolId);
       //查询数量代号的信息
       public List<BaseDict> selectanAnimalNuber(@Param("SPID")String SPID,@Param("PatrolId")String PatrolId);
}
