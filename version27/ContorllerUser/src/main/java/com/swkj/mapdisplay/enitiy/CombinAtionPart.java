package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
/*
  @动物要素信息和植物要素信息的整合
 */
@Getter
@Setter
public class CombinAtionPart {
        //动物要素信息
        private List<PatrolFindInfoSub> patrolFindInfoSub;
        //植物要素信息
        private List<SpreadSubXhPlant> spreadSubXhPlant;

        public CombinAtionPart(){}

        public CombinAtionPart(List<PatrolFindInfoSub> patrolFindInfoSub,List<SpreadSubXhPlant> spreadSubXhPlant){
            this.patrolFindInfoSub=patrolFindInfoSub;
            this.spreadSubXhPlant=spreadSubXhPlant;
        }
}
