package backend.hobbiebackend.model.dto;

import lombok.Data;

@Data
public class UpdateBusinessDto {
    private Long id;
    private String businessName;
    private String address;
    private String password;
}
