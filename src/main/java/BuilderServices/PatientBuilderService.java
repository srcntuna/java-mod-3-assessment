package BuilderServices;

import Entities.*;
import Enums.OptionService;
import Enums.Specialities;
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

        for(Speciality speciality : hospital.getSpecialtyToDoctors().keySet()){
            Set<Ailment> ailmentsOfCurrSpeciality = speciality.getAssociatedAilments();
            for(Ailment ailment : ailmentsOfCurrSpeciality){
                ailmentList.add(ailment);
            }
        }

        Ailment ailment = ailmentSelectionService.selectAilment(ailmentList);

        Patient patient = new Patient(name, ailment);

        hospital.addPatient(patient);

        return patient;
    }

    public Hospital getHospital() {
        return hospital;
    }
}