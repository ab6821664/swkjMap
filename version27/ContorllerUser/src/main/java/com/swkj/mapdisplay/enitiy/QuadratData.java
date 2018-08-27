package com.swkj.mapdisplay.enitiy;

import com.sun.org.apache.xml.internal.serialize.Serializer;
import lombok.Getter;
import lombok.Setter;
import net.sf.json.JSONString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/*
  @样地表主表
 */
@Setter
@Getter
public class QuadratData {

        private Integer isid;

        private Integer quadratid;

        private String nativecode;

        private String quadratdatacode;

        private String quadratdataname;

        private String lat;

        private String lng;

        private String gradient;

        private String aspect;

        private BigDecimal altitude;

        private BigDecimal area;

        private String address;

        private String soilcode;

        private String humusspy;

        private String invester;

        private Date investerdate;

        private String createdby;

        private Date creationdate;

        private String lastupdatedby;

        private Date lastupdatedate;
        //从表植物表信息
        private List<QuadratDataSub> quadratDataSub;

        public void setQuadratid(Integer quadratid) {
                this.quadratid = quadratid;
        }

        public void setInvesterdate(Date investerdate) {
                this.investerdate = investerdate;
        }

        public void setCreationdate(Date creationdate) {
                this.creationdate = creationdate;
        }

        public void setLastupdatedate(Date lastupdatedate) {
                this.lastupdatedate = lastupdatedate;
        }

        public Date getInvesterdate() {
                return investerdate;
        }

        public Date getCreationdate() {
                return creationdate;
        }

        public Date getLastupdatedate() {
                return lastupdatedate;
        }

}
