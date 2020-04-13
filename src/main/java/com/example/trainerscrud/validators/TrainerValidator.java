/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.trainerscrud.validators;

import com.example.trainerscrud.models.Trainer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author dimit
 */
@Component
public class TrainerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Trainer.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Trainer tr = (Trainer) target;
        String trName = tr.getTrainerName();
        String trSurname = tr.getTrainerSurname();
        for (Character i : trName.toCharArray()) {
            if (!Character.isLetter(i)) {
                errors.rejectValue("trainerName", "name.not.all.chars");
                break;
            }
        }

        if (trSurname.length() > 40 || trSurname.length() < 5) {
            errors.rejectValue("trainerSurname", "surname.not.valid.length");
        }

        for (Character i : trSurname.toCharArray()) {
            if (!Character.isLetter(i)) {
                errors.rejectValue("trainerSurname", "surname.not.all.chars");
                break;
            }
        }

        if (trName.length() > 40 || trName.length() < 5) {
            errors.rejectValue("trainerName", "name.not.valid.length");
        }
    }
}
