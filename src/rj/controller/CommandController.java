package rj.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import rj.vo.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 从页面接收参数，封装javabean的user对象
 * Created by 隽 on 2016/12/15.
 */
public class CommandController extends AbstractCommandController{
    //指定把参数封装到哪个对象
    public CommandController(){
        //封装了命令对象
        this.setCommandClass(User.class);
    }
    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object o, BindException e) throws Exception {
        //值被封装到命令对象
        User user= (User) o;
        ModelAndView mv=new ModelAndView();
        //设置model对象，可以是任意的pojo
        mv.addObject("user",user);
        mv.setViewName("index");
        return mv;
    }


    @Override
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {

        String str = request.getParameter("birthday");

        if(str.contains("/")){

            binder.registerCustomEditor(Date.class,
                    new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true));
        }else{

            binder.registerCustomEditor(Date.class,
                    new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));

        }


    }
}
