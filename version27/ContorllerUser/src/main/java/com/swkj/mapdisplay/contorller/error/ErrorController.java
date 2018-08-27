package com.swkj.mapdisplay.contorller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
@异常统一判断,并作出处理
*/
@Controller
public class ErrorController {
  //当页面没有找到，跳到404页面
  @RequestMapping("errorpage/404")
  public void geterror(){
      System.out.print("404");
  }
  //当页面错误时跳往500页面
  @RequestMapping("errorpage/500")
  public void getwrong(){
      System.out.print("500");
  }

}
