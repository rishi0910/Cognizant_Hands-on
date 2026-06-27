public class PdfCreator extends FileCreator {
    @Override
    public FileFormat createDocument() {
        return new PdfFile();
    }
}