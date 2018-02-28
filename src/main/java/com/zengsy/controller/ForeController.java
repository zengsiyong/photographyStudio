package com.zengsy.controller;

import com.zengsy.pojo.Category;
import com.zengsy.pojo.User;
import com.zengsy.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 前台首页对应控制类
 * Created by zengsy on 2018-02-23.
 */
@Controller
@RequestMapping("")
public class ForeController {
    //log4j
    //private static Logger log = Logger.getLogger(ForeController.class);
    private final static Logger log = Logger.getLogger("PhotographyStudio_log");
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;

    @RequestMapping("forehome")
    public String home(Model model) {
        List<Category> cs = categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
        model.addAttribute("cs", cs);
        log.info("输出错误的信息");
        return "fore/home";
    }
    //registerPage.jsp 的form提交数据到路径 foreregister
    @RequestMapping("foreregister")
    public String register(Model model, User user) {
        String name = user.getName();
        //防止恶意注册，将特殊符号进行转义
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);
        //判断用户是否存在
        boolean exist = userService.isExist(name);
        if(exist) {
            String m = "用户名已经被使用，不能使用";
            model.addAttribute("msg", m);
            model.addAttribute("user", null);
            return "fore/register";
        }
        //将新增用户落表
        userService.add(user);

        return "redirect:registerSuccessPage";
    }
    //loginPage.jsp的form提交数据到路径 forelogin,导致ForeController.login()方法被调用
    @RequestMapping("forelogin")
    public String login(@RequestParam String name, @RequestParam("password") String password, Model model, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name, password);

        if (null == user) {
            model.addAttribute("msg", "账号密码错误");
            return "fore/login";
        }

        session.setAttribute("user", user);
        return "redirect:forehome";
    }
}



























