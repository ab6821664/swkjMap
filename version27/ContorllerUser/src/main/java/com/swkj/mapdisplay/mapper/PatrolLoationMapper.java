package com.swkj.mapdisplay.mapper;


import com.swkj.mapdisplay.enitiy.PatrolFindInfoSub;
import com.swkj.mapdisplay.enitiy.PatrolFindInfoSubSJYZ;
import com.swkj.mapdisplay.enitiy.PatrolLocationInfo;
import com.swkj.mapdisplay.enitiy.PatrolManageInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatrolLoationMapper {
       //查询所有的patrolId
       @Select("SELECT DISTINCT patrolId \n" +
               ",locationTime FROM PT_PatrolLocationInfo t \n" +
               "WHERE NOT EXISTS \n" +
               "(SELECT 1 FROM PT_PatrolLocationInfo WHERE \n" +
               "t.patrolId = patrolId AND t.locationTime> locationTime)\n" +
               "order by locationTime")
       public List<String> querypatro();
       //根据id查询出[lat] [lng]
       @Select("select lat,lng from PT_PatrolLocationInfo where patrolId=#{patrolId} ORDER BY locationTime")
       public List<PatrolLocationInfo> querypatrolId(@Param("patrolId") String  patrolId);
        //根据id删除信息
       @Delete("delete from PT_PatrolLocationInfo where patrolId=#{patrolId}")
       public int deletcpatrolId(@Param("patrolId") String patrolId);
       //增加数据
        @Insert("INSERT INTO PT_PatrolLocationInfo VALUES (#{patrolId},#{lat},#{lng},#{locationTime},#{locationId},#{userId},#{altitude},#{gravity},#{Speed},#{Length},#{InfoState},#{TaskState},#{ReciverDate})")
       public int addPatrolLocationInfo(PatrolLocationInfo patrolLocationInfo);
        //查询巡护轨迹展示
        public List<PatrolManageInfo> PatrolLocationInfoquery();
         //根据巡护的id查询出相应的记录
        public List<PatrolManageInfo> ManageInfoid(@Param("patrolId") String patrolId);
        //查询出在巡护过程中动物的信息
        public List<PatrolFindInfoSub> processlist(@Param("SubpatrolId")String SubpatrolId);
        //查询出在巡护过程生物因子的信息
        public List<PatrolFindInfoSubSJYZ> paraList(@Param("patroid")String patroid);




}
