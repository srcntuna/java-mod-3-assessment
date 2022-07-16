package BuilderServices;

import Entities.Doctor;
import Entities.Patient;
import Entities.Speciality;
import InputServices.UserInputService;

import java.util.Map;

public class PatientSelectionService {

    private UserInputService userInputService;

    public PatientSelectionService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public Patient selectPatient(Map<Integer,Patient> patientList) {

        Patient patient = userInputService.getPatient(patientList);

        return patient;
    }

}
