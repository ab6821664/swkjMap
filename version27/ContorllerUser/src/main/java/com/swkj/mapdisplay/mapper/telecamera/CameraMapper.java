package com.swkj.mapdisplay.mapper.telecamera;

import com.swkj.mapdisplay.enitiy.Camera;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Repository
public interface CameraMapper {
        //查询摄像机
        public List<Camera> queryCamera(@Param("CameraId") Integer CameraId);
        //修改摄像机
        public Integer updateCamera(Camera su);
        //增加摄像机属性
        public Integer addCamera(Camera camera);
        //删除摄像机信息
        public Integer deleteCamera(@Param("CameraId")Integer CameraId);
        //加载摄像机的下拉框里面的值
        public List<Map<String,Object>> designCamera(@Param("type") String type);
}
