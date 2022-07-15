package InputServices;

import Entities.Ailment;
import Entities.Patient;
import Entities.Speciality;
import Enums.CardiologyAilments;
import Enums.DermatologyAilments;
import Enums.RadiologyAilments;
import Enums.Specialities;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ScannerUserInputService implements UserInputService {
    private Scanner scanner;
    private UserOutputService userOutputService;

    public ScannerUserInputService(UserOutputService userOutputService) {
        this.scanner = new Scanner(System.in);
        this.userOutputService = userOutputService;
    }

    public String getUserInput(String prompt) {
        userOutputService.printMessage(prompt);
        String input = scanner.nextLine();
        if (input.isBlank()) {
            return getUserInput(prompt);
        }
        return input;
    }

    @Override
    public int getUserIntegerInput(String prompt) {
        userOutputService.printMessage(prompt);
        String optionStr = scanner.nextLine();
        int option;
        try{
            option = Integer.parseInt(optionStr);

        }catch (Exception e){
            System.out.println("Please type a number for option!");
            return getUserIntegerInput(prompt);
        }
        return  option;
    }

    @Override
    public Ailment getAilment() {
        System.out.println(" -------- Ailment Options ------- ");
        System.out.println("1. " + CardiologyAilments.HeartDisase);
        System.out.println("2. " + DermatologyAilments.Eczema);
        System.out.println("3. " + DermatologyAilments.Psoriasis);
        System.out.println("4. " + RadiologyAilments.KidneyFailure);


        String optionStr = scanner.nextLine();
        int option;
        try{
            option = Integer.parseInt(optionStr);
            if(option < 1 || option > 4){
                System.out.println("Please type a number for option within range!");
                return getAilment();
            }
        }catch (Exception e){
            System.out.println("Please type a number for option!");
            return getAilment();
        }

        if(option == 1) return new Ailment(50, CardiologyAilments.HeartDisase.toString(),Specialities.CARDIOLOGY.toString());
        if(option == 2) return new Ailment(70, DermatologyAilments.Eczema.toString(),Specialities.DERMATOLOGY.toString());;
        if(option == 3) return new Ailment(70, DermatologyAilments.Psoriasis.toString(),Specialities.DERMATOLOGY.toString());
        if(option == 4) return new Ailment(30, RadiologyAilments.KidneyFailure.toString(),Specialities.RADIOLOGY.toString());

        return null;

    }

    @Override
    public Speciality getSpeciality() {

        System.out.println(" -------- Speciality Options ------- ");
        System.out.println("1. " + Specialities.CARDIOLOGY);
        System.out.println("2. " + Specialities.DERMATOLOGY);
        System.out.println("3. " + Specialities.RADIOLOGY);
        System.out.println(" ----------------------------------- ");

        String optionStr = scanner.nextLine();
        int option;
        try{
            option = Integer.parseInt(optionStr);
            if(option < 1 || option > 3){
                System.out.println("Please type a number for option within range!");
                return getSpeciality();
            }
        }catch (Exception e){
            System.out.println("Please type a number for option!");
            return getSpeciality();
        }

        if(option == 1) return new Speciality(Specialities.CARDIOLOGY.toString(),5);
        if(option == 2) return new Speciality(Specialities.DERMATOLOGY.toString(),3);
        if(option == 3) return new Speciality(Specialities.RADIOLOGY.toString(),7);

       return null;
    }

    @Override
    public Patient getPatient(Map<Integer,Patient> patientList) {
        System.out.println("Please select the patient for treatment");
        for(int number : patientList.keySet()){
            System.out.println(number+". "+patientList.get(number).getName());
        }
        String optionStr = scanner.nextLine();
        int option;
        try{
            option = Integer.parseInt(optionStr);
            if(option < 1 || option > patientList.size()){
                System.out.println("Please type a number for option within range!");
                return getPatient(patientList);
            }
        }catch (Exception e){
            System.out.println("Please type a number for option!");
            return getPatient(patientList);
        }

        return patientList.get(option);

    }

    @Override
    public void close() throws Exception {
        scanner.close();

    }
}