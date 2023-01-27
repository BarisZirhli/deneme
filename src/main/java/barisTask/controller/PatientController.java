package barisTask.controller;

import barisTask.DTO.PatientDTO;
import barisTask.model.Patient;
import barisTask.service.PatientServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class PatientController {

    private PatientServiceImp PatienceService;
    private PatientDTO patientDTO;

    @GetMapping("/register")
    public String registerPOST() {

        //model.addAttribute("patient", p);
        return "register";
    }

   /* @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("");
        modelAndView.setViewName("register"); // resources/templates/register.html
        return modelAndView;
    }
*/
    @PostMapping("/register")
    public String registerGET(Model model) {
        Patient patient = new Patient();
        PatientDTO p = PatienceService.savePatient(patient);
        model.addAttribute("patientDTO", p);
        return "redirect:/login";
    }

    @GetMapping("/login/{id}")
    public String login(@PathVariable(value = "id") String id, Model model) {
        Patient p = PatienceService.findPatientId(id);
        patientDTO = PatienceService.convertPatientDTO(p);
        model.addAttribute("login", patientDTO);
        return "login";
    }

}
