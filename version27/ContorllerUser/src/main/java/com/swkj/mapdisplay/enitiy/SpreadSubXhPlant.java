package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
/*
   @在巡护过程中发现植物要素信息表
 */
@Getter
@Setter
public class SpreadSubXhPlant {
       private String SPID;

       public void setSPID(String SPID) {
              this.SPID = SPID;
       }

       public String getSPID() {
              return SPID;
       }

       private Integer PatrolSubId;
       private String Qty;
       private String BotanyName;
       private String CoverType;
       private String GrowthSort;
       private String Phenological;
       private String GuanFu;
       private String CoverDegree;
       private String HealthStatus;
       private String Lng;
       private String Altitude;
       private String PatrolLineName;
       private String BotanyCode;
       private String MonitorAddress;
       private String PlantType;
       private String XiongJing;
       private String Height;
       private String FirstFz;
       private String LocationId;

       private String FindContent;
       private String PatrolLineId ;
       private String Lat;
       private String SlopeId;
       private String Terrain;
       private String MonitorTime;
       private String HabitatId;

}
