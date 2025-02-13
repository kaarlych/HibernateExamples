package pl.zajavka.oneToMany;

import pl.zajavka.HibernateUtil;

import java.util.Set;

import static pl.zajavka.oneToMany.ExampleData.*;

public class OneToManyRunner {

    public static void main(String[] args) {

        OwnerRepository ownerRepository = new OwnerRepository();
        PetRepository petRepository = new PetRepository();

        ownerRepository.selectExampleN1();

//        ownerRepository.deleteAll();
//        petRepository.deleteAll();
//
//        ownerRepository.insertData(someOwner1(), Set.of(somePet1(), somePet2()));
//        ownerRepository.insertData(someOwner2(), Set.of(somePet3(), somePet4()));
//        ownerRepository.insertData(someOwner3(), Set.of());
//        ownerRepository.insertData(someOwner4(), Set.of());
//        ownerRepository.insertData(someOwner5(), Set.of());
//        ownerRepository.insertData(someOwner6(), Set.of());
//
//        petRepository.insertData(somePet5());
//        petRepository.insertData(somePet6());

        HibernateUtil.closeSessionFactory();

//        ownerRepository.deleteAll();

//        Owner owner1 = ownerRepository.insertData(
//                ExampleData.someOwner1(),
//                Set.of(ExampleData.somePet1(), ExampleData.somePet2())
//        );
//
//        Owner owner2 = ownerRepository.insertData(
//                ExampleData.someOwner2(),
//                Set.of(ExampleData.somePet3(), ExampleData.somePet4())
//        );
//
//        ownerRepository.listOwners()
//                .forEach(owner -> System.out.println("###Owner listing: " + owner));
//
//        System.out.println("###Owner1 " +  ownerRepository.getOwner(owner1.getId()));
//        System.out.println("###Owner2 " + ownerRepository.getOwner(owner2.getId()));
//
//        Pet newPet = Pet.builder().name("Drapek").breed(Breed.MONKEY).owner(owner1).build();
//        ownerRepository.updateOwner(owner1.getId(), newPet);
//        System.out.println("###Owner1 after update: " + ownerRepository.getOwner(owner1.getId()));
//        ownerRepository.listOwners()
//                .forEach(owner -> System.out.println("###Owner listing: " + owner));
//        ownerRepository.orphanRemovalExample(owner1.getId());
//        ownerRepository.listOwners()
//                .forEach(owner -> System.out.println("###Owner listing: " + owner));
//
//        HibernateUtil.closeSessionFactory();

    }
}
