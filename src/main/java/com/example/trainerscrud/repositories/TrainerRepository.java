/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.trainerscrud.repositories;

import com.example.trainerscrud.models.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dimit
 */
@Repository
public interface TrainerRepository extends CrudRepository<Trainer,Integer>{
    
}
