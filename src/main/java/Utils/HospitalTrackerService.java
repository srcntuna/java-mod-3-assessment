package Utils;

import Entities.Hospital;
import IOServices.IOService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalTrackerService implements IOService {

    private List<String> hospitalNames;

    public HospitalTrackerService() {
        this.hospitalNames = new ArrayList<>();

    }

    @Override
    public void writeToFile(String fileName, Hospital hospital) throws Exception {

        StringBuffer stringBuffer = new StringBuffer();

        for (int i=0;i<hospitalNames.size();i++) {

            if(i == hospitalNames.size() -1){
                stringBuffer.append(hospitalNames.get(i));
            }else{
                stringBuffer.append(hospitalNames.get(i) + "\n");
            }

        }

        try (FileWriter fileWriter = new FileWriter(fileName);) {

            fileWriter.write(stringBuffer.toString());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }

    @Override
    public List<String> parseFile(String fileName) throws IOException {

        try(Scanner scanner = new Scanner(new File(fileName))){

            while (scanner.hasNextLine()) {
                String thisLine = scanner.nextLine();

                this.hospitalNames.add(thisLine);
            }

        }catch (Exception e){
            System.out.println("There is no existing hospital!");
            System.out.println("Lets create a new one!");
            return  null;
        }

        return  this.hospitalNames;

    }

    public void addToHospitalList(String hospitalName){
        this.hospitalNames.add(hospitalName);
        System.out.println(hospitalName+" has been added to the hospital list");
    }

    public void removeFromHospitalList(String hospitalName){
        this.hospitalNames.remove(hospitalName);
        System.out.println(hospitalName+" has been removed from hospital list");

    }

    @Override
    public void close() throws Exception {
        System.out.println("IO service is closed");
    }
}
