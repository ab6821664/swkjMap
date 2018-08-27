package com.swkj.mapdisplay.enitiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

//巡护轨迹表
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Setter
@Getter
public class PatrolManageInfo {

        private String patrolId;
       // private String userId;
        private String userName;
       // private int patrolTypeId;
      //  private String patrolTypeName;
      //  private String patrolRemark;
    //   @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
      // @DateTimeFormat(pattern="yyyy-MM-dd")
         @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
         private Date beginTime;
     //   @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date endTime;
        private Integer state;
        //private String PatrolPlanId;

       // private List<PatrolLine> PatrolList;

        private String patrolPlanName;

        private Integer PointCount;


}
