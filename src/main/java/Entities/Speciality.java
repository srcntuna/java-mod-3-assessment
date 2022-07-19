package Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Speciality {

    private String name;
    private int numOfTreatmentsReq;


    private Map<String, List<Object>> associatedDetails;

    public Speciality(){

    }



    public Speciality(String name, int numOfTreatmentsReq, Map<String, List<Object>> associatedDetails) {
        this.name = name;
        this.numOfTreatmentsReq = numOfTreatmentsReq;
        this.associatedDetails = associatedDetails;

    }


    public String getName() {
        return name;
    }

    public int getNumOfTreatmentsReq() {
        return numOfTreatmentsReq;
    }



    public void addAilment(Ailment ailment){
        int requiredStartingIndex = 100 - numOfTreatmentsReq * 10;
        ailment.setStartingHealthIndex(requiredStartingIndex);
        associatedAilments.add(ailment);
        System.out.println(ailment+" has been added to speciality: "+name);
    }

    public Set<Ailment> getAssociatedAilments() {
        return associatedAilments;
    }
}
