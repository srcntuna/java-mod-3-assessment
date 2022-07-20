package BuilderServices;

import Entities.Doctor;
import Entities.Hospital;
import Entities.Speciality;
import Enums.OptionService;
import Enums.Specialities;
import InputServices.UserInputService;

public class DoctorBuilderService {
    private UserInputService userInputService;

    private SpecialityBuilderService specialityBuilderService;

    private Hospital hospital;



    public DoctorBuilderService(UserInputService userInputService, Hospital hospital) {
        this.userInputService = userInputService;
        this.specialityBuilderService = new SpecialityBuilderService(userInputService);
        this.hospital = hospital;
    }

    public Doctor createDoctor() {
        String name = userInputService.getUserInput("What's the doc's name?");


        Speciality speciality = specialityBuilderService.createSpeciality();
        hospital.addSpeciality(speciality);

        Doctor newDoctor = new Doctor(name);

        speciality.addDoctor(newDoctor);

        return newDoctor;
    }

    public Hospital getHospital() {
        return hospital;
    }



}

