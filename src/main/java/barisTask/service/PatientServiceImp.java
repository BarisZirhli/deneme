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
public class PatientServiceImp implements PatientService {

    private PatientRepository PatientRepository;
    private PatientDTO PatientDTO;

    @Override
    public Patient findPatientId(String x) {
        Optional<Patient> p = PatientRepository.findById(x);
        Patient patient = p.get();
        return patient;
    }

    @Override
    public Patient savePatient(Patient x) {

        x.setId(UUID.randomUUID().toString());
        return PatientRepository.save(x);
    }

    @Override
    public void deletePatient(Patient x) {
        PatientRepository.delete(x);
    }

    public PatientDTO convertPatientDTO(Patient p) {

        PatientDTO.setName(p.getName());
        PatientDTO.setPassword(p.getPassword());
        PatientDTO.setEmail(p.getEmail());
        savePatient(p);
        return new PatientDTO();
    }

}
