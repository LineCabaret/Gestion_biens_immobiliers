package rapport;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class CreerRapport {
	
    public void creerDocument(InputStream modele, OutputStream fileOut) throws IOException {
        XWPFDocument document = new XWPFDocument(modele);
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Planning des cours...");
        paragraph = document.createParagraph();
        run = paragraph.createRun();
        run.addCarriageReturn();
        run.addCarriageReturn();
        run.setText("Veuillez trouver ci-joint, l'ensemble des créneaux affichés dans la table.");
        
        DaoCreneau dao = new DaoCreneau();
        List<Creneau> creneaux = dao.getCreaux();
        XWPFTable tab = document.createTable();
        XWPFTableRow row = tab.getRow(0);
        XWPFTableCell cell = row.addNewTableCell();
        cell.setText("Jour de la semaine");
        cell = row.addNewTableCell();
        cell.setText("Groupe");
        cell = row.addNewTableCell();
        cell.setText("Heure de début du cours");
        cell = row.addNewTableCell();
        cell.setText("Heure de fin du cours");
        cell = row.addNewTableCell();
        cell.setText("Type du cours");
        cell = row.addNewTableCell();
        cell.setText("Matière");
        
        for (Creneau creneau : creneaux) {
            row = tab.createRow();
            cell = row.getCell(0);
            cell.setText(creneau.getJourSemaine());
            cell = row.addNewTableCell();
            cell.setText(creneau.getGroupe());
            cell = row.addNewTableCell();
            cell.setText(creneau.getHeureDebut());
            cell = row.addNewTableCell();
            cell.setText(creneau.getHeureFin());
            cell = row.addNewTableCell();
            cell.setText(creneau.getTypeCours());
            cell = row.addNewTableCell();
            cell.setText(creneau.getMaterie());
        }
        
        paragraph = document.createParagraph();
        run = paragraph.createRun();
        run.addCarriageReturn();
        run.addCarriageReturn();
        run.setText("Pour toute modification, vous devez contacter le service des plannings ou le secrétariat.");
        
        document.write(fileOut);
        document.close();
    }

    public static void main(String[] args) {
        try {
            InputStream modele = new FileInputStream("vide.docx");
            OutputStream fileOut = new FileOutputStream("test.docx");
            CreerRapport rapport = new CreerRapport();
            rapport.creerDocument(modele, fileOut);
            fileOut.close();
            modele.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}

