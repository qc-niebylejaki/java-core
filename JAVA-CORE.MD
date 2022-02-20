### Podstawy   
* Zmienne działają jako referencje do obiektów
* Atrybuty metod są przekazywane jako referencje do obiektów
* Klasy oznaczane jako **final** nie mogą być dziedziczone
* Metody oznaczane jako **final** nie mogą być przeciążane w klasie dziedziczącej
* Enumy mają tylko prywatne konstruktory, mogą mieć tylko gettery
* Metody w interfejsach są domyślnie publiczne 
* Do zmiennej typu **final** nie można przypisać nowej wartości/referencji do obiektu 
* Jeśli do metody przekażemy zmienną typu prymitywnego, to przekazujemy kopię jej wartości 
* Jeśli do metody przekażęmy referencję do obiektu, to wewnątrze metody możemy zmienić stan tego obiektu,  
ale jeśli zmienimy wewnątrze metody referencję, to poza metodą referencja się nie zmieni 
* Statyczne importy pozwalają na korzystanie ze statycznych klas i pól w innych obiektach, bez prefixu z klasą je zawierającą 
* Widoczność klas: package (no modifier), public, protected, private
* We can override (@Override) methods in subclasses
* Sublcass contructors - you can call superclass constructor by super() on the beginning of constructor i subclass
* Use **interface** type variables
* Polimorfizm działa też na tablice obiektów dziedziczących po sobie
* *Inner Classes* mają dostęp do pól klasy, w której się znajdują

### Lambdy
* Lambdy można użyć przy tworzeniu obiektu, któy zawiera pojedynczą abstrakcyjną metodę - w interfejsach funkcyjnych
* Functional Interfaces majątylko pojedynczą abstrakcyjną metodę, poza tym mogą mieć metody **default** oraz **static** 
---

### Wyjątki
* **UncheckedExceptions** - wszystkie wyjątki wywodzące się z **Error** i **RuntimeException** - nie muszą być deklarowane
* **CheckedException** - wszystkie pozostałe, muszą być deklarowane
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
* Comparator udostępnia metodę compare() do sortowania elementó
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