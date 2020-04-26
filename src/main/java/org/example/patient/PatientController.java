package org.example.patient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/list")
    public String patientList() throws JsonProcessingException {
        return objectMapper.writeValueAsString(patientService.findAllListView());

    }
}
