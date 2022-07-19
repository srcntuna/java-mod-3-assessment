package Deserializer;

import Entities.Speciality;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

import java.io.IOException;

public class MyCustomDeserializer extends KeyDeserializer {
    @Override
    public Speciality deserializeKey(String key, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        //Use the string key here to return a real map key object

        return null;
    }


}