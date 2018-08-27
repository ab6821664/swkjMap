package com.swkj.mapdisplay.enitiy;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/*
  @在巡护过程中生物因子的信息
 */
@Getter
@Setter
@Data
public class PatrolFindInfoSubSJYZ {
        private String PlantType;
        private String Terrain;
        private String CoverPorosity;
        private String CoverStructural;
        private String CoverColloid;
        private String LocationId;
        private String SlopeId;
        private String HabitatId;
        private String Altitude;
        private String lng;
        private String lat;

}
