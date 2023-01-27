package barisTask.service;

import barisTask.DTO.PatientDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import barisTask.model.Patient;
import org.apache.jackrabbit.uuid.UUID;
import barisTask.repository.PatientRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@NoArgsConstructor
public class PatientServiceImp {

    @Autowired
    private PatientRepository PatientRepository;
    private PatientDTO PatientDTO;

    public Patient findPatientId(String x) {
        Optional<Patient> p = PatientRepository.findById(x);
        Patient patient = p.get();
        return patient;
    }

    public Patient savePatient(Patient x) {

        x.setId(UUID.randomUUID().toString());
        return PatientRepository.save(x);
    }

    public void deletePatient(Patient x) {
        PatientRepository.delete(x);
    }

    public PatientDTO convertPatientDTO(Patient p) {

        PatientDTO.setName(p.getName());
        PatientDTO.setPassword(p.getPassword());
        PatientDTO.setEmail(p.getEmail());
        PatientRepository.save(p);
        return new PatientDTO();
    }

}
