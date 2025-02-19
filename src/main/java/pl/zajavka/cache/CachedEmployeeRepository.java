package pl.zajavka.cache;

import org.hibernate.Session;
import pl.zajavka.HibernateUtil;

import java.util.Objects;

public class CachedEmployeeRepository {

    CachedEmployee insertData(final CachedEmployee employee) {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.persist(employee);
            session.getTransaction().commit();
            return employee;
        }
    }

    void deleteAll() {
        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            session.createQuery("select e from CachedEmployee e", CachedEmployee.class)
                    .getResultList()
                    .forEach(session::remove);

            session.getTransaction().commit();
        }
    }

    void l1c(int employeeId ) {

        try (Session session = HibernateUtil.getSession()) {
            if (Objects.isNull(session)) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();

            CachedEmployee e1 = session.get(CachedEmployee.class, employeeId);
            System.out.printf("###E1: %s %s%n", e1.getName(), e1.getSurname());

            CachedEmployee e2 = session.get(CachedEmployee.class, employeeId);
            System.out.printf("###E1: %s %s%n", e2.getName(), e2.getSurname());

            CachedEmployee e3 = session.get(CachedEmployee.class, employeeId);
            System.out.printf("###E1: %s %s%n", e3.getName(), e3.getSurname());


            session.getTransaction().commit();
        }
    }
}
