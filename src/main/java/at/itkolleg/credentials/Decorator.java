package at.itkolleg.credentials;

import java.util.List;

public abstract class Decorator implements ExportCredentials{

    private ExportCredentials csvExporter;

    public Decorator(ExportCredentials csvExporter) {
        this.csvExporter = csvExporter;
    }

    public ExportCredentials getCsvExporter() {
        return csvExporter;
    }

    @Override
    public void export(List<Credentials> credentialsList) {
        this.csvExporter.export(credentialsList);
    }
}
