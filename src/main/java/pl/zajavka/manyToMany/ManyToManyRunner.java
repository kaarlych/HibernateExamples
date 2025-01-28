package pl.zajavka.manyToMany;

import pl.zajavka.HibernateUtil;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ManyToManyRunner {

    public static void main(String[] args) {

        EmployeeRepository employeeRepository = new EmployeeRepository();

        employeeRepository.deleteAll();

        List<Employee> employeesCreated = createEmployees(employeeRepository);

        employeeRepository.listEmployees()
                .forEach(employee -> System.out.println("###Employee listing: " + employee));

        System.out.println("###Employee1: " + employeeRepository
                .getEmployee(employeesCreated.get(employeesCreated.size() - 1).getEmployeeId()));

        System.out.println("###Employee2: " + employeeRepository
                .getEmployee(employeesCreated.get(employeesCreated.size() - 2).getEmployeeId()));

        updateEmployees(employeeRepository, employeesCreated);
        employeeRepository.listEmployees()
                .forEach(employee -> System.out.println("###Employee listing: " + employee));

        employeeRepository.deleteEmployee(employeesCreated.get(employeesCreated.size() - 2));
        employeeRepository.listEmployees()
                .forEach(employee -> System.out.println("###Employee listing: " + employee));

        HibernateUtil.closeSessionFactory();

    }

    private static List<Employee> createEmployees(EmployeeRepository employeeRepository) {
        Project project1 = ExampleData.someProject1();
        Project project2 = ExampleData.someProject2();
        Project project3 = ExampleData.someProject3();
        Employee employee1 = ExampleData.someEmployee1();
        Employee employee2 = ExampleData.someEmployee2();
        Employee employee3 = ExampleData.someEmployee3();
        employee1.setProjects(new ArrayList<>(List.of(project1, project2)));
        employee2.setProjects(new ArrayList<>(List.of(project2)));
        employee3.setProjects(new ArrayList<>(List.of(project2, project3)));
        return employeeRepository.insertEmployees(List.of(employee1, employee2, employee3));
    }

    private static void updateEmployees(
            EmployeeRepository employeeRepository,
            List<Employee> employeesCreated
    ) {
        Employee employeeToBeUpdated = employeesCreated.get(employeesCreated.size() - 1);
        Project newProject = Project.builder()
                .name("Performance optimization")
                .description("Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                .deadline(OffsetDateTime.of(2025, 2, 1, 12, 0, 0, 0, ZoneOffset.UTC))
                .build();

        employeeRepository.updateEmployee(employeeToBeUpdated, newProject);
        System.out.println("###Employee1 after update: " + employeeRepository
                .getEmployee(employeesCreated.get(employeesCreated.size() - 1).getEmployeeId()));
    }

}
