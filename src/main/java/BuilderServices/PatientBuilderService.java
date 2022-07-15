package BuilderServices;

import Entities.Ailment;
import Entities.Doctor;
import Entities.Patient;
import Entities.Speciality;
import Enums.OptionService;
import Enums.Specialities;
import InputServices.UserInputService;

public class PatientBuilderService {
    private UserInputService userInputService;

    public PatientBuilderService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public Patient createPatient() {
        String name = userInputService.getUserInput("What's the patient's name?");

        Ailment ailment = userInputService.getAilment();

        Patient patient = new Patient(name, ailment);

        return patient;
    }
}