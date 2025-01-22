package pl.zajavka;

public class Main {
    public static void main(String[] args) {

        // database objects:
        // tabele
        // constraints
        // indeksy
        // widoki

        // database schema - w obrebie bazy danych mozna tworzyc schematy
        // schemat w bazie danych jest przestrzenia, ktora zawiera tabele funkcje procedury etc
        // select * from other.employee
        // public jest schematem domyslnym
        // schmaty pomagaja nam lepiej pogrupowac dane w logiczne grupy

        // create schema company;
        // create schema users;
        // schemat sluzy do lepszej organizacji danych w bazie danych

        // indeks - wskaznik do danych w tabeli
        // przyspiesza zapytanie d bazy danych, przyspiesza dostep
        // create index idx_car_brand on car(brand, model)
        // indekswanie kolumn po ktorych najczesciej wyszukujemy typu email dla uzytkownika
        // indexy sa automatycznie robione dla kluczy glownych

        // view - widok - obiekt definiwany przez okreslne zapytanie
        // okno na dane/wirtualna tabela
        // widoki sluza tylko do odczytu, nie zajmuja dodatkoweg miejsca na dysku
        // create view person_view as select id, namespace from person p where age < 10
        // wada moze byc taka ze widok nie przechowuje danych
        // potrafi zuzyc wiele zasbow

    }
}
