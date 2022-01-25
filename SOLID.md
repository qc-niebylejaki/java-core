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
Klasa powinna być zamknięta na modyfikacje, ale otwarta na rozszerzanie
