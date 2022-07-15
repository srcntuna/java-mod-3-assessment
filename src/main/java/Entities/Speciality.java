package Entities;

import java.util.HashSet;

public class Speciality {

    private String name;
    private int numOfTreatmentsReq;

    private HashSet<Ailment> associatedAilments;



    public Speciality(String name, int numOfTreatmentsReq) {
        this.name = name;
        this.numOfTreatmentsReq = numOfTreatmentsReq;
        this.associatedAilments = new HashSet<>();

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

    public HashSet<Ailment> getAssociatedAilments() {
        return associatedAilments;
    }
}
