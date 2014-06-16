package IHM;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FenetreDAccueil extends JFrame{
	private JPanel panneauPrinc ;

	public FenetreDAccueil(){
		panneauPrinc = new JPanel();
		this.setContentPane(panneauPrinc);
		//this.pack();
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Ardoise Magique");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
