package BuilderServices;

import Entities.Hospital;
import IOServices.IOService;
import IOServices.JsonIOService;
import InputServices.UserInputService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HospitalSelectionServices {


    private UserInputService userInputService;
    private IOService ioService;

    public HospitalSelectionServices(UserInputService userInputService) {
        this.userInputService = userInputService;
        this.ioService = new JsonIOService();
    }

    public Hospital selectHospital() throws IOException {
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


    public Hospital importHospital() throws IOException {

        System.out.println("hey here!");

      Hospital hospital = null;
        try{
            hospital = ioService.parseFile("hospital.json");
        }catch (Exception e){
            System.out.println("Hospital does not exist, redirecting you to build a new hospital....");
            return buildNewHospital();
        }

        return hospital;
    }



}
