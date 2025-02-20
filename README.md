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

### Cachowanie w Hibernate
- first level cache & second level cache
- cache - hardware or software component that stores data so that future requests for that data can be served faster
- cache jest po to zeby nie ladowac danych z bazy danych za kazdym razem
- first level cache jest wlaczony domyslne w hibernate -nie trzeba nic robic 
- nie da sie go wylaczyc - jest to cache na poziomie sesji
- second level cache - cache na poziomie aplikacji
- kazdy obiekt session na swoj first level cache
- 1LC jest na sztywno zwiazany z session

### -> First Level Cache
- jest domyslnie wlaczony i nie mozna go wylaczyc 
- obejmuje jedna sesje po zamknieciu sesji obiekty znikaja z pamieci 
- Hibernate nie pozwala na zapisanie obiektu wiecej niz jeden raz
- jezeli w tej samej sesji pytamy 2 razy o ten sam obiekt to Hibernate zaladuje encje z first level cache
- caly 1LC mozna usunac przy uzyciu metody clear() na obiekcie session
- evic() - usuwa obiekt z 1LC
- clear() - usuwa caly 1LC

### -> Second Level Cache
- cache na poziomie aplikacji
- cache jest wspoldzielony przez wszystkie sesje
- mozna go wylaczyc
- cache jest zalezny od dostawcy
- interfejs RegionFactory - java specyfikuje interfejsy ale trzeba go zaimplementowac 
- jednym z dostawcow jest ehcache
- cache mozna konfigurowac w pliku xml
- adnotacje @Cache i @Cachable - Enable Selective - domyslnie zalecana
- Disable selective - @Cache(usage = CacheConcurrencyStrategy.NONE)

### -> Locki bazodanowe
- database lock/database concurrency control
- locki w bazie danych - mechanizm blokowania wierszy w bazie danych
- locki w hibernate - mechanizm blokowania obiektow w hibernate
- locki w hibernate sa zalezne od dostawcy
- tematyka zwiazana z concurrency
- concurrency - wspolbieznosc - wielowatkowosc
- optimistic locking - optymistyczne blokowanie
- pessimistic locking - pesymistyczne blokowanie
- lock bazodanowy - mechanizm pozwalajacy na blokowanie danych w bazie danych
- kazdy uzytkownik strony internetowej ma swoja sesje bazodanowa
- jezeli wielu uzytkownikow dokonuje zmiany na danych to tylko jeden uzytkownik bedzie w stanie je zmienic 
- hibernate obsluguje dwa rodzaje lockingu - optimistic oraz pessimistic
- 

