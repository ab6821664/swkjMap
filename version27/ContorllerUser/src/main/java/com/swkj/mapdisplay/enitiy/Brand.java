package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/*
  @界栏信息表
 */
@Getter
@Setter
public class Brand {
        private Integer BHQID;
        private String BrandID;
        private String LocationName;
        private String SortName;
        private Integer Qty;
        private float Lat;
        private float Lng;
        private String Model;
        private String Publisher;
        private String Sizes;
        private Date Publishdate;
        private String Content;
        private String PersonLiable;
        private String BioImageId;
        private Date CreationDate;
        private String CreatedBy;
        private Date LastUpdateDate;
        private String LastUpdatedBy;
        private String NativeCode;
        private String BrandName;

}
