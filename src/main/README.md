<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Java EE - Spring

### Zadania.

1. Stwórz projekt `Homework_01`. Rozwiązania zadań powinny znajdować się w tym projekcie.


#### Zadanie 1

1. Stwórz klasę `Customer`, która ma spełniać następujące wymogi:

Klasa ma mieć prywatne atrybuty:
 * `id` - atrybut ten powinien trzymać numer identyfikacyjny,
 * `firstName` - atrybut określający imię klienta,
 * `lastName` - atrybut określający nazwisko klienta,
 
2. Ma posiadać konstruktor przyjmujący id, imię, nazwisko. Getery i settery dla pól, oraz bezparametrowy konstruktor.
 
#### Zadanie 2 
1. Utwórz interfejs `CustomerLogger` zawierający metodę `void log()`;
3. Utwórz klasę `SimpleCustomerLogger` implementującą interfejs `CustomerLogger`.
4. W ciele metody `log` dodaj wyświetlanie na konsoli napisu `<Aktualna data i godzina>: Customer operation`;
5. `SimpleCustomerLogger` - powinno być ziarnem zarządzanym przez Springa.
5. Utwórz klasę startową aplikacji Spring.
6. Utwórz obiekt kontekstu na podstawie konfiguracji.
7. Pobierz od kontekstu ziarno a następnie wywołaj na nim metodę log. 

#### Zadanie 3 

1. Utwórz interfejs `CustomerRepository` zawierający metody:
 * dodawanie klienta
 * usuwanie klienta 
 * pobieranie listy klientów
2. Utwórz klasę `MemoryCustomerRepository` implementującą interfejs `CustomerRepository`.
3. Klasa powinna zapisywać dane do wewnętrznie zdefiniowanej listy obiektów `Customer` - skorzystaj z `ArrayList`.  
4. Klasa ma zawierać pole typu `CustomerLogger`, wstrzyknij odpowiednią zależność.
5. Zmodyfikuj metody klasy  `MemoryCustomerRepository` dodając logowanie w każdej z metod. (wywołaj metodę `log()`).     
6. W metodzie main pobierz ziarno repozytorium, utwórz użytkownika a następnie zapisz go używając metody z repozytorium.

#### Zadanie 4
1. Utwórz implementację interfejsu `CustomerLogger` o nazwie `FileCustomerLogger`.
2. Klasa ma logować zmiany na klientach do pliku.
3. Dodaj w klasie właściwość `String` o nazwie `filename`, zmodyfikuj ziarno tak aby wstrzyknąć właściwość prostą z nazwą pliku logu.
4. Zmodyfikuj definicje wstrzykiwania tak aby repozytorium korzystało z nowego loggera.
5. Jeżeli korzystasz z automatycznego skanowania komponentów użyj w tym celu adnotacji `@Primary`.
  
#### Zadanie 5 - dodatkowe
1. Utwórz implementację interfejsu `CustomerLogger` o nazwie `DBCustomerLogger`.
2. Klasa ma logować zmiany na klientach do bazy danych.
3. Dodaj sterownik bazy danych oraz utwórz ziarno zajmujące się zapisem do bazy.
4. Utwórz bazę oraz tabelę, która będzie przechowywać logi.
5. Wstrzyknij za pomocą właściwości prostych dane wymagane do skonfigurowania połączenia.
6. Wstrzyknij ziarno odpowiedzialne za połączenie do nowego loggera.

#### Zadanie 6 - dodatkowe
1. Dla przykładu z poprzedniego zadania utwórz kwantyfikatory dla jednego z logerów.
2. Zmodyfikuj repozytorium tak by wykorzystać kwantyfikator, usuwając tym samym adnotację `@Primary`.
         
#### Zadanie 7 - dodatkowe
1. Utwórz implementację interfejsu `CustomerRepository` o nazwie `DBCustomerRepository`.
2. Implementacja zamiast przechowywać dane o klientach w pamięci ma je zapisywać do bazy danych.
3. Utwórz odpowiednią tabelę w bazie danych.
4. Zmodyfikuj aplikację by korzystała z nowego repozytorium.       
       
