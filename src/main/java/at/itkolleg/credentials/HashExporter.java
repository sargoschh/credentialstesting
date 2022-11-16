package at.itkolleg.credentials;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Die Klasse HashExporter erbt vom Decorator. Diese erledigt dann das "Hashen" des Passworts
 * und somit das Dekorieren des ursprünglichen Exports.
 * @author Sarah Gosch
 * @version 1.0
 */
public class HashExporter extends Decorator{

    /**
     * Dem Konstruktor des HashExporter wird ein bereits erstellter Exporter vom Typ
     * ExportCredentials mitgegeben und mit super() an die Mutterklasse übergeben.
     * Diese setzt damit das dort vorhandene Datenfeld csvExporter, welches nun im
     * HashExporter dekoriert wird.
     * @param csvExporter - bereits erstellter csvExporter vom Typ ExportCredentials
     */
    public HashExporter(ExportCredentials csvExporter) {
        super(csvExporter);
    }

    /**
     * Die Methode export() dekoriert nun den Export der User-Login-Daten.
     * Dazu wird eine neue Liste erstellt, die den Inhalt der übergebenen credentialsList
     * erhält. Dies muss nicht so implementiert werden, da aber die ursprüngliche Liste im nächsten
     * Schritt verändert wird und diese eventuell in der ursprünglichen Form noch benötigt wird,
     * wird eine Kopie erstellt.
     * Im nächsten Schritt wird die Liste mit einer ForEach Schleife durchlaufen, und das Passwort
     * jeweils mit getHash() neu gesetzt.
     * @param credentialsList - Liste mit Credentials
     */
    @Override
    public void export(List<Credentials> credentialsList) {
        List<Credentials> newCredentialsList = credentialsList;
        for(Credentials c : newCredentialsList) {
            c.setPwd(getHash(c.getPwd()));
        }
        super.export(newCredentialsList);
    }

    /**
     * Die Methode getHash() wandelt einen mitgegebenen String in einen Hash um.
     * Dazu wird die Funktion Hashing verwendet. Es wird dann der Gehashte String
     * zurückgegeben.
     * @param string - String, der gehasht werden soll
     * @return gehashter String
     */
    public String getHash(String string) {
        String sha256hex = Hashing.sha256()
                .hashString(string, StandardCharsets.UTF_8)
                .toString();

        return sha256hex;
    }
}
