import BuilderServices.*;
import Entities.Hospital;
import IOServices.IOService;
import IOServices.JsonIOService;
import InputServices.ScannerUserInputService;
import InputServices.SysoutUserOutputService;
import InputServices.UserInputService;
import InputServices.UserOutputService;

public class HospitalWorld {
    public static void main(String[] args) {
        UserOutputService userOutputService = new SysoutUserOutputService();
        try (UserInputService userInputService = new ScannerUserInputService(userOutputService);) {

            HospitalSelectionServices hospitalSelectionServices = new HospitalSelectionServices(userInputService);
            Hospital hospital = hospitalSelectionServices.selectHospital();

            System.out.println("Hospital is ready!!");

            PatientSelectionService patientSelectionService = new PatientSelectionService(userInputService);
            PatientBuilderService patientBuilderService = new PatientBuilderService(userInputService);


            PatientServices patientServices = new PatientServices(patientBuilderService,userInputService,patientSelectionService,hospital);
            patientServices.choosePatientService();

            IOService ioService = new JsonIOService();
            ioService.writeToFile("hospital.json",hospital);

            return;








        } catch (Exception e) {
            e.printStackTrace();
        }




    }
    }

