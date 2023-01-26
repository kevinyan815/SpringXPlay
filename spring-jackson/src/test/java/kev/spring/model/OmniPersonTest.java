package kev.spring.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class OmniPersonTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void OmniPersonToJson() throws JsonProcessingException {
        OmniPerson omniPerson = new OmniPerson();
        PersonId personId = new PersonId();
        personId.setId(1);
        omniPerson.setPersonId(personId);
        omniPerson.setAge(22);
        omniPerson.setName("Calvin");
        ArrayList<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("C++");
        omniPerson.setSkillList(skills);
        String json = objectMapper.writeValueAsString(omniPerson);
        System.out.println(json);
    }

    @Test
    public void JsonToOmniPerson() throws JsonProcessingException {
        // 不使用自定义 Deserializer 时，JSON 必须符合OmniPerson的类型结构
        // String jsonStr = "{\"personId\":{\"id\": 1},\"name\":\"Calvin\",\"age\":22,\"skillList\":[\"Java\",\"C++\"]}";
        // 下面使用自定义 Deserializer
        String jsonStr = "{\"personId\": 1,\"name\":\"Calvin\",\"age\":22,\"skillList\":[\"Java\",\"C++\"]}";
        OmniPerson omniPerson = objectMapper.readValue(jsonStr, OmniPerson.class);
        System.out.println(omniPerson);
    }

}