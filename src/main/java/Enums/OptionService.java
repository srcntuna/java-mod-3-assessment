package Enums;

import InputServices.UserInputService;

public class OptionService {


    private UserInputService userInputService;

    public OptionService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public int getSpecialityOption(){
        printSpecialityOptions();
        String optionStr = userInputService.getUserInput("Please choose one");
        int option;
        try{
            option = Integer.parseInt(optionStr);
            if(option < 1 || option > 3){
                System.out.println("Please type a number for option within range!");
                return getSpecialityOption();
            }
        }catch (Exception e){
            System.out.println("Please type a number for option!");
            return getSpecialityOption();
        }
        return option;
    }



    public int getAilmentOption(int specialityOption){
        if(specialityOption == 1){
            printCardiologyAilments();
        }else if(specialityOption == 2){
            printDermatologyAilments();
        }else{
            printRadiologyAilments();
        }
        String optionStr = userInputService.getUserInput("Please choose one");
        int option;
        try{
            option = Integer.parseInt(optionStr);
            if(option < 1 || option > 3){
                System.out.println("Please type a number for option within range!");
                return getAilmentOption(specialityOption);
            }
        }catch (Exception e){
            System.out.println("Please type a number for option!");
            return getAilmentOption(specialityOption);
        }
        return option;
    }




    public void printSpecialityOptions(){

        System.out.println(" -------- Speciality Options ------- ");
        System.out.println("1. " + Specialities.CARDIOLOGY);
        System.out.println("2. " + Specialities.DERMATOLOGY);
        System.out.println("3. " + Specialities.RADIOLOGY);
        System.out.println(" ----------------------------------- ");


    }

    public void printCardiologyAilments(){

        System.out.println(" -------- Cardiology Ailment Options ------- ");
        System.out.println("1. " + CardiologyAilments.AortaDisease);
        System.out.println("2. " + CardiologyAilments.HeartDisase);
        System.out.println("3. " + CardiologyAilments.VascularDisase);
        System.out.println(" -------------------------------- ");

    }
    public void printDermatologyAilments(){

        System.out.println(" -------- Dermatology Ailment Options ------- ");
        System.out.println("1. " + DermatologyAilments.Acne);
        System.out.println("2. " + DermatologyAilments.Eczema);
        System.out.println("3. " + DermatologyAilments.Psoriasis);
        System.out.println(" -------------------------------- ");

    }  public void printRadiologyAilments(){

        System.out.println(" -------- Radiology Ailment Options ------- ");
        System.out.println("1. " + RadiologyAilments.Anemia);
        System.out.println("2. " + RadiologyAilments.Appendicitis);
        System.out.println("3. " + RadiologyAilments.KidneyFailure);
        System.out.println(" -------------------------------- ");

    }


}
