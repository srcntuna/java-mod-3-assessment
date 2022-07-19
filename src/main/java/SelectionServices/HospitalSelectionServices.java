package SelectionServices;

import BuilderServices.DoctorBuilderService;
import BuilderServices.HospitalBuilderService;
import BuilderServices.PatientBuilderService;
import Entities.Hospital;
import IOServices.IOService;
import IOServices.JsonIOService;
import InputServices.UserInputService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class HospitalSelectionServices {

    private UserInputService userInputService;

    private IOService ioService;

    private String selectedHospital;

    public HospitalSelectionServices(UserInputService userInputService,IOService jsonIOService) {
        this.userInputService = userInputService;
        this.ioService = jsonIOService;
        this.selectedHospital = null;
    }

    public Hospital selectHospital(List<String> hospitalList) throws IOException {
        System.out.println("Please select the hospital from the list below...");
        for(int i=1;i<=hospitalList.size();i++){
            String currHospital = hospitalList.get(i-1);
            System.out.println(i+". "+currHospital);
        }

        String chosenOption = userInputService.getUserInput("....");
        int chosenOptionNum = Integer.parseInt(chosenOption);
        String chosenHospital = hospitalList.get(chosenOptionNum-1);
        this.selectedHospital = chosenHospital;

       Hospital hospital =ioService.parseFile(chosenHospital+".json");

        return hospital;

    }

    public String getSelectedHospital() {
        return selectedHospital;
    }





}
