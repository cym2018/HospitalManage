package org.example.common;


import org.example.bed.Bed;
import org.example.bed.BedService;
import org.example.doctor.Doctor;
import org.example.doctor.DoctorService;
import org.example.patient.Patient;
import org.example.patient.PatientService;
import org.example.recode.Recode;
import org.example.recode.RecodeService;
import org.example.section.Section;
import org.example.section.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 病床状态:0-空闲 1-占用 2-停用
 * 患者状态:0-出院 1-在住
 * 记录状态:0-有效 1-完成 2-撤销
 */
@SuppressWarnings("SpringMVCViewInspection")
@Controller
public class MainController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpSession session;
    @Autowired
    private PatientService patientService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private BedService bedService;
    @Autowired
    private RecodeService recodeService;

    /**
     * @param cUsername cookie中的用户名
     * @param cPassword cookie中的密码
     * @param sUsername session中的登录信息
     * @return 视图
     * @description 从Cookie和Session中获取并验证登录信息
     */
    @RequestMapping("/")
    public String autoLogin(
            @Nullable @CookieValue("username") String cUsername,
            @Nullable @CookieValue("password") String cPassword,
            @Nullable @SessionAttribute("username") String sUsername,
            @Nullable @CookieValue("name") String cName,
            @Nullable @CookieValue("idNumber") String cIdNumber,
            @Nullable @SessionAttribute("name") String sName
    ) {
        if (sUsername != null || doctorService.Login(cUsername, cPassword)) {
            // session 或 cookie存在,已登陆
            if (sUsername == null) {
                session.setAttribute("username", cUsername);
            }
            return "main";
        }
        if(sName != null || patientService.Login(cName, cIdNumber)){
            return "pmain";
        }
        return "login";
    }

    /**
     * @return debug页面
     * @description 初始化数据, 为每个表生成两条模拟数据
     */
    @RequestMapping("/debug")
    public String debug() throws Exception {
        if (doctorService.isEmpty()) {
            Section section = new Section();
            section.setLocation("1楼西区");
            section.setSectionName("神经内科");
            section.setNote("双休");
            sectionService.save(section);
            section = new Section();
            section.setLocation("1楼东区");
            section.setSectionName("儿科");
            section.setNote("7*24值班");
            sectionService.save(section);

            Doctor doctor = new Doctor();
            doctor.setUsername("admin");
            doctor.setPassword("admin");
            doctor.setName("张三");
            doctor.setGender("男");
            doctor.setAge(30);
            doctor.setIdNumber("370126199804260435");
            doctor.setSection(sectionService.findById(1));
            doctorService.save(doctor);
            doctor = new Doctor();
            doctor.setUsername("root");
            doctor.setPassword("root");
            doctor.setName("李四");
            doctor.setGender("女");
            doctor.setAge(27);
            doctor.setIdNumber("370126199804260415");
            doctor.setSection(sectionService.findById(1));
            doctorService.save(doctor);

            Bed bed = new Bed();
            bed.setNo("01001");
            bed.setSection(sectionService.findById(1));
            bed.setNote("200/天");
            bedService.save(bed);
            bed = new Bed();
            bed.setNo("02001");
            bed.setSection(sectionService.findById(2));
            bed.setNote("150/天");
            bedService.save(bed);

            Patient patient = new Patient();
            patient.setAge(30);
            patient.setGender("男");
            patient.setIdNumber("370126199804260416");
            patient.setName("王二");
            patient.setNote("神经病");
            patientService.save(patient);
            patient = new Patient();
            patient.setAge(22);
            patient.setGender("女");
            patient.setIdNumber("370126199804260417");
            patient.setName("麻子");
            patient.setNote("偏头痛");

            patientService.save(patient);

            Recode recode = new Recode();
            bed = bedService.findByNo("01001");
            patient = patientService.findByIdNumber("370126199804260416");

            recode.setNote("家属陪床");
            recode.setBed(bed);
            recode.setPatient(patient);
            recode.setState(RECODESTATE.有效);
            recode = recodeService.save(recode);
            bed.addRecode(recode);
            patient.addRecode(recode);
            bed.setState(BEDSTATE.占用);
            patient.setState(PATIENTSTATE.住院);
            bedService.save(bed);
            patientService.save(patient);


            recode = new Recode();
            bed = bedService.findByNo("02001");
            patient = patientService.findByIdNumber("370126199804260417");
            patient.setState(PATIENTSTATE.住院);
            recode.setNote("病情稳定");
            recode.setBed(bed);
            recode.setPatient(patient);
            recode.setState(RECODESTATE.有效);
            recode = recodeService.save(recode);
            bed.addRecode(recode);
            patient.addRecode(recode);
            bed.setState(BEDSTATE.占用);
            bedService.save(bed);
            patientService.save(patient);
        }
        return "debug";
    }
}
