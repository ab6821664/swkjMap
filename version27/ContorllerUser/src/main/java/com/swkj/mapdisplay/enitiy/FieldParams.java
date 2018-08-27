package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldParams {
        private Integer ISID;
        private String SortCode;
        private String SortName;
        private Integer ParamsId;
        private String ParamsCode;
        private String ParamsType;
        private String ParamsName;
        private String Type;
        private Integer ParamsShowId;

        public void setISID(Integer ISID) {
                this.ISID = ISID;
        }

        public void setSortCode(String sortCode) {
                SortCode = sortCode;
        }

        public void setSortName(String sortName) {
                SortName = sortName;
        }

        public void setParamsName(String paramsName) {
                ParamsName = paramsName;
        }

        public Integer getISID() {
                return ISID;

        }

        public String getSortCode() {
                return SortCode;
        }

        public String getSortName() {
                return SortName;
        }

        public String getParamsName() {
                return ParamsName;
        }
}
