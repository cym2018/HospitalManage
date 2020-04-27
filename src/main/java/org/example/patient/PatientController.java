package org.example.patient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 患者管理相关http请求处理
 */
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @return json
     * @throws JsonProcessingException json转换异常
     * @description 获取患者表的列表视图
     */
    @RequestMapping("/list")
    public String patientList() throws JsonProcessingException {
        return objectMapper.writeValueAsString(patientService.findAllListView());

    }
}
