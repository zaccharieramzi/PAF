package IHM;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;



public class PanneauPeriode extends JPanel{
	private JTextField saisie1;
	private JTextField saisie2;

	public PanneauPeriode(){
		this.setLayout(new FlowLayout());
		this.setBorder(new TitledBorder(new LineBorder(Color.black, 1, true),"Choisissez votre période"));
		
		this.saisie1= new JTextField("De");
		this.saisie2=new JTextField("à");
		this.add(saisie1);
		this.add(saisie2);
		
	}
	
	public ArrayList<String> actualize(){
		ArrayList<String> result = new ArrayList<String>();
		result.add(saisie1.getText());
		result.add(saisie2.getText());
		return result;
	}
	

}
