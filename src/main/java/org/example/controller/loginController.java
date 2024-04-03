package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

/**
 * @Project: SpringDemo
 * @Package: org.example.controller
 * @author: maZhuo
 * @Email:17320080198@163.com
 * @date: 2024年04月03日 9:45
 */

@Controller
public class loginController {
    @GetMapping("/toLoginPage")
    public  String toLoginPage(Model model){
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        return "login";
    }
}
