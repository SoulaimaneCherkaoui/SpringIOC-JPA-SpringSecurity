package com.patient.spring;

import com.patient.spring.entities.patient;
import com.patient.spring.repository.PatientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    //@Bean
    CommandLineRunner start(PatientRepo patientRepo) {
        return args -> {
            //Ajouter
            patient patient = new patient();
            patient.setId(1);
            patient.setNom("Soulaimane");
            patient.setMalade(true);
            patient.setDateNaissance(new Date());
            patient.setScore(10);



            patient patient1 = patient.builder()
                    .nom("Soulay")
                    .dateNaissance(new Date())
                    .Score(10)
                    .malade(true)
                    .build();
            patientRepo.save(patient);
            patientRepo.save(patient1);




        };
    }}
