package at.itkolleg.credentials;

import java.util.List;

public abstract class Decorator implements ExportCredentials{

    private CsvExporter csvExporter;

    public Decorator(CsvExporter csvExporter) {
        this.csvExporter = csvExporter;
    }

    @Override
    public void export(List<Credentials> credentialsList) {
        this.csvExporter.export(credentialsList);
    }
}
