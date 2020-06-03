package org.example.patient;

import org.example.common.STATE;
import org.example.patient.view.PatientEditView;
import org.example.patient.view.PatientListView;
import org.example.patient.view.PatientLookupView;
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


    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient findByIdNumber(String idNumber) {
        return patientRepository.findByIdNumber(idNumber);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient addRecode(Patient patient, Recode recode) {
        patient.addRecode(recode);
        return save(patient);
    }

    public List<PatientListView> toListView(List<Patient> patients) {
        List<PatientListView> listViews = new ArrayList<>();
        patients.forEach(o -> listViews.add(new PatientListView(o)));
        return listViews;
    }

    public List<PatientLookupView> toLookupView(List<Patient> patients) {
        List<PatientLookupView> listViews = new ArrayList<>();
        patients.stream().filter(o->o.getState().equals(STATE.未住院)).forEach(o -> listViews.add(new PatientLookupView(o)));
        return listViews;
    }
    public List<PatientLookupView> toLookupViews(List<Patient> patients) {
        List<PatientLookupView> listViews = new ArrayList<>();
        patients.forEach(o -> listViews.add(new PatientLookupView(o)));
        return listViews;
    }

    public List<PatientEditView> toEditView(List<Patient> patients) {
        List<PatientEditView> listViews = new ArrayList<>();
        patients.forEach(o -> listViews.add(new PatientEditView(o)));
        return listViews;
    }

    public void delete(Patient patient) {
        patientRepository.delete(patient);
    }
}
