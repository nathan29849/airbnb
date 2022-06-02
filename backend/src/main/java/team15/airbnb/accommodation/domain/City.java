package team15.airbnb.accommodation.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum City {
    SEOUL("서울"),
    GWANGJU("광주"),
    UIJEONGBU("의정부"),
    SUWON("수원"),
    DAEGU("대구"),
    ULJIN("울진"),
    DAEJUN("대전"),
    BUCHEON("부천");


    private final String name;
}
