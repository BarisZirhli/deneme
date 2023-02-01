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
    public String registerGET(Model model) {
        PatientDTO DTO = new PatientDTO();
        model.addAttribute("Patient", DTO);
        //  LOGGER.info("what is this " + DTO);
        return "register";
    }

    @PostMapping("/register")
    public String registerPOST(@Valid PatientDTO p, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("Patient", p);
            LOGGER.info("what is this " + p);
            return "register";
        } else {

            patienceService.savePatient(p);
            model.addAttribute("successMsg", "Your Account Registered Successfully");
            //    LOGGER.info("what is this " + p);
            return "login";
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
    /* @GetMapping("/login/{id}")
    public String login(@PathVariable(value = "id") String id, Model model) {
        Patient p = patienceService.findPatientId(id);
        PatientDTO patientDTO = patienceService.convertPatientDTO(p);
        model.addAttribute("login", patientDTO);
        return "login";
    }
     */
}
