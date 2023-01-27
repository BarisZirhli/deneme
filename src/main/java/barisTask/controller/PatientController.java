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
    
    private PatientServiceImp PatienceService;
    private PatientDTO patientDTO;

    @GetMapping("/register/")
    public String registerPOST(Patient p, Model model) {
        patientDTO = PatienceService.convertPatientDTO(p);
        model.addAttribute("patient", patientDTO);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerGET(Model model) {
        Patient p = new Patient();
        patientDTO = PatienceService.convertPatientDTO(p);
        model.addAttribute("patient", patientDTO);
        return "register";
    }

    @GetMapping("/login/{id}")
    public String login(@PathVariable(value = "id") String id, Model model) {
        Patient p = PatienceService.findPatientId(id);
        patientDTO = PatienceService.convertPatientDTO(p);
        model.addAttribute("login", patientDTO);
        return "login";
    }

}
