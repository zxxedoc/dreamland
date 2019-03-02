package com.zxx.dreamland.interceptor;
import com.zxx.dreamland.controller.BaseController;
import com.zxx.dreamland.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.zxx.dreamland.common.PageHelper;
import com.zxx.dreamland.dao.UserContentMapper;
import com.zxx.dreamland.entity.UserContent;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.*;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public class IndexJspFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("===========自定义过滤器==========");
        ServletContext context = request.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        UserContentMapper userContentMapper = ctx.getBean(UserContentMapper.class);
        PageHelper.startPage(null, null);//开始分页
        List<UserContent> list = userContentMapper.findByJoin(null);
        PageHelper.Page endPage = PageHelper.endPage();//分页结束
        request.setAttribute("page", endPage );
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
