package IHM;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FenetreSelectionDeCriteres extends JFrame implements ActionListener{
	private PanneauCriteres panneauCriteres ;
	private PanneauPropositionSubjects panneauPropositionSubjects;
	private RecepteurDeCriteres rdc;

	private JPanel panneauPrinc ;
	public FenetreSelectionDeCriteres(){
		rdc = new RecepteurDeCriteres();
		panneauCriteres= new PanneauCriteres(rdc,this);
		panneauPropositionSubjects = new PanneauPropositionSubjects(rdc.getSubjects());
		
		JButton valider =new JButton("Valider");
		valider.setActionCommand("Valider");
		valider.addActionListener(this);
		
		panneauPrinc = new JPanel();
		panneauPrinc.add(new JScrollPane(panneauCriteres),BorderLayout.WEST);
		panneauPrinc.add(new JScrollPane(panneauPropositionSubjects),BorderLayout.CENTER);
		panneauPrinc.add(valider,BorderLayout.SOUTH);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Valider")){
			this.valider();
		}
		
	}
	
	private void valider(){
		SubjectToFiche stf = new SubjectToFiche();
		stf.setDate("1994");
		stf.setAuthorName("Zaccharie Ramzi");
		stf.setNature("Etre humain");
		stf.setSubject("moi");
		new FenetreFiche(stf);
	}
}
