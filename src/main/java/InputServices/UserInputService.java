package InputServices;

import Entities.Ailment;
import Entities.Patient;
import Entities.Speciality;

import java.util.List;
import java.util.Map;

public interface UserInputService extends AutoCloseable {
    String getUserInput(String prompt);

    int getUserIntegerInput(String prompt);

    Ailment getAilment();
    Speciality getSpeciality();

    Patient getPatient(Map<Integer,Patient> patientList);


}