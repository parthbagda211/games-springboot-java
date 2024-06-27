package com.example.springapi.service;


import com.example.springapi.model.Patient;
import com.example.springapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Optional<Patient> getPatientById(int id){
        return patientRepository.findById(id);
    }

    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
    }

    public void deletePatient(int id){
        patientRepository.deleteById(id);
    }
}