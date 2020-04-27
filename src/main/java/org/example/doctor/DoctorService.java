package org.example.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 医生管理相关业务逻辑
 */
@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    /**
     * @param username 用户名
     * @param password 密码
     * @return 登陆成功/失败
     * @description 登陆逻辑, 非空检查
     */
    public boolean Login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        return doctorRepository.existsByUsernameAndPassword(username, password);
    }

    /**
     * @return 数据库是否存在记录
     * @description 检测数据库是否存在记录, 以确定是否可以执行初始化操作
     */
    public boolean isEmpty() {
        return doctorRepository.findAll().size() == 0;
    }

    /**
     * @param doctor 实体
     * @return 更新后的状态
     * @description 保存给定实体
     */
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    /**
     * @return 所有列表视图
     * @description 查询全部记录, 并转换为列表视图
     */
    public List<DoctorListView> findAllListView() {
        List<DoctorListView> doctorList = new ArrayList<>();
        doctorRepository.findAll().forEach(o -> doctorList.add(new DoctorListView(o)));
        return doctorList;
    }
}
