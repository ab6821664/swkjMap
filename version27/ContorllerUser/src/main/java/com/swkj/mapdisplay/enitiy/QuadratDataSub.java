package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/*
 @样地植物信息表
 */
@Getter
@Setter
public class QuadratDataSub {
    private Integer isid;

    private Integer subid;

    private Integer quadratid;

    private String botanycode;

    private String parameter1;

    private BigDecimal parameter2;

    private BigDecimal parameter3;

    private BigDecimal parameter4;

    private String healthstate;

    private String remark;
    //样地主表的属性
    private QuadratData quadratData;

}
