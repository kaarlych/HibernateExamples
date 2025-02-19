package pl.zajavka.cache;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class ExampleData {

    static CachedEmployee someEmployee1() {
        return CachedEmployee.builder()
                .name("Agnieszka")
                .surname("Pracownik")
                .salary(new BigDecimal("5910.10"))
                .since(OffsetDateTime.of(2010, 1, 1 , 10, 10, 10, 0, ZoneOffset.UTC))
                .build();
    }

    static CachedEmployee someEmployee2() {
        return CachedEmployee.builder()
                .name("Jan")
                .surname("Kowalski")
                .salary(BigDecimal.valueOf(3910.21))
                .since(OffsetDateTime.of(2011, 1, 1 , 10, 10, 10, 0, ZoneOffset.UTC))
                .build();
    }

    static CachedEmployee someEmployee3() {
        return CachedEmployee.builder()
                .name("Marek")
                .surname("Nowak")
                .salary(BigDecimal.valueOf(6543.21))
                .since(OffsetDateTime.of(2012, 1, 1 , 10, 10, 10, 0, ZoneOffset.UTC))
                .build();
    }
}
