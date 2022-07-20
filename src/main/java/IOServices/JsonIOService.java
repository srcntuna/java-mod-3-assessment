package IOServices;

import Entities.Hospital;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JsonIOService implements IOService {

    public void writeToFile(String fileName, Hospital hospital) throws Exception {

  FileWriter fileWriter = null;
                try {
                    fileWriter = new FileWriter(fileName, false);
                    String json = new ObjectMapper().writeValueAsString(hospital);
                    fileWriter.write(json);
                    fileWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }


    }


    @Override
    public Hospital parseFile(String fileName) throws IOException {

        Hospital restoredHospital = null;
        try{

            restoredHospital = new ObjectMapper().readValue(new File( fileName), Hospital.class);

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return restoredHospital;
    }

    @Override
    public void close() throws Exception {
        System.out.println("JSON file system is closed");
    }
}