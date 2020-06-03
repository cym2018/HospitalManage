package org.example.recode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.bed.Bed;
import org.example.patient.Patient;
import org.example.recode.view.RecodeEditView;
import org.example.section.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recode")
public class RecodeController {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    RecodeService recodeService;

    @RequestMapping("/list")
    String recodeList() throws JsonProcessingException {
        return objectMapper.writeValueAsString(recodeService.toListView(recodeService.findAll()));
    }

    @RequestMapping("/save")
    public String save(Recode recode, @RequestParam("bedNo")Bed bed, @RequestParam("patient")Patient patient) {
        try {
            System.out.println(recode.getState());
            recode.setBed(bed);
            recode.setPatient(patient);
            recodeService.save(recode);
            return "保存成功";
        } catch (Exception e) {
            return "保存失败";
        }
    }

    @RequestMapping("/{id}")
    public String edit(@PathVariable("id") Recode recode) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new RecodeEditView(recode));
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") Recode recode) {
        try {
            recodeService.delete(recode);
            return "成功";
        } catch (Exception e) {
            return "失败";
        }
    }

    @RequestMapping("/lookup")
    public String lookup() throws JsonProcessingException {
        return objectMapper.writeValueAsString(recodeService.toLookupView(recodeService.findAll()));
    }
    @RequestMapping("/lookups")
    public String lookups() throws JsonProcessingException {
        return objectMapper.writeValueAsString(recodeService.toLookupView(recodeService.findAll()));
    }

}
