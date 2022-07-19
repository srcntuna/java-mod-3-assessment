package BuilderServices;

import Entities.*;
import Enums.CardiologyAilments;
import Enums.DermatologyAilments;
import Enums.RadiologyAilments;
import Enums.Specialities;
import InputServices.UserInputService;

public class HospitalBuilderService {

    private UserInputService userInputService;


    // constructor injection
    public HospitalBuilderService(UserInputService userInputService
                                 ) {
        this.userInputService = userInputService;
    }

    public Hospital createHospital() {
        String name = userInputService.getUserInput("What's the hospital name?");
        Hospital hospital = new Hospital(name);


        return hospital;

    }

}
