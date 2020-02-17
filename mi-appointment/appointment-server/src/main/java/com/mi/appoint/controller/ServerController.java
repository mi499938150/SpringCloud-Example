package com.mi.appoint.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Rong
 * @date : 2020/2/16
 * @Desc:
 */
@RestController
@Slf4j
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "this is appoint msg";
    }
}