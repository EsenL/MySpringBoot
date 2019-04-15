package com.excmple;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class loginController {

    /**
     * 跳转登录页
     * @return
     */
    @GetMapping(value="/login")
    public ModelAndView login(String name){
        ModelAndView mav=new ModelAndView();
        mav.addObject("name",name);
        mav.setViewName("/test");
        return mav;
    }
}
