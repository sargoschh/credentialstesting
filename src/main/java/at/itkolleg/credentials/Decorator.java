package at.itkolleg.credentials;

import java.util.List;

/**
 * Die Klasse Decorator fungiert als Mutterklasse für alle Schlussendlichen Decorator.
 * Sie implementiert das Interface ExportCredentials und erhält ein Datenfeld
 * vom Typ ExportCredentials, welches dann "dekoriert" wird.
 * @author Sarah Gosch
 * @version 1.0
 */
public abstract class Decorator implements ExportCredentials{

    private ExportCredentials csvExporter;

    /**
     * Im Konstruktor wird dem Decorator ein bereits erstellter Exporter mitgegeben
     * (dieser wird dann dekoriert) und dem Datenfeld csvExporter zugewiesen.
     * @param csvExporter - bereits erstellter CSVExporter vom Typ ExportCredentials
     */
    public Decorator(ExportCredentials csvExporter) {
        this.csvExporter = csvExporter;
    }

    /**
     * Die Methode export() ruft lediglich auf den csvExporter (Datenfeld) die export() Methode
     * aus der Klasse CsvExporter auf. Die "Dekoration" erfolgt dann in den Unterklassen.
     * @param credentialsList - Liste mit Credentials
     */
    @Override
    public void export(List<Credentials> credentialsList) {
        this.csvExporter.export(credentialsList);
    }
}
