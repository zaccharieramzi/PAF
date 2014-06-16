package IHM;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreSelectionDeCriteres extends JFrame{
	private PanneauCriteres panneauCriteres ;
	private PanneauPropositionSubjects panneauPropositionSubjects;

	private JPanel panneauPrinc ;
	public FenetreSelectionDeCriteres(){
		panneauCriteres= new PanneauCriteres();
		panneauPropositionSubjects = new PanneauPropositionSubjects();
		panneauPrinc = new JPanel();
		panneauPrinc.add(panneauCriteres);
		panneauPrinc.add(panneauPropositionSubjects);
		this.setContentPane(panneauPrinc);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setTitle("Selectionnez vos criteres");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
