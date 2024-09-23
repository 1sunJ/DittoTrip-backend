package site.dittotrip.ditto_trip.mainpage.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.dittotrip.ditto_trip.auth.domain.CustomUserDetails;
import site.dittotrip.ditto_trip.mainpage.domain.dto.MainPageRes;
import site.dittotrip.ditto_trip.mainpage.service.MainPageService;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainPageController {

    private final MainPageService mainPageService;

    @GetMapping
    @Operation(summary = "메인 페이지 조회 기능",
            description = "")
    public MainPageRes mainPage(@AuthenticationPrincipal CustomUserDetails userDetails) {
        Long reqUserId = CustomUserDetails.getUserIdFromUserDetails(userDetails, false);
        return mainPageService.findMainPage(reqUserId);
    }

}
