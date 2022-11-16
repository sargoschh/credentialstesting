package at.itkolleg.credentials;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class HashExporter extends Decorator{

    public HashExporter(ExportCredentials csvExporter) {
        super(csvExporter);
    }

    @Override
    public void export(List<Credentials> credentialsList) {
        super.export(credentialsList);
        for(Credentials c : credentialsList) {
            System.out.println(getHash(c));
        }
    }

    public String getHash(Credentials credentials) {
        String sha256hex = Hashing.sha256()
                .hashString(credentials.getPwd(), StandardCharsets.UTF_8)
                .toString();

        return sha256hex;
    }
}
