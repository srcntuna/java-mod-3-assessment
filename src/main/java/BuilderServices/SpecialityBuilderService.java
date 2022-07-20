package BuilderServices;

import Entities.Ailment;
import Entities.Doctor;
import Entities.Speciality;
import Enums.CardiologyAilments;
import Enums.DermatologyAilments;
import Enums.RadiologyAilments;
import Enums.Specialities;
import InputServices.UserInputService;

import java.util.*;

public class SpecialityBuilderService {
    private UserInputService userInputService;

    public SpecialityBuilderService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public Speciality createSpeciality() {


        System.out.println("1. " + Specialities.CARDIOLOGY);
        System.out.println("2. " + Specialities.DERMATOLOGY);
        System.out.println("3. " + Specialities.RADIOLOGY);

        String name = userInputService.getUserInput("Please select the speciality?");

        int option = Integer.parseInt(name);

       Set<Ailment> associatedAilments = new HashSet<>();
        String nameOfSpeciality;
        int numOfTreatmentsReq;

        if(option ==1 ){
            nameOfSpeciality = Specialities.CARDIOLOGY.name();
            numOfTreatmentsReq = 5;
            for(CardiologyAilments ailment : CardiologyAilments.values()){

                associatedAilments.add(new Ailment(50,ailment.name(),Specialities.CARDIOLOGY.name()));
            }
        }else if(option == 2){
            nameOfSpeciality = Specialities.DERMATOLOGY.name();
            numOfTreatmentsReq = 3;
            for(DermatologyAilments ailment : DermatologyAilments.values()){
                associatedAilments.add(new Ailment(70,ailment.name(),Specialities.DERMATOLOGY.name()));
            }
            
        }else{
            nameOfSpeciality = Specialities.RADIOLOGY.name();
            numOfTreatmentsReq = 7;
            for(RadiologyAilments ailment : RadiologyAilments.values()){
                associatedAilments.add(new Ailment(30,ailment.name(),Specialities.RADIOLOGY.name()));
            }
        }


       Speciality newSpeciality = new Speciality(nameOfSpeciality,numOfTreatmentsReq,associatedAilments);


        return newSpeciality;
        
    }



}