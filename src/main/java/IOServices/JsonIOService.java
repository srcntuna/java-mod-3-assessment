package IOServices;

import Entities.Hospital;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonIOService implements IOService {

    public void writeToFile(String fileName, Hospital hospital) throws Exception {

//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValue(new File("hospital.json"), hospital);

        String json = new ObjectMapper().writeValueAsString(hospital);
        System.out.println(json);



    }


    @Override
    public Hospital parseFile(String fileName) throws IOException {

        Hospital restoredHospital = null;
        try{

            restoredHospital = new ObjectMapper().readValue(new File( "hospital.json"), Hospital.class);

        } catch (Exception e){
            return restoredHospital;
        }
        return restoredHospital;
    }
}