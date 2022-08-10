package kev.spring.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class PersonTestSerialize {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void pojoToJsonString() throws JsonProcessingException {
        Person person = new Person();
        person.setName("KB");
        person.setAge(27);
        person.setSkillList(Arrays.asList("Java", "C++"));

        String json = objectMapper.writeValueAsString(person);
        System.out.println(json);
        String expectedJson = "{\"name\":\"KB\",\"age\":27,\"skillList\":[\"Java\",\"C++\"]}";
        Assertions.assertEquals(json, expectedJson);
    }
}