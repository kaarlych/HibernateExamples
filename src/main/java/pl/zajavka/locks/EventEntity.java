package pl.zajavka.locks;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "eventId")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "date_time")
    private OffsetDateTime dateTime;

    @Column(name = "capacity")
    private Integer capacity;

    @OneToMany(mappedBy = "event")
    private Set<TicketEntity> tickets;

    @Version
    private Long version;

    public void addTicket(TicketEntity ticket) {
        ticket.setEvent(this);
        getTickets().add(ticket);
    }
}
