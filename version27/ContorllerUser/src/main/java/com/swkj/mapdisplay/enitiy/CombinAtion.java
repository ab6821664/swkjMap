package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*
  @动物和生物因子的组合实体类
 */
@Getter
@Setter
public class CombinAtion {
        //动物信息
        private List<PatrolFindInfoSub> patrolFindInfoSub;
        //生物因子信息
        private List<PatrolFindInfoSubSJYZ> patrolFindInfoSubSJYZ;
        public CombinAtion(){}
        public CombinAtion(List<PatrolFindInfoSub> patrolFindInfoSub,List<PatrolFindInfoSubSJYZ> patrolFindInfoSubSJYZ){
            this.patrolFindInfoSub=patrolFindInfoSub;
            this.patrolFindInfoSubSJYZ=patrolFindInfoSubSJYZ;
        }
}
