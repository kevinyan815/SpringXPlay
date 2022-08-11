package kev.spring.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import kev.spring.serializer.PersonIdDeserializer;
import kev.spring.serializer.PersonIdSerializer;
import lombok.Data;

import java.util.List;

@Data
public class OmniPerson {
    @JsonSerialize(using = PersonIdSerializer.class)
    @JsonDeserialize(using = PersonIdDeserializer.class)
    private PersonId personId;
    private String name;
    private Integer age;
    private List<String> skillList;
}
