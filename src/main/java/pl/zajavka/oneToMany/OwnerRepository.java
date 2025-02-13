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

    List<Owner> findAll() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "FROM Owner";
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

    int updateHQL(final String oldEmail, final String newPhone, final String newEmail) {
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
                    UPDATE Owner ow
                    SET ow.phone = :newPhone, ow.email = :newEmail
                    WHERE ow.email = :oldEmail
                    """;
            Query query = entityManager.createQuery(hql)
                    .setParameter("oldEmail", oldEmail)
                    .setParameter("newPhone", newPhone)
                    .setParameter("newEmail", newEmail);

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

    int deleteHQL(final String email) {
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
                    DELETE FROM Owner ow
                    WHERE ow.email = :email
                    """;
            Query query = entityManager.createQuery(hql)
                    .setParameter("email", email);

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

    List<Owner> selectExample1() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "FROM Owner";
            List<Owner> owners = session.createQuery(query, Owner.class).getResultList();
            session.getTransaction().commit();
            return owners;
        }
    }

    List<OwnerTemp> selectExample2() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String selectExample2 = "SELECT new pl.zajavka.oneToMany.OwnerTemp(ow.id, ow.name) FROM Owner ow";
            List<OwnerTemp> resultList = session.createQuery(selectExample2, OwnerTemp.class).getResultList();

            session.getTransaction().commit();
            return resultList;
        }
    }

    List<Owner> selectExample3() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String selectExample3 = """
                    SELECT ow FROM Owner ow WHERE ow.email LIKE :email
                    """;
            List<Owner> resultList = session.createQuery(selectExample3, Owner.class)
                    .setParameter("email", "stefan@zajavka.pl")
                    .getResultList();

            session.getTransaction().commit();
            return resultList;
        }
    }

    List<Owner> selectExample4() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String selectExample3 = """
                    SELECT ow FROM Owner ow ORDER BY ow.email ASC, ow.name DESC
                    """;
            List<Owner> resultList = session.createQuery(selectExample3, Owner.class)
                    .getResultList();

            session.getTransaction().commit();
            return resultList;
        }
    }

    List<Owner> selectExample5() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String select5_1 = """
                    SELECT ow FROM Owner ow ORDER BY ow.email DESC
                    """;
            List<Owner> resultList = session.createQuery(select5_1, Owner.class)
                    .setFirstResult(0)
                    .getResultList();

            session.getTransaction().commit();
            return resultList;
        }
    }

    void selectExample7() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String select7_1 = "SELECT ow FROM Owner ow JOIN FETCH ow.pets pt";
            session.createQuery(select7_1, Owner.class)
                            .getResultList()
                                    .forEach(entity -> System.out.println("###Entity: " + entity));

            session.getTransaction().commit();
        }
    }

    void selectExample8() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String select8 = """
                    SELECT ow FROM Owner ow
                    INNER JOIN FETCH ow.pets pt
                    INNER JOIN FETCH pt.toys ts
                    """;

            session.createQuery(select8, Owner.class)
                            .getResultList()
                                    .forEach(entity -> System.out.println("###Entity: " + entity));

            session.getTransaction().commit();
        }
    }

    void selectExample9() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String select9 = """
                    SELECT COUNT(t.toyId) FROM Toy t
                    """;

            session.createQuery(select9, Owner.class)
                    .getResultList()
                    .forEach(entity -> System.out.println("###Entity: " + entity));

            session.getTransaction().commit();
        }
    }

    void selectExampleNamedQuery(String email) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            session.createNamedQuery("Owner.findOwnerByEmail", Owner.class)
                    .setParameter("email", email)
                    .getResultList()
                    .forEach(entity -> System.out.println("###Entity: " + entity));

            session.getTransaction().commit();
        }
    }

    void saveTestData() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            //toy creation and saving
            Toy toy1 = ExampleData.someToy1();
            Toy toy2 = ExampleData.someToy2();
            Toy toy3 = ExampleData.someToy3();
            Toy toy4 = ExampleData.someToy4();
            session.persist(toy1);
            session.persist(toy2);
            session.persist(toy3);
            session.persist(toy4);

            //Pet creation and saving
            Pet pet1 = ExampleData.somePet1();
            Pet pet2 = ExampleData.somePet2();
            Pet pet3 = ExampleData.somePet3();
            Pet pet4 = ExampleData.somePet4();
            pet1.setToys(Set.of(toy1, toy2));
            pet2.setToys(Set.of(toy3, toy4));
            pet3.setToys(Set.of(toy1, toy2, toy3));
            pet3.setToys(Set.of(toy2, toy3, toy4));

            //Owner creation and saving
            Owner owner1 = ExampleData.someOwner1();
            Owner owner2 = ExampleData.someOwner2();
            owner1.setPets(Set.of(pet1, pet2));
            owner2.setPets(Set.of(pet3, pet4));
            owner1.getPets().forEach(pet -> pet.setOwner(owner1));
            owner2.getPets().forEach(pet -> pet.setOwner(owner2));
            session.persist(owner1);
            session.persist(owner2);
            session.getTransaction().commit();
        }
    }

    void selectExampleN1() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            String hql = "SELECT ow FROM Owner ow JOIN FETCH ow.pets pt";

            session.createQuery(hql, Owner.class)
                            .getResultList()
                    .forEach(entity -> System.out.println("###Entity: " + entity));

            session.getTransaction().commit();
        }
    }
}
