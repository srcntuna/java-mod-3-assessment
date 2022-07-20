import BuilderServices.*;
import Entities.Hospital;
import IOServices.IOService;
import IOServices.JsonIOService;
import InputServices.ScannerUserInputService;
import InputServices.SysoutUserOutputService;
import InputServices.UserInputService;
import InputServices.UserOutputService;
import SelectionServices.HospitalSelectionServices;
import SelectionServices.DoctorSelectionService;
import PatientServices.PatientServices;
import Utils.HospitalTrackerService;

import java.util.List;

public class HospitalWorld {
    public static void main(String[] args) {
        UserOutputService userOutputService = new SysoutUserOutputService();
        try (UserInputService userInputService = new ScannerUserInputService(userOutputService);HospitalTrackerService hospitalTracker = new HospitalTrackerService(); IOService jsonIOService = new JsonIOService();) {

            System.out.println("WELCOME!");
            System.out.println("1.Select existing hospital");
            System.out.println("2.Create a new hospital");
            String optionStr = userInputService.getUserInput("....");
            int optionNum = Integer.parseInt(optionStr);
            List<String> hospitalList =  hospitalTracker.parseFile("hospitalList.csv");
            Hospital currHospital;
            PatientBuilderService patientBuilderService = null;
            if(optionNum == 1 && hospitalList != null){

                HospitalSelectionServices hospitalSelectionServices = new HospitalSelectionServices(userInputService,jsonIOService);
                currHospital = hospitalSelectionServices.selectHospital(hospitalList);
                patientBuilderService = new PatientBuilderService(userInputService,currHospital);

            }else{

                HospitalBuilderService hospitalBuilderService = new HospitalBuilderService(userInputService);
                Hospital newHospital = hospitalBuilderService.createHospital();
                DoctorBuilderService doctorBuilderService = new DoctorBuilderService(userInputService,newHospital);
                MultipleDoctorBuilder multipleDoctorBuilder = new MultipleDoctorBuilder(userInputService,doctorBuilderService);
                multipleDoctorBuilder.createMultipleDoctors();
                patientBuilderService = new PatientBuilderService(userInputService,newHospital);
                MultiplePatientBuilder multiplePatientBuilder = new MultiplePatientBuilder(userInputService,patientBuilderService);
                multiplePatientBuilder.createMultiplePatients();
                currHospital = newHospital;
                hospitalTracker.addToHospitalList(currHospital.getName());


            }

            System.out.println("Hospital is ready!!");

            PatientServices patientServices = new PatientServices(patientBuilderService,userInputService,currHospital);
            patientServices.choosePatientService();

            hospitalTracker.writeToFile("hospitalList.csv",currHospital);

            jsonIOService.writeToFile(currHospital.getName()+".json",currHospital );

            System.out.println(currHospital.toString());







        } catch (Exception e) {
            e.printStackTrace();
        }




    }
    }

