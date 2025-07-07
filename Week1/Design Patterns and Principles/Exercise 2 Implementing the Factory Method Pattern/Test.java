public class Test{
    public static void main(String[] args){
        DocumentFactory word = new WordDocumentFactory();
        Document worddoc = word.createDocument();
        worddoc.open();

        DocumentFactory pdf = new PdfDocumentFactory();
        Document pdfdoc = pdf.createDocument();
        pdfdoc.open();

        DocumentFactory excel = new ExcelDocumentFactory();
        Document exceldoc = excel.createDocument();
        exceldoc.open();
    }
}