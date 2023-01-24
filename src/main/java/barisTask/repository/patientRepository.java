package barisTask.repository;

import barisTask.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientRepository extends JpaRepository<Patient, String> {

    public Patient savePatient(Patient item);

    public Patient findPatientId(String item);

    public Patient addPatient(Patient item);

    public void deletePatient(Patient item);

}
