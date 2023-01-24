package barisTask.repository;

import barisTask.model.Patient;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, String> {

    public Patient savePatient(Patient item);

    public Optional<Patient> findPatientId(String item);

    public void deletePatient(Patient item);

}
