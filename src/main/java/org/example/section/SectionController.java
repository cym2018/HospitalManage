package org.example.section;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.section.view.SectionEditView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String list() throws JsonProcessingException {
        return objectMapper.writeValueAsString(sectionService.toListView(sectionService.findAll()));
    }

    @RequestMapping("/lookup")
    public String lookup() throws JsonProcessingException {
        return objectMapper.writeValueAsString(sectionService.toLookupView(sectionService.findAll()));
    }

    @RequestMapping("/lookups")
    public String lookups() throws JsonProcessingException {
        return objectMapper.writeValueAsString(sectionService.toLookupView(sectionService.findAll()));
    }

    @RequestMapping("/save")
    public String save(Section section) {
        try {
            sectionService.save(section);
            return "成功";
        } catch (Exception e) {
            return "失败";
        }
    }

    @RequestMapping("/{id}")
    public String edit(@PathVariable("id") Section section) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new SectionEditView(section));
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") Section section) {
        try {
            sectionService.delete(section);
            return "成功";
        } catch (Exception e) {
            return "失败";
        }
    }
}
