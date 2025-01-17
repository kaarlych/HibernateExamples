package pl.zajavka;

public class Main {
    public static void main(String[] args) {
        // OOP - Object-Oriented-Programming
        // ORM - Object-Relational-Mapping
        // zalety - mniejsza ilosc kodu i przyspieszony proces tworzenia oprogramowania
        // - DRY - eliminacja potrzeby powtarzania kodu
        // - zwieksza bezpieczenstwo utrudniajac przeprowadzenie SQL Injection
        //  mozna zmienic baze danych bez zmian w kodzie ( przykladowo z Postgres na Oracle)
        // wady - gorsza wydajnosc dla skomplikowanych zapytan
        // - utrata kontroli przez programiste nad wieloma rzeczami
        // Eclipse Link, TopLink, Hibernate
        // Entity - encja - w odniesieniu do POJO - klasaa uzywania w mapowaniu do bazy danych
        // encja - klasa albo obiekt ktory bedzie uzuwany w mapowaniu pomiedzy java a baza danych
        // JDBC - APi ktore umozliwia nam podstawowe narzedzia do polaczenia sie do bazy danych w Javie

        // JPA (Jakarta Persistance API) - standard okreslajacy w jaki sposob program java ma sie komunikowac
        // z relacyjna baza danych
        // specyfikacja ktora uwzglednia to jak obiekty w javie maja byc mapowane na tabele w bazie danych
        // jakarta.persistance
        // jak chcemy korzystac to trzeba dodac te interfejsy
        // specyfikacja JPA - w jaki sposob mapwac biekty javowe na obiekty bazodanowe
        // wspomaga pperacje CRUD - Create, Read, Update, Delete

        // JPA vs JDBC
        // najbardziej znanym vendorem JPA jest wlasnie Hibernate
        // JPA - ustandaryzowana specyfikacja dla podejscia ORM
        // dostawca JPA - jednym z nich jest Hibernate

        // Persistance Unit - definiuje zestaw wsztstkich klas encji ktore maja byc zarzadzane przez manager
        // mamy plik persistence.xml -


    }
}
