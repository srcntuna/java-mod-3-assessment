package BuilderServices;

import Entities.Hospital;
import IOServices.IOService;
import InputServices.UserInputService;

import java.io.File;

public class HospitalSelectionServices {


    private UserInputService userInputService;
    private IOService ioService;

    public HospitalSelectionServices(UserInputService userInputService, IOService ioService) {
        this.userInputService = userInputService;
        this.ioService = ioService;
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
            e.printStackTrace();
        }
        return restoredHospital;

    }

}
