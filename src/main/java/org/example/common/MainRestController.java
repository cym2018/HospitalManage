package org.example.common;

import org.example.doctor.DoctorService;
import org.example.patient.Patient;
import org.example.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class MainRestController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    HttpServletRequest request;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    HttpServletResponse response;
    @Autowired
    PatientService patientService;

    /**
     * @param username 用户名
     * @param password 密码
     * @return 登陆成功或失败
     * @description 登录功能, 验证登陆成功后, 为用户返回cookie和登陆状态
     */
    @RequestMapping("/login")
    public String login(String username, String password) {
        logout();
        if (doctorService.Login(username, password)) {
            request.getSession().setAttribute("username", username);
            response.addCookie(new Cookie("username", username));
            response.addCookie(new Cookie("password", password));
            return "登陆成功";
        }
        return "用户名或密码错误";
    }

    @RequestMapping("/plogin")
    public String plogin(String name, String idNumber) {
        logout();
        if (patientService.Login(name, idNumber)) {
            request.getSession().setAttribute("name", name);
            response.addCookie(new Cookie("name", name));
            response.addCookie(new Cookie("idNumber", idNumber));
            return "登陆成功";
        }
        return "姓名与身份证号不匹配";
    }

    /**
     * @description 删除登陆信息:Cookie和Session
     */
    @RequestMapping("/logout")
    public String logout() {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie i : cookies) {
                i.setMaxAge(0);
                response.addCookie(i);
            }
        HttpSession session = request.getSession();
        if (session != null)
            session.invalidate();
        return "注销成功";
    }

    @RequestMapping("/psave")
    public String psave(Patient patient) {
        if (patient.getName() == null || patient.getIdNumber() == null) {
            return "姓名或身份证号不得为空";
        }
        if (patientService.findByIdNumber(patient.idNumber) != null) {
            return "用户已存在";
        }
        patientService.save(patient);
        return "注册成功";
    }
}
