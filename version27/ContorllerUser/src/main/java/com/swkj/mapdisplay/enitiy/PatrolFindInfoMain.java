package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class PatrolFindInfoMain {
        private Integer ISID;
        private String PatrolType;
        private String PatrolId;
        private String PatrolPlanId;
        private String PatrolLineId;
        private double ConsumingTime;
        private double PatrolDistance;
        private char PatrolStatus;
        private String Suggestion;
        private String Situation;
        private String Remark;
        private String NativeCode;
        private String UserId;
        private String CreateBy;
        private Date CreateDate;
        private String LastUpdateBy;
        private Date LastUpdateDate;


}
