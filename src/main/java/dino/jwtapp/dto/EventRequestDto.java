package dino.jwtapp.dto;

import dino.jwtapp.model.Organization;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class EventRequestDto
{
    private Long id;
    private String name;
    private String shortName;
    private Timestamp dateBegin;
    private Timestamp dateEnd;
    private Organization org;
}
