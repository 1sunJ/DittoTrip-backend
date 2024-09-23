package site.dittotrip.ditto_trip.mainpage.domain.dto;

import lombok.Builder;
import lombok.Data;
import site.dittotrip.ditto_trip.category.domain.Category;

@Data
@Builder
public class MainPageCategoryData {

    private String name;
    private String imagePath;
    private String path;

    public static MainPageCategoryData fromEntity(Category category) {
        return MainPageCategoryData.builder()
                .name(category.getName())
                .imagePath(category.getImagePath())
                .path("/category/" + category.getId() + "/spot/list") // 파라미터 처리 잘 해야 함 ★★★
                .build();
    }

}
