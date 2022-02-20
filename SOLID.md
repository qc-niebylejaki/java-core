## SOLID

### **S**   - **SRP** - Single responsibility principle
Klasa powinna mieć tylko jedną odpowiedzialność - powinna wykonywać tylko jeden określony proces.
Powód do modyfikacji klasy powinien być tylko jeden.

Przykład klasy łamiącej SRP, ponieważ ma 2 odpowiedzialności:
```
class Recangle {
    public void renderRectangle() {
    }
    
    public double calculateArea() {
    }
}
```

### **O**   - **OCP** - Open/closed  principle
Klasa powinna być zamknięta na modyfikacje, ale otwarta na rozszerzanie.
Podstawowymi mechanizmami stojącymi za OCP są abstrakcja i polimorfizm.

Przykład nie spełniania OCP, przy dodaniu nowego kształtu musimy zmodyfikować klasę Geometry:
```
public class Square {
    public Point topLeft;
    public double side;
}

public class Rectangle {
    public Point topLeft;
    public double height;
    public double width;
}

pulic class Circle {
    public Point center;
    public double radius;
}

public class Geometry {
    public final double PI = 3.14.......;
    
    public double area(Object shape) throws NoSuchShapeException {
        switch (getType(shape)) {
            case ShapeType.Square:
                Square s = (Square) shape;
                return s.side * s.side;
            case ShapeType.Rectangle:
                Rectangle r = (Rectangle) shape;
                return r.height * r.width;
            case ShapeType.Circle:
                Circle c = (Circle) shape;
                return PI * c.radius * c.radius;
            default:
                throw new NowSuchShapeException();
        }
    }
    
    private ShapeType getType(Shape shape) { ... }
}
```

Przykład poprawny, korzystający z poliformizu:
```
public class Square implements Shape {
    private Point topLeft;
    private double side;
    
    public double area() {
        return side * side;
    }
}

public class Rectangle implements Shape {
    private Point topLeft;
    private double height;
    private double width;
    
    public double area() {
        return heigth * width;
    }
}

public class Circle implements Shape {
    private Point center;
    private double radius;
    public final double PI = 3.14.......;

    public double area() {
        return PI * radius * radius;
    }
}

public interface Shape {
    public double area();
}
```

### **L**   - **LSP** - Zasada podstawiania Liskov
Funkcje które używają wskaźników lub referencji do klas bazowych, muszą być w stanie używać również obiektów klas dziedziczących po klasach bazowych, bez dokładnej znajomości tych obiektów.

Musi być możliwość podstawienia typów pochodnych za ich typy bazowe. Np. tworzymy zmienne typu interfejsu/klasy abstrakcyjnej, a nie klasy konkretnej, jeśli jest to możliwe.

Ogólnie, to w tej zasadzie chodzi o **polimorfizm**.

### **I**   - **ISP** - Zasada segregacji interfejsów
Nie tworzyć interfejsów z metodami, których nie używa klasa. Interfejsy powinny być jak najmniejsze i konkretne  klasy nie powinny implementować metod których nie potrzebują.

### **D**   - **DIP** - Zasada odwracania zależności
Wysokopoziomowe moduły nie powinny zależeć od modułów niskopoziomowych – zależności między nimi powinny wynikać z abstrakcji.
Przykładem jest wstrzykiwanie zależności - klasa, która korzysta z innej klasy nie tworzy w swoim wnętrzu jej instancji, tylko ma wstrzykiwaną konkretną implementację, z której następnie korzysta.