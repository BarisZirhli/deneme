package barisTask.controller;

import barisTask.DTO.PatientDTO;
import barisTask.model.Patient;
import barisTask.service.PatientServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class PatientController {

    private PatientServiceImp patienceService ;

    @GetMapping("/register")
    public String registerGET(Model model) {
        Patient p = new Patient();
        PatientDTO patientDTO = patienceService.convertPatientDTO(p);
        model.addAttribute("patient", patientDTO);
        return "register";
    }

    @PostMapping("/register")
    public String registerPOST(Model model) {
        Patient patient = new Patient();
        PatientDTO p = patienceService.savePatient(patient);
        model.addAttribute("patient", p);
        return "redirect:/login";
    }

    @GetMapping("/login/{id}")
    public String login(@PathVariable(value = "id") String id, Model model) {
        Patient p = patienceService.findPatientId(id);
        PatientDTO patientDTO = patienceService.convertPatientDTO(p);
        model.addAttribute("login", patientDTO);
        return "login";
    }

}
