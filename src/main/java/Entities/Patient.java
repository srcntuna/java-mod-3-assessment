package Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

public class Patient {
    private String name;

    private Ailment ailment;



    private int healthIndex;

    private int patientID;

    private String speciality;
    private boolean isHealed;

    public Patient(){

    }

    public Patient(String name, Ailment ailment) {
        this.name = name;
        this.speciality = ailment.getSpeciality();
        this.ailment = ailment;
        this.healthIndex = ailment.getStartingHealthIndex();
        this.isHealed = false;
        this.patientID = 0;

    }

    public String getName() {
        return name;
    }


    public Ailment getAilment() {
        return ailment;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void receiveTreatment(int points){
        if(this.healthIndex >= 100){
            System.out.println("The patient is healed already!");
            return;
        }
        this.healthIndex+=points;
        if(this.healthIndex >= 100){
            System.out.println("HealthIndex is over 100 now. No longer treatment required. The patient is healed!");
            this.isHealed = true;
        }

    }



    public int getHealthIndex() {
        return healthIndex;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }


}