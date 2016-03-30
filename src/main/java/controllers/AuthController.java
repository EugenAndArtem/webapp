package controllers;

import model.User;
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
    ArrayList<User> users;

    void createUsers() {
        users = new ArrayList<User>();
        users.add(new User("User1", "password1"));
        users.add(new User("User2", "password2"));
        users.add(new User("User3", "password3"));
    }

    User getUserByName(String name) {
        for (User user : users) {
            if (user.getUsername().equals(name)) return user;
        }
        return null;
    }

    @RequestMapping(value = "/loginValidation", method = RequestMethod.POST)
    public String loginValidate(User userAttribute, Model model, HttpServletRequest request)  {
        System.out.println("Login");
        String username = userAttribute.getUsername();
        String password = userAttribute.getPassword();
        createUsers();
        // A simple authentication manager
        if (username != null && password != null) {
            User user = getUserByName(username);
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
    public String showLogin(Model model,User user){
        model.addAttribute("userAttribute",user);
        return "login";
    }
}
