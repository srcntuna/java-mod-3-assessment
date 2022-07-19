package Deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ArrayToMapDeserializer extends JsonDeserializer<Map<?, ?>> {

    @Override
    public Map<?, ?> deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        Map map = new LinkedHashMap();

        ObjectCodec oc = p.getCodec();
        JsonNode anode = oc.readTree(p);

        for (int i = 0; i < anode.size(); i++) {
            JsonNode node = anode.get(i);
            map.put(node.get(0), node.get(1));
        }

        return map;
    }
}