import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Display extends JFrame {

	private JButton calculateButton;
	private JButton resetButton;
	private JTextField avgField;
	private JTextField desiredField;
	private JTextField finalField;
	private String storeAvg;
	private String storeDesired;
	private String storeFinal;

	//constructor 
	public Display(){

		//Setting up Display
		super("Final Grade Calculator");
		setPreferredSize(new Dimension(680,150));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout layout = new GridLayout(4,2); // 5 rows, 2 columns 
		setLayout(layout);

		//Creating the components i.e label, text field and buttons 
		JLabel textAvg = new JLabel("What is your current average (%): ");
		avgField = new JTextField();
		JLabel textDesired = new JLabel("What is your desired grade (%): ");
		desiredField = new JTextField();
		JLabel textFinal = new JLabel("How much is your final worth (%): ");
		finalField = new JTextField();
		calculateButton = new JButton("Calculate");
		resetButton = new JButton("Reset");

		//Adding the components
		add(textAvg);
		add(avgField);
		add(textDesired);
		add(desiredField);
		add(textFinal);
		add(finalField);
		add(resetButton);
		add(calculateButton);

		pack();
		setVisible(true);

		//Creating new object "eventPressed" from eventHandler class
		eventHandler eventPressed = new eventHandler();
		calculateButton.addActionListener(eventPressed);
		resetButton.addActionListener(eventPressed);
	}

	//new class that handles all the action
	private class eventHandler implements ActionListener{

		//method called automatically when an action occurs
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == calculateButton) {
				storeAvg = avgField.getText();
				double currentGrade = Double.parseDouble(storeAvg);
				storeDesired = desiredField.getText();
				double desiredGrade = Double.parseDouble(storeDesired);
				storeFinal = finalField.getText();
				double finalWorth = Double.parseDouble(storeFinal);
				double MinimumFinalGrade = (100*(desiredGrade - currentGrade*((100-finalWorth)/(double) 100)))/(double) finalWorth;
				double finalGrade = Math.round(MinimumFinalGrade*100)/100.0;
				JOptionPane.showMessageDialog(null,"You will need at least: " + finalGrade +"%");		
			}else if(e.getSource() == resetButton){
				avgField.setText(null);
				desiredField.setText(null);
				finalField.setText(null);
			}
		}

	}
}
