package org.example.bed;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.bed.view.BedEditView;
import org.example.common.STATE;
import org.example.section.Section;
import org.example.section.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @description 病床管理相关http请求处理
 */
@RestController
@RequestMapping("/bed")
public class BedController {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    BedService bedService;
    @Autowired
    private SectionService sectionService;

    @RequestMapping("/list")
    public String doctorList() throws JsonProcessingException {
        return objectMapper.writeValueAsString(bedService.toListView(bedService.findAll()));
    }

    @RequestMapping("/lookup")
    public String lookup() throws JsonProcessingException {
        return objectMapper.writeValueAsString(bedService.toLookupView(bedService.findAll()));
    }
    @RequestMapping("/lookups")
    public String lookups() throws JsonProcessingException {
        return objectMapper.writeValueAsString(bedService.toLookupViews(bedService.findAll()));
    }

    @RequestMapping("/{id}")
    public String findById(@PathVariable("id") Bed bed) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new BedEditView(bed));
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") Bed bed) {
        if (bed.getState() == STATE.占用) {
            return "在使用的床位不允许删除";
        }
        try {
            bedService.remove(bed);
            return "删除成功";
        } catch (Exception e) {
            return "删除失败";
        }

    }

    @RequestMapping("/save")
    public String editSave(Bed bed, @RequestParam("sectionId") Section section) {
        try {
            bed.setSection(section);
            bedService.save(bed);
            return "保存成功";
        } catch (Exception e) {
            return "保存失败";
        }
    }


}
