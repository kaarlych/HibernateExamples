package pl.zajavka.locks;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class EventEntityData {

    static EventEntity someEvent1() {
        return EventEntity.builder()
                .eventName("Event 1")
                .dateTime(OffsetDateTime.of(2021, 10, 3, 12, 0, 0, 0, ZoneOffset.ofHours(2)))
                .capacity(5)
                .build();
    }

    static EventEntity someEvent2() {
        return EventEntity.builder()
                .eventName("Event 2")
                .dateTime(OffsetDateTime.of(2021, 10, 4, 12, 0, 0, 0, ZoneOffset.ofHours(2)))
                .capacity(1)
                .build();
    }
}
