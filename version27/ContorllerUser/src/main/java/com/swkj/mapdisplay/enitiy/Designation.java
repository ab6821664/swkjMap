package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;
/*
    @查询巡护过程中动物和生物因子代号的信息
    @即PT_PatrolFindInfoSub表
 */
@Getter
@Setter
public class Designation {
       private String action;
       private String habitatId;
       private String terrain;
       private String traceTime;
       private String traceType;
       private String coverColloid;
       private String coverPorosity;
       private String coverStructural;
;      private String plantType;
       private String slopeId;

    public void setCoverColloid(String coverColloid) {
        this.coverColloid = coverColloid;
    }

    public void setCoverPorosity(String coverPorosity) {
        this.coverPorosity = coverPorosity;
    }

    public void setCoverStructural(String coverStructural) {
        this.coverStructural = coverStructural;
    }

    public String getCoverColloid() {
        return coverColloid;
    }

    public String getCoverPorosity() {
        return coverPorosity;
    }

    public String getCoverStructural() {
        return coverStructural;
    }






    public void setAction(String action) {
        this.action = action;
    }

    public void setHabitatId(String habitatId) {
        this.habitatId = habitatId;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public void setTraceTime(String traceTime) {
        this.traceTime = traceTime;
    }

    public void setTraceType(String traceType) {
        this.traceType = traceType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public void setSlopeId(String slopeId) {
        this.slopeId = slopeId;
    }

    public String getAction() {
        return action;
    }

    public String getHabitatId() {
        return habitatId;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getTraceTime() {
        return traceTime;
    }

    public String getTraceType() {
        return traceType;
    }

    public String getPlantType() {
        return plantType;
    }

    public String getSlopeId() {
        return slopeId;
    }
}
