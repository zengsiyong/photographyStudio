package com.zengsy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zengsy.pojo.Category;
import com.zengsy.pojo.Product;
import com.zengsy.pojo.Property;
import com.zengsy.service.CategoryService;
import com.zengsy.service.ProductService;
import com.zengsy.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by xlc on 2017-11-14.
 */
@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;


    @RequestMapping("admin_product_list")
    public String list(int cid, Model model, Page page) {
        Category c = categoryService.get(cid);

        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Product> ps = productService.list(cid);

        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&cid=" + c.getId());

        model.addAttribute("ps", ps);
        model.addAttribute("c", c);
        model.addAttribute("page", page);

        return "admin/listProduct";
    }

    @RequestMapping("admin_product_add")
    public String add(Model model, Product p) {
        // listProduct.jsp提交数据的时候，除了提交产品名称，小标题，原价格，优惠价格，库存外还会提交cid
        // 通过springmvc的自动封装将获取的Product对象插入到数据库
        productService.add(p);
        return "redirect:admin_product_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_product_edit")
    public String edit(Model model, int id) {
        // 根据properoty对象的cid产品获取Category对象，并把其设置在product对象的category产品上
        Product p = productService.get(id);
        Category c = categoryService.get(p.getCid());
        p.setCategory(c);
        System.out.println(p.getCid());
        model.addAttribute("p", p);
        return "admin/editProduct";
    }

    @RequestMapping("admin_product_update")
    public String update(Product p) {
        productService.update(p);
        return "redirect:admin_product_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_product_delete")
    public String delete(int id) {
        Product p = productService.get(id);
        productService.delete(id);
        return "redirect:admin_product_list?cid=" + p.getCid();
    }
}
