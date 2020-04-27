package org.example.patient;

import org.example.recode.Recode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 患者管理相关业务逻辑
 */
@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    /**
     * @param patient 实体
     * @return 更新后的状态
     * @description 保存给定实体
     */
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    /**
     * @param idNumber 身份证号
     * @return 实体
     * @description 根据身份证号查询实体
     */
    public Patient findByIdNumber(String idNumber) {
        return patientRepository.findByIdNumber(idNumber);
    }

    /**
     * @return 所有列表视图
     * @description 查询全部记录, 并转换为列表视图
     */
    public List<PatientListView> findAllListView() {
        List<PatientListView> patientList = new ArrayList<>();
        patientRepository.findAll().forEach(o -> patientList.add(new PatientListView(o)));
        return patientList;
    }

    /**
     * @param patient 患者实体
     * @param recode  记录实体
     * @return 更新后的患者信息
     * @description 为患者添加就医记录
     */
    public Patient addRecode(Patient patient, Recode recode) {
        patient.addRecode(recode);
        return save(patient);
    }
}
