package org.example.doctor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/list")
    String reg() throws JsonProcessingException {
        return objectMapper.writeValueAsString(doctorRepository.findAll());
    }


}
