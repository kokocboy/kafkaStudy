package cboy.com.example.kafkastudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cboy.yang
 * @createDate 2022-10-06 20:47
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    /**
     * 测试方法
     * @return
     */
    @GetMapping("/test")
    public String test(){
        return "测试";
    }


}
