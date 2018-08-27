package com.swkj.mapdisplay.service;

import com.swkj.mapdisplay.mapper.DropBaseMapper;
import com.swkj.mapdisplay.service.impl.DropBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DropBaseServiceImpl implements DropBaseService {
     @Autowired
     private DropBaseMapper dropBaseMapper;
    //加载所有生物的下拉框中的值
    @Override
   public List<String> ActionIfon(String action) {
        return dropBaseMapper.dropActionIfon(action);
    }

    //动物名字信息和AnimalCode信息
    @Override
    public List<Map<String,String>> selectAnimalCode() {
        return dropBaseMapper.queryAnimalCode();
    }
    //植物名字信息和BotanyCode信息
    @Override
    public List<Map<String,String>> selectBotanyCode() {
        return dropBaseMapper.queryBotanyCode();
    }

}
