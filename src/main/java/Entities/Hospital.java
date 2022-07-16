package Entities;

import java.io.Serializable;
import java.util.*;

public class Hospital implements Serializable {
    private String name;
    private Map<String, Set<Doctor>> specialtyToDoctors;

    private int patientID;

    private Map<Integer,Patient> allPatients;

    public Hospital(){

    }

    public Hospital(String name) {
        this.name = name;
        this.specialtyToDoctors = new HashMap<>();
        this.allPatients = new HashMap<>();
        this.patientID = 1;
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {

        String doctorSpeciality = doctor.getSpecialty();

        for(String speciality : specialtyToDoctors.keySet()){
            if(speciality.equals(doctorSpeciality)  ){
                specialtyToDoctors.get(speciality).add(doctor);
                System.out.println(doctor.getName()+" has been added to " + speciality+" department");
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
        patient.setPatientID(patientID);
        chosenDoctor.addPatient(patient);

        allPatients.put(patientID,patient);
        patientID++;
        System.out.println(patient.getName()+" has been to added to Doctor "+chosenDoctor.getName()+" list in "+chosenDoctor.getSpecialty()+" department");

    }

    public void removePatient(Patient patient){

        int patientID = patient.getPatientID();


        Set<Doctor> doctorsWithThatSpecialty = specialtyToDoctors.get(patient.getSpeciality());

        //from doctors list
        for(Doctor doctor : doctorsWithThatSpecialty){
            List<Patient> doctorList = doctor.getPatients();
            for(Patient currPatient : doctorList){
                if(currPatient.getPatientID() == patientID){
                    doctorList.remove(currPatient);
                    System.out.println(patient.getName()+" has been removed from hospital...");
                };

            }

        }

        //from the whole list of patients
        allPatients.remove(patient);

    }

    public void addSpeciality(Speciality speciality){

        specialtyToDoctors.put(speciality.getName(),new HashSet<>());

    }


    private Doctor findDoctorWithShortestQueue(Set<Doctor> doctors) {


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

    public Map<String, Set<Doctor>> getSpecialtyToDoctors() {
        return specialtyToDoctors;
    }

    public void setSpecialtyToDoctors(Map<String, Set<Doctor>> specialtyToDoctors) {
        this.specialtyToDoctors = specialtyToDoctors;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public Map<Integer, Patient> getAllPatients() {
        return allPatients;
    }

    public void setAllPatients(Map<Integer, Patient> allPatients) {
        this.allPatients = allPatients;
    }

    @Override
    public String toString() {
        return "Hospital{" + "name='" + name + '\'' + ", specialtyToDoctors=" + specialtyToDoctors + ", patientID=" + patientID + ", allPatients=" + allPatients + '}';
    }
}
