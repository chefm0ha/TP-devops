package backend.hobbiebackend.model.dto;

import backend.hobbiebackend.model.entities.enums.GenderEnum;
import lombok.Data;

@Data
public class AppClientSignUpDto {
    private String username;
    private String fullName;
    private GenderEnum gender;
    private String email;
    private String password;
}
