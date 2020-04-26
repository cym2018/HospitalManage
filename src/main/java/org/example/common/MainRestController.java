package org.example.common;

import org.example.doctor.Doctor;
import org.example.doctor.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class MainRestController {
    @Autowired
    DoctorService doctorService;

    @RequestMapping("/init")
    public String init() {
        if (doctorService.Init()) {
            Doctor doctor = new Doctor();
            doctor.setUsername("admin");
            doctor.setPassword("admin");
            doctorService.save(doctor);
            return "初始化成功:用户名:admin,密码:admin";
        }
        return "";
    }

    @RequestMapping("/login")
    public boolean setCookie(HttpServletResponse response, String username, String password) {
        if (doctorService.Login(username, password)) {
            response.addCookie(new Cookie("username", username));
            response.addCookie(new Cookie("password", password));
            return true;
        }
        return false;
    }

    @RequestMapping("/logout")
    public boolean login(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie i : cookies) {
            i.setMaxAge(0);
            response.addCookie(i);
        }
        return true;
    }
}
