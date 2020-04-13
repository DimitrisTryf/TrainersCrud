/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.trainerscrud.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dimit
 */
@Entity
@Table(name = "trainer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trainer.findAll", query = "SELECT t FROM Trainer t"),
    @NamedQuery(name = "Trainer.findByTrainerId", query = "SELECT t FROM Trainer t WHERE t.trainerId = :trainerId"),
    @NamedQuery(name = "Trainer.findByTrainerName", query = "SELECT t FROM Trainer t WHERE t.trainerName = :trainerName"),
    @NamedQuery(name = "Trainer.findByTrainerSurname", query = "SELECT t FROM Trainer t WHERE t.trainerSurname = :trainerSurname"),
    @NamedQuery(name = "Trainer.findByTrainerSubject", query = "SELECT t FROM Trainer t WHERE t.trainerSubject = :trainerSubject")})
public class Trainer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trainer_id")
    private Integer trainerId;
    @Size(max = 45)
    @Column(name = "trainer_name")
    private String trainerName;
    @Size(max = 45)
    @Column(name = "trainer_surname")
    private String trainerSurname;
    @Size(max = 45)
    @Column(name = "trainer_subject")
    private String trainerSubject;

    public Trainer() {
    }

    public Trainer(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public Integer getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Integer trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerSurname() {
        return trainerSurname;
    }

    public void setTrainerSurname(String trainerSurname) {
        this.trainerSurname = trainerSurname;
    }

    public String getTrainerSubject() {
        return trainerSubject;
    }

    public void setTrainerSubject(String trainerSubject) {
        this.trainerSubject = trainerSubject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trainerId != null ? trainerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trainer)) {
            return false;
        }
        Trainer other = (Trainer) object;
        if ((this.trainerId == null && other.trainerId != null) || (this.trainerId != null && !this.trainerId.equals(other.trainerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.trainerscrud.models.Trainer[ trainerId=" + trainerId + " ]";
    }
    
}
