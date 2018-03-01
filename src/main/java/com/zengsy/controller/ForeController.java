package com.zengsy.controller;

import com.zengsy.pojo.*;
import com.zengsy.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    @Autowired
    ReviewService reviewService;

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
    //前台退出用户功能
    @RequestMapping("forelogout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:forehome";
    }
    //前台套餐详情页面
    @RequestMapping("foreproduct")
    public String product(int pid, Model model) {
        //1. 获取参数pid
        //2. 根据pid获取Product 对象p
        Product p = productService.get(pid);
        //3. 根据对象p，获取这个产品对应的单个图片集合
        List<ProductImage> productSingleImages = productImageService.list(p.getId(), ProductImageService.type_single);
        //4. 根据对象p，获取这个产品对应的详情图片集合
        List<ProductImage> productDetailImage = productImageService.list(p.getId(), ProductImageService.type_detail);
        p.setProductSingleImages(productSingleImages);
        p.setProductDetailImages(productDetailImage);

        //5. 获取产品的所有属性值
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        //6. 获取产品对应的所有的评价
        List<Review> reviews = reviewService.list(p.getId());
        //7. 设置产品的销量和评价数量
        productService.setSaleANdReviewNumber(p);
        //8. 把上述取值放在request属性上
        //9. 服务端跳转到 "product.jsp" 页面
        model.addAttribute("reviews", reviews);
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "fore/product";
    }
    //前台点击立即购买或加入购物车按钮时ajax异步请求查看当前用户登入状态
    @RequestMapping("forecheckLogin")
    @ResponseBody
    public String checkLogin(HttpSession session) {
        User user = (User)session.getAttribute("user");

        session.getAttribute("user");
        if (null != user) {
            return "success";
        }
        return "fail";
    }
    //通过模态框登入按钮发起的ajax请求进行用户验证登入
    @RequestMapping("foreloginAjax")
    @ResponseBody
    public String loginAjax(@RequestParam("name") String name, @RequestParam("password") String password, HttpSession session) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.get(name,password);

        if (null == user) {
            return "fail";
        }
        session.setAttribute("user", user);
        return "success";
    }
}



























