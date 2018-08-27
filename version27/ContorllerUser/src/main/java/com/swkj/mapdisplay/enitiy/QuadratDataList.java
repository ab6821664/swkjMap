package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/*
*  @创建样地位置实体类
* */
public class QuadratDataList {
        private Integer iSID;
        private Integer listID;
        private Integer quadratID;
        private String lng;
        private String lat;

    public void setISID(Integer ISID) {
        this.iSID = iSID;
    }

    public void setListID(Integer listID) {
        listID = listID;
    }

    public void setQuadratID(Integer quadratID) {
        quadratID = quadratID;
    }

    public void setLng(String lng) {
        lng = lng;
    }

    public void setLat(String lat) {
        lat = lat;
    }

    public void setCoordinateTime(Date coordinateTime) {
        coordinateTime = coordinateTime;
    }

    public Integer getISID() {
        return iSID;
    }

    public Integer getListID() {
        return listID;
    }

    public Integer getQuadratID() {
        return quadratID;
    }

    public String getLng() {
        return lng;
    }

    public String getLat() {
        return lat;
    }

    public Date getCoordinateTime() {
        return coordinateTime;
    }

    private Date coordinateTime;
}
