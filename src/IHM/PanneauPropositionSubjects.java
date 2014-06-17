package IHM;

import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class PanneauPropositionSubjects extends JScrollPane{
	
	
	
	public PanneauPropositionSubjects(ArrayList<String> subjects){
		
		FlowLayout mgr = new FlowLayout();
		this.setLayout(mgr);
		
		ButtonGroup section = new ButtonGroup();
		
		JRadioButton[] subjectsList = new JRadioButton[subjects.size()];
		for(int i=0; i<subjects.size();i++){
			subjectsList[i] = new JRadioButton(subjects.get(i));
			section.add(subjectsList[i]);
			this.add(subjectsList[i]);
		}
	}

	
}
