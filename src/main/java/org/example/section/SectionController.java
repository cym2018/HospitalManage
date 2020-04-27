package org.example.section;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/section")
public class SectionController {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    SectionService sectionService;

    @RequestMapping("/list")
    public String sectionList() throws JsonProcessingException {
        return objectMapper.writeValueAsString(sectionService.findAllListView());
    }

    @RequestMapping("/sectionSelect")
    public String sectionSelect() throws JsonProcessingException {
        return objectMapper.writeValueAsString(sectionService.findAllKeyValueView());
    }
}
