package site.dittotrip.ditto_trip.mainpage.domain.dto;

import lombok.Data;
import site.dittotrip.ditto_trip.category.domain.dto.CategoryMiniData;
import site.dittotrip.ditto_trip.spot.domain.dto.SpotData;

import java.util.ArrayList;
import java.util.List;

@Data
public class MainPageRes {

    // 랜덤 스팟 1개 -> 디자인 문제
    private MainPageSpotData randomSpotData;

    // 랜덤 카테고리 5개
    private List<MainPageCategoryData> randomCategoryDataList = new ArrayList<>();

    // 리뷰 rating 기반 주간 hot spot 6개 -> redis ?
    private List<MainPageSpotData> hotSpotDataList = new ArrayList<>();

}
