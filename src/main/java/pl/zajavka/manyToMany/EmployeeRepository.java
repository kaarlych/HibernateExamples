package pl.zajavka.manyToMany;

import org.hibernate.Session;
import pl.zajavka.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {

    List<Employee> insertEmployees(List<Employee> employees) {
        try (Session session = HibernateUtil.getSession()) {
            if (session == null) {
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE INSERT EMPLOYEES\n----------------------------");
            session.beginTransaction();
            employees.forEach(session::persist);
            session.getTransaction().commit();
            System.out.println("----------------------------------\n###AFTER INSERT EMPLOYEES");
            return employees;
        }
    }

    List<Employee> listEmployees() {
        try (Session session = HibernateUtil.getSession()) {
            if (session == null) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "SELECT emp FROM Employee emp";
            List<Employee> employees = session.createQuery(query, Employee.class).getResultList();
            session.getTransaction().commit();
            return employees;
        }
    }

    Optional<Employee> getEmployee(final Integer id) {
        try (Session session = HibernateUtil.getSession()) {
            if (session == null) {
                throw new RuntimeException("Session is null");
            }
            return Optional.ofNullable(session.find(Employee.class, id));
        }
    }

    void updateEmployee(final Employee employee, Project newProject) {
        try (Session session = HibernateUtil.getSession()) {
            if (session == null) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            session.remove(session.find(Employee.class, employee.getEmployeeId()));
            employee.getProjects().add(newProject);
            session.getTransaction().commit();
        }
    }

    void deleteEmployee(final Employee employee) {
        try (Session session = HibernateUtil.getSession()) {
            if (session == null) {
                throw new RuntimeException("Session is null");
            }
            System.out.println("###BEFORE DELETE EMPLOYEE\n----------------------------");
            session.beginTransaction();
            session.remove(session.find(Employee.class, employee.getEmployeeId()));
            session.getTransaction().commit();
            System.out.println("----------------------------------\n###AFTER DELETE EMPLOYEE");
        }
    }

    void deleteAll() {
        try (Session session = HibernateUtil.getSession()) {
            if (session == null) {
                throw new RuntimeException("Session is null");
            }
            session.beginTransaction();
            String query = "SELECT emp FROM Employee emp";
            session.createQuery(query, Employee.class).getResultList().forEach(session::remove);
            session.getTransaction().commit();
        }
    }
}
