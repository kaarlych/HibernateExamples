package pl.zajavka.oneToMany;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@ToString(exclude = "pets")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "toy")
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "toy_id")
    private Integer toyId;

    @Column(name = "what")
    private String what;

    @Column(name = "color")
    private String color;

    @ManyToMany(mappedBy = "toys")
    private Set<Pet> pets;

}
