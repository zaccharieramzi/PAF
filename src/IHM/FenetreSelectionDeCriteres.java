package IHM;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FenetreSelectionDeCriteres extends JFrame{
	private PanneauCriteres panneauCriteres ;
	private PanneauPropositionSubjects panneauPropositionSubjects;
	private RecepteurDeCriteres rdc;

	private JPanel panneauPrinc ;
	public FenetreSelectionDeCriteres(){
		rdc = new RecepteurDeCriteres();
		panneauCriteres= new PanneauCriteres(rdc,this);
		panneauPropositionSubjects = new PanneauPropositionSubjects(rdc.getSubjects());
		
		panneauPrinc = new JPanel();
		panneauPrinc.add(new JScrollPane(panneauCriteres),BorderLayout.WEST);
		panneauPrinc.add(new JScrollPane(panneauPropositionSubjects),BorderLayout.CENTER);
		this.setContentPane(panneauPrinc);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setTitle("Selectionnez vos criteres");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void newCriterium(){
		panneauPropositionSubjects=new PanneauPropositionSubjects(rdc.getSubjects());
		panneauPrinc.repaint();
	}
}
