package site.dittotrip.ditto_trip.spot.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;
import site.dittotrip.ditto_trip.category.domain.Category;

import java.time.LocalTime;

@Entity
@NoArgsConstructor
@Getter
public class Spot {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "spot_id")
    private Long id;

    private String spotName;
    // 이미지 URI
    private String intro;
    private String address;
    private LocalTime startTime;
    private LocalTime endTime;
    private String phoneNumber;
    private String homeUri;
    private Point point;

}
