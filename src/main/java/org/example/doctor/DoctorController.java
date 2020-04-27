package org.example.doctor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 医生管理相关http请求处理
 */
@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @return json
     * @throws JsonProcessingException json转换异常
     * @description 获取医生表的列表视图
     */
    @RequestMapping("/list")
    String doctorList() throws JsonProcessingException {
        return objectMapper.writeValueAsString(doctorService.findAllListView());
    }


}
