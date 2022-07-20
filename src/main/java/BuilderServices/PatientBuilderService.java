package BuilderServices;

import Entities.*;

import InputServices.UserInputService;
import SelectionServices.AilmentSelectionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PatientBuilderService {
    private UserInputService userInputService;



    private Hospital hospital;
    private AilmentSelectionService ailmentSelectionService;

    public PatientBuilderService(UserInputService userInputService, Hospital hospital) {

        this.userInputService = userInputService;
        this.ailmentSelectionService = new AilmentSelectionService(userInputService);
        this.hospital = hospital;
    }

    public Patient createPatient() {
        String name = userInputService.getUserInput("What's the patient's name?");

        List<Ailment> ailmentList = new ArrayList();

        for(Speciality speciality : hospital.getSpecialities()){
            Set<Ailment> ailmentsOfCurrSpeciality = speciality.getAssociatedAilments();
            ailmentList.addAll(ailmentsOfCurrSpeciality);
        }

        Ailment ailment = ailmentSelectionService.selectAilment(ailmentList);

        Doctor chosenDoctor = null;

        for(Speciality speciality : hospital.getSpecialities()){
            if(speciality.getName().equals(ailment.getSpeciality())){
                chosenDoctor = speciality.findDoctorWithShortestQueue();
            }
        }

        Patient patient = new Patient(name);
        int startingHealthIndex = ailment.getStartingHealthIndex();
        patient.setHealthIndex(startingHealthIndex);

        if(chosenDoctor == null){
            System.out.println("Sorry there is no doctor in this department, please go to another hospital");
            return null;

        }
        chosenDoctor.addPatient(patient);



        return patient;
    }

    public Hospital getHospital() {
        return hospital;
    }
}