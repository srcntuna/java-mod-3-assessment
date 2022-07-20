package Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

public class Patient {
    private String name;


    private int healthIndex;


    private boolean isHealed;


    private Patient(){

    }

    public Patient(String name) {
        this.name = name;
        this.healthIndex = 0;
        this.isHealed = false;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthIndex() {
        return healthIndex;
    }

    public void setHealthIndex(int healthIndex) {
        this.healthIndex = healthIndex;
    }

    public boolean isHealed() {
        return isHealed;
    }

    public void setHealed(boolean healed) {
        isHealed = healed;
    }



    public void receiveTreatment(int points){
        if(this.healthIndex >= 100){
            System.out.println("The patient is healed already!");
            return;
        }
        System.out.println(this.name + " had "+this.healthIndex+" health index");
        this.healthIndex+=points;
        System.out.println(this.name+" gaining "+points + " points....");
        System.out.println(this.name+ " has "+this.healthIndex+" health index now!!!");
        if(this.healthIndex >= 100){
            System.out.println("HealthIndex is over 100 now. No longer treatment required. The patient is healed!");
            this.isHealed = true;
        }

    }


}