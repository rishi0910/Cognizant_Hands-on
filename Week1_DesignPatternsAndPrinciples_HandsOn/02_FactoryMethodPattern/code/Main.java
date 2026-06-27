public class Main {
    public static void main(String[] args) {
        System.out.println("-----IMPLEMENTATION OF FACTORY METHOD PATTERN-----");
        System.out.println("--------------------------------------------------\n");

        FileCreator docxFactory = new DocxCreator();
        FileCreator pdfFactory = new PdfCreator();
        FileCreator sheetFactory = new SpreadsheetCreator();

        FileFormat wordDoc = docxFactory.createDocument();
        FileFormat pdfDoc = pdfFactory.createDocument();
        FileFormat excelDoc = sheetFactory.createDocument();

        wordDoc.executeFileAction();
        System.out.println("--------------------------------------------------");
        pdfDoc.executeFileAction();
        System.out.println("--------------------------------------------------");
        excelDoc.executeFileAction();
        System.out.println("--------------------------------------------------");
    }
}