package com.swkj.mapdisplay.service.vidicon.vidiconImpl;

import com.swkj.mapdisplay.enitiy.Camera;

import java.util.List;
import java.util.Map;

public interface CameraService {
        //查询摄像机
       public List<Camera> selectCamera(Integer CameraId);
       //修改摄像机
      public boolean amendCamera(Camera su);
      //增加摄像机
      public Integer raiseCamera(String json,Camera camera);
      //删除摄像机信息
      public boolean dropCamera(Integer CameraId);
      //加载摄像机下拉框里面的值
      public String queryCameraIfon(String type);
}
