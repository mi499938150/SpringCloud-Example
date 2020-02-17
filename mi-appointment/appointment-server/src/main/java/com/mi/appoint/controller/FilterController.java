package com.mi.appoint.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Rong
 * @date : 2020/2/16
 * @Desc:
 */
@RestController
public class FilterController {


     // 假设主页

     @RequestMapping("index")
    public String Index(){

         return "index";
     }


     //假设查询
     @RequestMapping("query")
    public String Query(){
         return "query";
     }
}