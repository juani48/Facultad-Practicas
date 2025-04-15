## Dado el siguiente código implementado en la clase Document y que calcula algunas estadísticas del mismo:
```java
public class Document {
    List<String> words;
    public long characterCount() {
        long count = this.words.stream().mapToLong(w -> w.length()).sum();
        return count;
    }

    public long calculateAvg() {
        long avgLength = this.words.stream().mapToLong(w -> w.length()).sum() / this.words.size();
        return avgLength;
    }
// Resto del código que no importa
}
```

## A - Enumere los code smell y que refactorings utilizará para solucionarlos.

1. Variables que rompen el encapsulamiento: Ocultar y encapsular campo.
2. Inicializacion de varaibles ineccesarias: Replace temp whit query.
3. Codigo reptido: Replace temp whit query.

## B - Aplique los refactorings encontrados, mostrando el código refactorizado luego de aplicar cada uno.
1. 
```java
public class Document {
    private List<String> words;

    public List<String> getWords(){ return this.words; }

    public long characterCount() {
        long count = this.getWords().stream().mapToLong(w -> w.length()).sum();
        return count;
    }

    public long calculateAvg() {
        long avgLength = this.getWords().stream().mapToLong(w -> w.length()).sum() / this.getWords().size();
        return avgLength;
    }
}
```
2. 
```java
public class Document {
    private List<String> words;

    public List<String> getWords(){ return this.words; }

    public long characterCount() {
        return this.getWords().stream().mapToLong(w -> w.length()).sum();
    }

    public long calculateAvg() {
        return this.getWords().stream().mapToLong(w -> w.length()).sum() / this.getWords().size();
    }
}
```
3. 
```java
public class Document {
    private List<String> words;

    public List<String> getWords(){ return this.words; }

    public long characterCount() {
        return this.getWords().stream().mapToLong(w -> w.length()).sum();
    }

    public long calculateAvg() {
        return this.characterCount() / this.getWords().size();
    }
}
```

## C - Analice el código original y detecte si existe un problema al calcular las estadísticas. Explique cuál es el error y en qué casos se da ¿El error identificado sigue presente luego de realizar los refactorings? En caso de que no esté presente, ¿en qué momento se resolvió? De acuerdo a lo visto en la teoría, ¿podemos considerar esto un refactoring?

Puede ocurrir la division por '0' al intentar sacar el promedio de palabras del documento y este se encuntra vacio.
