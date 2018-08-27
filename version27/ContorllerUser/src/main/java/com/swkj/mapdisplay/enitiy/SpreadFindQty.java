package com.swkj.mapdisplay.enitiy;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;

/*
  @数量信息展示表
 */
@Getter
@Setter
public class SpreadFindQty {
        private Integer ISID;
        private String SPID;
        private String PatrolId;
        private Integer PatrolSubId;
        private Integer PatrolFindId;
        private Integer GrowthState;
        private Integer MaleQty;
        private Integer FemaleQty;
        private Integer TotalQty;
}
