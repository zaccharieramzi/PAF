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
	private JScrollPane jsp;
	private RecepteurDeCriteres rdc;

	private JPanel panneauPrinc ;
	public FenetreSelectionDeCriteres(){
		rdc = new RecepteurDeCriteres();
		panneauCriteres= new PanneauCriteres(rdc,this);
	
		
		JButton valider =new JButton("Valider");
		valider.setActionCommand("Valider");
		valider.addActionListener(this);
		
		panneauPrinc = new JPanel();
		panneauPrinc.add(new JScrollPane(panneauCriteres),BorderLayout.WEST);
		
		panneauPrinc.add(valider,BorderLayout.SOUTH);
		this.setContentPane(panneauPrinc);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setTitle("Selectionnez vos criteres");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void newCriterium(){
		if(panneauPropositionSubjects!=null){
			
			this.panneauPrinc.remove(jsp);
			panneauPropositionSubjects=null;
		}
		panneauPropositionSubjects=new PanneauPropositionSubjects(rdc.getSubjects());
		jsp = new JScrollPane(panneauPropositionSubjects);
		panneauPrinc.add(jsp,BorderLayout.CENTER);
		jsp.repaint();
		panneauPropositionSubjects.repaint();
		panneauPrinc.repaint();
		this.repaint();
		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Valider")){
			this.valider();
		}
		
	}
	
	private void valider(){
		
		SubjectToFiche stf = new SubjectToFiche();
		stf.setNature(rdc.getArtDomain().get(0));
		stf.setSubject(panneauPropositionSubjects.actualize());
//		stf.loadFromURL("http://dbpedia.org/sparql?default-graph-uri=http%3A%2F%2Fdbpedia.org&query=PREFIX+owl%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2002%2F07%2Fowl%23%3E%0D%0APREFIX+xsd%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2001%2FXMLSchema%23%3E%0D%0APREFIX+rdfs%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2000%2F01%2Frdf-schema%23%3E%0D%0APREFIX+rdf%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F1999%2F02%2F22-rdf-syntax-ns%23%3E%0D%0APREFIX+foaf%3A+%3Chttp%3A%2F%2Fxmlns.com%2Ffoaf%2F0.1%2F%3E%0D%0APREFIX+dc%3A+%3Chttp%3A%2F%2Fpurl.org%2Fdc%2Felements%2F1.1%2F%3E%0D%0APREFIX+%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2F%3E%0D%0APREFIX+dbpedia2%3A+%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2F%3E%0D%0APREFIX+dbpedia%3A+%3Chttp%3A%2F%2Fdbpedia.org%2F%3E%0D%0APREFIX+skos%3A+%3Chttp%3A%2F%2Fwww.w3.org%2F2004%2F02%2Fskos%2Fcore%23%3E%0D%0A%0D%0Aselect+*%0D%0A+where+%7B%3Chttp%3A%2F%2Fdbpedia.org%2Fresource%2FNighthawks%3E+%3Chttp%3A%2F%2Fdbpedia.org%2Fontology%2Fauthor%3E+%3Fauteur%3B%0D%0A%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Ftitle%3E+%3Fname%3B%0D%0A%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Ftype%3E+%3Ftype%3B%0D%0A%3Chttp%3A%2F%2Fdbpedia.org%2Fproperty%2Fyear%3E+%3Fdate%0D%0A%0D%0A%7D&format=text%2Fhtml&timeout=30000&debug=on");
		stf.loadFromQuery();
		new FenetreFiche(stf);
	}
}
