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
	private PanneauLocation panneauLocation;
	private FenetreSelectionDeCriteres fenetre;
	
	public PanneauCriteres(RecepteurDeCriteres rdc,FenetreSelectionDeCriteres fenetre){
		this.fenetre=fenetre;
		
		BoxLayout mgr = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(mgr);
		
		
		
		this.rdc=rdc;
		panneauPeriode= new PanneauPeriode();
		this.add(panneauPeriode);
		String[] arg1 ={"Film","Artwork","Monuments","Livre"};
		panneauDomaine= new PanneauDomaine(arg1);
		this.add(panneauDomaine);
		panneauLocation = new PanneauLocation();
		this.add(panneauLocation);
		
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
		rdc.setLocation(panneauLocation.actualize());
		fenetre.newCriterium();
	}

}
