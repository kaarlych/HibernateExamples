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

### Mechanizm paginacji
- ograniczenie ilosci wynikow zapytania

### Named queries
- pomaga w grupowaniu zapytan hql w jednym miejscu
- w efekcie mamy czystszy kod
- adnotacja @NamedQuery

### FetchMode
- ustawienie tego parametru ma wplyw na wydajnosc aplikacji
- mechanizm z Hibernate
- okresla jak hibernate ma dociagnac encje podprzedne 

### n+1 problem
- najczesciej pojawia sie w relacji one-to-many
- polega na tym ze hibernate pobiera dane z bazy w n+1 zapytaniach
- n+1 zapytan - 1 zapytanie na glowna encje i n zapytan na encje podrzedne
- rozwiazanie: fetchmode, fetch, batchsize

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

### Native Query
- natywne zapytania sql - wlasciwe sql dla danej bazy danych 
- mechanizm ktory pozwala na wykonanie zwyklej slqki w hibernate

### Criteria API
- obiekt Criteria Query na ktorym bedziemy okreslali rozne filtry
- Od Hibernate 5.x Criteria API jest zdeprecjonowane
- Tworcy Hibernate zdecydowali na tworzenie wlasnego Criteria API
- Zapytania zorientowane obiektowo

### Connection Pool
- cache of database connections maintained so that the connections can be reused when required
- HikariCP - najlepszy connection pool
- chodzi o to zeby nie otwierac co chwila nowego polaczenia do bazy danych tylko jest pewna pula
- tworzymy polaczenie i wrzucamy do worka i potem wyciagamy je z worka
- polaczen do bazy danych moze byc wiecej niz jedno - zaleznie od ilosci watkow
- troche podobnie jak Stringpool
- oszczednosc czasu i zasobow
- 

