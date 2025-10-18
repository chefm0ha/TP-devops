package backend.hobbiebackend.model.dto;

import backend.hobbiebackend.model.entities.enums.CategoryNameEnum;
import backend.hobbiebackend.model.entities.enums.LocationEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class HobbyInfoUpdateDto {
    private Long id;
    private String name;
    private String slogan;
    private String intro;
    private String description;
    private CategoryNameEnum category;
    private String creator;
    private BigDecimal price;
    private LocationEnum location;
    private String contactInfo;
    private String profileImgUrl;
    private String galleryImgUrl1;
    private String galleryImgUrl2;
    private String galleryImgUrl3;
    private String profileImgId;
    private String galleryImg1Id;
    private String galleryImg2Id;
    private String galleryImg3Id;
}
