package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

/*
  @人类活动信息表
 */
@Getter
@Setter
public class SpreadSubhuman {
      private String SPID;
      private String PatrolId;
      private String PatrolSubId;
      private String Qty;
      private String InterfereTime;
      private String Lng;
      private String Altitude;
      private String MonitorAddress;
      private String Law;
      private String PatrolLineName;
      private String PatrolLineId;
      private String InterfereStrg;
      private String Lat;
      private String PunishResult;
      private String InterfereType;
      private String FindContent;
      private String MonitorTime;

      public void setSPID(String SPID) {
            this.SPID = SPID;
      }

      public void setPatrolId(String patrolId) {
            PatrolId = patrolId;
      }

      public void setPatrolSubId(String patrolSubId) {
            PatrolSubId = patrolSubId;
      }

      public void setQty(String qty) {
            Qty = qty;
      }

      public void setInterfereTime(String interfereTime) {
            InterfereTime = interfereTime;
      }

      public void setLng(String lng) {
            Lng = lng;
      }

      public void setAltitude(String altitude) {
            Altitude = altitude;
      }

      public void setMonitorAddress(String monitorAddress) {
            MonitorAddress = monitorAddress;
      }

      public void setLaw(String law) {
            Law = law;
      }

      public void setPatrolLineName(String patrolLineName) {
            PatrolLineName = patrolLineName;
      }

      public void setPatrolLineId(String patrolLineId) {
            PatrolLineId = patrolLineId;
      }

      public void setInterfereStrg(String interfereStrg) {
            InterfereStrg = interfereStrg;
      }

      public void setLat(String lat) {
            Lat = lat;
      }

      public void setPunishResult(String punishResult) {
            PunishResult = punishResult;
      }

      public void setInterfereType(String interfereType) {
            InterfereType = interfereType;
      }

      public void setFindContent(String findContent) {
            FindContent = findContent;
      }

      public void setMonitorTime(String monitorTime) {
            MonitorTime = monitorTime;
      }

      public String getSPID() {
            return SPID;
      }

      public String getPatrolId() {
            return PatrolId;
      }

      public String getPatrolSubId() {
            return PatrolSubId;
      }

      public String getQty() {
            return Qty;
      }

      public String getInterfereTime() {
            return InterfereTime;
      }

      public String getLng() {
            return Lng;
      }

      public String getAltitude() {
            return Altitude;
      }

      public String getMonitorAddress() {
            return MonitorAddress;
      }

      public String getLaw() {
            return Law;
      }

      public String getPatrolLineName() {
            return PatrolLineName;
      }

      public String getPatrolLineId() {
            return PatrolLineId;
      }

      public String getInterfereStrg() {
            return InterfereStrg;
      }

      public String getLat() {
            return Lat;
      }

      public String getPunishResult() {
            return PunishResult;
      }

      public String getInterfereType() {
            return InterfereType;
      }

      public String getFindContent() {
            return FindContent;
      }

      public String getMonitorTime() {
            return MonitorTime;
      }
}
