package pl.zajavka;

public class Main {
    public static void main(String[] args) {

        // HIBERNATE
        // powstal w 2001 roku, Gevin King
        // wykracza poza standard JPA
        // narzedzie ORM open source
        // nowy poziom abstrakcji ktory obudowuje JDBC
        // ulatwia utrzymanie aplikacji - mniej kodu
        // poprawia wydajnosc aplikacji miedzy innymi przez mechanizm cashowania
        // pozwala na pewna niezaleznosc od database management systemu - zna sqlki danego silnika bazodanowego

        // Hibernate vs JDBC
        // Hibernate jest odpowiedzialny za mapowanie obiektowo-relacyjne
        // JDBC to tylko zestaw interfejsow do polaczenia sie z baza danych w Javie

        // Hibernate vs JPA
        // JPA jest specyfikacja dla dostawcow warstwy persystencji
        // Hibernate jest implementacja specyfikacji JPA
        // Hibernate to tak naprawde JPA z implementacja hibernate
        // jezeli uzywamy JPA to w kazdym mozliwym czasie teretycznie powinnismy moc zmienic implementacje
        
    }
}
