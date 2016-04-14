package controllers;

import model.User;
import model.UserImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Eugen on 23.03.2016.
 */
@Controller
public class AuthController {
    ArrayList<UserImpl> users;

    void createUsers() {
        users = new ArrayList<UserImpl>();
        users.add(new UserImpl("User1","password1","email1"));
        users.add(new UserImpl("User2","password2","email2"));
        users.add(new UserImpl("User3","password3","email3"));
    }

    UserImpl getUserByName(String name) {
        for (UserImpl user : users) {
            if (user.getNameUser().equals(name)) return user;
        }
        return null;
    }

    @RequestMapping(value = "/loginValidation", method = RequestMethod.POST)
    public String loginValidate(UserImpl userAttribute, Model model, HttpServletRequest request)  {
        System.out.println("Login");
        String username = userAttribute.getNameUser();
        String password = userAttribute.getPassword();
        createUsers();
        // A simple authentication manager
        if (username != null && password != null) {
            UserImpl user = getUserByName(username);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    request.getSession().setAttribute("LOGGEDIN_USER", userAttribute);
                    return "redirect:/index";
                }
            }
        }
        request.getSession().setAttribute("error","FAILED_LOGIN");
        return "redirect:/";
    }
    @RequestMapping(value = "/")
    public String showLogin(Model model,UserImpl user){
        model.addAttribute("userAttribute",user);
        return "login";
    }
}
