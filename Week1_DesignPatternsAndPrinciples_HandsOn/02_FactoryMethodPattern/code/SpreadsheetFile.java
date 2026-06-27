public class SpreadsheetFile implements FileFormat {
    @Override
    public void executeFileAction() {
        System.out.println("Excel Document Created");
        System.out.println("Opening the Excel");
        System.out.println("Closing the Excel");
    }
}