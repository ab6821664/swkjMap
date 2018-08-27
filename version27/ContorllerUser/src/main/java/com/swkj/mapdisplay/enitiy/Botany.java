package com.swkj.mapdisplay.enitiy;

import lombok.Getter;
import lombok.Setter;

/*
  @植物详细信息表
 */
@Getter
@Setter
public class Botany {
    private String BotanyId;
    private String BotanyName;
    private String KidName;
    private String LatinName;
    private String EnglishName;
    private String Door;
    private String Gand;
    private String Family;
    private String Orders;
    private String Genus;
    private Integer Breed;
    private String Remark;
    private Integer ProtectType;
    private String versionNum;
    private String BioImageId;
    private String CollectionPerson;
    //日期
    private String CollectionDate;
    private String taxaid;
    private String Species;
    private String BotanyCode;
    private String BotanyKey;
    private String NativeCode;
    private String ProtectTypeName;
    private Integer IsVisible;
    private String Door_C;
    private String Gand_C;
    private String Family_C;
    private String Orders_C;
    private String Genus_C;
}
