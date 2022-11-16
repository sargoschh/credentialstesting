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
        List<Credentials> newCredentialsList = credentialsList;
        for(Credentials c : newCredentialsList) {
            c.setPwd(getHash(c));
        }
        super.export(newCredentialsList);
    }

    public String getHash(Credentials credentials) {
        String sha256hex = Hashing.sha256()
                .hashString(credentials.getPwd(), StandardCharsets.UTF_8)
                .toString();

        return sha256hex;
    }
}
