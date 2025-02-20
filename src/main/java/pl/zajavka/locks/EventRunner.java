package pl.zajavka.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventRunner {

    public static void main(String[] args) {

        EventRepository eventRepository = new EventRepository();

        eventRepository.deleteAll();

        EventEntity event1 = eventRepository.createEmptyEvent(EventEntityData.someEvent1());
        EventEntity event2 = eventRepository.createEmptyEvent(EventEntityData.someEvent2());

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            eventRepository.saveNewTicket("Karol", "Janowski", event2.getEventId());
            try {
                Thread.sleep(1_000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            eventRepository.saveNewTicket("Jan", "Kowalski", event2.getEventId());
            try {
                Thread.sleep(1_000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }
}
