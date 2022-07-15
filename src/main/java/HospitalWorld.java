import BuilderServices.DoctorBuilderService;
import BuilderServices.HospitalBuilderService;
import BuilderServices.PatientBuilderService;
import Entities.Hospital;
import InputServices.ScannerUserInputService;
import InputServices.SysoutUserOutputService;
import InputServices.UserInputService;
import InputServices.UserOutputService;

public class HospitalWorld {
    public static void main(String[] args) {
        UserOutputService userOutputService = new SysoutUserOutputService();
        try (UserInputService userInputService = new ScannerUserInputService(userOutputService);) {

            System.out.println("Hospital is ready!");





        } catch (Exception e) {
            e.printStackTrace();
        }




    }
    }

