package Entities;

import Enums.Specialities;

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

    public Doctor(String name, Speciality speciality) {
        this.name = name;
        this.speciality = speciality;
        this.registered = true;
        this.patients = new ArrayList<>();
        this.healingPower = 5 + (int)(Math.random() * ((30 - 5) + 1));

    }

    public String getName() {
        return name;
    }

    public Speciality getSpecialty() {
        return speciality;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public int getPatientCount() {
        return this.patients.size();
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public int getHealingPower() {
        return healingPower;
    }


}