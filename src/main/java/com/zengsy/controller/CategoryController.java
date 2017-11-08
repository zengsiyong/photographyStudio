package com.zengsy.controller;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import com.zengsy.util.ImageUtil;
import com.zengsy.util.UploadedImageFile;
import org.mybatis.generator.internal.PluginAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zengsy.pojo.Category;
import com.zengsy.service.CategoryService;
import com.zengsy.util.Page;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;


	// 不使用分页插件的分页查询方式
	@RequestMapping("admin_category_list")
	public String list(Model model, Page page) {
		List<Category> cs = categoryService.list(page);
		int total = categoryService.total();

		page.setTotal(total);
		model.addAttribute("cs", cs);
		model.addAttribute("page", page);
		return "admin/listCategory";
	}




	//// 使用model的方式
    //
	//@RequestMapping("admin_category_list")
	//public String list(Model model, Page page){
	//	// 使用分页类自动分页，在分页后直接输出集合就会按分页类的start和count值进行分页
	//	PageHelper.offsetPage(page.getStart(), page.getCount());
	//	List<Category> categoryList = categoryService.list();
    //
	//	int total = (int) new PageInfo<>(categoryList).getTotal();
	//	page.setTotal(total);
	//	page.caculateLast(total);
    //
	//	model.addAttribute("categoryList", categoryList);
	//	model.addAttribute("page", page);
    //
    //
	//	return "admin/listCategory";
	//}

	//@RequestMapping("addmin_category_add")
	//public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
	//	categoryService.add(c);
    //
	//	//File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
	//	//File file = new File(imageFolder, c.getId() + ".jpg");
	//	//uploadedImageFile.getImage().transferTo(file);
	//	//BufferedImage img = ImageUtil.change2jpg(file);
	//	//ImageIO.write(img, "jpg", file);
	//	return "redirect:/admin_category_list";
	//}

	//@RequestMapping("admin_category_delete")
	//public String delete(int id, HttpSession session) {
	//	categoryService.delete(id);
	//	// getSession().getServletContext() 获取的是Servlet容器对象，相当于tomcat容器了。getRealPath("/") 获取实际路径，“/”指代项目根目录，所以代码返回的是项目在容器中的实际发布运行的根路径
	//	File imageFoleder = new File(session.getServletContext().getRealPath("img/category"));
	//	File file = new File(imageFoleder, id + ".jpg");
	//	file.delete();
    //
	//	return "redirect:/admin_category_list";
	//}
    //
	//@RequestMapping("admin_category_edit")
	//public String edit(int id, Model model) throws IOException {
	//	Category c = categoryService.get(id);
    //
	//	model.addAttribute("c", c);
    //
	//	return "admin/editCategory";
	//}

	//@RequestMapping("admin_category_update")
	//public String update(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
	//	categoryService.update(c);
    //
	//	MultipartFile image = uploadedImageFile.getImage();
	//	if(null != image &&! image.isEmpty()){
	//		File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
	//		File file = new File(imageFolder,c.getId()+".jpg");
	//		image.transferTo(file);
	//		BufferedImage img = ImageUtil.change2jpg(file);
	//		ImageIO.write(img, "jpg", file);
	//	}
	//	return "redirect:/admin_category_list";
	//}



	//@RequestMapping("admin_category_edit")
	//public String edit(int id, Model model) {
	//
	//}
	//// 使用modelandview的方式
	//@RequestMapping("admin_category_list")
	//public ModelAndView list(Page page){
	//	ModelAndView mav = new ModelAndView();
	//	PageHelper.offsetPage(page.getStart(),5);
	//	List<Category> categoryList = categoryService.list();
	//	int total = (int) new PageInfo<>(categoryList).getTotal();
	//
	//	page.caculateLast(total);
	//
	//	// 放入转发参数
	//	mav.addObject("cs", categoryList);
	//	// 放入jsp路径
	//	mav.setViewName("listCategory");
	//	return mav;
	//}

}
