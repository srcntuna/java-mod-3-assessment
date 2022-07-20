package Entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.print.Doc;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Speciality {

    private String name;
    private int numOfTreatmentsReq;

    private Set<Ailment> associatedAilments;

    private Set<Doctor> doctors;

    public Speciality(){

    }

    public Speciality(String name, int numOfTreatmentsReq, Set<Ailment> associatedAilments) {
        this.name = name;
        this.numOfTreatmentsReq = numOfTreatmentsReq;
        this.associatedAilments = associatedAilments;
        this.doctors = new HashSet<>();

    }

    public String getName() {
        return name;
    }

    public int getNumOfTreatmentsReq() {
        return numOfTreatmentsReq;
    }


    public void addDoctor(Doctor doctor){
        this.doctors.add(doctor);
    }

    public Set<Doctor> getDoctors() {
        return doctors;
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


    public Doctor findDoctorWithShortestQueue() {


        Doctor chosenDoctor = null;
        for (Doctor doctor : this.doctors) {
            if (chosenDoctor == null) {
                chosenDoctor = doctor;
            } else if (chosenDoctor.getPatients().size() > doctor.getPatients().size()) {
                chosenDoctor = doctor;
            }
        }

        return chosenDoctor;
    }

    @Override
    public String toString() {
        return "Speciality{" + "name='" + name + '\'' + ", numOfTreatmentsReq=" + numOfTreatmentsReq + ", associatedAilments=" + associatedAilments + ", doctors=" + doctors + '}';
    }
}
