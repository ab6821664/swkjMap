package com.swkj.mapdisplay.mapper.quadrat;

import com.swkj.mapdisplay.enitiy.QuadratData;
import com.swkj.mapdisplay.enitiy.QuadratDataList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
@Repository
public interface QuadratMapper {
      //查询样地表
      public List<QuadratData> selectDataSub(@Param("quadratID") String quadratID);
      //执行sp_sys_GetDataSN存储过程返回QuadratDataCode的值
      public String getDataSN(@Param("DataCode")String DataCode,@Param("Code") char Code);
      //增加样地属性信息
      public Integer addQuadratData(Map<String,Object> map);
      //保存位置表BHQ_QuadratDataList信息
      public Integer addQuadratDataList(@Param("map") Map<String,Object> map);
      //增加样地植物信息
      public Integer addQuadratDataSub(@Param("map") Map<String,Object> map);
      //修改样地属性
      public Integer updateQuadratData(Map<String,Object> map);
      //修改样地植物属性信息
      public Integer updateQuadratDataSub(Map<String,Object> subMap);
      //删除样地属性
      public Integer deleteQuadratData(@Param("QuadratID")String QuadratID);
      //删除样地植物属性信息
      public Integer deleteQuadratDataSub(@Param("QuadratID")String QuadratID);
      //加载植物名称的代号信息
      public List<Map<String,Object>> dictIfon();
}
