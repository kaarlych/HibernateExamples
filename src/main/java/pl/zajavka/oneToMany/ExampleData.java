package pl.zajavka.oneToMany;

public class ExampleData {

    static Owner someOwner1() {
        return Owner.builder()
                .name("Stefan")
                .surname("Nowacki")
                .phone("+48 589 245 114")
                .email("stefan@zajavka.pl")
                .build();
    }

    static Owner someOwner2() {
        return Owner.builder()
                .name("Adrian")
                .surname("Paczkomat")
                .phone("+48 894 256 331")
                .email("adrian@zajavka.pl")
                .build();
    }

    static Owner someOwner3() {
        return Owner.builder()
                .name("Kuba")
                .surname("Fischbach")
                .phone("+48 666 666 666")
                .email("kubafischbach@zajavka.pl")
                .build();
    }

    static Owner someOwner4() {
        return Owner.builder()
                .name("Milosz")
                .surname("Rendzio")
                .phone("+48 777 777 777")
                .email("miloszrendzio@zajavka.pl")
                .build();
    }

    static Owner someOwner5() {
        return Owner.builder()
                .name("Piotr")
                .surname("Olewinski")
                .phone("+48 444 444 444")
                .email("piotrolewinski@zajavka.pl")
                .build();
    }

    static Owner someOwner6() {
        return Owner.builder()
                .name("Marcel")
                .surname("Kawalec")
                .phone("+48 555 555 555")
                .email("piotrolewinski@zajavka.pl")
                .build();
    }

    static Pet somePet1() {
        return Pet.builder()
                .name("Fafik")
                .breed(Breed.DOG)
                .build();
    }

    static Pet somePet2() {
        return Pet.builder()
                .name("Kicikek")
                .breed(Breed.CAT)
                .build();
    }

    static Pet somePet3() {
        return Pet.builder()
                .name("Szymek")
                .breed(Breed.MONKEY)
                .build();
    }

    static Pet somePet4() {
        return Pet.builder()
                .name("Gucio")
                .breed(Breed.DOG)
                .build();
    }

    static Pet somePet5() {
        return Pet.builder()
                .name("Lilka")
                .breed(Breed.CAT)
                .build();
    }

    static Pet somePet6() {
        return Pet.builder()
                .name("Roy")
                .breed(Breed.DOG)
                .build();
    }

    public static Toy someToy1() {
        return null;
    }

    public static Toy someToy2() {
        return null;
    }

    public static Toy someToy3() {
        return null;
    }

    public static Toy someToy4() {
        return null;
    }
}
