package com.swkj.mapdisplay.enitiy;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.List;
//从表
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PatrolLocationInfo {
        private String patrolId;
        private String lat;
        private String lng;
        private Date locationTime;
        private String locationId;
        private String userId;
        private String altitude;
        private String  gravity;
        private double Speed;
        private double Length;
        private  Integer InfoState;
        private Integer TaskState;
        private Date ReciverDate;
        //进行多对多连接
        private List<PatrolManageInfo> ManageList;

    public String getPatrolId() {
        return patrolId;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public Date getLocationTime() {
        return locationTime;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getUserId() {
        return userId;
    }

    public String getAltitude() {
        return altitude;
    }

    public String getGravity() {
        return gravity;
    }

    public double getSpeed() {
        return Speed;
    }

    public double getLength() {
        return Length;
    }

    public int getInfoState() {
        return InfoState;
    }

    public int getTaskState() {
        return TaskState;
    }

    public Date getReciverDate() {
        return ReciverDate;
    }

    public List<PatrolManageInfo> getManageList() {
        return ManageList;
    }

    public void setPatrolId(String patrolId) {
        this.patrolId = patrolId;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setLocationTime(Date locationTime) {
        this.locationTime = locationTime;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public void setSpeed(double speed) {
        Speed = speed;
    }

    public void setLength(double length) {
        Length = length;
    }

    public void setInfoState(int infoState) {
        InfoState = infoState;
    }

    public void setTaskState(int taskState) {
        TaskState = taskState;
    }

    public void setReciverDate(Date reciverDate) {
        ReciverDate = reciverDate;
    }

    public void setManageList(List<PatrolManageInfo> manageList) {
        ManageList = manageList;
    }
}
