package com.swkj.mapdisplay.service.updateplatifonservice;

import com.swkj.mapdisplay.enitiy.*;
import com.swkj.mapdisplay.mapper.updateplatifon.AmendBotaMapper;
import com.swkj.mapdisplay.service.updateplatifonservice.updateplatifonserviceimpl.AmendBotaService;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.MARSHAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AmendBotaServiceImpl implements AmendBotaService {
    private List<Object> list=new ArrayList<>();
    private Map<String,Object> map=new HashMap<>();
    @Autowired
    private AmendBotaMapper amendBotaMapper;
    //修改界牌界碑信息
    @Override
    @Transactional
    public boolean AmendBoundaryIfon(Boundary boundary) {
        return amendBotaMapper.updateBoundary(boundary)>0;
    }
    //修改牌栏信息
    @Override
    @Transactional
    public boolean AmendBrandIfon(Brand brand) {
        return amendBotaMapper.updateBrand(brand)>0;
    }
    //修改灾害监测信息
    @Override
    @Transactional
    public boolean selectDisaster(SpreadSubnature spreadSubnature) {
        return amendBotaMapper.updateDisaster(spreadSubnature)>0;
    }
    //修改人为干扰信息
    @Override
    @Transactional
    public boolean selectJamming(SpreadSubhuman spreadSubhuman) {

        return amendBotaMapper.updateJamming(spreadSubhuman)>0;
    }
    //修改生境信息
    @Override
    public boolean selectSjyz(SpreadHabitatSub sub) {
        return amendBotaMapper.updateSjyz(sub)>0;
    }
    //增加人为干扰信息
    @Override
    @Transactional
    public String redisJamming(String json,SpreadSubhuman subhuman) {
        SpreadSubhuman jsonObject =(SpreadSubhuman) ShiroConfiguration.convertJsonObject(json, subhuman);
        //生成随机spid
        String uuid = ShiroConfiguration.getUUID();
        //生成随机PatrolId值
        String patro = ShiroConfiguration.getUUID();
        map.put("SPID",uuid);
        map.put("PatrolId",patro);
        map.put("PatrolMedioId",ShiroConfiguration.getUUID());
        map.put("sub",jsonObject);
        if (amendBotaMapper.addJamming(map)>0){
            list.add(uuid);
            list.add(patro);
            return ShiroConfiguration.getjson(list,null);
        }
        return null;
    }
    //增加灾害监测信息
    @Override
    @Transactional
    public String redisXhDisaster(String xhdjson,SpreadSubnature subnature) {
        SpreadSubnature object = (SpreadSubnature) ShiroConfiguration.convertJsonObject(xhdjson, subnature);
        //生成随机spid
        String uuid = ShiroConfiguration.getUUID();
        //生成随机PatrolId值
        String patro = ShiroConfiguration.getUUID();
        map.put("SPID",uuid);
        map.put("PatrolId",patro);
        map.put("PatrolMedioId",ShiroConfiguration.getUUID());
        map.put("sub",object);
        if (amendBotaMapper.addXhdisaster(map)>0){
            list.add(uuid);
            list.add(patro);
            return ShiroConfiguration.getjson(list,null);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean droJamming(String SPID, String PatrolId) {

        return amendBotaMapper.deleteJamming(SPID, PatrolId)>0;
    }
}
