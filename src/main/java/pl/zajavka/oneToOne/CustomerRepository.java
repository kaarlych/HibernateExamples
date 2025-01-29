package pl.zajavka.oneToOne;

import pl.zajavka.HibernateUtil;

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
        }
    }

    List<Customer> listCustomers() {
        try (var session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "SELECT cust FROM Customer cust";
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
}
