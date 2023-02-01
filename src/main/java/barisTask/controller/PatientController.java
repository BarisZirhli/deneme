package barisTask.controller;

import barisTask.DTO.PatientDTO;
import barisTask.model.Patient;
import barisTask.repository.PatientRepository;
import barisTask.service.PatientServiceImp;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Validated
public class PatientController {

    public static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);
    @Autowired
    private PatientServiceImp patienceService;

    @GetMapping("/register")
    public String registerFormGET(Model model) {
        PatientDTO DTO = new PatientDTO();
        model.addAttribute("Patient", DTO);
        return "register";
    }

    @PostMapping("/register/save")
    public String registerFormSavePOST(@Valid @ModelAttribute("Patient") PatientDTO patientDTO, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("Patient", patientDTO);
            LOGGER.info("what is this " + patientDTO);
            return "/register";
        } else {

            patienceService.savePatient(patientDTO);
            model.addAttribute("successMsg", "Your Account Registered Successfully");

            return "redirect:/";
        }
    }

    @GetMapping("/")
    public String loginGET(Model model) {
        return "login";
    }

    @PostMapping("/")
    public String loginPOST(Model model, Patient p) {

        return "patientDashboard";
    }
}
