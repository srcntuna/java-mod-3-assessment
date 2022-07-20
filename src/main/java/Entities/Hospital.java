package Entities;

import Deserializer.ArrayToMapDeserializer;
import Deserializer.MapSerializer;

import Deserializer.MyCustomDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.*;

public class Hospital implements Serializable {
    private String name;


    private Set<Speciality> specialities;

    public Hospital(){

    }

    public Hospital(String name) {
        this.name = name;
        this.specialities = new HashSet<>();


    }

    public String getName() {
        return name;
    }


    public void addSpeciality(Speciality speciality){

        specialities.add(speciality);

    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }




    public void setName(String name) {
        this.name = name;
    }






}
