public class DocxCreator extends FileCreator {
    @Override
    public FileFormat createDocument() {
        return new DocxFile();
    }
}