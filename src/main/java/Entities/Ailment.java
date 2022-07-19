package Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


public class Ailment {


    private int startingHealthIndex;

    private String name;

    private String speciality;

    public Ailment(){

    }



    public Ailment(int startingHealthIndex, String name, String speciality) {
        this.startingHealthIndex = startingHealthIndex;
        this.name = name;
        this.speciality = speciality;
    }

    public int getStartingHealthIndex() {
        return startingHealthIndex;
    }

    public void setStartingHealthIndex(int startingHealthIndex) {
        this.startingHealthIndex = startingHealthIndex;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }


}
