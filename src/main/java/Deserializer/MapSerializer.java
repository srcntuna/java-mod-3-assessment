package Deserializer;

import Entities.Doctor;
import Entities.Speciality;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Set;

public class MapSerializer extends JsonSerializer<Speciality> {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void serialize(Speciality value, JsonGenerator gen, SerializerProvider serializers) throws IOException,JsonProcessingException {

        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, value);
        gen.writeFieldName(writer.toString());

    }
}
