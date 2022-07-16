package BuilderServices;

import Entities.Doctor;
import Entities.Hospital;
import Entities.Patient;
import IOServices.IOService;
import IOServices.JsonIOService;
import InputServices.UserInputService;

public class PatientServices {

    private PatientBuilderService patientBuilderService;

    private UserInputService userInputService;

    private Hospital hospital;

    private PatientSelectionService patientSelectionService;

    private IOService ioService;

    public PatientServices(PatientBuilderService patientBuilderService, UserInputService userInputService, PatientSelectionService patientSelectionService, Hospital hospital) {
        this.patientBuilderService = patientBuilderService;
        this.userInputService = userInputService;
        this.patientSelectionService = patientSelectionService;
        this.hospital = hospital;
        this.ioService = new JsonIOService();
    }


    public void choosePatientService() throws Exception {
        while(true){
            System.out.println("What would you like to do? ");
            System.out.println("1.Add a patient to hospital..");
            System.out.println("2.Treat a patient in the hospital..");
            System.out.println("3.Exit hospital..");

            int option = userInputService.getUserIntegerInput("Please choose an option.");
            if(option == 1){
                Patient patient = patientBuilderService.createPatient();
                hospital.addPatient(patient);

            }else if(option == 2){
                Patient patient = patientSelectionService.selectPatient(hospital.getAllPatients());
                System.out.println(patient.getName()+" had "+patient.getHealthIndex()+" points");
                System.out.println("10 points is loading ......");
                patient.receiveTreatment(10);
                System.out.println(patient.getName()+" health index is now "+patient.getHealthIndex());
                if(patient.getHealthIndex()>= 100){
                    hospital.removePatient(patient);
                }
            }else{

              break;

            }
        }








    }






}
