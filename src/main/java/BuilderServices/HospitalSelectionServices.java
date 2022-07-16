package BuilderServices;

import Entities.Hospital;
import IOServices.IOService;
import InputServices.UserInputService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class HospitalSelectionServices {


    private UserInputService userInputService;
    private IOService ioService;

    public HospitalSelectionServices(UserInputService userInputService, IOService ioService) {
        this.userInputService = userInputService;
        this.ioService = ioService;
    }

    public Hospital selectHospital(){
        System.out.println("WELCOME!");
        System.out.println("1.Import the existing hospital");
        System.out.println("2.Create a new hospital");
        int option = userInputService.getUserIntegerInput("Select an option...");

        Hospital hospital = null;
        if(option == 1){
            hospital = importHospital();
        }else{
            hospital = buildNewHospital();
        }

        return hospital;
    }

    public Hospital buildNewHospital(){

        DoctorBuilderService doctorBuilderService = new DoctorBuilderService(userInputService);
        PatientBuilderService patientBuilderService = new PatientBuilderService(userInputService);
        HospitalBuilderService hospitalBuilderService = new HospitalBuilderService(userInputService,
                doctorBuilderService, patientBuilderService);
        Hospital hospital = hospitalBuilderService.createHospital();

        return hospital;
    }


    public Hospital importHospital() {

        Hospital restoredHospital = null;
        try{

            restoredHospital = new ObjectMapper().readValue(new File( "hospital.json"), Hospital.class);

        } catch (Exception e){
            System.out.println("Hospital does not exist. Redirecting to create a new one....");
            return buildNewHospital();
        }
        return restoredHospital;

    }



}
