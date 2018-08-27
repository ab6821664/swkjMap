package com.swkj.mapdisplay.enitiy;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
/*
  @查询巡护轨迹上动物和植物要素的代号信息
 */
@Getter
@Setter
public class SpreadSubMark {
        private String Action;
        private String terrain;
        private String TraceType;
        private String TraceTime;
        private String HabitatId;
        private String CoverType;
        private String GrowthSort;
        private String Phenological;
        private String HealthStatus;
}
