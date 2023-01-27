package barisTask.service;

import barisTask.model.Patient;
import java.util.Optional;

public interface PatientService {

    public Patient savePatient(Patient item);

    public Optional<Patient> findPatientId(String item);

    public void deletePatient(Patient item);



}
