package com.swkj.mapdisplay.contorller.pickupcamera;

import com.swkj.mapdisplay.enitiy.Camera;
import com.swkj.mapdisplay.service.vidicon.CameraServiceImpl;
import com.swkj.mapdisplay.utils.Determine;
import com.swkj.mapdisplay.utils.ShiroConfiguration;
import net.sf.json.JSONObject;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


@RestController
public class CameraContorller {
        @Autowired
       private CameraServiceImpl cameraService;
        //根据id查询摄像机属性
        @RequestMapping("/selectVidicon/{CameraId}")
        public String selectVidicon(@PathVariable("CameraId") String CameraId){
            //String substring = CameraId.substring(1);
            //将传进来的CameraId转换成Integer类型
            Integer anInt = Integer.parseInt(CameraId);
            return ShiroConfiguration.getjson(cameraService.selectCamera(anInt),null);
        }
        //根据id修改摄像机属性
       @RequestMapping("/reviseCamera/{json}")
       public String reviseCamera(@PathVariable("json")String json,Camera camera){
          // json="{\"cameraId\":653,\"cameraName\":\"哈哈\",\"installPos\":\"大幅度发\",\"deptId\":\"\",\"installTime\":\"1998-4-4\",\"runState\":4402,\"factory\":6,\"serialNo\":\"\",\"ipAddress\":\"218.76.76.146\",\"userName\":\"a103070\",\"userPw\":\"\",\"Port\":78,\"channel\":\"\",\"orderBy\":\"\",\"type\":2,\"serverName\":\"\",\"lat\":\"2323\",\"lng\":\"4565\",\"CDID\":\"7\",\"cameraStadia\":\"\",\"cameraVariation\":\"\",\"headVariation\":\"\",\"isVisible\":1,\"comIPAddress\":\"\",\"vVariation\":\"\",\"isJdhc\":\"\",\"serverIPAddress\":\"\",\"serverPort\":\"\",\"nativeCode\":\"\",\"rtspPort\":\"\"}";
            //将json转换成map集合
           Camera su=(Camera) ShiroConfiguration.convertJsonObject(json,camera);
            boolean isok=cameraService.amendCamera(su);
            return Determine.updateSuccess(isok);
       }
       //增加摄像机信息
      @RequestMapping("/raiseCameraUrl/{jsonCamer}")
      public Integer raiseCameraUrl(@PathVariable("jsonCamer") String jsonCamer,Camera camera){
            jsonCamer="{\"cameraName\":\"尔尔\",\"provinceid\":\"\",\"cityid\":\"\",\"countryID\":\"\",\"InstallPos\":\"大幅度发\",\"deptId\":\"\",\"installTime\":\"1998-4-4\",\"runState\":4402,\"Factory\":6,\"serialNo\":\"\",\"ipAddress\":\"5845\",\"userName\":\"a103070\",\"userPw\":\"\",\"port\":\"78\",\"channel\":\"\",\"orderBy\":\"\",\"type\":2,\"serverName\":\"\",\"lat\":\"2323\",\"lng\":\"4565\",\"CDID\":\"7\",\"cameraStadia\":\"\",\"cameraVariation\":\"\",\"headVariation\":\"\",\"isVisible\":\"\",\"comIPAddress\":\"\",\"vVariation\":\"\",\"isJdhc\":\"\",\"serverIPAddress\":\"\",\"serverPort\":\"\",\"nativeCode\":\"\",\"rtspPort\":\"\"}";
            Integer CameraId= cameraService.raiseCamera(jsonCamer,camera);
            return CameraId;
      }
      //删除摄像机信息
      @RequestMapping("/strikeOutCamera/{CameraId}")
      public String strikeOutCamera(@PathVariable("CameraId")Integer CameraId){
            return Determine.updateSuccess(cameraService.dropCamera(CameraId));
      }
      //加载摄像机下拉框里面的值
      @RequestMapping("/dropCamera")
      public String dropCamera(){
          return cameraService.queryCameraIfon(null);
      }
}
