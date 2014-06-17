package IHM;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class PanneauPropositionSubjects extends JPanel{
	
	
	
	public PanneauPropositionSubjects(ArrayList<String> subjects){
		
		BoxLayout mgr = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setLayout(mgr);
		
		this.setBorder(new TitledBorder(new LineBorder(Color.black, 1, true),"Liste des sujets de fiche disponibles"));
		
		ButtonGroup section = new ButtonGroup();
		
		JRadioButton[] subjectsList = new JRadioButton[subjects.size()];
		for(int i=0; i<subjects.size();i++){
			subjectsList[i] = new JRadioButton(subjects.get(i));
			section.add(subjectsList[i]);
			this.add(subjectsList[i]);
		}
		
		
	}

	
}
