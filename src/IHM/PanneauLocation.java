package IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanneauLocation extends JPanel {

	private JTextField saisie;
	
	public PanneauLocation(){
		this.saisie= new JTextField("A quel lieu se rapporte l'oeuvre d'art que vous recherchez?");
		this.saisie.setPreferredSize(new Dimension(700,20));
	
		this.setLayout(new FlowLayout());
		
		this.setBorder(new TitledBorder(new LineBorder(Color.black, 1, true),"Choisissez votre localisation"));
		
		this.add(saisie);
	}
	
	public ArrayList<String> actualize(){
		ArrayList<String> result = new ArrayList<String>();
		result.add(this.saisie.getText());
		return result;
	}
}
