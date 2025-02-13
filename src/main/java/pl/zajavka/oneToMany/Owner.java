package pl.zajavka.oneToMany;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "owner")
@NamedQueries(
        {
        @NamedQuery(
                name = "Owner.findAll",
                query = "FROM Owner"
        ),
        @NamedQuery(
                name = "Owner.findOwnerByEmail",
                query = "FROM Owner WHERE email = :email"
        )
        }
)
public class Owner {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "owner_id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)
    @BatchSize(size = 3)
    private Set<Pet> pets;

    public void removePet(final Pet pet) {
        pets.remove(pet);
    }
}
