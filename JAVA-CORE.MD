### Podstawy   
* Zmienne działają jako referencje do obiektów
* Atrybuty metod są przekazywane jako referencje do obiektów
* Klasy oznaczane jako **final** nie mogą być dziedziczone
* Metody oznaczane jako **final** nie mogą być przeciążane w klasie dziedziczącej
* Enumy mają tylko prywatne konstruktory, mogą mieć tylko gettery
* Metody w interfejsach są domyślnie publiczne 
* Do zmiennej typu **final** nie można przypisać nowej wartości/referencji do obiektu 
* Jeśli do metody przekażemy zmienną typu prymitywnego, to przekazujemy kopię jej wartości 
* Jeśli do metody przekażemy referencję do obiektu, to wewnątrze metody możemy zmienić stan tego obiektu,  
ale jeśli zmienimy wewnątrze metody referencję, to poza metodą referencja się nie zmieni 
* Statyczne importy pozwalają na korzystanie ze statycznych klas i pól w innych obiektach, bez prefixu z klasą je zawierającą 
* Widoczność klas: package (no modifier), public, protected, private
* We can override (@Override) methods in subclasses
* Sublcass contructors - you can call superclass constructor by super() on the beginning of constructor i subclass
* Use **interface** type variables
* Polimorfizm działa też na tablice obiektów dziedziczących po sobie
* *Inner Classes* mają dostęp do pól klasy, w której się znajdują
```java
final String CONSTANT_VALIABLE = "constant variable";
```

### Lambdy
* Lambdy można użyć przy tworzeniu obiektu, któy zawiera pojedynczą abstrakcyjną metodę - w interfejsach funkcyjnych
* Functional Interfaces majątylko pojedynczą abstrakcyjną metodę, poza tym mogą mieć metody **default** oraz **static** 
---

### Wyjątki
* **UncheckedExceptions** - wszystkie wyjątki wywodzące się z **Error** i **RuntimeException** - nie muszą być deklarowane
* **CheckedException** - wszystkie pozostałe, muszą być deklarowane
---

### equals() & hashCode()
```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pair pair = (Pair) o;
    return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
}

@Override
public int hashCode() {
    return Objects.hash(first, second);
}
```
---

### ArrayList vs LinkedList
#### ArrayList
* Używa wewnętrznej dynamicznej tablicy
* Dodawanie i usuwanie elementów powoduje przebudowanie wewnętrznej tablicy
* Najlepsze do przechowywania elementów i szybszego dostępu do poszczególnych danych

#### LinkedList
* Używa double linked list
* Szybsze manipulowanie elementami listy - dodawanie, usuwanie, przesuwanie
* Może działać jako lista i jako kolejka
* Lepsze do manipulowania danymi - dodawaniem, usuwaniem, przesuwaniem elementó

---
### Comparable vs Comparator
#### Comparable
* Można porównywać obiekty z poziomu pojedynczego elementu - wywołując na nim metodę compareTo()
* Trzeba rozszerzać oryginalną klasę
* Pozwala na sortowanie obiektów za pomocą Collections.sort(List)

#### Comparator
* Nie trzeba rozszerzać oryginalnej klasy
* Comparator udostępnia metodę compare() do sortowania elementów
* Pozwala na sortowanie obiektów m.in. za pomocą Collections.sort(List, Comparator)
* Można zdefiniować za pomocą Lambdy

---
### Interface default methods
* Umożliwia dodanie zewnetrznej fukcjonalności do klas implementujących interfejs, bez ich modyfikacji
* Oryginalnie wprowadzone do wprowadzenia wstecznej kompatybilności frameworka Collection z funkcjami Lambda
* Nie mogą wprowadzać logiki bazującej na stanie obiektu - nie mają dostępu do pól obiektu
* Jeśli są konflikty pomiędzy defaultowymi metodami z różnych interfejsów, to zostanie zgłoszony błąd kompilatora
klasa musi przeciążać tę metodę i wywołać odpowiednią metodę defaultową  
```java
I1.super.defaultMethod();
```
---
### Enums
```java
public enum Color {
    RED, BLUE, YELLOW
}

public enum ErrorTypes {
    EMPTY("Value is empty"),
    TOO_SHORT("Value is too short"),
    TOO_LONG("Value is too long");
    
    private String message;                     // private fields
    
    private ErrorTypes(String message) {        // only private constructor
        this.message = message;
    }
    
    public String getMessage() {                // only getters
        return message;
    }
}
```
---

### Interfaces
```java
public interface Printable {
    
    byte[] print();             // only public methods
}
```
---

### Cloneable
* Nie implementować interfejsu *Cloneable*
* Zamiast tego można stosować np. konstruktor kopiujący
* Metoda clone() zwraca *Object* a nie kontretny typ
* Konstruktor kopiujący, a dziedziczenie:
```java
public class Employee {
   public Employee copy() {
        return new Employee(this);
    }
}

public class Manager extends Employee {
    @Override
    public Employee copy() {
        return new Manager(this);
    }
}
```
---
### Generics
* klasa generyczna:
```java
class Validator<T> {
    public T getSomething();
}
```
* metody generyczne w niegenerycznych klasach:
```java
public <T> T getSomething(List<T> params);
```
* Bound types:

```java
import java.io.Serializable;

class Validator<T extends Serializable & Comparable> {}
```
* _Unbound types_ są tłumaczone przez kompilator na _Object_
* _Bounded types_ są tłumaczone przez kompulator na typ, który jest bounded
* Tworzenie wewnątrz klasy generycznej obiektów przekazanego typu:
```java
Pair<String> p = Pair.makePair(String::new);

public static <T> Pair<T> makePair(Supplier<T> constr)
{
    return new Pair<>(constr.get(), constr.get());
}
```

```java
Pair<String> p = Pair.makePair(String.class);

public static <T> Pair<T> makePair(Class<T> cl)
{
    try { 
        return new Pair<>(cl.newInstance(), cl.newInstance());
    } catch (Exception ex) { 
        return null;
    }
}
```

* Nie można stosować typu referencyjnego w statycznych polach ani metodach
* Nie można wyrzucać ani łapać instancji generycznych klas
* Wildcards (_?_) - reprezentuje nieznany typ, pozwala na kompatybilność generycznych typów
  * **Upper bound wildcard**: If the variable belongs to in type , i.e there is an in variable, we use the ‘extends’ keyword with a wildcard.
  * **Lower bound wildcard**: If the variable belongs to out type , i.e there is an out variable, we use ‘super’ keyword with a wildcard.
  * **Unbounded wildcard**: If we can access a variable using the Object class method, then we should prefer to use the unbounded wildcards.
  * **No wildcard**: If the variable is both in and out category, then there is no need to use the wildcards.
---

### Collections
* _Iterable <- Collection <- List <- ArrayList_
```java
public interface Collection<E>
{
    boolean add(E element);
    Iterator<E> iterator();
    ...
}
```
```java
public interface Iterable<E> {
  ...
  Iterator<E> iterator(); //Returns an 'Iterator'(not iterator) over elements of type T.
  ...
}
```
```java
public interface Iterator<E> {
  E next();
  boolean hasNext();
  void remove();
  default void forEachRemaining(Consumer<? super E> action);
}
```

* _HashSet_ - unordered, nie przyjmuje duplikatów, zastępuje je kolejnym przekazanym obiektem
* _TreeSet_ - sortedSet
* _Tree_ - nie może trzymać duplikatów kluczy
* Klasa _Collections_ udostępnia niemodyfikowalne widoki