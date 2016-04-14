package controllers;

import model.User;

import model.UserImpl;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by Eugen on 22.03.2016.
 */
public class AuthentificationInterceptor extends HandlerInterceptorAdapter {
    ArrayList<UserImpl> users;
    void createUsers(){
        users=new ArrayList<UserImpl>();
        users.add(new UserImpl("User1","password1","email1"));
        users.add(new UserImpl("User2","password2","email1"));
        users.add(new UserImpl("User3","password3","email1"));
    }
    User getUserByName(String name){
        for(UserImpl user:users){
            if(user.getNameUser().equals(name))return user;
        }
        return null;
    }
        @Override
        public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception
        {
            System.out.println("Interceptor");
            System.out.println(request.getRequestURI());
            String uri = request.getRequestURI();

            if(!uri.endsWith("/") && !uri.endsWith("/loginValidation"))
            {
                UserImpl userData = (UserImpl) request.getSession().getAttribute("LOGGEDIN_USER");
                if(userData == null)
                {
                    response.sendRedirect("/");
                    return false;
                }
            }
            System.out.println("Ok");
            return true;
        }



}
