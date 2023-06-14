package com.office.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//restful风格
public class CommonController {
    @RequestMapping("/html_{page}")
    public String toPage(@PathVariable("page") String html){
        return html;
    }
}
