package site.dittotrip.ditto_trip.mainpage.domain.dto;

import lombok.Builder;
import lombok.Data;
import site.dittotrip.ditto_trip.spot.domain.Spot;

@Data
@Builder
public class MainPageSpotData {

    private String name;
    private String imagePath;
    private String path;

    public static MainPageSpotData fromEntitY(Spot spot) {
        return MainPageSpotData.builder()
                .name(spot.getName())
                .imagePath(spot.getImagePath())
                .path("/spot/" + spot.getId())
                .build();
    }

}
