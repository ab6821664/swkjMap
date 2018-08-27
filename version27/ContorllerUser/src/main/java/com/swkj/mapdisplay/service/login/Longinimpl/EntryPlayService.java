package com.swkj.mapdisplay.service.login.Longinimpl;

import com.swkj.mapdisplay.enitiy.Boundary;

public interface EntryPlayService {
       public Boundary Longin(String LocationName);

       public Boundary LonginUser(String LocationName,String BoundaryID);
}
