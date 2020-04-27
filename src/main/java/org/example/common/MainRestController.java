package org.example.common;

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
    @Autowired
    HttpServletRequest request;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    HttpServletResponse response;

    /**
     * @param username 用户名
     * @param password 密码
     * @return 登陆成功或失败
     * @description 登录功能, 验证登陆成功后, 为用户返回cookie和登陆状态
     */
    @RequestMapping("/login")
    public String login(String username, String password) {
        if (doctorService.Login(username, password)) {
            request.getSession().setAttribute("username", username);
            response.addCookie(new Cookie("username", username));
            response.addCookie(new Cookie("password", password));
            return "登陆成功";
        }
        return "用户名或密码错误";
    }

    /**
     * @return 注销成功
     * @description 删除登陆信息:Cookie和Session
     */
    @RequestMapping("/logout")
    public boolean logout() {
        Cookie[] cookies = request.getCookies();
        for (Cookie i : cookies) {
            i.setMaxAge(0);
            response.addCookie(i);
        }
        request.getSession().invalidate();
        return true;
    }

}
