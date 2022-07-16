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



    private String speciality;
    private boolean registered;


    private List<Patient> patients;

    public Doctor(){

    }



    public Doctor(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
        this.registered = true;
        this.patients = new ArrayList<>();


    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
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

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }


}