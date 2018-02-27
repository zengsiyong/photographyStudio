package com.zengsy.controller;

import com.zengsy.pojo.Category;
import com.zengsy.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
