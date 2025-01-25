package pl.zajavka;

import java.math.BigDecimal;

public class EmployeeExample {

    public static void main(String[] args) {

        // Relacje
        // one to one = rekord w jednej encji jest powiazany dokladnie z jednym rekordem w jednej encji
        // jeden czlowiek moze miec tylko jedno serce i serce moze miec tylko jednego czlowieka
        // jeden kraj ma jedna stolice etc...
        // one to many
        // kraj ma wiele miast ale miasto moze znajdowac sie w jednym kraju
        // mieszkanie moze miec wiele lazienek ale lazienka moze byc tylko w jednym mieszkaniu
        // many to many
        // produkt moze byc zakupiony przez wielu konsumentow i wiele konsumentow moze kupic produkt
        // na jednej plycie moze byc wiele filmow DVD i jeden film DVD moze byc na wielu plytach

        // unidirectional vs bidirectional
        // bidirectional sa preferowane


        EmployeeRepository employeeRepository = new EmployeeRepository();

        employeeRepository.deleteAll();

        Employee employee1 = employeeRepository.insert(EmployeeData.someEmployee1());
        Employee employee2 = employeeRepository.insert(EmployeeData.someEmployee2());
        Employee employee3 = employeeRepository.insert(EmployeeData.someEmployee3());

        System.out.println("###Employee1: " + employeeRepository.getEmployee(employee1.getEmployeeId()));
        System.out.println("###Employee2: " + employeeRepository.getEmployee(employee2.getEmployeeId()));

        employeeRepository.updateEmployee(employee3.getEmployeeId(), new BigDecimal("10543.12"));
        System.out.println("###Employee updated: " + employeeRepository.getEmployee(employee3.getEmployeeId()));

        employeeRepository.listEmployee()
                .forEach(employee -> System.out.println("###Employee: " + employee));

        employeeRepository.deleteEmployee(employee2.getEmployeeId());

        employeeRepository.listEmployee()
                .forEach(employee -> System.out.println("###Employee: " + employee));

        HibernateUtil.closeSessionFactory();

    }
}
