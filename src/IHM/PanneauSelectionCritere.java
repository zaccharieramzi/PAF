package IHM;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanneauSelectionCritere extends JPanel {
	
	private JRadioButton[] checks;
	

	public PanneauSelectionCritere(String[] arg0,String titre){
		ButtonGroup section = new ButtonGroup();
		BoxLayout mgr = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(mgr);
		
		
		checks= new JRadioButton[arg0.length];
		
		for(int i=0; i<arg0.length;i++){
			checks[i]= new JRadioButton(arg0[i]);
			this.add(checks[i]);
			section.add(checks[i]);
		}
		
		this.setBorder(new TitledBorder(new LineBorder(Color.black, 1, true),titre));
	}
	
	public ArrayList<String> actualize(){
		ArrayList<String> listeSelect = new ArrayList<String>();
		for(int i=0;i<checks.length;i++){
			if (checks[i].isSelected()){
				listeSelect.add(checks[i].getName());
			}
		}
		return listeSelect;
	}
}
