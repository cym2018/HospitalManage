package org.example.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public boolean Login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        return doctorRepository.existsByUsernameAndPassword(username, password);
    }

    public boolean Init() {
        return doctorRepository.findAll().size() == 0;
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
