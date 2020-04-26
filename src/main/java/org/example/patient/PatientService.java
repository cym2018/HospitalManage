package org.example.patient;

import org.example.recode.Recode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient findByIdNumber(String idNumber) {
        return patientRepository.findByIdNumber(idNumber);
    }

    public List<PatientListView> findAllListView() {
        List<PatientListView> patientList = new ArrayList<>();
        patientRepository.findAll().forEach(o -> patientList.add(new PatientListView(o)));
        return patientList;
    }
    public Patient addRecode(Patient patient,Recode recode){
        patient.addRecode(recode);
        return save(patient);
    }
}
