package com.sf.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
    /**
     * 获取首页
     *
     * @param model
     * @return
     */
    @RequestMapping("")
    public ModelAndView index(ModelAndView model) {
        model.setViewName("index");
        return model;
    }

    /**
     * 欢迎页面
     *
     * @param model
     * @return
     */
    @RequestMapping("welcome")
    public ModelAndView welcome(ModelAndView model) {
        model.setViewName("welcome");
        return model;
    }

    /**
     * 会员列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping("member-list")
    public ModelAndView memberList(ModelAndView model) {
        model.setViewName("member-list");
        return model;
    }

    /**
     * 管理员列表页面
     *
     * @param model
     * @return
     */
    @RequestMapping("manage-list")
    public ModelAndView memageList(ModelAndView model) {
        model.setViewName("manage-list");
        return model;
    }


}
