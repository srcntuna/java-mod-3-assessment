package BuilderServices;

import Entities.Doctor;
import InputServices.UserInputService;

public class MultipleDoctorBuilder {

    private UserInputService userInputService;

    private DoctorBuilderService doctorBuilderService;


    public MultipleDoctorBuilder(UserInputService userInputService,DoctorBuilderService doctorBuilderService){

        this.userInputService = userInputService;
        this.doctorBuilderService = doctorBuilderService;

    }

    public void createMultipleDoctors(){

        String option = userInputService.getUserInput("How many doctors do you want to create?");
        int optionNum  = Integer.parseInt(option);

        for(int i =1 ; i<= optionNum;i++){
            Doctor newDoctor  = doctorBuilderService.createDoctor();

        }

    }

}
