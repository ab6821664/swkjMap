package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*
  @人类信息和灾害监测信息组和实体类
 */
@Getter
@Setter
public class CombinSub {
       //人类信息
      private List<SpreadSubhuman> spreadSubhuman;
      //灾害监测信息
      private List<SpreadSubnature> spreadSubnatures;
      public CombinSub(){}
      public CombinSub(List<SpreadSubhuman> spreadSubhuman, List<SpreadSubnature> spreadSubnatures){
           this.spreadSubhuman = spreadSubhuman;
           this.spreadSubnatures = spreadSubnatures;
      }

}
