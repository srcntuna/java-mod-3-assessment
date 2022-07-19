package Entities;

import Deserializer.ArrayToMapDeserializer;
import Deserializer.MapToArraySerializer;
import Deserializer.MyCustomDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.*;

public class Hospital implements Serializable {
    private String name;

    @JsonSerialize(using = MapToArraySerializer.class)
    private Map<Speciality, Set<Doctor>> specialtyToDoctors;


    private int patientID;



    public Hospital(){

    }



    public Hospital(String name) {
        this.name = name;
        this.specialtyToDoctors = new HashMap<>();


    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {

        Speciality doctorSpeciality = doctor.getSpeciality();


        for(Speciality speciality : specialtyToDoctors.keySet()){

            if(speciality.equals(doctorSpeciality)){

                specialtyToDoctors.get(speciality).add(doctor);
                System.out.println(doctor.getName()+" has been added to " + speciality.getName()+" department");
            }
        }

    }

    public void addPatient(Patient patient) {

        Set<Doctor> doctorsWithThatSpecialty = specialtyToDoctors.get(patient.getSpeciality());
        Doctor chosenDoctor = findDoctorWithShortestQueue(doctorsWithThatSpecialty);
        if(chosenDoctor == null){
            System.out.println("Sorry no doctor exist in this speciality! Please go to another hospital");
            return;
        }

        chosenDoctor.addPatient(patient);



        System.out.println(patient.getName()+" has been to added to Doctor "+chosenDoctor.getName()+" list in "+chosenDoctor.getSpeciality().getName()+" department");

    }

    public Map<Speciality, Set<Doctor>> getSpecialtyToDoctors() {
        return specialtyToDoctors;
    }

    public void removePatient(Patient patient){

        int patientID = patient.getPatientID();


        Set<Doctor> doctorsWithThatSpecialty = specialtyToDoctors.get(patient.getSpeciality());

        //from doctors list
        for(Doctor doctor : doctorsWithThatSpecialty){
            List<Patient> doctorList = doctor.getPatients();
            for(int i =0 ;i<doctorList.size();i++){
                Patient currPatient = doctorList.get(i);
                int currPatientID = currPatient.getPatientID();
                if(currPatientID == patientID){
                    doctorList.remove(currPatient);
                    System.out.println(patient.getName()+" has been removed from hospital...");
                };

            }

        }



    }

    public void addSpeciality(Speciality speciality){

        specialtyToDoctors.put(speciality,new HashSet<>());

    }


    private Doctor findDoctorWithShortestQueue(Set<Doctor> doctors) {

        System.out.println(doctors);

        Doctor chosenDoctor = null;
        for (Doctor doctor : doctors) {
            if (chosenDoctor == null) {
                chosenDoctor = doctor;
            } else if (chosenDoctor.getPatientCount() > doctor.getPatientCount()) {
                chosenDoctor = doctor;
            }
        }

        return chosenDoctor;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }




    @Override
    public String toString() {
        return "Hospital{" + "name='" + name + '\'' + ", specialtyToDoctors=" + specialtyToDoctors + ", patientID=" + patientID +  '}';
    }
}
