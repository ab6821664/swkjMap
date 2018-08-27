package com.swkj.mapdisplay.service.quadratifon.quadratServiceImpl;

import com.swkj.mapdisplay.enitiy.QuadratData;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface QuadratServuce {
    //查询样地属性信息
    public List<QuadratData> queryQuadratData(String quadratID);
    //增加样地信息
     public Integer same(String json);
    //查询样地下拉框中的信息
    public String droQuadratData();
    //删除样地属性信息
    public boolean amputateQuadratData(String QuadratID);
    //修改样地属性信息
    public String reviseQuadratData(String json);
    //加载植物的代号信息
    public List<Map<String,String>> baseDict();
}
