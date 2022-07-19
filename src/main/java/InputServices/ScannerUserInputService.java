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
    public void close() throws Exception {
        scanner.close();

    }
}