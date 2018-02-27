package com.zengsy.controller;

import com.zengsy.pojo.Product;
import com.zengsy.pojo.PropertyValue;
import com.zengsy.service.ProductService;
import com.zengsy.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by xlc on 2017-12-10.
 */
@Controller
@RequestMapping("")
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ProductService productService;

    @RequestMapping("admin_propertyValue_edit")
    public String edit(Model model, int pid) {
        Product p = productService.get(pid);
        propertyValueService.init(p);
        // 获取当前产品对应的所有属性值
        List<PropertyValue> pvs = propertyValueService.list(p.getId());
        for(int i = 0 ; i < pvs.size() ; i++) {
            System.out.println(pvs.get(i).getValue());
        }

        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        return "admin/editPropertyValue";
    }

    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String update(PropertyValue pv) {
        propertyValueService.update(pv);
        return "success";
    }
}


































