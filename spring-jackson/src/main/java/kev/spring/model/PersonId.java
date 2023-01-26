package kev.spring.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import kev.spring.serializer.PersonIdSerializer;
import lombok.Data;

@Data
public class PersonId {
    private int id;
}
