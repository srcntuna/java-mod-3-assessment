package BuilderServices;

import Entities.Doctor;
import Entities.Hospital;
import Entities.Speciality;
import Enums.OptionService;
import Enums.Specialities;
import InputServices.UserInputService;

public class DoctorBuilderService {
    private UserInputService userInputService;

    public DoctorBuilderService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public Doctor createDoctor() {
        String name = userInputService.getUserInput("What's the doc's name?");


        Speciality speciality = userInputService.getSpeciality();

        Doctor newDoctor = new Doctor(name,speciality);


        return newDoctor;
    }



}

