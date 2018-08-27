package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;
/*
  @代号表
  dbo.PT_BaseDict
 */
@Getter
@Setter
public class BaseDict {
    private Integer id;

    private String name;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
