package IHM;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class FenetreFiche extends JFrame implements ActionListener{
	SubjectToFicheInterface stf;
	PanneauChamp[] champs;
	
	
	public FenetreFiche(SubjectToFicheInterface stf){
		this.stf=stf;
		JPanel panneauPrinc = new JPanel();
		
		JButton valider = new JButton("Valider");
		valider.setActionCommand("Valider");
		valider.addActionListener(this);
		
		String[] arg0 = {"authorName","description","date"};
		champs = new PanneauChamp[arg0.length];
		
		for(int i=0;i<champs.length;i++){
			champs[i]= new PanneauChamp(arg0[i], stf.get(arg0[i]));
			panneauPrinc.add(champs[i]);
		}
		
		panneauPrinc.add(valider,BorderLayout.SOUTH);
		this.setContentPane(panneauPrinc);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setTitle("Voici votre fiche");
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Valider")){
			this.valider();
		}
		
	}
	
	private void valider(){
		this.generatePDF();
		this.setVisible(false);
		this.dispose();
	}

	private void generatePDF(){
		Document document = new Document();
		try {
			PdfWriter.getInstance(document,
			new FileOutputStream(stf.getSubject()+".pdf"));
			document.open();
			document.add(new Paragraph("Le nom de l'auteur est :"+champs[0].actualize()));
			document.add(new Paragraph("La description de l'oeuvre est :"+champs[1].actualize()));
			document.add(new Paragraph("La date de composition de l'oeuvre est :"+champs[2].actualize()));
			} catch (DocumentException de) {
			de.printStackTrace();
			} catch (IOException ioe) {
			ioe.printStackTrace();
			}
			 
			document.close();
	}
}
// second comm
