package BuilderServices;

import InputServices.UserInputService;

public class MultiplePatientBuilder {

    private UserInputService userInputService;

    private PatientBuilderService patientBuilderService;


    public MultiplePatientBuilder(UserInputService userInputService,PatientBuilderService patientBuilderService){

        this.userInputService = userInputService;
        this.patientBuilderService = patientBuilderService;

    }

    public void createMultiplePatients(){

        String option = userInputService.getUserInput("How many patients do you want to create?");
        int optionNum  = Integer.parseInt(option);

        for(int i =1 ; i<= optionNum;i++){
            patientBuilderService.createPatient();
        }

    }

}