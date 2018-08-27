package com.swkj.mapdisplay.mapper.appendmapper;

import com.swkj.mapdisplay.enitiy.Botany;
import com.swkj.mapdisplay.enitiy.Boundary;
import com.swkj.mapdisplay.enitiy.SpreadHabitatSub;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface BoundaryPostMapper {
        //查询出界牌界碑和牌栏的id
        public String BoundaId(Map<String,Object> map);
        //增加界牌界碑信息
        public Integer raiseBoundary( Map<String,Object> bounMap);
        //增加牌栏信息
        public Integer raiseBotany(Map<String,Object> botanyMap);
        //增加生境信息
        public Integer raiseSjyz(Map<String,Object> sjyzMap);
        //增加与生境信息关联的BHQ_Sm_Relation表的信息
        public Integer addRelation(Map<String,Object> map);
        //查询生境信息的范围信息
        public String range(Map<String,Object> map);
}
