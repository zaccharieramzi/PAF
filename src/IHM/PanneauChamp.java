package IHM;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanneauChamp extends JPanel {
	JTextField saisie ;
	public PanneauChamp(String titre, String valeurInit){
		this.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), titre));
		saisie = new JTextField(valeurInit);
		this.add(saisie);
	}
	
	public String actualize(){
		return saisie.getText();
	}
	

}
