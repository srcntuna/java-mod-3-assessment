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


    private boolean registered;

    private List<Patient> patients;

    public Doctor(){

    }



    public Doctor(String name) {
        this.name = name;
        this.registered = true;
        this.patients = new ArrayList<>();

        this.healingPower = 5 + (int)(Math.random() * ((30 - 5) + 1));


    }

    public String getName() {
        return name;
    }



    public boolean isRegistered() {
        return registered;
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }



    public List<Patient> getPatients() {
        return patients;
    }

    public void removePatient(Patient patient){
        this.patients.remove(patient);
        System.out.println(patient.getName()+" has been removed from the hospital...");
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

    public int getHealingPower() {
        return healingPower;
    }

    public void setHealingPower(int healingPower) {
        this.healingPower = healingPower;
    }

}