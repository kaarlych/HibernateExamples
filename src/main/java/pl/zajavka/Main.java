package pl.zajavka;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory
                = Persistence.createEntityManagerFactory("zajavkaPersistenceUnitExample");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        String selectQuery = "SELECT p FROM Person p";
//        Query query = entityManager.createQuery(selectQuery);
//        List<Person> people = query.getResultList();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = criteriaBuilder.createQuery(Person.class);
        Root<Person> root = criteriaQuery.from(Person.class);
        criteriaQuery.select(root);
        TypedQuery<Person> query = entityManager.createQuery(criteriaQuery);
        List<Person> people = query.getResultList();

    }
}
