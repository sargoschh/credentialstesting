# FSE-Test 1

Git, Maven, Mikroarchitektur

## Gegeben
Gegeben ist eine Applikation die Benutzer-Login-Daten (Credentials) exportieren kann. Die Applikation kann über GitHub bezogen werden.

Repository: https://github.com/clander/credentialstesting

## Funktionale Anforderungen
Erweitern Sie die bestehende Applikation mit der Zusatzfunktionalität zum Export der Benutzer-Login-Daten mit Passwort-Hash anstelle des Passworts in Klartext.

## Nicht-Funktionale Anforderungen
### Decorator-Pattern
Die Erweiterung muss unter Verwendung des Decorator-Patterns erfolgen.

https://de.wikipedia.org/wiki/Decorator

Die bestehende Applikation darf nicht verändert werden. Die Anwendung des Hashing-Decorators muss in der Main-Methode demonstriert werden.

### Hashing-Algorithmus / Hashing Bibliothek
Als Hashing-Bibliothek muss folgende Bibliothek zum Einsatz kommen:


```xml
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>31.0.1-jre</version>
</dependency>
```

Als Hasing-Algorithmus muss SHA256 zum Einsatz kommen. Die Verwendung sieht wie folgt aus:

```java
String sha256hex = Hashing.sha256()
.hashString(originalString, StandardCharsets.UTF_8)
.toString();
```

### Dokumentation
Alle neu erstellen Klassen und Methoden müssen mit JavaDoc-Kommentaren und sinnvollen Kommentaren an wichtigen Codestellen dokumentiert werden.

### Git
Der gesamte Entwicklungsprozess muss unter Verwendung von Git und GitHub begleitet werden. 

Jeder Kandidat / jede Kandidatin forked in ein eigenes Repo

https://docs.github.com/en/get-started/quickstart/fork-a-repo#forking-a-repository

und klont das Projekt für die lokale Bearbeitung.

https://docs.github.com/en/get-started/quickstart/fork-a-repo#cloning-your-forked-repository

Jeder Kandidat checkt einen eigenen Feature-Branch (Name des Branches entspricht dem Nachnamen des Kandidaten) aus. 

Es sind laufend Commits und Pushes durchzuführen. 

Am Ende des Tests wird ein finaler Push durchgeführt und zum Schluss ein Merge-Request abgesetzt. Der Pull-Request gilt als Testabgabe.
