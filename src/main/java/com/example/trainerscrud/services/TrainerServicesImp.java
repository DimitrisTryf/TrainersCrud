/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.trainerscrud.services;

import com.example.trainerscrud.models.Trainer;
import com.example.trainerscrud.repositories.TrainerRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dimit
 */
@Service
@Transactional
public class TrainerServicesImp implements TrainerServices{

    @Autowired
    TrainerRepository trainerRepo;
    
    @Override
    public List<Trainer> getTrainerList() {
        return (List<Trainer>)trainerRepo.findAll();
    }

    @Override
    public void deleteTrainetById(Integer trainerId) {
        trainerRepo.deleteById(trainerId);
    }

    @Override
    public Optional<Trainer> getTrainerById(Integer trainerId) {
        
        return trainerRepo.findById(trainerId);
    }

    @Override
    public void updateTrainer(Trainer trainer) {
        trainerRepo.save(trainer);
    }

    @Override
    public void insertTrainer(Trainer trainer) {
        trainerRepo.save(trainer);
    }
    
}
