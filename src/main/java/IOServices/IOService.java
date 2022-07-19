package IOServices;

import Entities.Hospital;

import java.io.IOException;

public interface IOService extends AutoCloseable {

    public void writeToFile(String fileName, Hospital hospital) throws Exception;

    public <T> T parseFile(String fileName) throws IOException;

}

