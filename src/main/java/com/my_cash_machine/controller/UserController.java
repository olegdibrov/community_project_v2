package com.my_cash_machine.controller;

import com.my_cash_machine.domen.News;
import com.my_cash_machine.domen.User;
import com.my_cash_machine.service.NewsService;
import com.my_cash_machine.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.my_cash_machine.utils.PassEncoding;
import com.my_cash_machine.utils.Roles;

import java.util.Collection;
import java.util.List;


@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    NewsService newsService;


    @RequestMapping({"/", "/login" })
    public String root(Model model) {
       // model.addAttribute("reqUser", new User());
        logger.info("root");
        return "login";
    }


    @RequestMapping("/home")
    public String home(Model model) {
//        List<Product> products = productService.getAllProducts();
//        model.addAttribute("products", products);
        Collection<News> news = newsService.findAll();
        model.addAttribute("news", news);
        logger.info("home");
        return "home";
    }

    @RequestMapping("/admin")
    public String helloAdmin() {
        logger.info("admin");
        return "admin";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("reqUser", new User());
        logger.info("register");
        return "register";
    }

    //ToDO Add optional!!!!!!!!!!!!!!!!!!!1
    @RequestMapping(value = {"/user/register"}, method = RequestMethod.POST)
    public String register(@ModelAttribute("reqUser") User reqUser,
                           final RedirectAttributes redirectAttributes) {

        logger.info("/user/register");
        User user = userService.findByEmail(reqUser.getEmail());
        if (user != null) {
            redirectAttributes.addFlashAttribute("saveUser", "exist-name");
            return "redirect:/register";
        }


        user = userService.findByEmail(reqUser.getEmail());

        if (user != null) {
            redirectAttributes.addFlashAttribute("saveUser", "exist-email");
            return "redirect:/register";
        }

        reqUser.setPassword(PassEncoding.getInstance().passwordEncoder.encode(reqUser.getPassword()));
        reqUser.setRole(2);

        if (userService.save(reqUser) != null) {
            redirectAttributes.addFlashAttribute("saveUser", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveUser", "fail");
        }

        return "redirect:/register";
    }


}
