package barisTask.service;

import barisTask.DTO.PatientDTO;
import barisTask.model.Patient;

public interface PatientService {

    public PatientDTO savePatient(Patient item);

    public Patient findPatientId(String item);

    public void deletePatient(Patient item);



}
