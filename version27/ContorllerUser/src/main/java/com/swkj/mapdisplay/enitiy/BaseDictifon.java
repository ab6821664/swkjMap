package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

/*
  @信息下拉框里面的值
 */
@Getter
@Setter
public class BaseDictifon {
        private Integer id;
        private String name;
        private String type;
        private Integer lock;
        private String versionNum;
        private Integer IsId;
}
