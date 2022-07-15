package IOServices;

import Entities.Hospital;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public class JsonIOService implements IOService {
//
//    public void writeToFile(String fileName, Hospital hospital) throws Exception {
//
//        String json = new ObjectMapper().writeValueAsString(hospital);
//
//        try (FileWriter fileWriter = new FileWriter(fileName);) {
//
//            fileWriter.write(json);
//        } catch (IOException ioException) {
//            ioException.printStackTrace();
//        }
//
//
//    }
//
//
//    @Override
//    public Hospital parseFile(String fileName) throws IOException {
//
//        List<Person> restoredPersons = null;
//
//        try{
//            restoredPersons = new ArrayList<>(Arrays.asList(new ObjectMapper().readValue(new File(fileName), Person[].class)));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        return restoredPersons;
//
//    }
//}