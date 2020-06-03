package org.example.doctor;

import org.example.doctor.view.DoctorEditView;
import org.example.doctor.view.DoctorListView;
import org.example.doctor.view.DoctorLookupView;
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

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public boolean Login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        return doctorRepository.existsByUsernameAndPassword(username, password);
    }

    public boolean isEmpty() {
        return doctorRepository.findAll().size() == 0;
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<DoctorListView> toListView(List<Doctor> doctors) {
        List<DoctorListView> doctorList = new ArrayList<>();
        doctors.forEach(o -> doctorList.add(new DoctorListView(o)));
        return doctorList;
    }

    public List<DoctorLookupView> toLookupView(List<Doctor> doctors) {
        List<DoctorLookupView> doctorList = new ArrayList<>();
        doctors.forEach(o -> doctorList.add(new DoctorLookupView(o)));
        return doctorList;
    }

    public List<DoctorEditView> toEditView(List<Doctor> doctors) {
        List<DoctorEditView> doctorList = new ArrayList<>();
        doctors.forEach(o -> doctorList.add(new DoctorEditView(o)));
        return doctorList;
    }

    public void delete(Doctor doctor) {
        doctorRepository.delete(doctor);
    }
}
