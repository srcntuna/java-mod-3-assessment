package SelectionServices;

import Entities.Doctor;
import Entities.Speciality;
import InputServices.UserInputService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpecialitySelectionService {

    private UserInputService userInputService;

    private Speciality selectedSpeciality;

    public SpecialitySelectionService(UserInputService userInputService) {
        this.userInputService = userInputService;
        this.selectedSpeciality = null;
    }

    public Speciality selectSpeciality(Set<Speciality> specialities) {



        List<Speciality> specialityList = new ArrayList<Speciality>(specialities);

        for(int i=1;i<=specialityList.size();i++){
            System.out.println(i+". "+specialityList.get(i-1).getName());
        }


        String optionStr = userInputService.getUserInput("Please select the speciality");
        int option;
        try{
            option = Integer.parseInt(optionStr);
            if(option < 1 || option > specialityList.size()){
                System.out.println("Please type a number for option within range!");
                return selectSpeciality(specialities);
            }
        }catch (Exception e){
            System.out.println("Please type a number for option!");
            return selectSpeciality(specialities);
        }


        Speciality chosenSpeciality = specialityList.get(option-1);

        this.selectedSpeciality = chosenSpeciality;

        return  chosenSpeciality;

    }

    public Speciality getSelectedSpeciality() {
        return selectedSpeciality;
    }
}