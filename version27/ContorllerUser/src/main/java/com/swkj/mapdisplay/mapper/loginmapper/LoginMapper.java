package com.swkj.mapdisplay.mapper.loginmapper;

import com.swkj.mapdisplay.enitiy.Boundary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
        public Boundary Long(@Param("LocationName") String LocationName);

}
