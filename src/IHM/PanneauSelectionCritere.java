package IHM;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanneauSelectionCritere extends JPanel {
	
	private JCheckBox[] checks;

	public PanneauSelectionCritere(String[] arg0,String titre){
		BoxLayout mgr = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(mgr);
		
		
		checks= new JCheckBox[arg0.length];
		
		for(int i=0; i<arg0.length;i++){
			checks[i]= new JCheckBox(arg0[i]);
			this.add(checks[i]);
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
