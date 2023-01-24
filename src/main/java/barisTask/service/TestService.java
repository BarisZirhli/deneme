package barisTask.service;

import barisTask.repository.patientRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import barisTask.model.Patient;
import org.apache.jackrabbit.uuid.UUID;

@Service
@NoArgsConstructor
public class TestService {

    private patientRepository patient;

    public TestService(patientRepository patient) {
        this.patient = patient;
    }

    private Patient findPatientId(String x) throws Exception {
        return patient.findById(x).orElseThrow(() -> {
            return new Exception("not found patient" + x);

        });
    }

    private Patient savePatient(Patient x) {

        x.setId(UUID.randomUUID().toString());
        return patient.save(x);
    }
}
