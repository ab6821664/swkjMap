package com.swkj.mapdisplay.enitiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
/*
@  在巡护的过程中发现动物要素信息,和动物信息
 */
@Setter
@Getter
public class PatrolFindInfoSub {
        private String SPID;
        private Integer PatrolSubId;
        private String AnimalCode;
        private String AnimalName;
        private String Lat;
        private String Action;
        private String Diatance;
        private String TraceType;
        private String FindContent;
        private String TraceTime;
        private String MonitorAddress;
        private String Altitude;
        private String PatrolLineId;
        private String Terrain;
        private String WeatherId;
        private String MonitorTime;
        private String PatrolLineName;
        private String Lng;
        private String HabitatId;

           public String getTraceType() {
              return TraceType;
               }

           public void setTraceType(String traceType) {
               TraceType = traceType;
               }
       }
