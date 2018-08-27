package com.swkj.mapdisplay.service.appendservice;


import com.swkj.mapdisplay.mapper.appendmapper.BoundaryPostMapper;
import com.swkj.mapdisplay.service.appendservice.appendimpl.BoundaryPostService;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Max;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Service
public class BoundaryPostServiceImpl implements BoundaryPostService
{
    private ExecutorService service=Executors.newCachedThreadPool();
    private String spid=ShiroConfiguration.getUUID();//生境信息的spid
    private String patrolId=ShiroConfiguration.getUUID();//生境信息的PatrolId
    private  SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private BoundaryPostMapper boundaryPostMapeer;

    @Override
    @Transactional
    public String selectBounId(Map<String, Object> map) {
        String bounid=  boundaryPostMapeer.BoundaId(map);
        return bounid;
    }

    //增加界牌界碑信息
    @Override
    public boolean raiseBoundaryIfon(Map<String,Object> bounMap) {

         return boundaryPostMapeer.raiseBoundary(bounMap)>0;
    }
    //增加牌栏信息
    @Override
    public boolean raiseBotanyIfon(Map<String,Object> botany) {

        return boundaryPostMapeer.raiseBotany(botany)>0;
    }
    //增加生境信息
    @Override
    @Transactional
    public String raiseSjyzIfon(String json) {
        //将json格式转换成map集合形式
        Map<String, Object> map = JSONObject.fromObject(JSONObject.fromObject(json));
        List<String> list = new ArrayList<>();
        map.put("SPID", spid);
        map.put("PatrolId", patrolId);
        map.put("PatrolMedioId", ShiroConfiguration.getUUID());
        map.put("CreateTime", simpleDateFormat.format(new Date()));
        String range = boundaryPostMapeer.range(map);
        System.out.print(range);
        map.put("SmId", range);
         if (range !=null) {
        Integer sjyzmap = boundaryPostMapeer.raiseSjyz(map);
        if (sjyzmap > 0) {
            boundaryPostMapeer.addRelation(map);
            //增加成功将生境信息的id返回给前台
            list.add(spid);
            list.add(patrolId);
        }
          }else{
            return "0";

        }
        return ShiroConfiguration.getjson(list,null);
    }
}
