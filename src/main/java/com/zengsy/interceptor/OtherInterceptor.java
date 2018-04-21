package com.zengsy.interceptor;

import com.zengsy.pojo.Category;
import com.zengsy.pojo.OrderItem;
import com.zengsy.pojo.User;
import com.zengsy.service.CategoryService;
import com.zengsy.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 在session中存入所有页面都需要的参数，contextPath和List<Category>
 * Created by zengsy on 2018-03-06.
 */
public class OtherInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderItemService orderItemService;

    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler) throws Exception {
        return true;

    }

    /**
     * 在业务处理器处理请求执行完成后，生成视图之前执行的动作
     * @param request
     * @param response
     * @param handler
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //这里获取分类集合信息，用于放在搜索栏下方
        List<Category> cs  = categoryService.list();
        request.getSession().setAttribute("cs", cs);

        //这里是获取当前的contextPath:photo_ssm,用于让链接跳转到首页
        HttpSession session = request.getSession();
        String ContextPath = session.getServletContext().getContextPath();
        request.getSession().setAttribute("ContextPath",ContextPath);

        //这里是获取购物车中套餐数量
        User user = (User) session.getAttribute("user");
        int cartTotalItemNumber = 0;
        if (null != user) {
            List<OrderItem> ois = orderItemService.listByUser(user.getId());
            for (OrderItem oi : ois) {
                cartTotalItemNumber += oi.getNumber();
            }
        }
        request.getSession().setAttribute("cartTotalItemNumber", cartTotalItemNumber);
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
