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
	
	private JRadioButton[] subjectsList;
	private ArrayList<String> subjects;
	
	
	public PanneauPropositionSubjects(ArrayList<String> subjects){
		
		this.subjects=subjects;
		
		BoxLayout mgr = new BoxLayout(this,BoxLayout.Y_AXIS);
		this.setLayout(mgr);
		
		this.setBorder(new TitledBorder(new LineBorder(Color.black, 1, true),"Liste des sujets de fiche disponibles"));
		
		ButtonGroup section = new ButtonGroup();
		
		subjectsList = new JRadioButton[subjects.size()];
		for(int i=0; i<subjects.size();i++){
			subjectsList[i] = new JRadioButton(subjects.get(i));
			section.add(subjectsList[i]);
			this.add(subjectsList[i]);
		}
		subjectsList[0].setSelected(true);
		
		
	}
	
	public String actualize(){
		String sujet=subjects.get(0);
		for(int i=0;i<subjectsList.length;i++){
			if(subjectsList[i].isSelected()){
				sujet=subjects.get(i);
			}
		}
		return sujet ;
	}

	
}
