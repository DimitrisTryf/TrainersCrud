/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.trainerscrud.controllers;

import com.example.trainerscrud.models.Trainer;
import com.example.trainerscrud.services.TrainerServices;
import com.example.trainerscrud.validators.TrainerValidator;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author dimit
 */
@Controller
public class TrainerController {

    @Autowired
    TrainerServices trainerSer;

    @GetMapping(value = "/")
    public String index() {
        return "redirect:/getTrainerList";
    }

    @GetMapping(value = "/getTrainerList")
    public String getTrainerList(ModelMap mm) {
        mm.addAttribute("trainerList", trainerSer.getTrainerList());
        Trainer p = new Trainer();
        mm.addAttribute("Trainer", p);
        return "trainersList";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteTrainer(@PathVariable(name = "id") Integer trainerId) {
        trainerSer.deleteTrainetById(trainerId);
        return "redirect:/getTrainerList";
    }

    @PostMapping(value = "/updateTrainer")
    public String updateTrainer(@RequestParam(name = "id") Integer trainerId,
            @RequestParam(name = "name") String trainerName,
            @RequestParam(name = "surname") String trainerSurname,
            @RequestParam(name = "subject") String trainerSubject) {

        Trainer temp = new Trainer();
        temp.setTrainerId(trainerId);
        temp.setTrainerName(trainerName);
        temp.setTrainerSurname(trainerSurname);
        temp.setTrainerSubject(trainerSubject);

        trainerSer.updateTrainer(temp);

        return "redirect:/";
    }

    @Autowired
    TrainerValidator pv;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(pv);
    }

    @PostMapping(value = "/insertTrainer")
    public String insertTrainer(@Valid @ModelAttribute("Trainer") Trainer trainer,
            BindingResult br,
            ModelMap mm) {

        if (br.hasErrors()) {
            mm.addAttribute("errors", "1");
            mm.addAttribute("trainerList", trainerSer.getTrainerList());
            return "trainersList";
        }
        trainerSer.insertTrainer(trainer);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping(value = "/preUpdateTrainerSer")
    public Trainer preUpdateTrainerSer(@RequestParam(name = "id") Integer trainerId) {

        Optional<Trainer> optTrainer = trainerSer.getTrainerById(trainerId);

        if (optTrainer.isPresent()) {
            return optTrainer.get();
        }
        return null;
    }
}
