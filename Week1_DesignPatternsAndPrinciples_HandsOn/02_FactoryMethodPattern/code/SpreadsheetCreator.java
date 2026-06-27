public class SpreadsheetCreator extends FileCreator {
    @Override
    public FileFormat createDocument() {
        return new SpreadsheetFile();
    }
}