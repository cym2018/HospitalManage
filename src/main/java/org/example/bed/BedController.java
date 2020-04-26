package org.example.bed;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bed")
public class BedController {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    BedService bedService;
    @RequestMapping("/list")
    String doctorList() throws JsonProcessingException {
        return objectMapper.writeValueAsString(bedService.findAllListView());
    }
}
