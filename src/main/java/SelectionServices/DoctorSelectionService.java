package SelectionServices;

import Entities.Doctor;
import Entities.Patient;
import InputServices.UserInputService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DoctorSelectionService {

    private UserInputService userInputService;

    private Doctor selectedDoctor;

    public DoctorSelectionService(UserInputService userInputService) {
        this.userInputService = userInputService;
        this.selectedDoctor = null;
    }

    public Doctor selectDoctor(Set<Doctor> doctorList) {




        List<Doctor>doctorListArrayList = new ArrayList<Doctor>(doctorList);


        for(int i=1;i<=doctorList.size();i++){
            System.out.println(i+". "+doctorListArrayList.get(i-1).getName());
        }
        String optionStr = userInputService.getUserInput("Please select the doctor to access his/her patients");
        int option;
        try{
            option = Integer.parseInt(optionStr);
            if(option < 1 || option > doctorListArrayList.size()){
                System.out.println("Please type a number for option within range!");
                return selectDoctor(doctorList);
            }
        }catch (Exception e){
            System.out.println("Please type a number for option!");
            return selectDoctor(doctorList);
        }


        Doctor doctor = doctorListArrayList.get(option-1);

        this.selectedDoctor = doctor;

        return  doctor;

    }


    public Doctor getSelectedDoctor() {
        return selectedDoctor;
    }


}