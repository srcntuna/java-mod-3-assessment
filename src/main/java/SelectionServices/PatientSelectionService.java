package SelectionServices;

import Entities.Doctor;
import Entities.Patient;
import Entities.Speciality;
import InputServices.UserInputService;

import java.util.List;
import java.util.Map;

public class PatientSelectionService {

    private UserInputService userInputService;

    private Patient selectedPatient;

    public PatientSelectionService(UserInputService userInputService) {
        this.userInputService = userInputService;
        this.selectedPatient = null;
    }

    public Patient selectPatient(List<Patient> patientList) {

        if(patientList.size() == 0){
            System.out.println("Sorry but there is no patient under this doctor. Choose another doctor or speciality!");
            return null;
        }

        System.out.println("Please select the patient for treatment");
        for(int i=1;i<=patientList.size();i++){
            System.out.println(i+". "+patientList.get(i-1).getName());
        }
        String optionStr = userInputService.getUserInput("....");
        int option;
        try{
            option = Integer.parseInt(optionStr);
            if(option < 1 || option > patientList.size()){
                System.out.println("Please type a number for option within range!");
                return selectPatient(patientList);
            }
        }catch (Exception e){
            System.out.println("Please type a number for option!");
            return selectPatient(patientList);
        }


        Patient patient = patientList.get(option-1);

        this.selectedPatient = patient;

        return  patient;

    }

    public Patient getSelectedPatient() {
        return selectedPatient;
    }


}
