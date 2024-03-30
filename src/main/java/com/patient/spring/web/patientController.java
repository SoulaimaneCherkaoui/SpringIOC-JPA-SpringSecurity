package com.patient.spring.web;

import com.patient.spring.entities.patient;
import com.patient.spring.repository.PatientRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class patientController {
    @Autowired
    private PatientRepo patientRepo;

    @GetMapping("user/index")
    public  String index(Model model, @RequestParam(name = "page",defaultValue = "0")  int page,
                         @RequestParam(name= "size",defaultValue = "5") int size,
                         @RequestParam(name= "keyword",defaultValue = "") String kw){
        Page<patient> pagePatient = patientRepo.findByNomContains(kw,PageRequest.of(page,size));
        model.addAttribute("patientList",pagePatient.getContent());
        model.addAttribute("pages",new int[pagePatient.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",kw);

        return "patient";
    }

    @GetMapping("admin/delete")
    public String delete(@RequestParam(name = "id") Long id,
                         @RequestParam(name = "keyword", defaultValue = "") String keyword,
                         @RequestParam(name = "page", defaultValue = "0") int page){

        patientRepo.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;

    }
    @GetMapping("/")
    public String home() { return "redirect:/user/index";}

    @GetMapping("admin/fromPatients")
    public String fromPatient(Model model){
        model.addAttribute("patient",new patient());
        return "fromPatients";
    }
    @PostMapping(path="admin/save")
    public String save(Model model, @Valid patient p, BindingResult bindingResult,
                       @RequestParam(name = "keyword", defaultValue = "") String keyword,
                       @RequestParam(name = "page", defaultValue = "0") int page){
        if(bindingResult.hasErrors()) {return "fromPatients";}
        System.out.println(p.getId());

        patientRepo.save(p);

        return "redirect:/user/index?page="+page+"&keyword="+keyword;

    }
    @GetMapping("/admin/editPatient")
    public String editPatient(Model model,long id,
                               String keyword,
                               int page){
        patient p = patientRepo.findById(id).orElse(null);
        if(p==null) throw new RuntimeException("patient introuvable");
        System.out.println(p.getId());
        model.addAttribute("patient",p);

        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);

        return "editPatient";
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
