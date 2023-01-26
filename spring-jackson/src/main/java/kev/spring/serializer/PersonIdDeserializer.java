package kev.spring.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import kev.spring.model.PersonId;

import java.io.IOException;

public class PersonIdDeserializer extends JsonDeserializer<PersonId> {


    @Override
    public PersonId deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        PersonId personId = new PersonId();

        personId.setId(jsonNode.asInt());
        return personId;
    }
}
