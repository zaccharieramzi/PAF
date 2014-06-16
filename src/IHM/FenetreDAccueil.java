package IHM;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FenetreDAccueil extends JFrame implements ActionListener{
	
	private JPanel panneauPrinc ;
	public FenetreDAccueil(){
		panneauPrinc = new JPanel();
		JButton bouton = new JButton("Entrer");
		bouton.setActionCommand("Entrer");
		bouton.addActionListener(this);
		JLabel welcome = new JLabel("Welcome");
		panneauPrinc.add(welcome,BorderLayout.CENTER);
		panneauPrinc.add(bouton,BorderLayout.SOUTH);
		this.setContentPane(panneauPrinc);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setTitle("Accueil");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Entrer")){
			new FenetreSelectionDeCriteres();
			this.setVisible(false);
			this.dispose();
		}
	}
	
}
