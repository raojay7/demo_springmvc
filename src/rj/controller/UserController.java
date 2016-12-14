package rj.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 隽 on 2016/12/14.
 */
public class UserController implements Controller{
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //接收请求，接收参数，验证参数，处理请求
        // 封装参数，调用业务方法
        //返回处理结果
        ModelAndView mv=new ModelAndView();
        //给模型视图设置数据
        mv.addObject("hello","这是springmvc");
        //设置物理视图相对路径的（不用解析）
        //mv.setViewName("/WEB-INF/jsp/index.jsp");
        //配置逻辑视图
        mv.setViewName("index");
        return mv;
    }
}
