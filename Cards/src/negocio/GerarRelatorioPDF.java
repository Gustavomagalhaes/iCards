package negocio;
import java.io.FileOutputStream;
import java.io.OutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


/**
 *
 * @author Gustavo
 */
public class GerarRelatorioPDF { 
    public void PDF(String ID, int tipo) throws Exception {
        Document doc = null;
        OutputStream os = null;
        try {
            doc = new Document(PageSize.A4, 72, 72, 72, 72); //cria o documento tamanho A4, margens de 2,54cm

            os = new FileOutputStream("Relatório iCards.pdf");//cria a stream de saída

            PdfWriter.getInstance(doc, os); //associa a stream de saída ao 

            doc.open(); //abre o documento
            Font fonte2 = new Font(FontFamily.HELVETICA, 24,Font.BOLD);
            Font fonte = new Font(FontFamily.HELVETICA, 16,Font.BOLD);
            Paragraph title = new Paragraph("Relatório iCards",fonte2); //adiciona o texto ao PDF
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(5);
            Paragraph linha = new Paragraph("__________________________________________________",fonte);
            doc.add(linha);
            doc.add(title);
            
            GerenciarDB banco = new GerenciarDB();
            
            if (tipo==0) { //Usuario
                String[][] mtx = banco.getExtratoUsuario(ID);
                int i;
                PdfPTable table = new PdfPTable(3);
                
                Paragraph head = new Paragraph("Nome: "+banco.getUsername(ID) ,fonte);
                head.setSpacingAfter(20);
                doc.add(head);
                
                for (i=(mtx[0].length)-1;i>=0;i--){
                    table.addCell(mtx[0][i]);
                    table.addCell(mtx[1][i]);
                    table.addCell(mtx[2][i]);
               }
               doc.add(table);
               Paragraph fim = new Paragraph("Saldo total: R$ "+banco.getSaldoCartaoDB(ID) ,fonte);
               doc.add(fim);
              
            } else if (tipo==1) { //Estabelecimento
                String[][] mtx = banco.getExtratoEst(ID);
                int j;
                PdfPTable table = new PdfPTable(2);
                
                Paragraph head = new Paragraph("Nome: "+banco.getEstabelecimentoDB(ID) ,fonte);
                head.setSpacingAfter(20);
                doc.add(head);

                for (j=(mtx[0].length)-1;j>=0;j--){
                    table.addCell(mtx[0][j]);
                    table.addCell(mtx[2][j]);
                }
                doc.add(table);
                Paragraph fim = new Paragraph("Receita total: R$ "+banco.getVendaTotalEstabelecimentoDB(ID) ,fonte);
                doc.add(fim);
            } else {
                System.out.println("Relatório não gerado");
            }
            doc.add(linha);

        } finally {
            if (doc != null) {
                doc.close();
            }
            if (os != null) {
               os.close();
            }
        }
    }
}

