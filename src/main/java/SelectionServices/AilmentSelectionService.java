package SelectionServices;

import Entities.Ailment;
import Entities.Doctor;
import InputServices.UserInputService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AilmentSelectionService {

    private UserInputService userInputService;


    public AilmentSelectionService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public Ailment selectAilment(List<Ailment> ailmentList) {

        System.out.println("Please select the ailment of the patient");


        for(int i=1;i<=ailmentList.size();i++){
            System.out.println(i+". "+ailmentList.get(i-1).getName());
        }
        String optionStr = userInputService.getUserInput("....");
        int option;
        try{
            option = Integer.parseInt(optionStr);
            if(option < 1 || option > ailmentList.size()){
                System.out.println("Please type a number for option within range!");
                return selectAilment(ailmentList);
            }
        }catch (Exception e){
            System.out.println("Please type a number for option!");
            return selectAilment(ailmentList);
        }


        Ailment ailment = ailmentList.get(option-1);


        return  ailment;

    }



}
