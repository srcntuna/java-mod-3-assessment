package IOServices;

import Entities.Hospital;

import java.io.IOException;
import java.util.List;

public interface IOService {

    public void writeToFile(String fileName, Hospital hospital) throws Exception;

    public Hospital parseFile(String fileName) throws IOException;

}

