package PatientServices;

import BuilderServices.PatientBuilderService;
import Entities.Doctor;
import Entities.Hospital;
import Entities.Patient;
import Entities.Speciality;
import IOServices.IOService;
import IOServices.JsonIOService;
import InputServices.UserInputService;
import SelectionServices.DoctorSelectionService;
import SelectionServices.PatientSelectionService;
import SelectionServices.SpecialitySelectionService;

import javax.print.Doc;

public class PatientServices {

    private PatientBuilderService patientBuilderService;

    private UserInputService userInputService;

    private Hospital hospital;

    private PatientSelectionService patientSelectionService;

    private DoctorSelectionService doctorSelectionService;

    private SpecialitySelectionService specialitySelectionService;


    public PatientServices(PatientBuilderService patientBuilderService, UserInputService userInputService,  Hospital hospital) {
        this.patientBuilderService = patientBuilderService;
        this.userInputService = userInputService;
        this.patientSelectionService = new PatientSelectionService(userInputService);
        this.doctorSelectionService = new DoctorSelectionService(userInputService);
        this.specialitySelectionService = new SpecialitySelectionService(userInputService);
        this.hospital = hospital;

    }


    public void choosePatientService() throws Exception {
            System.out.println("What would you like to do? ");
            System.out.println("1.Add a patient to hospital..");
            System.out.println("2.Treat a patient in the hospital..");
            System.out.println("3.Exit hospital..");

            String optionStr = userInputService.getUserInput("...");
            int optionNum = Integer.parseInt(optionStr);
            if(optionNum == 1){

                Patient newPatient = patientBuilderService.createPatient();


            }else if(optionNum == 2) {

                
                Speciality chosenSpeciality = specialitySelectionService.selectSpeciality(hospital.getSpecialities());

                Doctor chosenDoctor = null;
                Patient chosenPatient = null;
                
                for(Speciality speciality : hospital.getSpecialities()){
                    if(speciality.equals(chosenSpeciality)){
                        chosenDoctor = doctorSelectionService.selectDoctor(speciality.getDoctors());
                        chosenPatient = patientSelectionService.selectPatient(chosenDoctor.getPatients());
                    }
                }

                if(chosenPatient == null){
                    choosePatientService();
                    return;
                }

                chosenDoctor.treatPatient(chosenPatient);

                boolean isHealed = chosenPatient.isHealed();

                if(isHealed){
                    chosenDoctor.removePatient(chosenPatient);
                }

            }else if(optionNum == 3){
                System.out.println("GOODBYE!!!");
                return;
            }


            choosePatientService();

            return;


        }








    }







