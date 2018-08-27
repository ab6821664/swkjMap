package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/*
@ 界桩表
 */
@Getter
@Setter
public class Boundary {
      private Integer BHQID;
      private  String BoundaryID;
      private String LocationName;
      private String BoundaryName;
      private float Lat;
      private float Lng;
      private String Model;
      private Date Publishdate;
      private String Content;
      private String BioImageId;
      private Date  CreationDate;
      private String CreatedBy;
      private Date LastUpdateDate;
      private String LastUpdatedBy;
      private String NativeCode;

      public String getBoundaryID() {
            return BoundaryID;
      }

      public void setBoundaryID(String boundaryID) {
            BoundaryID = boundaryID;
      }
}
