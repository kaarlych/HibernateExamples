package pl.zajavka;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Integer personID;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    // getters and setters

}
