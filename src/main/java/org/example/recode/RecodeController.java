package org.example.recode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.bed.Bed;
import org.example.bed.BedService;
import org.example.common.BEDSTATE;
import org.example.common.PATIENTSTATE;
import org.example.common.RECODESTATE;
import org.example.patient.Patient;
import org.example.patient.PatientService;
import org.example.recode.view.RecodeEditView;
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
    @Autowired
    PatientService patientService;
    @Autowired
    BedService bedService;

    @RequestMapping("/list")
    String recodeList() throws JsonProcessingException {
        return objectMapper.writeValueAsString(recodeService.toListView(recodeService.findAll()));
    }

    @RequestMapping("/p/list")
    String pRecodeList(String idNumber) throws JsonProcessingException {
        Patient patient = patientService.findByIdNumber(idNumber);
        return objectMapper.writeValueAsString(recodeService.toListView(recodeService.pFindAll(patient)));
    }

    @RequestMapping("/acc/{id}")
    String acc(@PathVariable("id") Recode recode) throws Exception {
        recode.getBed().setState(BEDSTATE.占用);
        bedService.save(recode.getBed());
        recode.setState(RECODESTATE.有效);
        recodeService.save(recode);
        recode.getPatient().setState(PATIENTSTATE.住院);
        patientService.save(recode.getPatient());
        return "成功";
    }

    @RequestMapping("/save")
    public String save(Recode recode, @RequestParam("bedNo") Bed bed, @RequestParam("patient") Patient patient) {
        try {
            recode.setBed(bed);
            recode.setPatient(patient);
            if (recode.getState() == null)
                recode.setState(RECODESTATE.有效);
            recodeService.save(recode);
            if (recode.getState().equals(RECODESTATE.预约))
                bed.setState(BEDSTATE.预约);
            if (recode.getState().equals(RECODESTATE.有效))
                bed.setState(BEDSTATE.占用);
            bedService.save(bed);
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
