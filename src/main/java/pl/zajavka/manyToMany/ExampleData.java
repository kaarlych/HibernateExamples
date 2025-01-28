package pl.zajavka.manyToMany;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class ExampleData {

    static Employee someEmployee1() {
        return Employee.builder()
                .name("Agnieszka")
                .surname("Pracownik")
                .salary(new BigDecimal("5910.10"))
                .since(OffsetDateTime.of(2010, 1, 1 , 10, 10, 10, 0, ZoneOffset.UTC))
                .build();
    }

    static Employee someEmployee2() {
        return Employee.builder()
                .name("Jan")
                .surname("Kowalski")
                .salary(BigDecimal.valueOf(3910.21))
                .since(OffsetDateTime.of(2011, 1, 1 , 10, 10, 10, 0, ZoneOffset.UTC))
                .build();
    }

    static Employee someEmployee3() {
        return Employee.builder()
                .name("Marek")
                .surname("Nowak")
                .salary(BigDecimal.valueOf(6543.21))
                .since(OffsetDateTime.of(2012, 1, 1 , 10, 10, 10, 0, ZoneOffset.UTC))
                .build();
    }

    static Project someProject1() {
        return Project.builder()
                .name("Database migration")
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
                .deadline(OffsetDateTime.of(2027, 10, 3, 12, 0, 0, 0, ZoneOffset.UTC))
                .build();
    }

    static Project someProject2() {
        return Project.builder()
                .name("Some external system integration")
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
                .deadline(OffsetDateTime.of(2025, 10, 3, 12, 0, 0, 0, ZoneOffset.UTC))
                .build();
    }

    public static Project someProject3() {
        return Project.builder()
                .name("Some bullshit")
                .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
                .deadline(OffsetDateTime.of(2028, 10, 3, 12, 0, 0, 0, ZoneOffset.UTC))
                .build();
    }
}
