package com.swkj.mapdisplay.service.vidicon;

import com.swkj.mapdisplay.enitiy.Camera;
import com.swkj.mapdisplay.mapper.telecamera.CameraMapper;
import com.swkj.mapdisplay.service.vidicon.vidiconImpl.CameraService;
import com.swkj.mapdisplay.utils.utilsImpl.Constants;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CameraServiceImpl implements CameraService {
    Map<String,Object> map=new HashMap<>();
    @Autowired
    private CameraMapper cameraMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Override
    public List<Camera> selectCamera(Integer CameraId) {

            return cameraMapper.queryCamera(CameraId);
    }
     //修改摄像机信息
    @Override
    public boolean amendCamera(Camera su) {

           return  cameraMapper.updateCamera(su)>0;
    }
    //增加摄像机信息
    @Override
    public Integer raiseCamera(String json,Camera camera) {
        //Map<String,Object> map= JSONObject.fromObject(JSONObject.fromObject(json));
        Camera object = (Camera) ShiroConfiguration.convertJsonObject(json, camera);
        Integer integer = cameraMapper.addCamera(object);
        return integer;
    }

    @Override
    public boolean dropCamera(Integer CameraId) {
        return cameraMapper.deleteCamera(CameraId)>0;
    }

    @Override
    public String queryCameraIfon(String type) {
     /*   //从缓存中取数据
        String redisString = (String) redisTemplate.opsForValue().get(Constants.XhPEOPLEACTION);
        //判断缓存中是否有数据如果没有则从数据库中查询
        synchronized (this) {
            if (redisString == null) {*/
                List<Map<String, Object>> maps = cameraMapper.designCamera("44");
                List<Map<String, Object>> list = cameraMapper.designCamera("26");
                List<Map<String, Object>> camera = cameraMapper.designCamera("45");
                String cameraIfon = ShiroConfiguration.CameraIfon(maps, list, camera);
                //redisTemplate.opsForValue().set(Constants.XhPEOPLEACTION, cameraIfon);
                return cameraIfon;
    }
}
