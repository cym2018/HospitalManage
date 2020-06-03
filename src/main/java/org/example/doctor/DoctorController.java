package org.example.doctor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.doctor.view.DoctorEditView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 医生管理相关http请求处理
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/list")
    public String list() throws JsonProcessingException {
        return objectMapper.writeValueAsString(doctorService.toListView(doctorService.findAll()));
    }

    @RequestMapping("/lookup")
    public String lookup() throws JsonProcessingException {
        return objectMapper.writeValueAsString(doctorService.toLookupView(doctorService.findAll()));
    }

    @RequestMapping("/lookups")
    public String lookups() throws JsonProcessingException {
        return objectMapper.writeValueAsString(doctorService.toLookupView(doctorService.findAll()));
    }

    @RequestMapping("/{id}")
    public String edit(@PathVariable("id") Doctor doctor) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new DoctorEditView(doctor));
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") Doctor doctor) throws JsonProcessingException {
        try {
            doctorService.delete(doctor);
            return "成功";
        } catch (Exception e) {
            return "失败";
        }
    }

    @RequestMapping("/save")
    public String save(Doctor doctor) {
        try {
            doctorService.save(doctor);
            return "成功";
        } catch (Exception e) {
            return "失败";
        }
    }

}
