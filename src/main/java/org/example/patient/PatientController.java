package org.example.patient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.patient.view.PatientEditView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 患者管理相关http请求处理
 */
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/lookup")
    public String lookup() throws JsonProcessingException {
        return objectMapper.writeValueAsString(patientService.toLookupView(patientService.findAll()));
    }
    @RequestMapping("/lookups")
    public String lookups() throws JsonProcessingException {
        return objectMapper.writeValueAsString(patientService.toLookupViews(patientService.findAll()));
    }

    @RequestMapping("/list")
    public String list() throws JsonProcessingException {
        return objectMapper.writeValueAsString(patientService.toListView(patientService.findAll()));
    }

    @RequestMapping("/{id}")
    public String edit(@PathVariable("id") Patient patient) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new PatientEditView(patient));
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") Patient patient) {
        try {
            patientService.delete(patient);
            return "成功";
        } catch (Exception e) {
            return "失败";
        }
    }

    @RequestMapping("/save")
    public String save(Patient patient) {
        try {
            patientService.save(patient);
            return "成功";
        } catch (Exception e) {
            return "失败";
        }
    }

}
