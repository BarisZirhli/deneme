package barisTask.repository;

import barisTask.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface patientRepository extends JpaRepository<Patient, String> {

    public Patient PatientSave(Patient item);

    public Patient findUserId(String item);

    public Patient PatientAdd(Patient item);

    public void PatientDelete(Patient item);

}
