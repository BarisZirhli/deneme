package barisTask.service;

import barisTask.DTO.PatientDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import barisTask.model.Patient;
import org.apache.jackrabbit.uuid.UUID;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import barisTask.repository.PatientRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@NoArgsConstructor
public class PatientServiceImp implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Patient findPatientId(String x) {
        Optional<Patient> p = patientRepository.findById(x);
        Patient patient = p.get();
        return patient;
    }

    @Override
    public void savePatient(PatientDTO x) {
        
        Patient patient = new Patient(x.getName(), x.getEmail(), x.getPassword());
        patient.setId(UUID.randomUUID().toString());
        patient.setPassword(passwordEncoder.encode(x.getPassword()));
        patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Patient x) {
        patientRepository.delete(x);
    }

}
