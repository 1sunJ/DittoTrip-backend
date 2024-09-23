package site.dittotrip.ditto_trip.category.domain.dto;

import lombok.Builder;
import lombok.Data;
import site.dittotrip.ditto_trip.category.domain.Category;

@Data
@Builder
public class CategoryMiniData {

    private Long categoryId;
    private String name;
    private String imagePath;

    public static CategoryMiniData fromEntity(Category category) {
        return CategoryMiniData.builder()
                .categoryId(category.getId())
                .name(category.getName())
                .imagePath(category.getImagePath())
                .build();
    }

}
