package kev.spring.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PersonTestDeserialize {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void jsonStringToPojo() throws JsonProcessingException {
        String expectedJson = "{\"name\":\"KB\",\"age\":27,\"skillList\":[\"Java\",\"Go\"]}";
        Person person = objectMapper.readValue(expectedJson, Person.class);
        System.out.println(person);
        Assertions.assertEquals(person.getName(), "KB");
        Assertions.assertEquals(person.getSkillList().toString(), "[Java, Go]");
    }
}