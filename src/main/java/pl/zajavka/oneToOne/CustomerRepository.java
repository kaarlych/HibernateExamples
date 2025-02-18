package pl.zajavka.oneToOne;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.ParameterExpression;
import jakarta.persistence.criteria.Root;
import org.hibernate.JDBCException;
import org.hibernate.query.Query;
import pl.zajavka.HibernateUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CustomerRepository {

    Customer insertCustomer(final Customer customer) {
        try (var session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE INSERT CUSTOMER\n----------------------------");
            session.beginTransaction();
            session.persist(customer);
            session.getTransaction().commit();
            System.out.println("----------------------------------\n###AFTER INSERT CUSTOMER");
            return customer;
        } catch (PersistenceException ex) {
            JDBCException jdbcException = (JDBCException) ex.getCause();
            System.err.println("jdbcException.getSQL()): " + jdbcException.getSQL());
            System.err.println("jdbcException.getSQLState()): " + jdbcException.getSQLState());
            SQLException sqlException = jdbcException.getSQLException();
            System.err.println("sqlException.getErrorCode()): " + sqlException.getErrorCode());
            System.err.println("sqlException.getMessage()): " + sqlException.getMessage());
            return null;
        }
    }

    List<Customer> findAllCustomers() {
        try (var session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "FROM Customer";
            List<Customer> customers = session.createQuery(query, Customer.class).getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }

    Optional<Customer> getCustomer(final Integer id) {
        try (var session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            return Optional.ofNullable(session.find(Customer.class, id));
        }
    }

    void updateCustomer(final Customer customer, Address newAddress) {
        try (var session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            Customer customerFromDb = session.find(Customer.class, customer.getId());
            customer.setAddress(newAddress);
            session.getTransaction().commit();
        }
    }

    void deleteCustomer(final Customer customer) {
        try (var session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.remove(session.find(Customer.class, customer.getId()));
            session.getTransaction().commit();
        }
    }

    void deleteAll() {
        try (var session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "SELECT cust FROM Customer cust";
            session.createQuery(query, Customer.class).getResultList().forEach(session::remove);
            session.getTransaction().commit();
        }
    }

    void testSession(final int customerId) {
        try (var session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            Customer customer1 = session.find(Customer.class, customerId);
            Customer customer2 = session.find(Customer.class, customerId);

            System.out.println("c1 == c2: " + (customer1 == customer2));
            System.out.println("c1.equals(c2): " + customer1.equals(customer2));

            session.getTransaction().commit();
        }
    }

    void criteriaExample() {
        try (var session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            System.out.println("### Before Criteria --------------------------------");

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
            Root<Customer> root = criteriaQuery.from(Customer.class);
            ParameterExpression<String> parameter1 = criteriaBuilder.parameter(String.class);


            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), parameter1));

            Query<Customer> query = session.createQuery(criteriaQuery);
            query.setParameter(parameter1, "adrian@zajavka.pl ");
            List<Customer> resultList = query.getResultList();
            System.out.println("### After Criteria --------------------------------");
            resultList.forEach(entity -> System.out.println("###Entity: " + entity));

            session.getTransaction().commit();
        }
    }
}

