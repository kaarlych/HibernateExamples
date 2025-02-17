package pl.zajavka.oneToOne;

import pl.zajavka.HibernateUtil;

public class ExampleRunner {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();

        customerRepository.deleteAll();

        Customer customer1 = customerRepository.insertCustomer(ExampleData.someCustomer1());
        Customer customer2 = customerRepository.insertCustomer(ExampleData.someCustomer2());

//        customerRepository.getCustomer(customer1.getId()).orElseThrow();
//        customerRepository.getCustomer(customer2.getId()).orElseThrow();
//
//        System.out.println("c1 == c2: " + (customer1 == customer2));
//        System.out.println("c1.equals(c2): " + customer1.equals(customer2));


//        customerRepository.listCustomers()
//                .forEach(customer -> System.out.println("###Customer listing: " + customer));

        //System.out.println("###Customer1: " + customerRepository.getCustomer(customer1.getId()));
//        System.out.println("###Customer2: " + customerRepository.getCustomer(customer2.getId()));

//        Address newAddress = Address.builder()
//                .country("Poland")
//                .city("Sopot")
//                .postalCode("81-367")
//                .address("Mlynska 2")
//                .build();
//
//        customerRepository.updateCustomer(customer1, newAddress);
//        System.out.println("###Customer update: " + customerRepository.getCustomer(customer1.getId()));
//
//        customerRepository.listCustomers()
//                        .forEach(customer -> System.out.println("###Customer listing: " + customer));
//
//        customerRepository.deleteCustomer(customer2);
//
//        customerRepository.listCustomers()
//                        .forEach(customer -> System.out.println("###Customer listing: " + customer));
//


        HibernateUtil.closeSessionFactory();
    }
}
