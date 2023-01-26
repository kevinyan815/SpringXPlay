package kev.spring.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import kev.spring.model.PersonId;

import java.io.IOException;

public class PersonIdSerializer extends JsonSerializer<PersonId> {
    @Override
    public void serialize(PersonId personId, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(personId.getId());
//        jsonGenerator.writeStartObject();
//        jsonGenerator.writeNumberField("person_id", personId.getId());
//        jsonGenerator.writeEndObject();
    }
}