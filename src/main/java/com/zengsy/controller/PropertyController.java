package com.zengsy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zengsy.pojo.Category;
import com.zengsy.pojo.Property;
import com.zengsy.service.CategoryService;
import com.zengsy.service.PropertyService;
import com.zengsy.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by xlc on 2017-11-13.
 */

@Controller
@RequestMapping("")
public class PropertyController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    PropertyService propertyService;

    @RequestMapping("admin_property_list")
    public String list(int cid, Model model, Page page) {
        Category c = categoryService.get(cid);
        // 使用分页插件
        PageHelper.offsetPage(page.getStart(), page.getCount());
        List<Property> ps = propertyService.list(cid);
        // 获得分页的总页数
        int total = (int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        // 把&cid= 参数设置到在page对象的param属性上,在adminPage.jsp页面中通过${page.param}取出这个参数
        page.setParam("&cid=" + c.getId());

        model.addAttribute("ps", ps);
        // c 在面包屑导航 中会用于显示分类名称
        model.addAttribute("c", c);
        model.addAttribute("page", page);

        return "admin/listProperty";
    }

    @RequestMapping("admin_property_add")
    public String add(Model model, Property p) {
        propertyService.add(p);
        return "redirect:admin_property_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_property_delete")
    public String delete(int id) {
        Property p = propertyService.get(id);
        propertyService.delete(id);
        return "redirect:admin_property_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_property_edit")
    public String edit(Model model, int id) {
        Property p = propertyService.get(id);
        Category c = categoryService.get(p.getCid());
        p.setCategory(c);
        model.addAttribute("p", p);
        return "admin/editProperty";
    }

    @RequestMapping("admin_property_update")
    public String update(Property p) {
        propertyService.update(p);
        return "redirect:admin_property_list?cid=" + p.getCid();
    }




}
