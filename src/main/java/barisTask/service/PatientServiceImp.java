package barisTask.service;

import barisTask.DTO.PatientDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import barisTask.model.Patient;
import org.apache.jackrabbit.uuid.UUID;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import barisTask.repository.PatientRepository;

@Service
@NoArgsConstructor
public class PatientServiceImp implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient findPatientId(String x) {
        Optional<Patient> p = patientRepository.findById(x);
        Patient patient = p.get();
        return patient;
    }

    public Patient convertPatientDTO(PatientDTO p) {
        return new Patient(p.getName(), p.getEmail(), p.getPassword());
    }

    @Override
    public void savePatient(PatientDTO x) {

        Patient patient = convertPatientDTO(x);
        patient.setId(UUID.randomUUID().toString());
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Patient x) {
        patientRepository.delete(x);
    }

}
