package org.example.bed;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.section.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * @return json
     * @throws JsonProcessingException json转换异常
     * @description 获取病床表的列表视图
     */
    @RequestMapping("/list")
    public String doctorList() throws JsonProcessingException {
        return objectMapper.writeValueAsString(bedService.findAllListView());
    }

    /**
     * @param bed 床位id
     * @return 实体
     * @throws JsonProcessingException json转换异常
     * @description 根据id查找床位信息
     */
    @RequestMapping("/edit/{id}")
    public String findById(@PathVariable("id") Bed bed) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new BedEditView(bed));
    }

    @RequestMapping("/edit/save")
    public String editSave(Integer id, Integer sectionId, String no, Integer state, String note) {
        try {
            Bed bed = bedService.getOrCreate(id);
            bed.setNo(no);
            bed.setSection(sectionService.findById(sectionId));
            bed.setNote(note);
            if (bed.getState() != 1)
                bed.setState(state);
            bedService.save(bed);
            return "保存成功";
        } catch (Exception e) {
            return "保存失败";
        }
    }

    @RequestMapping("/remove/{id}")
    public String remove(@PathVariable("id") Bed bed) {
        try {
            if (bed.getState() == 1) {
                return "在使用的床位不允许删除";
            }
            bedService.remove(bed);
            return "删除成功";
        } catch (Exception e) {
            return "删除失败";
        }

    }
}
