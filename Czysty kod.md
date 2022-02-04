## Czysty kod - Robert C. Martin

#### Zmienne
- W nazwach kolekcji wyrażać intencje
  ```java
  // źle
  int d; // Czas trwania w dniach

  // dobrze 
  int elapsedTimeInDays; // czasTrwaniawDniach
  int daysSinceCreation; // dniOdUtworzenia
  int daysSinceModification; // dniOdModyfikacji
  int fileAgeInDays; // wiekPlikuwDniach
  ```

- Nie dodawać do nazwy obiektu kolekcji typu kolekcji
  ```java
  // źle
  List<String> namesList = new ArrayList<>();
  Set<String> citiesSet = new Set<>();
  Map<String, Shape> shapesMap = new Map<>();
  
  // dobrze
  List<String> names = new ArrayList<>();
  Set<String> cities = new Set<>();
  Map<String, Shape> shapes = new Map<>();
  ```

- Nie używać nazw zmiennych, mających podobny wygląd, albo różniących się tylko drobnym szczegółem
- Nie kodować nazw np. za pomocą przedrostków typów ani dodatkowych notacji nazewniczych (np. notacja węgierska)
- Nie stosować _Magic Numbers_

#### Metody
- Nazwy metod powinny być **czasownikami** lub **wyrażeniami czasownikowymi**

- Przy przeciążonych konstruktorach należy używać metod fabryk o nazwach  opisujących argumenty:
  ```java
  // słabo
  Complex fulcrumPoint = new Complex(23.0);

  // lepiej
  Complex fulcrumPoint = Complex.FromRealNumber(23.0);  
  ```

- Jedno słowo na pojęcie; metody wykonujące analogiczne operacje powinny mieć spójne nazwy, np. get, retrieve, fetch bez ich naprzemiennego używania

- Metody powinny być jak najkrótsze
- Powinno się dążych do maksymalnie 2 wcięć w metodzie

- Metoda powinna wykonywać jedną czynność (tylko jeden poziom abstrakcji)

- Unikać efektów ubocznych w wykonywanej metodzie, np.
  ```java
  public boolean checkPassword(String userName, String password) {
    User user = UserGateway.findByName(userName);
    if (user != User.NULL) {
      String codedPhrase = user.getPhraseEncodedByPassword();
      String phrase = cryptographer.decrypt(codedPhrase, password);
      if ("Hasło prawidłowe".equals(phrase)) {
        // efekt uboczny, funkcja powinna tylko sprawdzać hasło, a nie dodatkowo inicjować sesję
        Session.initialize();
        return true;
      }
    }
    return false;
  }
  ```

- Jak najmniej argumentów wejściowych w metodach; powyżej 3-4 zastanawiać się, czy nie zmienić ich na argumenty obiektowe

- W metodach zwracających *void* starać się nie modyfikować argumentu wejściowego, ale najlepiej jakieś pole w klasie
  ```java
  // zamiast
  public void addError(String fieldName, String errorMessage, Set<Error> validationErrors) {
    validatioErrors.put(fieldName, message);
  }
  
  // lepiej dać
  class FieldValidator() {
    private final Set<Error> validationErrors = ...
  
    public void addError(String fieldName, String errorMessage) {
      validatioErrors.put(fieldName, message);
    }
  }
  ```

- Jeśli metoda modyfikuje jakiś argument wejściowy, to powinna go zwrócić w argumencie wyjściowym [str. 63]
  ```java
  public List<Names> addName(String name, List<String> names) {
    names.add(name);
    return names;
  }
  ```

- Nie stosować argumentów znacznikowych (booleanów, argumentów logicznych) - sugerują, że metoda wykonuje więcej niż jedną operację, a wartość argumentu determinuje, którą [str. 63]
- Wyodrębniać do metod instrukcje z bloków **try-catch** [str. 68]
- Unikać pociągów wywołań metod z obiektów
- Nie zwracać z metod *null*, ani nie przekazywać *null* do metody jako argument

#### Klasy
- Nazwy klas powinny być **rzeczownikami** lub **wyrażeniami rzeczownikowymi**

- Nazwa interfejsu i tylko jednej klasy implementującej:
  ```java
  public interface ShapeFactory {
  }
  
  public class ShapeFactoryImpl implements ShapeFactory {
  }
  
  public class BaseShapeFactory implements ShapeFactory {
  }
  
  public class DefaultShapeFactoryImpl implements ShapeFactory {
  }
  ```

- Unikać tworzenia hybrydowych klas, które posiadają gettery i settery, oraz jednocześnie wykonują logikę biznesową.
- Nie stosować nazw klas kończących się na **Procesor**, **Manager**, **Super** - sugeruje, że klasa ma zbyt wiele odpowiedzialności.
- Klasa powinna mieć jak najmniej zmiennych instancyjnych, a najlepiej jedną

- Organizacja klas:
  - Klasy powinny zaczynać się od listy zmiennych
  - Następnie publiczne stałe statyczne
  - Następnie prywatne zmienne statyczne
  - Po nich prywatne zmienne instancyjne
  - Rzadko istnieje dobry powód do tworzenia publicznych zmiennych instancyjnych
  - Po nich publiczne metody
  - Po każdej publicznej metodzie, metody prywatne, które wywołuje dana funkcja publiczna

- Jeśli potrzebujemy dostępu do zmiennej typu **private** w testach, to możemy ustawić ją jako **protected**

#### Formatowanie
- Koncepcje związane ze sobą powinny znajdować się możliwie jak najblizej siebie, np. zmienna powinna być zadeklarowana jak najblizej miejsca użycia
- Zmienne instancyjne powinny być deklarowane na początku klasy
- Funkcje zależne powinny być zadeklarowane jak najbliżej siebie, np. funkcja wywoływana powinna być zadeklarowana zaraz po funkcji wywołującej:  
  ```java
  public class Person() {

    public void methodA() {
      var resultA1 = methodA1();
      var resultA2 = methodA2();
    }
  
    private String methodA1() { ... }
    private String methodA2() { ... }
  
    public void methodB() {
      var resultB1 = methodB1();
      var resultB2 = methodB2();
    }
  
    private String methodB1() { ... }
    private String methodB2() { ... }

  }
  ```
  
****Wyjątki****
- Dla wyjątków zwracanych z API lub bibliotek używać klas osłonowych

****Testy****
- Trzy prawa TDD (Test Driven Developement)
  - **Pierwsze prawo** - nie można zacząć pisać kodu produkcyjnego do momentu napisania niespełnianego testu jednostkowego
  - **Drugie prawo** - nie można napisać więcej testów jednostkowych, które są wystarczające do niespełnienia testu, a brak kompilacji jest jednocześnie nieudanym testem
  - **Trzecie prawo** - nie można pisać większej ilości kodu produkcyjnego, niż wystarczy do spełnienia obecnie niespełnianego testu

- F.I.R.S.T.
  - **Fast** (szybkie) - powinny wykonywać się szybko
  - **Independent** (niezależne) - nie powinny zależeć od siebie wzajemnie, powinny móc być wykonywane w dowolnej kolejności
  - **Repeatable** (powtarzalne) - powinny zawsze zwracać te same wyniki
  - **Self-validating** (samokontrolujące się)
  - **Timely** (o czasie) - testy powinny być pisane w odpowiednim momencie, bezpośrednio przed pisaniem testowanego kodu produkcyjnego

****Wielowątkowość****
- Klasy przydatne w aplikacji wielowątkowej:
  - **ReentrantLock** - blokada, która może być nałożona w jednej metodzie i zwolniona w innej
  - **Semaphore** - implementacja klasycznego semafora, czyli blokady z licznikiem
  - **CountDownLatch** - blokada, która oczekuje na określoną liczbę zdarzeń przed ponownym uruchomieniem wszystkich wątków oczekujących na niej. Pozwala ona, aby wszystkie ątki miały możliwość wystartowania mniej więcej w tym samym momencie

- **Zasoby związane** - zasoby stałej wielkości i liczby, używane w środowisku współbieżnym. Przykładem mogą być połączenia z bazą danych oraz bufory odczytu i zapisu o stałej wielkości
- **Wzajemne wykluczanie** - tylko jeden wątek możę odwoływać się do danych współużytkowanych w danym momencie.
- **Zagłodzenie** - jeden wątek z grupy wątków nie może działać przez zbyt długi czas lub ciągle. Np. dopuszczenie, aby szybko działające wątki zawsze pierwsze przechodziły przez blokadę, powoduje zagłodzenie wolniej działających atków, jeżeli nie ma końca strumienia szybko działających wątków.
- **Zakleszczenie** - co najmniej 2 wątki czekają na zakoćżenie innego z oczekujących wątków. Każdy wątek posiada zasób, który jest wymagany przez inny wątek i  żaden nie może się zakończyć, dopóki nie uzyska innego zasobu
- **Uwięzienie** - wątki są wstrzymane, ale każdy z nich próbuje znaleźć "innądrogę". Z powodu rezonansu wątki próbujące iść dalej, nie są w stanie zrobić tego przez nadmiernie długi czas - lub też nigdy.
