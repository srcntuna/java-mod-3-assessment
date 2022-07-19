package Entities;

import Enums.Specialities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Doctor {
    private String name;


    private int healingPower;

    private Speciality speciality;
    private boolean registered;

    private List<Patient> patients;

    public Doctor(){

    }



    public Doctor(String name, Speciality speciality) {
        this.name = name;
        this.speciality = speciality;
        this.registered = true;
        this.patients = new ArrayList<>();
        //random power from 5 to 30
        this.healingPower = 5 + (int)(Math.random() * ((30 - 5) + 1));


    }

    public String getName() {
        return name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    @JsonIgnore
    public int getPatientCount() {
        return this.patients.size();
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void treatPatient(Patient patient){
        patient.receiveTreatment(this.healingPower);

    }


    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }


}