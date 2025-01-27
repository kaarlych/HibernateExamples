package pl.zajavka.oneToMany;

import org.hibernate.Session;
import pl.zajavka.HibernateUtil;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class OwnerRepository {

    Owner insertData(final Owner owner, final Set<Pet> pets) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            owner.setPets(pets);
            pets.forEach(pet -> pet.setOwner(owner));
            session.persist(owner);
            session.getTransaction().commit();
            return owner;
        }
    }

    List<Owner> listOwners() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "SELECT owner FROM Owner owner";
            List<Owner> owners = session.createQuery(query, Owner.class).getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    Optional<Owner> getOwner(final Integer ownerId) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            return Optional.ofNullable(session.find(Owner.class, ownerId));
        }
    }

    void updateOwner(Integer ownerId, Pet newPet) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            Owner owner = session.find(Owner.class, ownerId);
            owner.getPets().add(newPet);
            session.getTransaction().commit();
        }
    }

    void deleteOwner(final Owner owner) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.remove(session.find(Owner.class, owner.getId()));
            session.getTransaction().commit();
        }
    }

    public void deleteAll() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "SELECT owner FROM Owner owner";
            session.createQuery(query, Owner.class).getResultList().forEach(session::remove);
            session.getTransaction().commit();
        }
    }
}
