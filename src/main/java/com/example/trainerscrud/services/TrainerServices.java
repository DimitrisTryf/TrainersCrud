/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.trainerscrud.services;

import com.example.trainerscrud.models.Trainer;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dimit
 */
public interface TrainerServices {
    
    public List<Trainer> getTrainerList();
    
    public void deleteTrainetById(Integer trainerId);
    
    public Optional<Trainer> getTrainerById(Integer trainerId);
    
    public void updateTrainer(Trainer trainer);
    
    public void insertTrainer(Trainer trainer);
}
