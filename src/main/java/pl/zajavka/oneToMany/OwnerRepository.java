package pl.zajavka.oneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
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
            System.out.println("###BEFORE INSERT OWNER\n----------------------------");
            session.beginTransaction();
            owner.setPets(pets);
            pets.forEach(pet -> pet.setOwner(owner));
            session.persist(owner);
            session.getTransaction().commit();
            System.out.println("----------------------------------\n###AFTER INSERT OWNER");
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
            System.out.println("###BEFORE GET OWNER\n----------------------------");
            Owner owner = session.find(Owner.class, ownerId);
            System.out.println("----------------------------------\n###AFTER GET OWNER");
            System.out.println("###BEFORE GET PETS\n----------------------------");
            System.out.println(owner.getPets());
            System.out.println("----------------------------------\n###AFTER GET PETS");
            return Optional.of(owner);
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
            System.out.println("###BEFORE DELETE ALL\n----------------------------");
            session.beginTransaction();
            String query = "SELECT owner FROM Owner owner";
            session.createQuery(query, Owner.class).getResultList().forEach(session::remove);
            session.getTransaction().commit();
            System.out.println("----------------------------------\n###AFTER DELETE ALL");
        }
    }

    public void orphanRemovalExample(final Integer ownerId) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE ORPHAN REMOVAL\n----------------------------");
            session.beginTransaction();
            Owner owner = session.find(Owner.class, ownerId);
            Pet petToRemove = owner.getPets().stream().findAny().orElseThrow();
            owner.removePet(petToRemove);
            session.merge(owner);
            session.getTransaction().commit();
            System.out.println("----------------------------------\n###AFTER ORPHAN REMOVAL");
        }
    }

    int insertHQL() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        int result;
        try {
            entityManager = HibernateUtil.getSession();
            if (Objects.isNull(entityManager)) {
                throw new RuntimeException("EntityManager is null");
            }
            transaction = entityManager.getTransaction();
            transaction.begin();
            String hql = """
                    INSERT Owner (name, surname, phone, email)
                    VALUES ('Romek', 'Zabawniacha', '+48 513 435 088', 'romek@zajavka.pl')
                    """;
            Query query = entityManager.createQuery(hql);
            result = query.executeUpdate();
            transaction.commit();
            entityManager.close();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (Objects.nonNull(transaction) && transaction.isActive()) {
                entityManager.close();
            }
        }
        return result;
    }

    int updateHQL() {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        int result;
        try {
            entityManager = HibernateUtil.getSession();
            if (Objects.isNull(entityManager)) {
                throw new RuntimeException("EntityManager is null");
            }
            transaction = entityManager.getTransaction();
            transaction.begin();
            String hql = """
                    INSERT Owner (name, surname, phone, email)
                    VALUES ('Romek', 'Zabawniacha', '+48 513 435 088', 'romek@zajavka.pl')
                    """;
            Query query = entityManager.createQuery(hql);
            result = query.executeUpdate();
            transaction.commit();
            entityManager.close();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (Objects.nonNull(transaction) && transaction.isActive()) {
                entityManager.close();
            }
        }
        return result;
    }
}
