package com.swkj.mapdisplay.service.impl;

import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.Map;

public interface DropBaseService {
         //加载所有生物的下拉框中的值
        public List<String> ActionIfon(String acion);
       //动物名字信息和AnimalCode
       public List<Map<String,String>> selectAnimalCode();
       //植物名字信息和BotanyCode
       public List<Map<String,String>> selectBotanyCode();
}
