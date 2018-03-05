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
	@RequestMapping("admin_category_list")
	public String list(Model model, Page page) {
		// 使用pageHelper插件分页,固定格式
		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Category> cs = categoryService.list();
		int total = (int) new PageInfo<>(cs).getTotal();
		page.setTotal(total);

		model.addAttribute("cs", cs);
		model.addAttribute("page", page);
		return "admin/listCategory";

		// 不使用分页插件的分页查询方式
		// List<Category> cs = categoryService.list(page);
		// int total = categoryService.total();


	}

	// 增加新的分类

	// 参数Category c 接收页面提交的分类名称
	// 参数 session 用于在后续获取当前应用的路径
	// UploadedImageFile 用于接收上传的图片
	/**
	 * @param
	 */
	@RequestMapping("admin_category_add")
	// 下面三行代码验证当前页面是否有将上传的图片自动封装到uploadedImageFile对象中，结果是可以的,注意jsp页面的input标签如果要上传图片的话一定type="file" name="image" ，name如果是其他值的话就会报错
	//public String add(UploadedImageFile uploadedImageFile){
	//	System.out.println(uploadedImageFile.getImage());
	//	return null;
	//}
	public String add(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
	    categoryService.add(c);
	    // 通过session获取ControllerContext,再通过getRealPath定位存放分类图片的路径。 得到的file路径为.....\target\ssm\img\category
	    File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
	    // 根据分类id创建文件名
	    File file = new File(imageFolder, c.getId() + ".jpg");

	    // 如果/img/category目录不存在，则创建该目录，否则后续保存浏览器穿过来的图片，都会提示无法保存
	    if (!file.getParentFile().exists()) {
	        file.getParentFile().mkdirs();
	    }
	    // 通过UploadedImageFile 把浏览器传递过来的图片保存在上述指定的位置
	    // 使用transferTo（dest）方法将上传文件写到服务器上指定的文件。
	    uploadedImageFile.getImage().transferTo(file);
		// 通过ImageUtil.change2jpg(file); 确保图片格式一定是jpg，而不仅仅是后缀名是jpg.
	    BufferedImage img = ImageUtil.change2jpg(file);
	    ImageIO.write(img, "jpg", file);
	    // 客户端跳转到admin_category_list
	    return "redirect:/admin_category_list";
	}



	@RequestMapping("admin_category_delete")
	public String delete(int id, HttpSession session) {
		categoryService.delete(id);

		File imageFolder = new File(session.getServletContext().getRealPath("img/category"));
		File file = new File(imageFolder, id + ".jpg");
		file.delete();

		return "redirect:/admin_category_list";
	}

	// 对应的分类管理界面点击编辑后的界面，该方法用于将从jsp获取到的id找到对应category类取出name和图片放入当前的编辑页面
	@RequestMapping("admin_category_edit")
	public String edit(int id, Model model) {
		Category c = categoryService.get(id);
		model.addAttribute("c", c);
		return "admin/editCategory";
	}

	// 对应分类编辑页面的确认编辑操作，完成数据库内容的插入
	@RequestMapping("admin_category_update")
	public String update(Category c, HttpSession session, UploadedImageFile uploadedImageFile) throws IOException {
		categoryService.update(c);
		MultipartFile image = uploadedImageFile.getImage();
		if(null!=image &&!image.isEmpty()){
			File  imageFolder= new File(session.getServletContext().getRealPath("img/category"));
			File file = new File(imageFolder,c.getId()+".jpg");
			image.transferTo(file);
			BufferedImage img = ImageUtil.change2jpg(file);
			ImageIO.write(img, "jpg", file);
		}
		return "redirect:/admin_category_list";
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

}
