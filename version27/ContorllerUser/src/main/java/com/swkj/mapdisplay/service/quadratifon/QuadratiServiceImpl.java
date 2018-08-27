package com.swkj.mapdisplay.service.quadratifon;

import com.swkj.mapdisplay.enitiy.QuadratData;
import com.swkj.mapdisplay.enitiy.QuadratDataSub;
import com.swkj.mapdisplay.mapper.DropBaseMapper;
import com.swkj.mapdisplay.mapper.quadrat.QuadratMapper;
import com.swkj.mapdisplay.mapper.telecamera.CameraMapper;
import com.swkj.mapdisplay.service.quadratifon.quadratServiceImpl.QuadratServuce;
import com.swkj.mapdisplay.utils.Determine;
import com.swkj.mapdisplay.utils.utilsImpl.Constants;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class QuadratiServiceImpl implements QuadratServuce {
    @Autowired
    private QuadratMapper quadratMapper;
    @Autowired
    private CameraMapper cameraMapper;
    @Autowired
    private DropBaseMapper baseMapper;

    //增加样地信息
    @Override
    @Transactional
    public synchronized Integer same(String json) {
         //定义QuadratDataCode的值
         String dataSN=null;
         //定义QuadratID的值
         Integer quadratID=null;
         Map<String,Object> map=null;
        // json="[{\"quadratdataname\":\"样地信息\",\"gradient\":45,\"aspect\":45,\"altitude\":77.0000,\"area\":164143.480000,\"address\":\"77\",\"soilcode\":\"褐土\",\"humusspy\":\"54656\",\"invester\":\"232\",\"investerdate\":\"2018-8-8 12:12:7\",\"quadratDataSub\":[{\"botanycode\":\"43007-P020109002005002\",\"parameter1\":\"8506\",\"parameter2\":22.000000,\"parameter3\":666.000000,\"parameter4\":999.000000,\"healthstate\":\"8403\",\"remark\":\"7777\"},{\"botanycode\":\"43007-P020109002005001\",\"parameter1\":\"8504\",\"parameter2\":77.000000,\"parameter3\":777.000000,\"parameter4\":666.000000,\"healthstate\":\"8404\",\"remark\":\"666\"}]}]";
          JSONArray array = JSONArray.fromObject(json);
          for (int i=0;i<array.size();i++) {
              //得到存储过程中的值
              dataSN = quadratMapper.getDataSN("YF", 'N');
              //截取dataSN中0后面的值
              quadratID =Integer.parseInt( dataSN.substring(3));
              JSONObject object = array.getJSONObject(i);
              map= JSONObject.fromObject(JSONObject.fromObject(object));
              map.put("QuadratID",quadratID);
              map.put("QuadratDataCode",dataSN);
              //增加样地属性信息
                quadratMapper.addQuadratData(map);
                  JSONArray subarray = JSONArray.fromObject(map.get("quadratDataSub"));
                  for (int j = 0; j < subarray.size(); j++) {
                      JSONObject subarrayJSONObject = subarray.getJSONObject(j);
                      Map<String, Object> subMap = JSONObject.fromObject(JSONObject.fromObject(subarrayJSONObject));
                      subMap.put("QuadratID",quadratID);
                      subMap.put("SubID",j);
                      //增加样地植物属性信息
                        quadratMapper.addQuadratDataSub(subMap);
                      /*JSONArray listarray=JSONArray.fromObject(map.get("quadratDataList"));
                      for (int k=0;k<listarray.size();k++){
                          JSONObject listarrayJSONObject = listarray.getJSONObject(k);
                          Map<String,Object> listMap= JSONObject.fromObject(JSONObject.fromObject(listarrayJSONObject));
                          listMap.put("ListID",k+1);
                          listMap.put("QuadratID",quadratID);
                          listMap.put("CoordinateTime",Constants.SIMPLE_DATE_FORMAT.format(new Date()));
                         //增加样地位置信息
                         quadratMapper.addQuadratDataList(listMap);
                      }*/
                  }
              }
        return quadratID;

    }
    //查询样地属性信息
    @Override
    public List<QuadratData> queryQuadratData(String quadratID) {

        return quadratMapper.selectDataSub(quadratID);
    }
    //增加BHQ_QuadratDataSub表中的信息

    //查询样地下拉框中的值
    @Override
    public String droQuadratData() {
        List<Map<String, Object>> maps = cameraMapper.designCamera("31");

        return ShiroConfiguration.getjson(maps,null);
    }
    //删除样地属性信息
    @Override
    @Transactional
    public boolean amputateQuadratData(String QuadratID) {
        Integer dataSub=0;
        synchronized (QuadratiServiceImpl.class) {
            quadratMapper.deleteQuadratData(QuadratID);
             dataSub = quadratMapper.deleteQuadratDataSub(QuadratID);
        }
        return dataSub>0;
    }
    //修改样地属性信息
    @Override
    @Transactional
    public String reviseQuadratData(String quadratData) {
            Integer isok=null;
            Map<String,Object> map=JSONObject.fromObject(JSONObject.fromObject(quadratData));
            //修改样地属性信息
            quadratMapper.updateQuadratData(map);
            JSONArray subJsonObject = JSONArray.fromObject(map.get("quadratDataSub"));
            for (int j=0;j<subJsonObject.size();j++){
                JSONObject subarrayJSONObject = subJsonObject.getJSONObject(j);
                Map<String,Object> subMap = JSONObject.fromObject(JSONObject.fromObject(subarrayJSONObject));
                //修改植物属性信息
                isok= quadratMapper.updateQuadratDataSub(subMap);
            }
        return Determine.updateSuccess(isok>0);
    }
    //加载植物的代号信息
    @Override
    public List<Map<String, String>> baseDict() {
        return baseMapper.queryBotanyCode();
    }
}


