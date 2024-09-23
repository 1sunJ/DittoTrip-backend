package site.dittotrip.ditto_trip.mainpage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.dittotrip.ditto_trip.mainpage.domain.dto.MainPageRes;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MainPageService {

    public MainPageRes findMainPage(Long reqUserId) {
        return null;
    }

}
