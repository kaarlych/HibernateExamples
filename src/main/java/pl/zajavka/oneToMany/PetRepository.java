package pl.zajavka.oneToMany;

import org.hibernate.Session;
import pl.zajavka.HibernateUtil;

import java.util.Objects;

public class PetRepository {

    Pet insertData(final Pet pet) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE INSERT\n-----------------------");
            session.beginTransaction();
            session.persist(pet);
            session.getTransaction().commit();
            System.out.println("###AFTER INSERT\n-----------------------");
            return pet;
        }
    }

    public void deleteAll() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE DELETE ALL\n----------------------------");
            session.beginTransaction();
            String query = "SELECT pet FROM Pet pet";
            session.createQuery(query, Pet.class).getResultList().forEach(session::remove);
            session.getTransaction().commit();
            System.out.println("----------------------------------\n###AFTER DELETE ALL");
        }
    }
}
