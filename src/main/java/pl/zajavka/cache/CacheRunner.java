package pl.zajavka.cache;

public class CacheRunner {

    public static void main(String[] args) {

        CachedEmployeeRepository employeeRepository = new CachedEmployeeRepository();

        employeeRepository.deleteAll();

        CachedEmployee employee1 = ExampleData.someEmployee1();
        CachedEmployee employee2 = ExampleData.someEmployee2();
        CachedEmployee employee3 = ExampleData.someEmployee3();


        employeeRepository.insertData(employee1);
        employeeRepository.insertData(employee2);
        employeeRepository.insertData(employee3);

        employeeRepository.l1c(employee1.getEmployeeId());
    }
}
