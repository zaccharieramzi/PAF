package IHM;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanneauCriteres extends JPanel implements ActionListener{
	
	private RecepteurDeCriteres rdc;
	private PanneauPeriode panneauPeriode;
	private PanneauDomaine panneauDomaine;
	private FenetreSelectionDeCriteres fenetre;
	
	public PanneauCriteres(RecepteurDeCriteres rdc,FenetreSelectionDeCriteres fenetre){
		this.fenetre=fenetre;
		
		BoxLayout mgr = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(mgr);
		
		
		
		this.rdc=rdc;
		String[] arg0 = {"Antiquité","Moyen-Age","Renaissance","Temps Modernes","XXeme siecle","XXIeme siecle"};
		panneauPeriode= new PanneauPeriode(arg0);
		this.add(panneauPeriode);
		String[] arg1 ={"Art visuel","Art spatial","Art auditif"};
		panneauDomaine= new PanneauDomaine(arg1);
		this.add(panneauDomaine);
		
		JButton valider = new JButton("Valider");
		valider.setActionCommand("Valider");
		valider.addActionListener(this);
		this.add(valider);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Valider")){
			this.valider();
		}
		
	}
	
	public void valider(){
		rdc.setPeriod(panneauPeriode.actualize());
		rdc.setArtDomain(panneauDomaine.actualize());
		fenetre.newCriterium();
	}

}
