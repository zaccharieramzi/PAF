package IHM;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FenetreFiche extends JFrame implements ActionListener{
	
	public FenetreFiche(SubjectToFicheInterface stf){
		JPanel panneauPrinc = new JPanel();
		
		JButton valider = new JButton("Valider");
		valider.setActionCommand("Valider");
		valider.addActionListener(this);
		
		String[] arg0 = {"authorName","nature","date","composer"};
		PanneauChamp[] champs = new PanneauChamp[arg0.length];
		
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
	
	public void valider(){
		
	}

}
