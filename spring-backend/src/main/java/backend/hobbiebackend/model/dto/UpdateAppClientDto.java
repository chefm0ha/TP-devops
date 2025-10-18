package backend.hobbiebackend.model.dto;

import backend.hobbiebackend.model.entities.enums.GenderEnum;
import lombok.Data;

@Data
public class UpdateAppClientDto {
    private Long id;
    private String fullName;
    private GenderEnum gender;
    private String password;
}
