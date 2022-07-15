package BuilderServices;

import Entities.*;
import Enums.CardiologyAilments;
import Enums.DermatologyAilments;
import Enums.RadiologyAilments;
import Enums.Specialities;
import InputServices.UserInputService;

public class HospitalBuilderService {

    private UserInputService userInputService;
    private DoctorBuilderService doctorBuilderService;
    private PatientBuilderService patientBuilderService;
    private static final int NUMBER_OF_DOCTORS = 3;
    private static final int NUMBER_OF_PATIENTS = 5;

    // constructor injection
    public HospitalBuilderService(UserInputService userInputService, DoctorBuilderService doctorBuilderService,
                                  PatientBuilderService patientBuilderService) {
        this.userInputService = userInputService;
        this.doctorBuilderService = doctorBuilderService;
        this.patientBuilderService = patientBuilderService;
    }

    public Hospital createHospital() {
        String name = userInputService.getUserInput("What's the hospital name?");
        Hospital hospital = new Hospital(name);

        //PREDEFINED SPECIALITIES IN HOSPITAL
        Speciality cardiology = new Speciality(Specialities.CARDIOLOGY.toString(),5);
        Speciality dermatology = new Speciality(Specialities.DERMATOLOGY.toString(),3);
        Speciality radiology = new Speciality(Specialities.RADIOLOGY.toString(),7);
        hospital.addSpeciality(cardiology);
        hospital.addSpeciality(dermatology);
        hospital.addSpeciality(radiology);

//
        for (int i = 0; i < NUMBER_OF_DOCTORS; i++) {
            Doctor doctor = doctorBuilderService.createDoctor();
            hospital.addDoctor(doctor);
        }
        for (int i = 0; i < NUMBER_OF_PATIENTS; i++) {
            Patient patient = patientBuilderService.createPatient();
            hospital.addPatient(patient);
        }
        return hospital;

    }

}
