package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class PatrolPlanInfo {
        private String patrolPlanId;
        private String patrolPlanName;
        private Integer patrolTypeId;
        private String patrolTypeName;
        private String patrolRemark;
        private String PATROLLINEID;
        private String State;
        private Date patrolStartDate;
        private Date patrolEndDate;
        private String patrolPerson;
        private String patrolKeyPoint;
        private String NativeCode;
        private String patrolAdvice;
        private Date patrolAdviceDate;
        private String patrolPersonName;
        private String PatrolType;


}
