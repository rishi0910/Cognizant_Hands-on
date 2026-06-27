public class PdfFile implements FileFormat {
    @Override
    public void executeFileAction() {
        System.out.println("PDF Document Created");
        System.out.println("Opening the PDF");
        System.out.println("Closing the PDF");
    }
}