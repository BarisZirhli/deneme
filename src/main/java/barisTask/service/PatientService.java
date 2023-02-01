package barisTask.service;

import barisTask.DTO.PatientDTO;
import barisTask.model.Patient;

public interface PatientService {

    public void savePatient(PatientDTO item);

    public Patient findPatientId(String item);

    public void deletePatient(Patient item);



}
