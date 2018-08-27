package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Camera {
        private Integer CameraId;

        private String CameraName;

        private Integer Provinceid;

        private Integer Cityid;

        private Integer CountryID;

        private String InstallPos;

        private String DeptId;

        private Date InstallTime;

        private Integer RunState;

        private Integer Factory;

        private String SerialNo;

        private String IpAddress;

        private String UserName;

        private String UserPw;

        private Integer Port;

        private Integer Channel;

        private Integer OrderBy;

        private Integer type;

        private String ServerName;

        private BigDecimal Lat;

        private BigDecimal Lng;

        private Integer CDID;

        private BigDecimal CameraStadia;

        private BigDecimal CameraVariation;

        private BigDecimal HeadVariation;

        private Integer IsVisible;

        private String ComIPAddress;

        private BigDecimal VVariation;

        private Integer IsJdhc;

        private String ServerIPAddress;

        private String ServerPort;

        private String nativeCode;

        private String RtspPort;


}
