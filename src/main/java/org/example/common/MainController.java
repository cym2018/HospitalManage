package org.example.common;

import org.example.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpSession session;

    @RequestMapping("/")
    public String autoLogin(
            @Nullable @CookieValue("username") String cUsername,
            @Nullable @CookieValue("password") String cPassword,
            @Nullable @SessionAttribute("username") String sUsername
    ) {
        if (sUsername != null || doctorService.Login(cUsername, cPassword)) {
            // session 或 cookie存在,已登陆
            if (sUsername == null) {
                session.setAttribute("username", cUsername);
            }
            return "main";

        }
        return "login";
    }
}
