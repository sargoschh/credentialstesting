# FSE-Test 1

Git, Maven, Mikroarchitektur

## 1) Gegeben
Gegeben ist eine Applikation die Benutzer-Login-Daten (Credentials) exportieren kann. Die Applikation kann über GitHub bezogen werden.

Repository: https://github.com/clander/credentialstesting

## 2) Funktionale Anforderungen
Erweitern Sie die bestehende Applikation mit der Zusatzfunktionalität zum Export der Benutzer-Login-Daten mit Passwort-Hash anstelle des Passworts in Klartext.

## 3) Nicht-Funktionale Anforderungen
### 3.1)Decorator-Pattern
Die Erweiterung muss unter Verwendung des Decorator-Patterns erfolgen.

https://de.wikipedia.org/wiki/Decorator

Die bestehende Applikation darf nicht verändert werden. Die Anwendung des Hashing-Decorators muss in der Main-Methode demonstriert werden.

### 3.2) Hashing-Algorithmus / Hashing Bibliothek
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

### 3.3) Dokumentation
Alle neu erstellen Klassen und Methoden müssen mit JavaDoc-Kommentaren und sinnvollen Kommentaren an wichtigen Codestellen dokumentiert werden.

### 3.4) Git
Der gesamte Entwicklungsprozess muss unter Verwendung von Git und GitHub begleitet werden. 

Jeder Kandidat / jede Kandidatin forked in ein eigenes Repo

https://docs.github.com/en/get-started/quickstart/fork-a-repo#forking-a-repository

und klont das Projekt für die lokale Bearbeitung.

https://docs.github.com/en/get-started/quickstart/fork-a-repo#cloning-your-forked-repository

Es sind laufend Commits und Pushes durchzuführen. 

Am Ende des Tests wird ein finaler Push durchgeführt.

Ein Pull-Request auf das Ausgangsrepo https://github.com/clander/credentialstesting gilt als Testabgae. Im Pull-Request muss der Name des Kandidaten / der Kandidatin angegeben werden.
