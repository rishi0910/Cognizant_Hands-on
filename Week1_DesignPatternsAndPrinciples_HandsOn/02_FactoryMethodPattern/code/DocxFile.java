public class DocxFile implements FileFormat {
    @Override
    public void executeFileAction() {
        System.out.println("Word Document Created");
        System.out.println("Opening the Word");
        System.out.println("Closing the Word");
    }
}