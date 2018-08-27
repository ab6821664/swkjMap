package com.swkj.mapdisplay.service.deleteLivestockservice.deleteLivestockImpl;

public interface DropSpreadSubService {
         //删除动物信息
         public boolean dropAnimalIfon(String SPID,String PatrolSubId);
         //删除界桩界碑的信息
         public boolean dropBoundary(String BoundaryID);
         //删除牌栏信息
         public boolean dropBrand(String BrandID);
}
