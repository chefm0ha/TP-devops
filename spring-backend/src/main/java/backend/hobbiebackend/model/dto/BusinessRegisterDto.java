package backend.hobbiebackend.model.dto;

import lombok.Data;

@Data
public class BusinessRegisterDto {
    private String username;
    private String businessName;
    private String address;
    private String email;
    private String password;
}
