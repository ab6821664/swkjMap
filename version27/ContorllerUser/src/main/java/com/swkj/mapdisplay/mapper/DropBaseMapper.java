package com.swkj.mapdisplay.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/*
  @加载下拉框中的值
 */
@Repository
public interface DropBaseMapper {
        //加载所有生物的下拉框中的值
        public List<String> dropActionIfon(@Param("acion") String acion);
        //动物名字信息和AnimalCode
        public List<Map<String,String>> queryAnimalCode();
        //植物名字信息和BotanyCode
        public List<Map<String,String>> queryBotanyCode();

}
