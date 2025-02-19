package pl.zajavka.cache;

import pl.zajavka.HibernateUtil;

public class CacheRunner {

    public static void main(String[] args) {

        CachedEmployeeRepository cachedEmployeeRepository = new CachedEmployeeRepository();

        cachedEmployeeRepository.deleteAll();

        CachedEmployee employee1 = ExampleData.someEmployee1();
        CachedEmployee employee2 = ExampleData.someEmployee2();
        CachedEmployee employee3 = ExampleData.someEmployee3();


        cachedEmployeeRepository.insertData(employee1);
        cachedEmployeeRepository.insertData(employee2);
        cachedEmployeeRepository.insertData(employee3);

        cachedEmployeeRepository.l2c(employee1.getEmployeeId());
        cachedEmployeeRepository.l2c(employee2.getEmployeeId());

        HibernateUtil.closeSessionFactory();
    }
}
