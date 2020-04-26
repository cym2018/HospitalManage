package org.example.recode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return objectMapper.writeValueAsString(recodeService.recodeList());
    }

}
