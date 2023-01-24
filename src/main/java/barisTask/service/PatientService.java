package barisTask.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import barisTask.model.Patient;
import org.apache.jackrabbit.uuid.UUID;
import barisTask.repository.PatientRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@NoArgsConstructor
public class PatientService {

    private PatientRepository patient;

    public PatientService(PatientRepository patient) {
        this.patient = patient;
    }

    public Optional<Patient> findPatientId(String x) {
        return patient.findById(x);
    }

    public Patient savePatient(Patient x) {

        x.setId(UUID.randomUUID().toString());
        return patient.save(x);
    }

    public void deletePatient(Patient x) {
        patient.delete(x);
    }

}
