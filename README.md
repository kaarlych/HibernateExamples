Zapytania na bazie danych:

         JPQL - specyfikacja JPA definiujaca jezyk zapytan, ktora jest mieszanka SQL i obiektow
         - Jakarta Persistance Query Language
         - jezyk bardzo podobny do sql ale bedziemy operowali na obiektach
         - HQL - Hibernate Query Language - podzbior JPQL
         - wada HQL jest to ze jest podobny do SQL i ludzie czesto myla go z SQL
         - HQL ma wlasna gramatyke w postaci Stringa
         - HQL nie sluzy do modyfikacji bazy danych, sluzy tylko do CRUDow
         - sa tlumaczone przez Hibernate to tradycyjnych SQLek
         - HQL pracuje na podstawie klas i ich wlasciwosci a nie na podstawie tabel i kolumn jak SQL



         Criteria API -
         Native Query
         Stored Procedures

         DTO - Data Transfer objects

### MECHANIZM PAGINACJI

### Named queries
- pomaga w grupowaniu zapytan hql w jednym miejscu
- w efekcie mamy czystszy kod
- adnotacja @NamedQuery

### FetchMode
- ustawienie tego parametru ma wplyw na wydajnosc aplikacji
- mechanizm z Hibernate
- okresla jak hibernate ma dociagnac encje podprzedne 

### n+1 problem

### set vs list w mapowaniach
- persistenceBag - domyslnie ustawione dla list
- set nie przechowuje duplikatow - list przechowuje duplikaty
- persistanceBag - nie zachowuje kolejnosci mimo ze jest implementacja listy
- set zajmuje wiecej pamieci od listy
- hibernetowa implementacja seta jest persistenceSet
- stosujac set w hibernacie trzeba pamietac o equals i hashcode

### Eguals() and Hashcode()

### Sortowanie 
- order by w hqlce
- @OrderBy("nazwa_kolumny")
- najlepiej sortowac dane na poziomie bazy danych (wydajnosc) i nie zawracac tym sobie glowy w javie
- mapoowanie wyjatkow:

