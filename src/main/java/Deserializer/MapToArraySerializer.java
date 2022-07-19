package Deserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Map;

public class MapToArraySerializer extends JsonSerializer<Map<?, ?>> {

    @Override
    public void serialize(Map<?, ?> value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException {
        gen.writeStartArray();
        for (Map.Entry<?, ?> entry : value.entrySet()) {
            gen.writeStartArray();
            gen.writeObject(entry.getKey());
            gen.writeObject(entry.getValue());
            gen.writeEndArray();
        }
        gen.writeEndArray();
    }

}
